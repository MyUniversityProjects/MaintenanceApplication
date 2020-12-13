package root.entities;

import java.util.Objects;

public class User {
    public enum UserRole {
        SYSTEM_ADMINISTRATOR,
        PLANNER,
        MAINTAINER
    };
    
    private String cf;
    private String username;
    private UserRole role;
    private String name;
    private String surname;
    private String email;
    private String address;

    public User(String cf, String username, UserRole role, String name, String surname, String email, String address) {
        this.cf = cf;
        this.username = username;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    public String getCf() {
        return cf;
    }

    public String getUsername() {
        return username;
    }

    public UserRole getRole() {
        return role;
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
    
    public void setCf(String cf) {
        this.cf = cf;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(UserRole role) {
        this.role = role;
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
    
    /**
     * Convert a string that rappresent an user role, to its enumeration.
     * The convertion is case sensitive (role should be upper case).
     * @param raw the raw string
     * @return UserRole value if the string is valid; otherwise null
     */
    public static UserRole convertRawRole(String raw) {
        if (raw == null) return null;
        switch (raw) {
            case "SA": return UserRole.SYSTEM_ADMINISTRATOR;
            case "P": return UserRole.PLANNER;
            case "M": return UserRole.MAINTAINER;
            default: return null;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.cf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.cf, other.cf)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        return true;
    }
}
