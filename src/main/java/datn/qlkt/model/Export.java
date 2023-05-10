package datn.qlkt.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Table(name = "export")
public class Export {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idExport;
    private Date inTime = new Date();
    private String note;
    @OneToMany(mappedBy = "export", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<WareHouseExport> wareHouseExports;
    private Long moneyTotal;
    private Integer is_active;
    private String creator;

    public Export(Long id, String idExport, Date inTime, String note, Collection<WareHouseExport> wareHouseExports, Long moneyTotal, String creator, Integer is_active) {
        this.id = id;
        this.idExport = idExport;
        this.inTime = inTime;
        this.note = note;
        this.wareHouseExports = wareHouseExports;
        this.moneyTotal = moneyTotal;
        this.is_active = is_active;
        this.creator = creator;
    }

    public Export() {
    }
}
