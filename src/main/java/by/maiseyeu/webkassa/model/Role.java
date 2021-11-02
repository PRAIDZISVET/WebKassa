package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends BaseEntity <Long> {

    @Column(name = "name")
    private String name;
}
