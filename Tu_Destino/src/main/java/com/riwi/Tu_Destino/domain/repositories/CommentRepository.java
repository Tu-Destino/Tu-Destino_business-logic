package com.riwi.Tu_Destino.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.Tu_Destino.domain.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Long> {

}