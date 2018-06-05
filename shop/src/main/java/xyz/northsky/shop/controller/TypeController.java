package xyz.northsky.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.northsky.shop.entity.Syscode;
import xyz.northsky.shop.service.SyscodeService;
import xyz.northsky.shop.utils.ResponseCode;
import xyz.northsky.shop.utils.ResponseMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private SyscodeService syscodeService;

    @GetMapping(value = "/manage")
    public String typeIndex(Model model){
        List<Map<String, Object>> types =  syscodeService.selectTypesByCondition(null, null);
        model.addAttribute("types", types);
        return "type";
    }

    @RequestMapping(value = "/condition", method = RequestMethod.POST)
    public String searchTypeByCondition(String secondName, Integer firstType, Model model){
        List<Map<String, Object>> types =  syscodeService.selectTypesByCondition(secondName, firstType);
        model.addAttribute("types", types);
        model.addAttribute("secondName", secondName);
        model.addAttribute("firstType", firstType);
        return "type";
    }

    @GetMapping("/manage/{typeId}")
    @ResponseBody
    public ResponseMessage selectTypeByTypeId(@PathVariable("typeId") Integer typeId){
        HashMap<String, Object> map = syscodeService.selectTypeByTypeId(typeId);
        return new ResponseMessage().data(map);
    }

    @PutMapping("/manage")
    public String updateTypeById(Syscode syscode, Model model) {
        boolean isUpdate = syscodeService.updateTypeSelective(syscode);
        List<Map<String, Object>> types =  syscodeService.selectTypesByCondition(null, null);
        model.addAttribute("types", types);
        return "type";
    }

    @PostMapping("/manage")
    public String insertType(Syscode syscode, Model model) {
        boolean isInsert = syscodeService.insertType(syscode);
        List<Map<String, Object>> types =  syscodeService.selectTypesByCondition(null, null);
        model.addAttribute("types", types);
        return "type";
    }

    @DeleteMapping("/manage")
    public String deleteTypeById(Integer typeId, Model model) {
        boolean isDelete = syscodeService.deleteTypeById(typeId);
        List<Map<String, Object>> types =  syscodeService.selectTypesByCondition(null, null);
        model.addAttribute("types", types);
        return "type";
    }

    @DeleteMapping("/manage/batch")
    @ResponseBody
    public ResponseMessage batchDeleteTypeByIds(String ids) {
        boolean isDelete = syscodeService.batchDeleteByIds(ids);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.code(isDelete ? ResponseCode.OK : ResponseCode.NO);
        return responseMessage;
    }

}
