package service;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class StudentService {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @RequestMapping("/getStudentList")
    @ResponseBody
    List<HashMap<String, String>> getStudentList() {
        return studentDAO.getStudentList();
    }

    @RequestMapping(value = "/getStudent",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> getStudent(@RequestParam(value = "id") int id) {
        return studentDAO.getStudent(id);
    }

    @RequestMapping(value = "/createStudent",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> createStudent(@RequestParam(value = "studentNameUa") String studentNameUa,
                                                @RequestParam(value = "studentSurnameUa") String studentSurnameUa,
                                                @RequestParam(value = "studentLastnameUa") String studentLastnameUa,
                                                @RequestParam(value = "studentNameEn") String studentNameEn,
                                                @RequestParam(value = "studentSurnameEn") String studentSurnameEn,
                                                @RequestParam(value = "studentLastnameEn") String studentLastnameEn,
                                                @RequestParam(value = "group") int group,
                                                @RequestParam(value = "subgroup") int subgroup,
                                                @RequestParam(value = "gender") int gender,
                                                @RequestParam(value = "cityOfBirth") String cityOfBirth,
                                                @RequestParam(value = "dateOfBirth") Date dateOfBirth,
                                                @RequestParam(value = "identicationCode") int identicationCode,
                                                @RequestParam(value = "mainCitizenship") int mainCitizenship,
                                                @RequestParam(value = "nationality") int nationality,
                                                @RequestParam(value = "mainLingo") int mainLingo,
                                                @RequestParam(value = "maritalStatus") int maritalStatus,
                                                @RequestParam(value = "studentBookNumber") String studentBookNumber,
                                                @RequestParam(value = "nationalStudentCard") String nationalStudentCard,
                                                @RequestParam(value = "internationalStudentCard") String internationalStudentCard,
                                                @RequestParam(value = "studentPass") String studentPass,
                                                @RequestParam(value = "financingType") int financingType,
                                                @RequestParam(value = "credentialType") int credentialType,
                                                @RequestParam(value = "credentialNumber") String credentialNumber,
                                                @RequestParam(value = "credentialPublisher") String credentialPublisher,
                                                @RequestParam(value = "credentialDate") Date credentialDate,
                                                @RequestParam(value = "addressRegistration") int addressRegistration,
                                                @RequestParam(value = "addressResidense") int addressResidense,
                                                @RequestParam(value = "studentContactPhone") int studentContactPhone,
                                                @RequestParam(value = "studentMobilePhone") int studentMobilePhone,
                                                @RequestParam(value = "studentHomePhone") int studentHomePhone,
                                                @RequestParam(value = "studentWorkPhone") int studentWorkPhone,
                                                @RequestParam(value = "studentContactEmail") String studentContactEmail,
                                                @RequestParam(value = "fatherName") String fatherName,
                                                @RequestParam(value = "fatherSurname") String fatherSurname,
                                                @RequestParam(value = "fatherLastname") String fatherLastname,
                                                @RequestParam(value = "fatherContactPhone") int fatherContactPhone,
                                                @RequestParam(value = "fatherMobilePhone") int fatherMobilePhone,
                                                @RequestParam(value = "fatherHomePhone") int fatherHomePhone,
                                                @RequestParam(value = "fatherWorkPhone") int fatherWorkPhone,
                                                @RequestParam(value = "fatherContactEmail") String fatherContactEmail,
                                                @RequestParam(value = "fatherName") String motherName,
                                                @RequestParam(value = "fatherSurname") String motherSurname,
                                                @RequestParam(value = "fatherLastname") String motherLastname,
                                                @RequestParam(value = "fatherContactPhone") int motherContactPhone,
                                                @RequestParam(value = "fatherMobilePhone") int motherMobilePhone,
                                                @RequestParam(value = "fatherHomePhone") int motherHomePhone,
                                                @RequestParam(value = "fatherWorkPhone") int motherWorkPhone,
                                                @RequestParam(value = "fatherContactEmail") String motherContactEmail) {
        return studentDAO.createStudent(studentNameUa, studentSurnameUa, studentLastnameUa, studentNameEn, studentSurnameEn, studentLastnameEn, group, subgroup, gender, cityOfBirth, dateOfBirth, identicationCode, mainCitizenship, nationality, mainLingo, maritalStatus, studentBookNumber, nationalStudentCard, internationalStudentCard, studentPass, financingType, credentialType, credentialNumber, credentialPublisher, credentialDate, addressRegistration, addressResidense, studentContactPhone, studentMobilePhone, studentHomePhone, studentWorkPhone, studentContactEmail, fatherName, fatherSurname, fatherLastname, fatherContactPhone, fatherMobilePhone, fatherHomePhone, fatherWorkPhone, fatherContactEmail, motherName, motherSurname, motherLastname, motherContactPhone, motherMobilePhone, motherHomePhone, motherWorkPhone, motherContactEmail);
    }

    @RequestMapping(value = "/updateStudent",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> updateStudent(@RequestParam(value = "id") int id,
                                                @RequestParam(value = "studentNameUa") String studentNameUa,
                                                @RequestParam(value = "studentSurnameUa") String studentSurnameUa,
                                                @RequestParam(value = "studentLastnameUa") String studentLastnameUa,
                                                @RequestParam(value = "studentNameEn") String studentNameEn,
                                                @RequestParam(value = "studentSurnameEn") String studentSurnameEn,
                                                @RequestParam(value = "studentLastnameEn") String studentLastnameEn,
                                                @RequestParam(value = "group") int group,
                                                @RequestParam(value = "subgroup") int subgroup,
                                                @RequestParam(value = "gender") int gender,
                                                @RequestParam(value = "cityOfBirth") String cityOfBirth,
                                                @RequestParam(value = "dateOfBirth") Date dateOfBirth,
                                                @RequestParam(value = "identicationCode") int identicationCode,
                                                @RequestParam(value = "mainCitizenship") int mainCitizenship,
                                                @RequestParam(value = "nationality") int nationality,
                                                @RequestParam(value = "mainLingo") int mainLingo,
                                                @RequestParam(value = "maritalStatus") int maritalStatus,
                                                @RequestParam(value = "studentBookNumber") String studentBookNumber,
                                                @RequestParam(value = "nationalStudentCard") String nationalStudentCard,
                                                @RequestParam(value = "internationalStudentCard") String internationalStudentCard,
                                                @RequestParam(value = "studentPass") String studentPass,
                                                @RequestParam(value = "financingType") int financingType,
                                                @RequestParam(value = "credentialType") int credentialType,
                                                @RequestParam(value = "credentialNumber") String credentialNumber,
                                                @RequestParam(value = "credentialPublisher") String credentialPublisher,
                                                @RequestParam(value = "credentialDate") Date credentialDate,
                                                @RequestParam(value = "addressRegistration") int addressRegistration,
                                                @RequestParam(value = "addressResidense") int addressResidense,
                                                @RequestParam(value = "studentContactPhone") int studentContactPhone,
                                                @RequestParam(value = "studentMobilePhone") int studentMobilePhone,
                                                @RequestParam(value = "studentHomePhone") int studentHomePhone,
                                                @RequestParam(value = "studentWorkPhone") int studentWorkPhone,
                                                @RequestParam(value = "studentContactEmail") String studentContactEmail,
                                                @RequestParam(value = "fatherName") String fatherName,
                                                @RequestParam(value = "fatherSurname") String fatherSurname,
                                                @RequestParam(value = "fatherLastname") String fatherLastname,
                                                @RequestParam(value = "fatherContactPhone") int fatherContactPhone,
                                                @RequestParam(value = "fatherMobilePhone") int fatherMobilePhone,
                                                @RequestParam(value = "fatherHomePhone") int fatherHomePhone,
                                                @RequestParam(value = "fatherWorkPhone") int fatherWorkPhone,
                                                @RequestParam(value = "fatherContactEmail") String fatherContactEmail,
                                                @RequestParam(value = "fatherName") String motherName,
                                                @RequestParam(value = "fatherSurname") String motherSurname,
                                                @RequestParam(value = "fatherLastname") String motherLastname,
                                                @RequestParam(value = "fatherContactPhone") int motherContactPhone,
                                                @RequestParam(value = "fatherMobilePhone") int motherMobilePhone,
                                                @RequestParam(value = "fatherHomePhone") int motherHomePhone,
                                                @RequestParam(value = "fatherWorkPhone") int motherWorkPhone,
                                                @RequestParam(value = "fatherContactEmail") String motherContactEmail) {
        return studentDAO.updateStudent(id, studentNameUa, studentSurnameUa, studentLastnameUa, studentNameEn, studentSurnameEn, studentLastnameEn, group, subgroup, gender, cityOfBirth, dateOfBirth, identicationCode, mainCitizenship, nationality, mainLingo, maritalStatus, studentBookNumber, nationalStudentCard, internationalStudentCard, studentPass, financingType, credentialType, credentialNumber, credentialPublisher, credentialDate, addressRegistration, addressResidense, studentContactPhone, studentMobilePhone, studentHomePhone, studentWorkPhone, studentContactEmail, fatherName, fatherSurname, fatherLastname, fatherContactPhone, fatherMobilePhone, fatherHomePhone, fatherWorkPhone, fatherContactEmail, motherName, motherSurname, motherLastname, motherContactPhone, motherMobilePhone, motherHomePhone, motherWorkPhone, motherContactEmail);
    }

    @RequestMapping(value = "/deleteStudent",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> deleteStudent(@RequestParam(value = "id") int id) {
        return studentDAO.deleteStudent(id);
    }
}
