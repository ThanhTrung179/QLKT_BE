package datn.qlkt.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Table(name = "entry")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idEntry;
    private Date inTime = new Date();
    private String note;
    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<WareHouse> wareHouse;
    private Long moneyTotal;
    private String creator;
    private Integer isActive;

    public Entry() {
    }


    public Entry(Long id, String idEntry, Date inTime, String note, List<WareHouse> wareHouse, String creator, Long moneyTotal,Integer isActive) {
        this.id = id;
        this.idEntry = idEntry;
        this.inTime = inTime;
        this.note = note;
        this.wareHouse = wareHouse;
        this.isActive = isActive;
        this.creator = creator;
        this.moneyTotal = moneyTotal;
    }
}
