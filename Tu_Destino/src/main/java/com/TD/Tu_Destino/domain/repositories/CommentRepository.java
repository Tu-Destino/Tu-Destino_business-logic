package com.TD.Tu_Destino.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TD.Tu_Destino.domain.entities.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Long> {
    List<Comment> findAllByPlace_id(Long lugar_id);
}