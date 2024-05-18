package com.riwi.Tu_Destino.api.dto.response;

import com.riwi.Tu_Destino.Util.enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private RoleUser enum_rol;

}
