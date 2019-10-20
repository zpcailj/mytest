import java.beans.PropertyVetoException;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jswl.dao.AccountService;
import com.jswl.dao.User;
import com.jswl.dao.UserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DriverManagerDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJDBC {
	@Autowired
	UserDao ud;
	@Resource(name="accountService")  
	private AccountService accountService;
	@Test
	public void test2(){
		accountService.transfer("李四", "张三", 1000d); 
	}
  public void Test1() throws PropertyVetoException{
//		ComboPooledDataSource ds=new ComboPooledDataSource();
//     ds.setDriverClass("com.mysql.jdbc.Driver");
//     ds.setJdbcUrl("jdbc:mysql:///demo");
//     ds.setUser("root");
//     ds.setPassword("1234");
//     JdbcTemplate jt=new JdbcTemplate();
//     jt.setDataSource(ds);
//     String  sql="insert into tuser values (null,'jack')";
//     jt.update(sql);
		User user=new User();
		user.setId(1);
		user.setName("123");
		List<User> all = ud.getAll();
		for (User user2 : all) {
			System.out.println(user2);
		}
  }
}
