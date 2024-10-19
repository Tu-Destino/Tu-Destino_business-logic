package com.TD.Tu.Destino.api.dtos.request;

import com.TD.Tu.Destino.infrastructure.helpers.WWcomma;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LabelsRequest {

    @NotNull
    @WWcomma(message = "Words in the String must be separated by commas ", words = {"lugares","historia","antiguo","cultura","naturaleza"})
    private String array;
}
