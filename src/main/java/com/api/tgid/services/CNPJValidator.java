package com.api.tgid.services;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.validation.InvalidStateException;
import org.springframework.stereotype.Component;

@Component
public class CNPJValidator {

   private String cnpjFormatter(String cnpj) {
        Formatter formatter = new CNPJFormatter();
        return formatter.format(cnpj);
    }

    public String cnpjValidator (String cnpj) {
        br.com.caelum.stella.validation.CNPJValidator validator = new br.com.caelum.stella.validation.CNPJValidator();

        try {
            validator.assertValid(cnpj);
            return cnpjFormatter(cnpj);
        } catch (InvalidStateException e) {
           throw new RuntimeException(String.valueOf(e.getInvalidMessages()));
        }
    }
}
