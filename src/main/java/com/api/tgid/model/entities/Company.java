package com.api.tgid.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "companies")
@Entity
@Getter
@Setter
public class Company extends GenericUser {

    private String businessName;
    private BigDecimal systemFee;
    //TODO histórico de transções

}
