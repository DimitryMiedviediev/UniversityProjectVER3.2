package dao;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Dimitry on 01.10.17.
 */
public interface FacultyDAO {

    List<HashMap<String, String>> createFaculty(String titleUa, String codeUa, String titleEn, String codeEn, int university);

    List<HashMap<String, String>> getFaculty(int id);

    List<HashMap<String, String>> getFacultyList();

    List<HashMap<String, String>> updateFaculty(int id, String titleUa, String codeUa, String titleEn, String codeEn, int university);

    List<HashMap<String, String>> deleteFaculty(int id);

}
