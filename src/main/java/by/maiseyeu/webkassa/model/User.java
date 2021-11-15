package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity <Long>{

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name="workplace_id", unique = true)
    @ToString.Exclude
    private Workplace workplace;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<Workshift> workshifts;

}
