package com.riwi.Tu_Destino.api.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    @NotBlank(message = "This attribute is required")
    @Size(min = 20, max =2000,message = "Comment must be more than 50 characters")
    private String comment;
    @NotNull(message = "This attribute is required")
    private String user;
    @NotNull(message = "This attribute is required")
    private Long place;
}
