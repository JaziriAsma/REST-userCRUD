package userAPI.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @NotNull(message="Username cannot be null")
    private String username;

    @NotNull(message="Email cannot be null")
    private String email;

    @NotNull(message="Password cannot be null")
    @Size(min = 8, max = 20, message = "Password between 8 and 20 characters")
    private String password;

    @Transient
    private String confirmPassword;

    public User() {
    }

    public User(long id, @NotNull(message = "Username cannot be null") String username, @NotNull(message = "Email cannot be null") String email, @NotNull(message = "Password cannot be null") String password, String confirmPassword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
