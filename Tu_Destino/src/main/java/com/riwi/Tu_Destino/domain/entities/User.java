package com.riwi.Tu_Destino.domain.entities;

import java.util.List;

import com.riwi.Tu_Destino.Util.enums.RoleUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cookies_id",referencedColumnName = "id")
    private Cookies cookies;

    // 1
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = false,fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Comment> comment;

}
