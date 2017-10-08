package service;

import dao.SpecializationDAO;
import dao.SpecializationDAOImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class SpecializationService {

    private SpecializationDAO specializationDAO = new SpecializationDAOImpl();

    @RequestMapping("/getSpecializationList")
    @ResponseBody
    List<HashMap<String, String>> getSpecializationList() {
        return specializationDAO.getSpecializationList();
    }

    @RequestMapping(value = "/getSpecialization",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> getSpecialization(@RequestParam(value = "id") int id) {
        return specializationDAO.getSpecialization(id);
    }

    @RequestMapping(value = "/createSpecialization",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> createSpecialization(@RequestParam(value = "titleUa") String titleUa,
                                                       @RequestParam(value = "codeUa") String codeUa,
                                                       @RequestParam(value = "titleEn") String titleEn,
                                                       @RequestParam(value = "codeEn") String codeEn,
                                                       @RequestParam(value = "speciality") int speciality,
                                                       @RequestParam(value = "bachelor") int bachelor,
                                                       @RequestParam(value = "specialist") int specialist,
                                                       @RequestParam(value = "master") int master,
                                                       @RequestParam(value = "katedra") int katedra) {
        return specializationDAO.createSpecialization(titleUa, codeUa, titleEn, codeEn, speciality, bachelor, specialist, master, katedra);
    }

    @RequestMapping(value = "/updateSpecialization",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> updateSpecialization(@RequestParam(value = "id") int id,
                                                       @RequestParam(value = "titleUa") String titleUa,
                                                       @RequestParam(value = "codeUa") String codeUa,
                                                       @RequestParam(value = "titleEn") String titleEn,
                                                       @RequestParam(value = "codeEn") String codeEn,
                                                       @RequestParam(value = "speciality") int speciality,
                                                       @RequestParam(value = "bachelor") int bachelor,
                                                       @RequestParam(value = "specialist") int specialist,
                                                       @RequestParam(value = "master") int master,
                                                       @RequestParam(value = "katedra") int katedra) {
        return specializationDAO.updateSpecialization(id, titleUa, codeUa, titleEn, codeEn, speciality, bachelor, specialist, master, katedra);
    }

    @RequestMapping(value = "/deleteSpecialization",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> deleteSpecialization(@RequestParam(value = "id") int id) {
        return specializationDAO.deleteSpecialization(id);
    }
}
