package com.pharmacy.controller;

import com.pharmacy.domain.Drugs;
import com.pharmacy.service.DrugstockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * 库存接口
 * @author Alonso
 */
@Controller
public class DrugstockController {

    @Resource
    private DrugstockService drugstockService;

    /**
     * 修改库存
     * @param drugs
     * @return
     */
    @PostMapping("/updateStock")
    public String updateStock(Drugs drugs){
        Integer stock = drugs.getStock();
        Integer id = drugs.getId();
//        System.out.println("========" + id);
//        System.out.println("========" + stock);
        boolean result = drugstockService.updateStock(id, stock);
        if (result){
            return "redirect:/drugs";
        }
        return "error";
    }
}
