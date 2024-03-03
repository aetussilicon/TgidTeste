package com.api.tgid.services;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.text.Normalizer;
import java.util.Random;

@Component
public class UsernameGenerator {

    public String usernameGenerator(@NotNull String name) {
        String cleanName = characterRemover(name);

        char[] nameToSplit = cleanName.toCharArray();
        int arrayLength = nameToSplit.length;
        int charsToExtract = 3;

        char[] firstThreeLetterOfFirstName = new char[charsToExtract];
        char[] lastThreeLettersOfLastName = new char[charsToExtract];

        System.arraycopy(nameToSplit, 0, firstThreeLetterOfFirstName, 0, 3);
        System.arraycopy(nameToSplit, arrayLength - charsToExtract, lastThreeLettersOfLastName, 0, charsToExtract);

        String str1 = new String(firstThreeLetterOfFirstName).toLowerCase();
        String str2 = new String(lastThreeLettersOfLastName).toLowerCase();

        Random complement = new Random();

        int randomInt = complement.nextInt(1000, 9999);
        return str1 + str2 + randomInt;
    }

    private String characterRemover(String name) {
        String normalizedString = Normalizer.normalize(name, Normalizer.Form.NFD);
        return normalizedString.replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
    }

}
