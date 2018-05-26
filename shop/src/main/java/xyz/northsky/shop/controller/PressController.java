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

import java.util.List;

@Controller
@RequestMapping("/press")
public class PressController {

    @Autowired
    private SyscodeService syscodeService;

    @GetMapping("/manage")
    public String pressIndex(Model model){
        List<LabelValueBean> labelValueBeanList = syscodeService.selectPressByCondition(null);
        model.addAttribute("presses", labelValueBeanList);
        return "press";
    }

    @PostMapping("/condition")
    public String selectPressByCondition(String proName, Model model) {
        List<LabelValueBean> syscodes = syscodeService.selectPressByCondition(proName);
        model.addAttribute("proName", proName);
        model.addAttribute("presses", syscodes);
        return "press";
    }

    @GetMapping("/manage/{pressId}")
    @ResponseBody
    public ResponseMessage selectPressById(@PathVariable("pressId") Integer pressId) {
        Syscode syscode = syscodeService.selectSyscodeById(pressId);
        return new ResponseMessage().data(syscode.getProName());
    }

    @PostMapping("/manage")
    public String insertPress(String proName, Model model) {
        boolean isInsert = syscodeService.insertPress(proName);
        List<LabelValueBean> labelValueBeanList = syscodeService.selectPressByCondition(null);
        model.addAttribute("presses", labelValueBeanList);
        return "press";
    }

    @PutMapping("/manage")
    public String updatePressById(Syscode syscode, Model model) {
        boolean isUpdate = syscodeService.updatePressSelective(syscode);
        List<LabelValueBean> labelValueBeanList = syscodeService.selectPressByCondition(null);
        model.addAttribute("presses", labelValueBeanList);
        return "press";
    }

    @DeleteMapping("/manage")
    public String deletePressById(Integer pressId, Model model) {
        boolean isDelete = syscodeService.deletePressById(pressId);
        List<LabelValueBean> labelValueBeanList = syscodeService.selectPressByCondition(null);
        model.addAttribute("presses", labelValueBeanList);
        return "press";
    }

    @DeleteMapping("/manage/batch")
    @ResponseBody
    public ResponseMessage batchDeletePressByIds(String id) {
        boolean isDelete = syscodeService.batchDeletePressByIds(id);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.code(isDelete ? ResponseCode.OK : ResponseCode.NO);
        return responseMessage;
    }
}
