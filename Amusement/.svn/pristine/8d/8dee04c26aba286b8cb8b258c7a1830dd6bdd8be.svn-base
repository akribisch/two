package com.web.util;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.web.entity.Department;
import com.web.entity.Menu;
import com.web.entity.Station;
import com.web.entity.User;

/**
 * 测试类
 * @author java201
 *
 */
public class Test {

	public static void main(String[] args) {
		//创建session
		Session session = HibernateUtil.getCurrentSession();
		
		//开启事务
		Transaction trans = session.beginTransaction();
		
		Department d = new Department(0, "信息部", 1);
		session.save(d);
		
		Menu m = new Menu(0, "用户管理", 0, "javascript:void(0);");
		session.save(m);
		Set<Menu> menu = new HashSet<>();
		menu.add(m);
		
		Station s = new Station(0, "系统管理员", 1, 5000, d,menu);
		session.save(s);
		
		String str = "1995-01-01";  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");  
        java.util.Date date = null;  
        try {  
        	date = format.parse(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        java.sql.Date birthday = new java.sql.Date(date.getTime());
		User u = new User(0, "admin", "root", s, "233333", 1, birthday, 0);
		session.save(u);
		
		//事务提交
		trans.commit();
	}

}
