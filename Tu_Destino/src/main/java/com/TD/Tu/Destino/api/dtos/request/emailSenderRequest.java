package com.TD.Tu.Destino.api.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class emailSenderRequest{

    @NotNull(message = "The mail must be not null")
    @Email(message = "The input must be a email")
    private String sender;

    @NotNull(message = "The subject can't be null")
    private String subject;

    @NotNull(message = "The body can't be null")
    private String body;

    private String attachmentPath;

}
