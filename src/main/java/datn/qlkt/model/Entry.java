package datn.qlkt.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private WareHouse wareHouse;

    public Entry() {
    }


    public Entry(Long id, String idEntry, Date inTime, String note, WareHouse wareHouse) {
        this.id = id;
        this.idEntry = idEntry;
        this.inTime = inTime;
        this.note = note;
        this.wareHouse = wareHouse;
    }
}
