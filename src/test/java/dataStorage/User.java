package dataStorage;

import java.util.Random;

public class User {

    private static User user;

    private User(){
        getName();
        getEmail();
        getPassword();
    }

    public synchronized static User getUser(){
        if (user == null)
            user = new User();
        return user;
    }

    private static final String NAME = generateRandomText();
    private String email;
    private String password;

    public synchronized String getName() {
        return NAME;
    }

    public synchronized String getEmail() {
        email = String.format("%s@gmail.com", NAME);
        return email.toLowerCase();
    }

    public synchronized String getPassword() {
        password = String.format("%sA123", NAME);
        return password;
    }

    //Generate random name
    private static String generateRandomText() {
        StringBuilder stringBuilder = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            stringBuilder.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return stringBuilder.toString();
    }
}
