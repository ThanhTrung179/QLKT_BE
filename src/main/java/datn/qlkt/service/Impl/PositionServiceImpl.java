package datn.qlkt.service.Impl;

import datn.qlkt.model.Position;
import datn.qlkt.repository.PositionRepository;
import datn.qlkt.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public Position findFirstEmtyPostion() {
        return positionRepository.findFirstByWareHouseIsNull();
    }

    @Override
    public void removeProductFromPosition(Position position) {
        position.setWareHouse(null);

        positionRepository.save(position);
    }
}
