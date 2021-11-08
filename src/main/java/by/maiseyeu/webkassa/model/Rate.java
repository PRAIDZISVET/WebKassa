package by.maiseyeu.webkassa.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "receipts")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rates")
public class Rate extends BaseEntity<Long>{

    @ManyToOne
    @JoinColumn(name = "curr_in_id", nullable = false)
    private Currency currIn;

    @ManyToOne
    @JoinColumn(name = "curr_out_id", nullable = false)
    private Currency currOut;

    @Column(name = "value")
    private double value;

    @Column(name = "set_date_time", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime setDateTime;

    @OneToMany(mappedBy = "rate")
    private List<Receipt> receipts;
}
