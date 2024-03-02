package com.api.tgid.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "customers")
@Entity
@Getter
@Setter
public class Customer extends GenericUser {
}
