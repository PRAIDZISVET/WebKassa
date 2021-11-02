package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

}
