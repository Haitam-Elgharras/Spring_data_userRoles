package ma.enset.jpa.userroles.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data// for getters and setters
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name="USER_NAME" ,unique = true,length = 20)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // do not send the password when we use it in JSON
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    public User(String password)  {
        this.password = password;
    }
}
