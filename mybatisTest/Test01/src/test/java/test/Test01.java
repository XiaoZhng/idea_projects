package test;

import com.mybatis.mapper.AddressMapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.Address;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Alonso
 */
public class Test01 {

    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUser();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
