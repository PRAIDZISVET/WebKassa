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
@Table(name = "currencies")
public class Currency extends BaseEntity<Long>{

    @Column(name = "code")
    private Integer code;

    @Column(name = "iso")
    private String iso;

    @Column(name = "name")
    private String name;

    @Column(name = "isactive")
    private boolean isActive;
}
