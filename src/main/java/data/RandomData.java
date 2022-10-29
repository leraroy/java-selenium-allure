package data;

import com.github.javafaker.Faker;

public class RandomData {

    private String firstName;
    private String lastName;
    private String email;
    private String validPassword;
    private String smallPassword;
    private String invalidPassword;
    private Faker faker=new Faker();

    public RandomData(){
        firstName=faker.name().firstName();
        lastName=faker.name().lastName();
        email=faker.internet().emailAddress();
        validPassword =faker.internet().password(8, 20, true, true,true);
        smallPassword=faker.internet().password(4, 7);
        invalidPassword=faker.internet().password(9, 12);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public String getSmallPassword() {
        return smallPassword;
    }
}
