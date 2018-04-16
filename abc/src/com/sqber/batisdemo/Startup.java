package com.sqber.batisdemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.scripting.xmltags.VarDeclSqlNode;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sqber.batisdemo.pojo.*;

public class Startup {

	public static void main(String[] args)throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
		
		SqlSession session = factory.openSession();
				
		User user = null;	
		List<User> users = null;
		try {
			/*select*/
			user = session.selectOne("test.findUserById",1);
			users = session.selectList("test.selectByName","小明");										
		} catch (Exception e) {
			System.out.print(e.toString());
		}finally {
			session.close();
		}
		System.out.println(user);
		
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
		
		//insertDemo();
		updateDemo();
	}
	
	private static void insertDemo() {
		SqlSession session = getSession();
		
		/*Insert*/
		User newModel=  new User();			
		newModel.setUserCode("newcode");
		newModel.setUserName("newTom");
		
		session.insert("test.insertItem",newModel);
		session.commit();
		session.close();
		//有返回值的insert
		System.out.println("the add model : id = " + newModel.getId());
	}
	
	private static void updateDemo() {
		SqlSession session = null;
		try {				
			session = getSession();
			
			User model = session.selectOne("test.findUserById",12);			
			model.setUserName("updateName");			
						
			session.update("test.updateItem", model);
			
			session.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(session != null) {
				session.close();	
			}			
		}
	}
	
	private static SqlSession getSession() {
		String resource = "sqlMapConfig.xml";
		InputStream stream = null;
		try {
			stream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			System.out.print("can not load resource");
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
		SqlSession session = factory.openSession();
		return session;
	}
}
