package service;

import dao.UniversityDAO;
import dao.UniversityDAOImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Dimitry on 22.09.17.
 */
@Controller
@EnableAutoConfiguration
public class UniversityService {

    private UniversityDAO universityDAO = new UniversityDAOImpl();

    @RequestMapping("/getUniversityList")
    @ResponseBody
    List<HashMap<String, String>> getUniversitiesList() {
        return universityDAO.getUniversityList();
    }

    @RequestMapping(value = "/getUniversity",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> getUniversity(@RequestParam(value = "id") int id) {
        return universityDAO.getUniversity(id);
    }

    @RequestMapping(value = "/createUniversity",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> createUniversity(@RequestParam(value = "titleUa") String titleUa,
                                                   @RequestParam(value = "codeUa") String codeUa,
                                                   @RequestParam(value = "titleEn") String titleEn,
                                                   @RequestParam(value = "codeEn") String codeEn) {
        return universityDAO.createUniversity(titleUa, codeUa, titleEn, codeEn);
    }

    @RequestMapping(value = "/updateUniversity",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> updateUniversity(@RequestParam(value = "id") int id,
                                                   @RequestParam(value = "titleUa") String titleUa,
                                                   @RequestParam(value = "codeUa") String codeUa,
                                                   @RequestParam(value = "titleEn") String titleEn,
                                                   @RequestParam(value = "codeEn") String codeEn) {
        return universityDAO.updateUniversity(id, titleUa, codeUa, titleEn, codeEn);
    }

    @RequestMapping(value = "/deleteUniversity",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> deleteUniversity(@RequestParam(value = "id") int id) {
        return universityDAO.deleteUniversity(id);
    }

}
