package com.api.tgid.services;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import org.springframework.stereotype.Component;

@Component
public class CPFValidatorService {

    private String cpfFormatter(String cpf) {
        Formatter formatter = new CPFFormatter();
        return formatter.format(cpf);
    }

    public String cpfValidator(String cpf) {
        CPFValidator validator = new CPFValidator();

        try {
            validator.assertValid(cpf);
            return cpfFormatter(cpf);
        } catch (InvalidStateException e){
            throw new RuntimeException(String.valueOf(e.getInvalidMessages()));
        }
    }

}
