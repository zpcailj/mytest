package com.jswl.dao;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	
	 // private JdbcTemplate getJdbcTemplate();
	//@Resource(name="dataSource")


	@Override
	public void save(User user) {

		// TODO Auto-generated method stub
		String sql="insert into tuser values(null,?)";
		getJdbcTemplate().update(sql,user.getName());
	}



	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql="delete  from  tuser where id=?";
		getJdbcTemplate().update(sql,id);
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql="update tuser set name=? where id=?";
		getJdbcTemplate().update(sql,user.getName(),user.getId());
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		String  sql ="select * from tuser where id=?";
	return	 getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				return u;
			}
		},id);
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		String  sql ="select count(*) from tuser ";
		return	 getJdbcTemplate().queryForObject(sql,Integer.class);
		
	}

	@Override
	public List<User> getAll() {
		String  sql ="select * from tuser";
			List<User> list= getJdbcTemplate().query(sql, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int arg1) throws SQLException {
					// TODO Auto-generated method stub
					User u=new User();
					u.setId(rs.getInt("id"));
					u.setName(rs.getString("name"));
					return u;
				}
			});
			 return  list;

		// TODO Auto-generated method stub
		
	}

}
