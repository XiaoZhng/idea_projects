package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.bean.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Alonso
 */
@Mapper
public interface BookDAO extends BaseMapper<Book> {
}
