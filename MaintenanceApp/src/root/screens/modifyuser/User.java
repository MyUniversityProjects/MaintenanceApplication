package root.screens.modifyuser;

public class User {
    
    public enum UserType{P, M};

    private String name;
    private final String initCf;
    private String surname;
    private String cf;
    private String email;
    private String address;
    private String username;
    private String password;
    private UserType role;

    public User(String name, String surname, String cf, String email, String address, String username, String password, UserType role) {
        this.name = name;
        this.surname = surname;
        this.cf = cf;
        this.initCf = cf;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }
    
    public String getInitCf() {
        return initCf;
    }

    public String getSurname() {
        return surname;
    }

    public String getCf() {
        return cf;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserType role) {
        this.role = role;
    }
    
}
