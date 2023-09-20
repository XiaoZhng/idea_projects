package com.pharmacy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pharmacy.domain.Drugstock;
import com.pharmacy.service.DrugstockService;
import com.pharmacy.mapper.DrugstockMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Alonso
* @description 针对表【drugstock】的数据库操作Service实现
* @createDate 2022-12-17 14:26:23
*/
@Service
public class DrugstockServiceImpl extends ServiceImpl<DrugstockMapper, Drugstock>
    implements DrugstockService{

    @Resource
    private DrugstockMapper drugstockMapper;

    /**
     * 添加完药品时添加库存信息
     * @param drugstock
     * @return
     */
    @Override
    public boolean addDrugStock(Drugstock drugstock) {
        int result = drugstockMapper.insert(drugstock);
        return result == 1;
    }

    @Override
    public boolean updateStock(Integer drugsId, Integer stock) {
        return drugstockMapper.updateStock(drugsId, stock);
    }

    @Override
    public boolean deleteByStock(Integer id) {
        return drugstockMapper.deleteByStock(id);
    }
}




