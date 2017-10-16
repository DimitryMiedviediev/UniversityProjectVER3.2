package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface GroupDAO {

    List<HashMap<String, String>> createGroup(String number, int status, int specialization, int educationForm, int academicDegree, Date startDate, Date endDate);

    List<HashMap<String, String>> getGroup(int id);

    List<HashMap<String, String>> getGroupList();

    List<HashMap<String, String>> updateGroup(int id, String number, int status, int specialization, int educationForm, int academicDegree, Date startDate, Date endDate);

    List<HashMap<String, String>> deleteGroup(int id);

}
