package utils;

import com.github.javafaker.Faker;

public class TestDataGenerator {

    private static String gender;
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String password;

    private static Faker faker = new Faker();

    public static void generateRegistrationData() {

        gender = faker.options().option("Male", "Female"); // Example: randomly choose between Male and Female
        firstName = faker.name().firstName();
        LogsUtils.info("Generated First Name: " + firstName);
        lastName = faker.name().lastName();
        LogsUtils.info("Generated Last Name: " + lastName);
        email = faker.internet().emailAddress();
        LogsUtils.info("Generated Email: " + email);
        password = faker.internet().password(8, 20, true, true, true);
        LogsUtils.info("Generated Password: " + password);
    }

    public static String getGender() {
        return gender;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
}