package com.riwi.Tu_Destino.domain.entities;

import com.riwi.Tu_Destino.Util.enums.RoleUser;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 100,nullable = false)
    private String name;
    @Column(length = 100,nullable = false)
    private String email;
    @Column(length = 40,nullable = false)
    private String password;
    @Column(nullable = false)
    private RoleUser enum_rol;
    private Cookies cookies_id;
}
