package dao;

import java.util.HashMap;
import java.util.List;

public interface KatedraDAO {

    List<HashMap<String, String>> createKatedra(String titleUa, String codeUa, String titleEn, String codeEn, int faculty);

    List<HashMap<String, String>> getKatedra(int id);

    List<HashMap<String, String>> getKatedraList();

    List<HashMap<String, String>> updateKatedra(int id, String titleUa, String codeUa, String titleEn, String codeEn, int faculty);

    List<HashMap<String, String>> deleteKatedra(int id);

}
