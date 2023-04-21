package datn.qlkt.repository;

import datn.qlkt.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {

    Position findFirstByWareHouseIsNull();
}
