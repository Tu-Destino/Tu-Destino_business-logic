package com.riwi.Tu_Destino.api.dto.requests;

import com.riwi.Tu_Destino.Util.enums.RoleUser;
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
public class UserRequest {
    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(max = 60, message = "superaste el limite de caracteres permitidos")
    private String name;
    @NotBlank(message = "El email no puede  estar vacio")
    @Size(max = 100, message = "superaste el limite de caracteres permitidos")
    private String email;
    @NotBlank(message = "La contraseña no puede  estar vacia")
    @Size(max = 30, message = "superaste el limite de caracteres permitidos")
    private String password;
    @NotNull(message = "El enum no puede ser nulo")
    private RoleUser enum_rol;
    private String cookies_id;
}
