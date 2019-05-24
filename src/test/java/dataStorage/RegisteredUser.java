package dataStorage;

public class RegisteredUser {

    private static RegisteredUser user;

    private String name;
    private String email;
    private String password;

    private RegisteredUser() {
        name = "Rozalline";
        email = "orusa@softserveinc.com";
        password = "123zxcQ";
    }

    public synchronized static RegisteredUser getUser() {
        if (user == null)
            user = new RegisteredUser();
        return user;
    }

    public synchronized String getName() {
        String name = null;
        if (user.name.equals("Rozalline")) {
            name = user.name;
        }
            return name;
    }

    public synchronized String getEmail() {
        String email = null;
        if (user.email.equals("orusa@softserveinc.com")) {
            email = user.email;
        }
        return email;
    }

    public synchronized String getPassword() {
        String password = null;
        if (user.password.equals("123zxcQ")) {
            password = user.password;
        }
        return password;
    }
}
