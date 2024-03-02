package com.api.tgid.model.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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
    private String taxNumber;
    private String address;
    private String postalCode;
    private String email;
    private String phoneNumber;
    private float balance;

}
