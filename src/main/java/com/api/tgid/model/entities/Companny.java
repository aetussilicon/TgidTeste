package com.api.tgid.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Companny extends GenericUser {

    private String companyName;
    private String businessName;
    private int systemFee;
    //TODO histórico de transções
    @Override
    public String getName() {
        return companyName;
    }
}
