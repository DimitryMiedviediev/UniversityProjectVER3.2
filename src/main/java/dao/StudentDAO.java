package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface StudentDAO {

    List<HashMap<String, String>> createStudent(String studentNameUa,
                                                String studentSurnameUa,
                                                String studentLastnameUa,
                                                String studentNameEn,
                                                String studentSurnameEn,
                                                String studentLastnameEn,
                                                int group,
                                                int subgroup,
                                                int gender,
                                                String cityOfBirth,
                                                Date dateOfBirth,
                                                int identicationCode,
                                                int mainCitizenship,
                                                int nationality,
                                                int mainLingo,
                                                int maritalStatus,
                                                String studentBookNumber,
                                                String nationalStudentCard,
                                                String internationalStudentCard,
                                                String studentPass,
                                                int financingType,
                                                int credentialType,
                                                String credentialNumber,
                                                String credentialPublisher,
                                                Date credentialDate,
                                                int addressRegistration,
                                                int addressResidense,
                                                int studentContactPhone,
                                                int studentMobilePhone,
                                                int studentHomePhone,
                                                int studentWorkPhone,
                                                String studentContactEmail,
                                                String fatherName,
                                                String fatherSurname,
                                                String fatherLastname,
                                                int fatherContactPhone,
                                                int fatherMobilePhone,
                                                int fatherHomePhone,
                                                int fatherWorkPhone,
                                                String fatherContactEmail,
                                                String motherName,
                                                String motherSurname,
                                                String motherLastname,
                                                int motherContactPhone,
                                                int motherMobilePhone,
                                                int motherHomePhone,
                                                int motherWorkPhone,
                                                String motherContactEmail);

    List<HashMap<String, String>> getStudent(int id);

    List<HashMap<String, String>> getStudentList();

    List<HashMap<String, String>> updateStudent(int id,
                                                String studentNameUa,
                                                String studentSurnameUa,
                                                String studentLastnameUa,
                                                String studentNameEn,
                                                String studentSurnameEn,
                                                String studentLastnameEn,
                                                int group,
                                                int subgroup,
                                                int gender,
                                                String cityOfBirth,
                                                Date dateOfBirth,
                                                int identicationCode,
                                                int mainCitizenship,
                                                int nationality,
                                                int mainLingo,
                                                int maritalStatus,
                                                String studentBookNumber,
                                                String nationalStudentCard,
                                                String internationalStudentCard,
                                                String studentPass,
                                                int financingType,
                                                int credentialType,
                                                String credentialNumber,
                                                String credentialPublisher,
                                                Date credentialDate,
                                                int addressRegistration,
                                                int addressResidense,
                                                int studentContactPhone,
                                                int studentMobilePhone,
                                                int studentHomePhone,
                                                int studentWorkPhone,
                                                String studentContactEmail,
                                                String fatherName,
                                                String fatherSurname,
                                                String fatherLastname,
                                                int fatherContactPhone,
                                                int fatherMobilePhone,
                                                int fatherHomePhone,
                                                int fatherWorkPhone,
                                                String fatherContactEmail,
                                                String motherName,
                                                String motherSurname,
                                                String motherLastname,
                                                int motherContactPhone,
                                                int motherMobilePhone,
                                                int motherHomePhone,
                                                int motherWorkPhone,
                                                String motherContactEmail);

    List<HashMap<String, String>> deleteStudent(int id);

}
