package by.maiseyeu.webkassa.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workshifts")
public class Workshift extends BaseEntity<Long> {

    @Column(name = "open_date_time")
    private LocalDateTime openDateTime;

    @Column(name = "close_date_time")
    private LocalDateTime closeDateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "workplace_id")
    private Workplace workplace;

    @OneToMany(mappedBy = "workshift", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<Receipt> receipts;

    @OneToMany(mappedBy = "workshift", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private Set<Rest> rests;
}
