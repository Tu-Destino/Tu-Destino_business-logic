package com.TD.Tu.Destino.infrastructure.services;

import com.TD.Tu.Destino.api.dtos.request.LabelsRequest;
import com.TD.Tu.Destino.api.dtos.response.PostDiscoverResponse;
import com.TD.Tu.Destino.domain.entities.PostDiscover;
import com.TD.Tu.Destino.infrastructure.abstract_service.IPostDiscoverService;
import com.TD.Tu.Destino.infrastructure.helpers.mappers.PostDiscoverMapper;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostDiscoverService implements IPostDiscoverService {

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private final PostDiscoverMapper postDiscoverMapper;

    @Override
    public List<PostDiscoverResponse> findByTags(LabelsRequest labelsRequest) {

        String tagsString = labelsRequest.getArray();

        String[] tagsArray = tagsString.split(",");

        List<String> tags = Arrays.stream(tagsArray)
                    .map(String::trim)
                    .collect(Collectors.toList());

        //Dynamic search
        StringBuilder jpql = new StringBuilder("SELECT p, ");

        //Calculate the number of matches
        jpql.append("(CASE ");

        //All labels matched
        jpql.append("WHEN ");
        for (int i = 0; i < tags.size(); i++){
            jpql.append("p.tags LIKE :tag").append(i);
            if (i < tags.size()-1)
                jpql.append(" AND ");
        }
        jpql.append(" THEN ").append(tags.size()).append(" ");

        //Combinations of [n-1 . 1]
        for (int matchCount = tags.size() - 1; matchCount > 0; matchCount--) {
            List<List<Integer>> combinations = getCombinations(tags.size(), matchCount);
            for (List<Integer> combination : combinations){
                jpql.append("WHEN (");
                for (int i = 0; i < combination.size(); i++){
                    jpql.append("p.tags LIKE :tag").append(combination.get(i));
                    if (i < combination.size() -1){
                        jpql.append(" AND ");
                    }
                }
                jpql.append(") THEN ").append(matchCount).append(" ");
            }
        }

        jpql.append("ELSE 0 END) as relevance FROM PostDiscover p WHERE ");

        //Condition for at least one match
        jpql.append("(");
        for (int i = 0; i < tags.size(); i++) {
            if (i > 0) {
                jpql.append(" OR ");
            }
            jpql.append("p.tags LIKE :tag").append(i);
        }
        jpql.append(") ORDER BY relevance DESC");

        //Create Query
        Query query = entityManager.createQuery(jpql.toString(), Object[].class);

        //Assign dynamic parameters
        for (int i = 0; i < tags.size(); i++){
            query.setParameter("tag" + i, "%" + tags.get(i) + "%");
        }

        //Execute query
        List<Object[]> results = query.getResultList();

        //Convert the results to PostResponse
        List<PostDiscoverResponse> response = new ArrayList<>();
        for (Object[] result : results) {
            PostDiscover postDiscover = (PostDiscover) result[0];
            response.add(this.postDiscoverMapper.toResponse(postDiscover));
        }

        return response;
    }

    // Helper function to generate combinations
    private List<List<Integer>> getCombinations(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(combinations, new ArrayList<>(), 0, n, k);
        return combinations;
    }

    // Recursive function to generate combinations
    private void generateCombinations(List<List<Integer>> combinations, List<Integer> current, int start, int n, int k){
        if (k == 0){
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < n; i++){
            current.add(i);
            generateCombinations(combinations, current, i + 1, n, k -1);
            current.remove(current.size()-1);
        }
    }

}
