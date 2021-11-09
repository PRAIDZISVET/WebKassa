package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rests")
public class Rest extends BaseEntity<Long> {


    @OneToOne
    @JoinColumn(name = "curr_id")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "workshift_id")
    private  Workshift workshift;

    @Column(name = "sum")
    private BigDecimal sum;





}
