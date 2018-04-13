package com.sqber.batisdemo;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
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
	}

}
