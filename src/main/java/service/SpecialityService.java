package service;

import dao.SpecialityDAO;
import dao.SpecialityDAOImpl;
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
public class SpecialityService {

    private SpecialityDAO specialityDAO = new SpecialityDAOImpl();

    @RequestMapping("/getSpecialityList")
    @ResponseBody
    List<HashMap<String, String>> getSpecialityList() {
        return specialityDAO.getSpecialityList();
    }

    @RequestMapping(value = "/getSpeciality",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> getSpeciality(@RequestParam(value = "id") int id) {
        return specialityDAO.getSpeciality(id);
    }

}
