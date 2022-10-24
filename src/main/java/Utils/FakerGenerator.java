package Utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerGenerator {
    private String email;
    private String name;
    private final Faker faker;

    public FakerGenerator(){
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getEmail(){
        String email = faker.internet().emailAddress();
        return email;
    }

    public String getName(){
        String name = faker.name().firstName();
        return name;
    }
}

