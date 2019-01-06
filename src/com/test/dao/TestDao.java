package com.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.test.DataSource;
import com.test.TestModel;


@Repository("testDao")
public class TestDao extends JdbcDaoSupport{

	@DataSource(name=DataSource.testDataSource1)
	public List<TestModel> findTest1(){
		
		String sql = "select name, age from test1";
		
		List<TestModel> list = this.getJdbcTemplate().query(sql, new RowMapper<TestModel>() {

			@Override
			public TestModel mapRow(ResultSet arg0, int arg1)
					throws SQLException {
				TestModel model = new TestModel();
				model.setName(arg0.getString("name"));
				model.setAge(arg0.getInt("age"));
				return model;
			}
		});
		
		return list;
	}
	
	@DataSource(name=DataSource.testDataSource2)
	public List<TestModel> findTest2(){
		
		String sql = "select name, age from test2";
		
		List<TestModel> list = this.getJdbcTemplate().query(sql, new RowMapper<TestModel>() {

			@Override
			public TestModel mapRow(ResultSet arg0, int arg1)
					throws SQLException {
				TestModel model = new TestModel();
				model.setName(arg0.getString("name"));
				model.setAge(arg0.getInt("age"));
				return model;
			}
		});
		
		return list;
	}
}
