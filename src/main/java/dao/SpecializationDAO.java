package dao;

import java.util.HashMap;
import java.util.List;

public interface SpecializationDAO {

    List<HashMap<String, String>> createSpecialization(String titleUa, String codeUa, String titleEn, String codeEn, int speciality, int bachelor, int specialist, int master, int katedra);

    List<HashMap<String, String>> getSpecialization(int id);

    List<HashMap<String, String>> getSpecializationList();

    List<HashMap<String, String>> updateSpecialization(int id, String titleUa, String codeUa, String titleEn, String codeEn, int speciality, int bachelor, int specialist, int master, int katedra);

    List<HashMap<String, String>> deleteSpecialization(int id);

}
