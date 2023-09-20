package com.pharmacy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pharmacy.domain.Drugs;
import com.pharmacy.service.DrugsService;
import com.pharmacy.mapper.DrugsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Alonso
* @description 针对表【drugs】的数据库操作Service实现
* @createDate 2022-12-16 19:35:14
*/
@Service
public class DrugsServiceImpl extends ServiceImpl<DrugsMapper, Drugs>
    implements DrugsService{

    @Resource
    private DrugsMapper drugsMapper;

    /**
     * 查询所有药品
     * @return
     */
    @Override
    public List<Drugs> drugsList(){
        List<Drugs> drugs = drugsMapper.drugsList();
        return drugs;
    }

    /**
     * 药品查询
     * @param drugsName
     * @param factory
     * @return
     */
    @Override
    public List<Drugs> searchDrugs(String drugsName, String factory) {
        List<Drugs> drugsBySearch = drugsMapper.searchDrugs(drugsName, factory);
        return drugsBySearch;
    }

    /**
     * 药品名称查询
     * @param drugsName
     * @return
     */
    @Override
    public List<Drugs> searchDrugsByDrugsName(String drugsName) {
        List<Drugs> drugsByDrugsName = drugsMapper.searchDrugsByDrugsName(drugsName);
        return drugsByDrugsName;
    }

    /**
     * 生产厂家查询
     * @param factory
     * @return
     */
    @Override
    public List<Drugs> searchDrugsByFactory(String factory) {
        List<Drugs> searchDrugsByFactory = drugsMapper.searchDrugsByFactory(factory);
        return searchDrugsByFactory;
    }

    /**
     * 添加药品
     * @param drugs
     * @return
     */
    @Override
    public boolean addDrugs(Drugs drugs){
        int result = drugsMapper.insert(drugs);
        return result == 1;
    }

    /**
     * 根据id 查询药品信息
     * @param id
     * @return
     */
    @Override
    public Drugs getDrugsById(Integer id){
        Drugs drugs = drugsMapper.getDrugsById(id);
        return drugs;
    }
}




