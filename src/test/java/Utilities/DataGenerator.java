package Utilities;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class DataGenerator {


    public static Map<String,String> createUserInfo(){

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        Map<String,String> newUser = new HashMap<>();
        newUser.put("firstName",firstName);
        newUser.put("lastName",lastName);
        newUser.put("email",(firstName.substring(0,2)+"@gmail.com").toLowerCase()); //api crashes when I send an email more than 5 letters before "@"

        return newUser;
    }
}
