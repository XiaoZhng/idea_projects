package com.mbplus;

import com.mbplus.mapper.UserMapper;
import com.mbplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class PlusApplicationTest {

	//这里报错是因为idea认为userMapper是无法进行自动装配的，运行是没问题的
	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelectList() {
		//通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
		List<User> users = userMapper.selectList(null);
		users.forEach(user -> System.out.println(user));
	}

	@Test
	public void insertUser(){
		//实现新增用户信息
		//INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
		User user = new User();
//		user.setId(100l);
		user.setName("jack2");
		user.setAge(21);
		user.setEmail("jack@qq.com");
		int result = userMapper.insert(user);
		System.out.println("result= " + result);
		System.out.println("id= " + user.getId());
	}

	@Test
	public void deleteUser(){
		//通过id删除用户信息
//		int result = userMapper.deleteById(1580094470172860417L);
//		System.out.println("result= " + result);

		//根据map集合中所设置的条件删除用户信息
		//DELETE FROM user WHERE name = ? AND age = ?
//		Map<String, Object> map = new HashMap<>();
//		map.put("name", "jack");
//		map.put("age", 21);
//		int result = userMapper.deleteByMap(map);
//		System.out.println("result= " + result);

		//通过多个id实现批量删除
		//DELETE FROM user WHERE id IN ( ? , ? , ? )
		List<Long> list = Arrays.asList(1l, 2l, 3l);
		System.out.println("result= " + userMapper.deleteBatchIds(list));
	}

	@Test
	public void updateUser(){
		//修改用户信息
		//UPDATE user SET name=?, email=? WHERE id=?
		User user = new User();
		user.setId(4l);
		user.setName("jack");
		user.setEmail("jack@qq.com");
		System.out.println(userMapper.updateById(user));
	}

	@Test
	public void selectUser(){
		//根据id查询用户信息
		//SELECT id,name,age,email FROM user WHERE id=?
//		System.out.println(userMapper.selectById(1));

		//根据多个id查询多个用户信息
		//SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
//		List<Long> list = Arrays.asList(1l, 2l, 3l);
//		System.out.println(userMapper.selectBatchIds(list));

		//根据条件查询用户信息
		//SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("name", "Tom");
//		map.put("age", 20);
//		System.out.println(userMapper.selectByMap(map));

		//查询所有用户信息
//		SELECT id,name,age,email FROM user
		System.out.println(userMapper.selectList(null));

		//自定义查询功能
//		System.out.println(userMapper.selectMapById(1l));
	}

}
