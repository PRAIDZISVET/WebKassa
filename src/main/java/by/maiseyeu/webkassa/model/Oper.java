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
@Table(name = "opers")
public class Oper extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "isactive")
    private boolean isActive;
}
