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
@Table(name = "workplaces")
public class Workplace extends BaseEntity<Long>{

    @Column(name = "code")
    private Long code;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy="workplace", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "workplace", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<Workshift> workshifts;

}
