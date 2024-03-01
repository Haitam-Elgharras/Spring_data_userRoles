package ma.enset.jpa.userroles.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="ROLE_NAME" ,unique = true,length = 20)
    private String roleName;

    @Column(name="description")// take care of reserved keywords in SQL
    private String desc;

    @ToString.Exclude // to avoid infinite loop when we call toString() method
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // to avoid infinite loop when we use it in JSON
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
//  @JoinTable(name = "users_roles", specify foreign keys)
    private List<User> users=new ArrayList<>(); //  when using eager we must initialize the list to avoid nullPointerException
}
