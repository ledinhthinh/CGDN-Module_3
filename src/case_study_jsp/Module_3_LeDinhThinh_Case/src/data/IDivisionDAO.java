package data;

import model.CustomerType;
import model.Division;

import java.util.List;

public interface IDivisionDAO {
    public List<Division> selectAllDivision();

    public Division selectDivisionNote(int id);
}
