package Models;

import Utils.FakerGenerator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarContatoModel {

    private String name;
    private String lastName;
    private String email;
    private String age;
    private String phone;
    private String address;
    private String state;
    private String city;
    private FakerGenerator faker = new FakerGenerator();

    public CriarContatoModel(){

        this.name = faker.getName();
        this.lastName = "Automation DB";
        this.email= faker.getEmail();
        this.age="23";
        this.phone="123456789";
        this.address="Rua Nova DB";
        this.state="Rio grande do sul";
        this.city="Porto Alegre";

    }

    public String getName() {
        return name;
    }
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}

