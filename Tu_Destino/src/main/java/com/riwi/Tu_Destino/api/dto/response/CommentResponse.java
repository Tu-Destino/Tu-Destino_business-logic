package com.riwi.Tu_Destino.api.dto.response;

import java.sql.Date;

import com.riwi.Tu_Destino.domain.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Date date;
    private String comentary;
    private Usuario user;
}
