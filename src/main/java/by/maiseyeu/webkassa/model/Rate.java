package by.maiseyeu.webkassa.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rates")
public class Rate extends BaseEntity<Long>{

    @ManyToOne
    @JoinColumn(name = "curr_in_id")
    private Currency currIn;

    @ManyToOne
    @JoinColumn(name = "curr_out_id")
    private Currency currOut;

    @Column(name = "value")
    private double value;

    @Column(name = "set_date_time")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime setDateTime;
}
