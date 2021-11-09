package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true, exclude = {"ratesIn","ratesOut", "rest"})
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

    @OneToMany(mappedBy = "currIn")
    private List<Rate> ratesIn;

    @OneToMany(mappedBy = "currOut")
    private List<Rate> ratesOut;

    @OneToOne(mappedBy = "currency")
    private Rest rest;

}
