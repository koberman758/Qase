package dto;

import com.github.javafaker.Faker;

public class SuiteFactory {

    public static Suite getRandom() {
        Faker faker = new Faker();
        return Suite.builder()
                .title(faker.name().firstName())
                .description(faker.address().streetAddress())
                .preconditions(faker.programmingLanguage().creator())
                .build();
    }
}
