package com.pharmacy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pharmacy.domain.Drugs;

import java.util.List;

/**
* @author Alonso
* @description 针对表【drugs】的数据库操作Service
* @createDate 2022-12-16 19:35:14
*/
public interface DrugsService extends IService<Drugs> {

    /**
     * 查询所有药品
     * @return
     */
    List<Drugs> drugsList();

    /**
     * 药品查询
     * @param drugsName
     * @param factory
     * @return
     */
    List<Drugs> searchDrugs(String drugsName, String factory);

    /**
     * 药品名称查询
     * @param drugsName
     * @return
     */
    List<Drugs> searchDrugsByDrugsName(String drugsName);

    /**
     * 生产厂家查询
     * @param factory
     * @return
     */
    List<Drugs> searchDrugsByFactory(String factory);

    /**
     * 添加药品
     * @param drugs
     * @return
     */
    boolean addDrugs(Drugs drugs);

    /**
     * 根据id 查询药品信息
     * @param id
     * @return
     */
    Drugs getDrugsById(Integer id);

}
