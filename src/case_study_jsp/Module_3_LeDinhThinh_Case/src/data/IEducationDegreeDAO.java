package data;

import model.CustomerType;
import model.EducationDegree;

import java.util.List;

public interface IEducationDegreeDAO {
    public List<EducationDegree> selectAllEducationDegree();

    public EducationDegree selectEducationDegreeNote(int id);
}
