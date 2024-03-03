package com.api.tgid.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "geid")
public abstract class GenericUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID geid;
    private String name;
    private String username;

    @Column(name = "tax_number" )
    private String taxNumber;
//    private String postalCode;
    private String email;
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;
    private float balance;

}
