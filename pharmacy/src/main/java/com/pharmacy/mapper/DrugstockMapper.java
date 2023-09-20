package com.pharmacy.mapper;

import com.pharmacy.domain.Drugstock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author Alonso
* @description 针对表【drugstock】的数据库操作Mapper
* @createDate 2022-12-17 14:26:23
* @Entity com.pharmacy.domain.Drugstock
*/
public interface DrugstockMapper extends BaseMapper<Drugstock> {

    //修改库存
    @Update("UPDATE drugstock SET stock = #{stock} WHERE id = #{drugsId}")
    boolean updateStock(Integer drugsId, Integer stock);

    //删除库存
    @Delete("DELETE FROM drugstock WHERE drugs_id = #{id}")
    boolean deleteByStock(Integer id);
}




