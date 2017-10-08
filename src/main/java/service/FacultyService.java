package service;

import dao.FacultyDAO;
import dao.FacultyDAOImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Dimitry on 01.10.17.
 */
@Controller
@EnableAutoConfiguration
public class FacultyService {

    private FacultyDAO facultyDAO = new FacultyDAOImpl();

    @RequestMapping("/getFacultyList")
    @ResponseBody
    List<HashMap<String, String>> getFacultyList() {
        return facultyDAO.getFacultyList();
    }

    @RequestMapping(value = "/getFaculty",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> getFaculty(@RequestParam(value = "id") int id) {
        return facultyDAO.getFaculty(id);
    }

    @RequestMapping(value = "/createFaculty",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> createFaculty(@RequestParam(value = "titleUa") String titleUa,
                                                @RequestParam(value = "codeUa") String codeUa,
                                                @RequestParam(value = "titleEn") String titleEn,
                                                @RequestParam(value = "codeEn") String codeEn,
                                                @RequestParam(value = "university") int university) {
        return facultyDAO.createFaculty(titleUa, codeUa, titleEn, codeEn, university);
    }

    @RequestMapping(value = "/updateFaculty",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> updateFaculty(@RequestParam(value = "id") int id,
                                                   @RequestParam(value = "titleUa") String titleUa,
                                                   @RequestParam(value = "codeUa") String codeUa,
                                                   @RequestParam(value = "titleEn") String titleEn,
                                                   @RequestParam(value = "codeEn") String codeEn,
                                                   @RequestParam(value = "university") int university) {
        return facultyDAO.updateFaculty(id, titleUa, codeUa, titleEn, codeEn, university);
    }

    @RequestMapping(value = "/deleteFaculty",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> deleteFaculty(@RequestParam(value = "id") int id) {
        return facultyDAO.deleteFaculty(id);
    }
}
