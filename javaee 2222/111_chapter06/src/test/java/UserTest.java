import com.liang.controller.UserController;
import com.liang.dao.UserDao;
import com.liang.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserTest {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("梁远昭");
        user.setPassword("123456789");
        user.setAge(22);

        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
        UserDao userDao = application.getBean(UserDao.class);
        userDao.insert(user);

        //        UserController userController = (UserController) application.getBean("userController");
//        boolean ret = userController.add(user);
//        System.out.println(ret?"添加成功":"添加失败");





//        JdbcTemplate jdbcTemplate =(JdbcTemplate) application.getBean("jdbcTemplate");
//        jdbcTemplate.execute("create table  kun( id int primary key auto_increment)");


    }
}
