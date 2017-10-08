package dao;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Dimitry on 9/19/17.
 */
public interface UniversityDAO {

    List<HashMap<String, String>> createUniversity(String titleUa, String codeUa, String titleEn, String codeEn);

    List<HashMap<String, String>> getUniversity(int id);

    List<HashMap<String, String>> getUniversityList();

    List<HashMap<String, String>> updateUniversity(int id, String titleUa, String codeUa, String titleEn, String codeEn);

    List<HashMap<String, String>> deleteUniversity(int id);

}
