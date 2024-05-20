package com.riwi.Tu_Destino.infrastructure.services;

import com.riwi.Tu_Destino.Util.exceptions.IdNotFoundException;
import com.riwi.Tu_Destino.api.dto.requests.CookiesRequest;
import com.riwi.Tu_Destino.api.dto.response.CookiesResponse;
import com.riwi.Tu_Destino.domain.entities.Cookies;
import com.riwi.Tu_Destino.domain.repositories.CookiesRepository;
import com.riwi.Tu_Destino.infrastructure.abstract_services.ICookiesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CookiesService implements ICookiesService {


    @Autowired
    private final CookiesRepository cookiesRepository;

    @Override
    public void delete(String s) {
        Cookies cookies = this.find(s);
        this.cookiesRepository.delete(cookies);
    }

    @Override
    public CookiesResponse create(CookiesRequest request) {
        Cookies cookies= this.requestToCookies(request, new Cookies());
        return this.entityResponse(this.cookiesRepository.save(cookies));
    }

    @Override
    public CookiesResponse update(String s, CookiesRequest request) {
        Cookies cookies = this.find(s);
        Cookies cookiesUpdate= this.requestToCookies(request,cookies);
        return this.entityResponse(this.cookiesRepository.save(cookiesUpdate));
    }

    @Override
    public List<CookiesResponse> getAll() {
        List<CookiesResponse> listCookies = this.cookiesRepository.findAll().stream().map(this::entityResponse).collect(Collectors.toList());

        return listCookies;
    }

    @Override
    public CookiesResponse getById(String id) {
        return this.entityResponse(this.find(id));
    }

    private Cookies find(String id){
        return this.cookiesRepository.findById(id).orElseThrow(()->new IdNotFoundException("Cookies"));
    }

    private CookiesResponse entityResponse(Cookies entity){
        CookiesResponse response = new CookiesResponse();

        BeanUtils.copyProperties(entity,response);

        return response;
    }

    private Cookies requestToCookies(CookiesRequest request, Cookies cookies) {
        BeanUtils.copyProperties(request, cookies);
        return cookies;
    }
}


