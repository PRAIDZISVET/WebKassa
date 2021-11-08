package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rests")
public class Rest extends BaseEntity<Long> {


    @OneToOne
    @JoinColumn(name = "curr_id", nullable = false)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "workshift_id", nullable = false)
    private  Workshift workshift;

    @Column(name = "sum")
    private BigDecimal sum;





}
