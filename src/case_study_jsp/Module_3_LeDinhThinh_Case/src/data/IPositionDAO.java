package data;

import model.CustomerType;
import model.Position;

import java.util.List;

public interface IPositionDAO {
    public List<Position> selectAllPosition();

    public CustomerType selectPositionNote(int id);
}
