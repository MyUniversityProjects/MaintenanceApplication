package root.screens.createuser;

public class User {
    private String cf;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String address;
    private RoleType role;
    
    
    public enum RoleType {P , M};

    public User(String cf, String username, String password, String name, String surname, String email,String address,  RoleType role) {
        this.cf = cf;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public String getCf() {
        return cf;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public RoleType getRole() {
        return role;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    
    public static RoleType convertRawType(String type) {
        switch (type) {
            case "P": return RoleType.P;
            case "M": return RoleType.M;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return "User{" + "cf=" + cf + ", username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname + ", email=" + email + ", address=" + address + ", role=" + role + '}';
    }


}
