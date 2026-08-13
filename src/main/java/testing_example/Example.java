package testing_example;

import java.util.Objects;

public class Example {

    public boolean isAdult(int age, String continent) {
        if(age < 0){
            throw new IllegalArgumentException("Age cannot be negative");
        }

        if (Objects.equals(continent, "US")) {
            return age >= 21;
        }
        return age >= 18;
    }

    public String formatUserName(String userName) {
        if(userName == null || userName.isBlank()) {
            return "ANONYMOUS";
        }

        return userName.trim().toUpperCase();
    }
}
