package dto;

import com.github.javafaker.Faker;

public class TestCaseFactory {

    public static TestCase getRandom() {
        Faker faker = new Faker();
        return TestCase.builder()
                .title(faker.name().firstName())
                .description(faker.address().streetAddress())
                .preconditions(faker.programmingLanguage().creator())
                .postconditions(faker.programmingLanguage().creator())
                .severity(faker.number().numberBetween(1, 7))
                .priority(faker.number().numberBetween(1, 4))
                .behavior(faker.number().numberBetween(1, 4))
                .type(faker.number().numberBetween(1, 11))
                .layer(faker.number().numberBetween(1, 4))
                .is_flaky(faker.number().numberBetween(1, 2))
                .suite_id(0)
                .automation(faker.number().numberBetween(1, 3))
                .status(faker.number().numberBetween(1, 3))
                .build();
    }
}
