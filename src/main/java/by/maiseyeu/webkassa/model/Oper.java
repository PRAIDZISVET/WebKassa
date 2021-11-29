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
@Table(name = "opers")
public class Oper extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "isincom")
    private boolean isIncom;

    @Column(name = "isclient")
    private boolean isClient;

    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(mappedBy = "oper", cascade = {CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Receipt> receipts;
}
