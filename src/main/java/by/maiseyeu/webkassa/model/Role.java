package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true, exclude = "users")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends BaseEntity <Long> {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
