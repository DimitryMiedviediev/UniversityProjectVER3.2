package service;

import dao.KatedraDAO;
import dao.KatedraDAOImpl;
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
public class KatedraService {

    private KatedraDAO katedraDAO = new KatedraDAOImpl();

    @RequestMapping("/getKatedraList")
    @ResponseBody
    List<HashMap<String, String>> getKatedraList() {
        return katedraDAO.getKatedraList();
    }

    @RequestMapping(value = "/getKatedra",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> getKatedra(@RequestParam(value = "id") int id) {
        return katedraDAO.getKatedra(id);
    }

    @RequestMapping(value = "/createKatedra",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> createKatedra(@RequestParam(value = "titleUa") String titleUa,
                                                @RequestParam(value = "codeUa") String codeUa,
                                                @RequestParam(value = "titleEn") String titleEn,
                                                @RequestParam(value = "codeEn") String codeEn,
                                                @RequestParam(value = "faculty") int faculty) {
        return katedraDAO.createKatedra(titleUa, codeUa, titleEn, codeEn, faculty);
    }

    @RequestMapping(value = "/updateKatedra",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> updateKatedra(@RequestParam(value = "id") int id,
                                                   @RequestParam(value = "titleUa") String titleUa,
                                                   @RequestParam(value = "codeUa") String codeUa,
                                                   @RequestParam(value = "titleEn") String titleEn,
                                                   @RequestParam(value = "codeEn") String codeEn,
                                                   @RequestParam(value = "faculty") int faculty) {
        return katedraDAO.updateKatedra(id, titleUa, codeUa, titleEn, codeEn, faculty);
    }

    @RequestMapping(value = "/deleteKatedra",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> deleteKatedra(@RequestParam(value = "id") int id) {
        return katedraDAO.deleteKatedra(id);
    }
}
