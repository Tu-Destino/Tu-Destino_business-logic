package com.TD.Tu_Destino.api.dto.response;

import com.TD.Tu_Destino.Util.enums.RoleUser;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private RoleUser enum_rol;

}
