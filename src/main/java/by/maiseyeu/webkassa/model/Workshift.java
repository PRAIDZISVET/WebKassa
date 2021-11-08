package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"receipts","rests"})
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workshifts")
public class Workshift extends BaseEntity<Long> {

    @Column(name = "open_date_time", nullable = false)
    private LocalDateTime openDateTime;

    @Column(name = "close_date_time")
    private LocalDateTime closeDateTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "workplace_id", nullable = false)
    private Workplace workplace;

    @OneToMany(mappedBy = "workshift")
    private List<Receipt> receipts;

    @OneToMany(mappedBy = "workshift")
    private List<Rest> rests;
}
