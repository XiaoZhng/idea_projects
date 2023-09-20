package com.pharmacy.service;

import com.pharmacy.domain.Drugstock;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Alonso
* @description 针对表【drugstock】的数据库操作Service
* @createDate 2022-12-17 14:26:23
*/
public interface DrugstockService extends IService<Drugstock> {

    /**
     * 添加完药品时添加库存信息
     * @param drugstock
     * @return
     */
    boolean addDrugStock(Drugstock drugstock);

    boolean updateStock(Integer drugsId, Integer stock);

    boolean deleteByStock(Integer id);
}
