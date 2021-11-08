package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"users","workshifts"})
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workplaces")
public class Workplace extends BaseEntity<Long>{

    @Column(name = "code", nullable = false)
    private Long code;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "workplace")
    private List<User> users;

    @OneToMany(mappedBy = "workplace")
    private List<Workshift> workshifts;

}
