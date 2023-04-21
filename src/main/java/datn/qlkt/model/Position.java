package datn.qlkt.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    @OneToOne
    private WareHouse wareHouse;
}
