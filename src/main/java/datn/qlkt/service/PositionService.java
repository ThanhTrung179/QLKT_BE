package datn.qlkt.service;

import datn.qlkt.model.Position;

public interface PositionService {

    Position findFirstEmtyPostion();

    void removeProductFromPosition(Position position) ;
}
