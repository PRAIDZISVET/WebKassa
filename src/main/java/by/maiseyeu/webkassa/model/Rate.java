package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rates")
public class Rate extends BaseEntity<Long>{

    @Column(name = "curr_in_id")
    private Integer currInId;

    @Column(name = "curr_out_id")
    private Integer currOutId;

    @Column(name = "value")
    private double value;

    @Column(name = "set_date_time")
    private LocalDateTime setDateTime;
}
