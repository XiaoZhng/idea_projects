package com.pharmacy.controller;

import com.pharmacy.domain.Drugs;
import com.pharmacy.domain.Drugstock;
import com.pharmacy.service.DrugsService;
import com.pharmacy.service.DrugstockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 药品信息接口
 * @author Alonso
 */
@Controller
public class DrugsController {

    @Resource
    private DrugsService drugsService;

    @Resource
    private DrugstockService drugstockService;

    /**
     * 药品管理
     * @param model
     * @return
     */
    @GetMapping("/drugs")
    public String drugs(Model model){
        List<Drugs> drugs = drugsService.drugsList();
        model.addAttribute("drugs", drugs);
        return "info";
    }

    /**
     * 查询药品
     * @param drugsName
     * @param factory
     * @param model
     * @return
     */
    @PostMapping("/searchDrugs")
    public String searchDrugs(String drugsName, String factory, Model model){
        //药品名称。生产厂家都为空
        if (Objects.equals(drugsName, "") && Objects.equals(factory, "")){
            return "redirect:/drugs";
        }
        //药品名称为空
        if (Objects.equals(drugsName, "") && !Objects.equals(factory, "")){
            List<Drugs> searchDrugsByFactory = drugsService.searchDrugsByFactory(factory);
            //查询失败
            if (searchDrugsByFactory.isEmpty()){
                model.addAttribute("searchError", "查询的药品不存在...");
                return "error";
            }
            model.addAttribute("drugs", searchDrugsByFactory);
            return "info";
        }
        //生产厂家为空
        if (!Objects.equals(drugsName, "") && Objects.equals(factory, "")){
            List<Drugs> searchDrugsByDrugsName = drugsService.searchDrugsByDrugsName(drugsName);
            //查询失败
            if (searchDrugsByDrugsName.isEmpty()){
                model.addAttribute("searchError", "查询的药品不存在...");
                return "error";
            }
            model.addAttribute("drugs", searchDrugsByDrugsName);
            return "info";
        }
        List<Drugs> searchByDrugs = drugsService.searchDrugs(drugsName, factory);
        //查询失败
        if (searchByDrugs.isEmpty()){
            model.addAttribute("searchError", "查询的药品不存在...");
            return "error";
        }
        model.addAttribute("drugs", searchByDrugs);
        return "info";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/add")
    public String toAdd(){
        return "add";
    }

    /**
     * 添加药品
     * @param drugs
     * @return
     */
    @PostMapping("/addDrugs")
    public String addDrugs(Drugs drugs){
        //没写药品名称就不能添加
        if (drugs.getDrugsName().equals("")){
            return "redirect:/drugs";
        }
        boolean result = drugsService.addDrugs(drugs);
        if (result){
            //药品添加成功后，根据药品的id，在库存表添加该药品的库存信息
            Integer drugsId = drugs.getId();
            Drugstock drugstock = new Drugstock();
            drugstock.setDrugsId(drugsId);
            drugstock.setStock(0);
            drugstockService.addDrugStock(drugstock);
            return "redirect:/drugs";
        }
        return "error";
    }

    /**
     * 根据药品id跳转到修改页面并回显数据
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        //获取到对于药品的id
        Drugs updateDrugs = drugsService.getDrugsById(id);
        model.addAttribute("updateDrugs", updateDrugs);
        System.out.println(updateDrugs.getId());
        return "update";
    }

    /**
     * 修改药品信息
     * @param drugs
     * @return
     */
    @PostMapping("/update")
    public String update(Drugs drugs){
        boolean result = drugsService.updateById(drugs);
        if (result){
            return "redirect:/drugs";
        }
        return "error";
    }

    /**
     * 根据药品id跳转到修改库存页面并回显数据
     * @return
     */
    @GetMapping("/updateStock/{id}")
    public String toUpdateStock(@PathVariable("id") Integer id, Model model){
        //获取到对于药品的id
        Drugs updateDrugs = drugsService.getDrugsById(id);
        model.addAttribute("updateDrugs", updateDrugs);
        System.out.println(updateDrugs.getId());
        return "updateStock";
    }

    /**
     * 删除药品
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println("=========" + id);
        boolean result = drugsService.removeById(id);
        if (result){
            //成功删除药品的同时，删除对应的库存信息
            drugstockService.deleteByStock(id);
            return "redirect:/drugs";
        }
        return "error";
    }
}
