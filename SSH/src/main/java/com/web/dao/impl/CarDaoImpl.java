package com.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.dao.CarDao;
import com.web.entity.Car;
import com.web.entity.Student;
import com.web.util.PageUtil;

@Repository //数据访问层
public class CarDaoImpl extends CommonDaoImpl<Car> implements CarDao {

	@Override
	public void queryPaging(PageUtil<Car> paging, Map<String, Object> map) {
		paging.setData(this.queryPagingData(paging, map));//设置分页查询的数据
		
		paging.setTotalCount(this.queryTotalCount(map));//设置分页查询的总条数
		
	}
	/**
	 * 分页查询
	 */
	
	/**
	 * 分页查询得到的数据
	 * @return
	 */
	public List<Car> queryPagingData(PageUtil<Car> paging, Map<String, Object> map){
		
		try {
			//1.获取session
			Session session = super.sessionFactory.getCurrentSession();
			
			//2.持久化操作
			StringBuffer hql = new StringBuffer("from Car where 1=1 ");
			
			
			if(map != null){
				for (String key : map.keySet()) {
					if("sname".equals(key)){
						hql.append(" and sname like '%"+map.get(key)+"%'");
					}
					if("schoolName".equals(key)){
						hql.append(" and school.scname like '%"+map.get(key)+"%'");
					}
					if("schoolId".equals(key)){
						hql.append(" and school.scid="+map.get(key));
					}
				}
			}
			
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			query.setFirstResult(paging.getPrev());//设置分页查询  排除前面多少笔数据
			query.setMaxResults(paging.getPageSize());//设置最多显示多少条数据
			
			//查询得到集合
			List<Car> list = query.list();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 分页查询得到的总条数
	 * @return
	 */
	public int  queryTotalCount(Map<String, Object> map){
		
		int count = 0;
		
		try {
			//1.获取session
			Session session = sessionFactory.getCurrentSession();
			
			//2.持久化操作
			//2.持久化操作
			StringBuffer hql = new StringBuffer("select count(*) from Car where 1=1 ");
			
			if(map != null){
				for (String key : map.keySet()) {
					if("sname".equals(key)){
						hql.append(" and sname like '%"+map.get(key)+"%'");
					}
					if("schoolName".equals(key)){
						hql.append(" and school.scname like '%"+map.get(key)+"%'");
					}
					if("schoolId".equals(key)){
						hql.append(" and school.scid="+map.get(key));
					}
				}
			}
			
			//执行查询
			Query query = session.createQuery(hql.toString());
			
			count = Integer.parseInt(query.uniqueResult().toString());
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Car> query() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
//     @Resource(name="dataSource")//@Autowired  自动查找
//     DataSource dataSource;//数据源
//
//	/**
//	 * 添加
//	 */
//	public boolean add(Car car) {
//		
//		int count = 0;
//		
//		try {
//			//1.获取数据库的连接
//			Connection conn = dataSource.getConnection();
//			
//			String sql = "insert into t_car (name,color,price) values (?,?,?)";
//			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			
//			ps.setString(1,car.getName());
//			ps.setString(2, car.getColor());
//			ps.setDouble(3, car.getPrice());
//			
//			count = ps.executeUpdate();//执行添加
//			
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return count > 0 ? true : false;
//	}
//
//	public List<Car> query() {
//		List<Car> list = new ArrayList<Car>();
//		try {
//			Connection conn = dataSource.getConnection();
//			
//			String sql = "select * from t_car";
//			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()){
//				Car c = new Car();
//				c.setId(rs.getInt("id"));
//				c.setName(rs.getString("name"));
//				c.setColor(rs.getString("color"));
//				c.setPrice(rs.getDouble("price"));
//				
//				list.add(c);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

}
