package service;

import dao.GroupDAO;
import dao.GroupDAOImpl;
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
public class GroupService {

    private GroupDAO groupDAO = new GroupDAOImpl();

    @RequestMapping("/getGroupList")
    @ResponseBody
    List<HashMap<String, String>> getGroupList() {
        return groupDAO.getGroupList();
    }

    @RequestMapping(value = "/getGroup",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> getGroup(@RequestParam(value = "id") int id) {
        return groupDAO.getGroup(id);
    }

    @RequestMapping(value = "/createGroup",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> createGroup(@RequestParam(value = "number") String number,
                                              @RequestParam(value = "status") int status,
                                              @RequestParam(value = "specialization") int specialization,
                                              @RequestParam(value = "educationForm") int educationForm,
                                              @RequestParam(value = "academicDegree") int academicDegree,
                                              @RequestParam(value = "startDate") Date startDate,
                                              @RequestParam(value = "endDate") Date endDate) {
        return groupDAO.createGroup(number, status, specialization, educationForm, academicDegree, startDate, endDate);
    }

    @RequestMapping(value = "/updateGroup",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> updateGroup(@RequestParam(value = "id") int id,
                                              @RequestParam(value = "number") String number,
                                              @RequestParam(value = "status") int status,
                                              @RequestParam(value = "specialization") int specialization,
                                              @RequestParam(value = "educationForm") int educationForm,
                                              @RequestParam(value = "academicDegree") int academicDegree,
                                              @RequestParam(value = "startDate") Date startDate,
                                              @RequestParam(value = "endDate") Date endDate) {
        return groupDAO.updateGroup(id, number, status, specialization, educationForm, academicDegree, startDate, endDate);
    }

    @RequestMapping(value = "/deleteGroup",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> deleteGroup(@RequestParam(value = "id") int id) {
        return groupDAO.deleteGroup(id);
    }

}
