package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.domain.SMSCode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Alonso
 */
@Mapper
public interface SmsDAO extends BaseMapper<SMSCode> {
}
