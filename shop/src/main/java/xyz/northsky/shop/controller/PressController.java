package xyz.northsky.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.northsky.shop.dto.LabelValueBean;
import xyz.northsky.shop.entity.Syscode;
import xyz.northsky.shop.service.SyscodeService;
import xyz.northsky.shop.utils.ResponseCode;
import xyz.northsky.shop.utils.ResponseMessage;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/press")
public class PressController {

    @Autowired
    private SyscodeService syscodeService;

    @GetMapping("/manage")
    public String pressIndex(HttpSession session){
        List<LabelValueBean> labelValueBeanList = syscodeService.selectPressByCondition(null);
        session.setAttribute("presses", labelValueBeanList);
        return "press";
    }

    @PostMapping("/condition")
    public String selectPressByCondition(String proName, HttpSession session, Model model) {
        List<LabelValueBean> syscodes = syscodeService.selectPressByCondition(proName);
        model.addAttribute("proName", proName);
        session.setAttribute("presses", syscodes);
        return "press";
    }

    @GetMapping("/manage/{pressId}")
    @ResponseBody
    public ResponseMessage selectPressById(@PathVariable("pressId") Integer pressId) {
        Syscode syscode = syscodeService.selectSyscodeById(pressId);
        return new ResponseMessage().data(syscode.getProName());
    }

    @PostMapping("/manage")
    public String insertPress(String proName, HttpSession session) {
        boolean isInsert = syscodeService.insertPress(proName);
        List<LabelValueBean> labelValueBeanList = syscodeService.selectPressByCondition(null);
        session.setAttribute("presses", labelValueBeanList);
        return "press";
    }

    @PutMapping("/manage")
    public String updatePressById(Syscode syscode, HttpSession session) {
        boolean isUpdate = syscodeService.updatePressSelective(syscode);
        List<LabelValueBean> labelValueBeanList = syscodeService.selectPressByCondition(null);
        session.setAttribute("presses", labelValueBeanList);
        return "press";
    }

    @DeleteMapping("/manage")
    public String deletePressById(Integer pressId, HttpSession session) {
        boolean isDelete = syscodeService.deletePressById(pressId);
        List<LabelValueBean> labelValueBeanList = syscodeService.selectPressByCondition(null);
        session.setAttribute("presses", labelValueBeanList);
        return "press";
    }

    @DeleteMapping("/manage/batch")
    @ResponseBody
    public ResponseMessage batchDeletePressByIds(String id, HttpSession session) {
        boolean isDelete = syscodeService.batchDeletePressByIds(id);
        List<LabelValueBean> labelValueBeanList = syscodeService.selectPressByCondition(null);
        session.setAttribute("presses", labelValueBeanList);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.code(isDelete ? ResponseCode.OK : ResponseCode.NO);
        return responseMessage;
    }
}
