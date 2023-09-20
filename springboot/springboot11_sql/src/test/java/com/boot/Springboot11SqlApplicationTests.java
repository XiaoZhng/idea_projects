package com.boot;

import com.boot.dao.BookDAO;
import com.boot.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class Springboot11SqlApplicationTests {

	@Autowired
	private BookDAO bookDAO;

	@Test
	void contextLoads() {
		bookDAO.selectById(3);
	}

	@Test
	public void testJDBCTemplate(@Autowired JdbcTemplate jdbcTemplate){
		String sql = "select * from book";
		RowMapper<Book> rm = new RowMapper<Book>() {
			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setType(rs.getString("type"));
				book.setAuthor(rs.getString("author"));
				return book;
			}
		};
		List<Book> list = jdbcTemplate.query(sql, rm);
		System.out.println(list);
	}

	//添加
	@Test
	public void testJDBCTemplateSave(@Autowired JdbcTemplate jdbcTemplate){
		String sql = "insert into book values(3, 'springboot3', 'springboot3', 'springboot3')";
		jdbcTemplate.update(sql);
	}

}
