package dao;

import logic.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    private ConnectionDB connectionDB = new ConnectionDB();

    @Override
    public List<HashMap<String, String>> createStudent(String nameUa, String surnameUa, String lastnameUa, String nameEn, String surnameEn, String lastnameEn, int group, int subgroup, int gender, String cityOfBirth, Date dateOfBirth, int identicationCode, int mainCitizenship, int nationality, int mainLingo, int maritalStatus, String studentBookNumber, String nationalStudentCard, String internationalStudentCard, String studentPass, int financingType, int credentialType, String credentialNumber, String credentialPublisher, Date credentialDate, int addressRegistration, int addressResidense, int studentContactPhone, int studentMobilePhone, int studentHomePhone, int studentWorkPhone, String studentContactEmail, String fatherName, String fatherSurname, String fatherLastname, int fatherContactPhone, int fatherMobilePhone, int fatherHomePhone, int fatherWorkPhone, String fatherContactEmail, String motherName, String motherSurname, String motherLastname, int motherContactPhone, int motherMobilePhone, int motherHomePhone, int motherWorkPhone, String motherContactEmail) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            HashMap<String, String> pair = new HashMap<>();
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = conn.prepareCall("{call p_create_student(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("p_student_name_ua", nameUa);
            statement.setString("p_student_surname_ua", surnameUa);
            statement.setString("p_student_lastname_ua", lastnameUa);
            statement.setString("p_student_name_en", nameEn);
            statement.setString("p_student_surname_en", surnameEn);
            statement.setString("p_student_lastname_en", lastnameEn);
            statement.setInt("p_group_id", group);
            statement.setInt("p_subgroup_number", subgroup);
            statement.setInt("p_gender", gender);
            statement.setString("p_city_of_birth", cityOfBirth);
            statement.setDate("p_titlep_date_of_birth_ua", (java.sql.Date) dateOfBirth);
            statement.setInt("p_identication_code", identicationCode);
            statement.setInt("p_main_citizenship", mainCitizenship);
            statement.setInt("p_nationality", nationality);
            statement.setInt("p_main_lingo", mainLingo);
            statement.setInt("p_marital_status", maritalStatus);
            statement.setString("p_student_book_number", studentBookNumber);
            statement.setString("p_national_student_card", nationalStudentCard);
            statement.setString("p_international_student_card", internationalStudentCard);
            statement.setString("p_student_pass", studentPass);
            statement.setInt("p_financing_type", financingType);
            statement.setInt("p_credential_type", credentialType);
            statement.setString("p_credential_number", credentialNumber);
            statement.setString("p_credential_publisher", credentialPublisher);
            statement.setDate("p_credential_date", (java.sql.Date) credentialDate);
            statement.setInt("p_address_registration", addressRegistration);
            statement.setInt("p_address_residense", addressResidense);
            statement.setInt("p_student_contact_phone", studentContactPhone);
            statement.setInt("p_student_mobile_phone", studentMobilePhone);
            statement.setInt("p_student_home_phone", studentHomePhone);
            statement.setInt("p_student_work_phone", studentWorkPhone);
            statement.setString("p_student_email", studentContactEmail);
            statement.setString("p_father_name", fatherName);
            statement.setString("p_father_surname", fatherSurname);
            statement.setString("p_father_lastname", fatherLastname);
            statement.setInt("p_father_contact_phone", fatherContactPhone);
            statement.setInt("p_father_mobile_phone", fatherMobilePhone);
            statement.setInt("p_father_home_phone", fatherHomePhone);
            statement.setInt("p_father_work_phone", fatherWorkPhone);
            statement.setString("p_father_email", fatherContactEmail);
            statement.setString("p_mother_name", motherName);
            statement.setString("p_mother_surname", motherSurname);
            statement.setString("p_mother_lastname", motherLastname);
            statement.setInt("p_mother_contact_phone", motherContactPhone);
            statement.setInt("p_mother_mobile_phone", motherMobilePhone);
            statement.setInt("p_mother_home_phone", motherHomePhone);
            statement.setInt("p_mother_work_phone", motherWorkPhone);
            statement.setString("p_mother_email", motherContactEmail);
            statement.execute();
            pair.put("responseCode", statement.getString("p_response_code"));
            pair.put("responseMessage", statement.getString("p_response_message"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;
    }

    @Override
    public List<HashMap<String, String>> getStudent(int id) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "select * from v_student where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                HashMap<String, String> pair = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    pair.put(resultSet.getMetaData().getColumnName(i), resultSet.getString(resultSet.getMetaData().getColumnName(i)));
                }
                list.add(pair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;
    }

    @Override
    public List<HashMap<String, String>> getStudentList() {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();

        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from v_student");
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                HashMap<String, String> pair = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    pair.put(resultSet.getMetaData().getColumnName(i), resultSet.getString(resultSet.getMetaData().getColumnName(i)));
                }
                list.add(pair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;
    }

    @Override
    public List<HashMap<String, String>> updateStudent(int id, String nameUa, String surnameUa, String lastnameUa, String nameEn, String surnameEn, String lastnameEn, int group, int subgroup, int gender, String cityOfBirth, Date dateOfBirth, int identicationCode, int mainCitizenship, int nationality, int mainLingo, int maritalStatus, String studentBookNumber, String nationalStudentCard, String internationalStudentCard, String studentPass, int financingType, int credentialType, String credentialNumber, String credentialPublisher, Date credentialDate, int addressRegistration, int addressResidense, int studentContactPhone, int studentMobilePhone, int studentHomePhone, int studentWorkPhone, String studentContactEmail, String fatherName, String fatherSurname, String fatherLastname, int fatherContactPhone, int fatherMobilePhone, int fatherHomePhone, int fatherWorkPhone, String fatherContactEmail, String motherName, String motherSurname, String motherLastname, int motherContactPhone, int motherMobilePhone, int motherHomePhone, int motherWorkPhone, String motherContactEmail) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = conn.prepareCall("{call p_update_student(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setInt("p_id", id);
            statement.setString("p_student_name_ua", nameUa);
            statement.setString("p_student_surname_ua", surnameUa);
            statement.setString("p_student_lastname_ua", lastnameUa);
            statement.setString("p_student_name_en", nameEn);
            statement.setString("p_student_surname_en", surnameEn);
            statement.setString("p_student_lastname_en", lastnameEn);
            statement.setInt("p_group_id", group);
            statement.setInt("p_subgroup_number", subgroup);
            statement.setInt("p_gender", gender);
            statement.setString("p_city_of_birth", cityOfBirth);
            statement.setDate("p_titlep_date_of_birth_ua", (java.sql.Date) dateOfBirth);
            statement.setInt("p_identication_code", identicationCode);
            statement.setInt("p_main_citizenship", mainCitizenship);
            statement.setInt("p_nationality", nationality);
            statement.setInt("p_main_lingo", mainLingo);
            statement.setInt("p_marital_status", maritalStatus);
            statement.setString("p_student_book_number", studentBookNumber);
            statement.setString("p_national_student_card", nationalStudentCard);
            statement.setString("p_international_student_card", internationalStudentCard);
            statement.setString("p_student_pass", studentPass);
            statement.setInt("p_financing_type", financingType);
            statement.setInt("p_credential_type", credentialType);
            statement.setString("p_credential_number", credentialNumber);
            statement.setString("p_credential_publisher", credentialPublisher);
            statement.setDate("p_credential_date", (java.sql.Date) credentialDate);
            statement.setInt("p_address_registration", addressRegistration);
            statement.setInt("p_address_residense", addressResidense);
            statement.setInt("p_student_contact_phone", studentContactPhone);
            statement.setInt("p_student_mobile_phone", studentMobilePhone);
            statement.setInt("p_student_home_phone", studentHomePhone);
            statement.setInt("p_student_work_phone", studentWorkPhone);
            statement.setString("p_student_email", studentContactEmail);
            statement.setString("p_father_name", fatherName);
            statement.setString("p_father_surname", fatherSurname);
            statement.setString("p_father_lastname", fatherLastname);
            statement.setInt("p_father_contact_phone", fatherContactPhone);
            statement.setInt("p_father_mobile_phone", fatherMobilePhone);
            statement.setInt("p_father_home_phone", fatherHomePhone);
            statement.setInt("p_father_work_phone", fatherWorkPhone);
            statement.setString("p_father_email", fatherContactEmail);
            statement.setString("p_mother_name", motherName);
            statement.setString("p_mother_surname", motherSurname);
            statement.setString("p_mother_lastname", motherLastname);
            statement.setInt("p_mother_contact_phone", motherContactPhone);
            statement.setInt("p_mother_mobile_phone", motherMobilePhone);
            statement.setInt("p_mother_home_phone", motherHomePhone);
            statement.setInt("p_mother_work_phone", motherWorkPhone);
            statement.setString("p_mother_email", motherContactEmail);
            statement.execute();
            HashMap<String, String> pair = new HashMap<>();
            pair.put("responseCode", statement.getString("p_response_code"));
            pair.put("responseMessage", statement.getString("p_response_message"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;
    }

    @Override
    public List<HashMap<String, String>> deleteStudent(int id) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = conn.prepareCall("{call p_delete_student(?,?,?)}");
            statement.setInt("p_id", id);
            statement.execute();

            HashMap<String, String> pair = new HashMap<>();
            pair.put("responseCode", statement.getString("p_response_code"));
            pair.put("responseMessage", statement.getString("p_response_message"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;
    }
}
