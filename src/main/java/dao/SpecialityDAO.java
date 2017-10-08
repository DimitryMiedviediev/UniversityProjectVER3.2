package dao;

import java.util.HashMap;
import java.util.List;

public interface SpecialityDAO {

    List<HashMap<String, String>> getSpeciality(int id);

    List<HashMap<String, String>> getSpecialityList();

}
