package com.liuhao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class JDBCUtil {
	static Connection connection;
	static PreparedStatement ps;
	static ResultSet rs;
	static Properties pro=null;
	static{
			pro = new Properties();
			try {
				pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Class.forName(pro.getProperty("classname"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	private void getcon(){
		try {
			connection = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"), pro.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getprepare(String sql) throws SQLException{
		getcon();
		ps = connection.prepareStatement(sql);
	}
	
	public ResultSet getpraparedate(String sql,List<Object> data) throws SQLException{
		getprepare(sql);
		if(data!=null){
			for (int i = 0; i < data.size(); i++) {
				ps.setObject(i+1, data.get(i));
			}
		}
		rs = ps.executeQuery();
		return rs;
	}
	//��ɾ��
	public int pupdate(String sql,List<Object> data) throws SQLException{
		int a;
		getprepare(sql);
		if(data!=null){
			for (int i = 0; i < data.size(); i++) {
				ps.setObject(i+1, data.get(i));
			}
		}
		a=ps.executeUpdate();
		return a;
	}
	
	public int[] addall(String sql,List<List<Object>> list) throws SQLException{
		getprepare(sql);
		for (int i = 0; i < list.size(); i++) {
			List<Object> pars = list.get(i);
			for (int j = 0; j < pars.size(); j++) {
				ps.setObject(j+1, pars.get(j));
			}
			ps.addBatch();
		}
		int[] r = ps.executeBatch();
		return r;	
	}
}
