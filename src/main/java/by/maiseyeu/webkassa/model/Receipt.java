package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receipts")
public class Receipt extends BaseEntity<Long>{

    @ManyToOne
    @JoinColumn(name = "oper_id")
    private Oper oper;

    @ManyToOne
    @JoinColumn(name = "workshift_id")
    private Workshift workshift;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    private  Rate rate;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "sum")
    private BigDecimal sum;
}
