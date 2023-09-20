package com.pharmacy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pharmacy.domain.Drugs;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Alonso
 * @description 针对表【drugs】的数据库操作Mapper
 * @createDate 2022-12-16 19:35:14
 * @Entity com.pharmacy.domain.Drugs
 */
public interface DrugsMapper extends BaseMapper<Drugs> {

    //查询所有药品信息和库存
    @Select("SELECT drugs.*, drugstock.stock FROM drugs, drugstock where drugs.id = drugstock.id")
    List<Drugs> drugsList();


    //根据药品名称、生产厂家查询药品信息和库存
    @Select("SELECT drugs.*, drugstock.stock FROM drugs, drugstock where drugs.id = drugstock.id AND drugsName LIKE #{drugsName} AND factory LIKE #{factory}")
    List<Drugs> searchDrugs(String drugsName, String factory);

    //根据药品名称查询药品信息和库存
    @Select("SELECT drugs.*, drugstock.stock FROM drugs, drugstock where drugs.id = drugstock.id AND drugsName LIKE #{drugsName}")
    List<Drugs> searchDrugsByDrugsName(String drugsName);

    //根据生产厂家查询药品信息和库存
    @Select("SELECT drugs.*, drugstock.stock FROM drugs, drugstock where drugs.id = drugstock.id AND factory LIKE #{factory}")
    List<Drugs> searchDrugsByFactory(String factory);

    //根据药品id查询药品信息
    @Select("SELECT drugs.*, drugstock.stock FROM drugs, drugstock where drugs.id = drugstock.id AND drugs.id = #{id}")
    Drugs getDrugsById(Integer id);
}




