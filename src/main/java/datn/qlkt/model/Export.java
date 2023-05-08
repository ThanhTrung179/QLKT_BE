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
    private Integer isActive;

    public Export(Long id, String idExport, Date inTime, String note, Collection<WareHouseExport> wareHouseExports, Integer isActive) {
        this.id = id;
        this.idExport = idExport;
        this.inTime = inTime;
        this.note = note;
        this.wareHouseExports = wareHouseExports;
        this.isActive = isActive;
    }

    public Export() {
    }
}
