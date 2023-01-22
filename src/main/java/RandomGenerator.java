import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {
    public String randomEmailYandex() {
        return RandomStringUtils.randomAlphanumeric(10).toLowerCase() + "@yandex.ru";
    }

    public String randomCorrectPassword() {
        return RandomStringUtils.randomAlphanumeric(6);
    }

    public String randomIncorrectPassword() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public String randomName() {
        return RandomStringUtils.randomAlphanumeric(12);
    }
}