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

    @OneToMany(mappedBy = "currIn", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<Rate> ratesIn;

    @OneToMany(mappedBy = "currOut", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<Rate> ratesOut;

    @OneToOne(mappedBy = "currency", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private Rest rest;

}
