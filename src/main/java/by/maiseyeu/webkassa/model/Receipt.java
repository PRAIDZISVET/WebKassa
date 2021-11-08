package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receipts")
public class Receipt extends BaseEntity<Long>{

    @ManyToOne
    @JoinColumn(name = "oper_id", nullable = false)
    private Oper oper;

    @ManyToOne
    @JoinColumn(name = "workshift_id", nullable = false)
    private Workshift workshift;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    private  Rate rate;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "sum")
    private BigDecimal sum;
}
