package com.lixianghong.airinfo.biz;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lixianghong.airinfo.dao.IAirinfoDao;
import com.lixianghong.airinfo.pojo.Airinfo;

@SuppressWarnings("all")
public class AirinfoBiz {
	// 通过sessionFactorBuilder构建sessionFactory对象
	SqlSessionFactoryBuilder sessionFactoryBuilder;

	SqlSessionFactory sessionFactory;
	SqlSession session;
	IAirinfoDao dao;

	public AirinfoBiz() {
		sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		try {
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = sessionFactoryBuilder.build(inputStream);
			session=sessionFactory.openSession();
			dao=session.getMapper(IAirinfoDao.class);
			//不推荐使用Configuration
//			sessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsReader("config.xml"));
//			session = sessionFactory.openSession();
//			dao = session.getMapper(IAirinfoDao.class);
			
			// String resource = "/Airinfo/src/main/resources/config.xml";
			// InputStream inputStream = Resources.getResourceAsStream(resource);
			// sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Airinfo> queryAll(Integer frist, Integer size) {
		// 1,2
		// (frist-1)*size ,size
		// 调用countLimit方法
		this.countLimit(frist, size);
		List<Airinfo> listAirinfo = dao.queryAllAifinfo(frist, size);
		session.close();
		return listAirinfo;
	}

	public List<Airinfo> queryByFlight_date(String flight_date, Integer frist, Integer size) {

		this.countLimit(frist, size);

		List<Airinfo> listAirinfo = dao.queryByFlight_date(flight_date, frist, size);
		session.close();

		return listAirinfo;

	}

	public List<Airinfo> queryByDestination(String destination, Integer frist, Integer size) {

		this.countLimit(frist, size);

		List<Airinfo> listAirinfo = dao.queryByDestination(destination, frist, size);
		session.close();

		return listAirinfo;

	}

	/**
	 * 
	 * @Title: countLimit @Description: TODO(计算要查询的起始数据下标，以及要查询的条数) @param @param
	 * frist @param @param size 设定文件 @return void 返回类型 @throws
	 */
	public void countLimit(Integer frist, Integer size) {
		frist = (frist - 1) * size;
		size = size;
	}

	public void removeAirinfoById(Integer id) {

		try {
			dao.removeAirinfoById(id);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();

		}
	}

	public void updateAirinfo(Airinfo airinfo) {
		try {
			dao.updateAirinfo(airinfo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

	}

	public void saveAirinfo(Airinfo airinfo) {

		try {
			dao.saveAirinfo(airinfo);
			session.commit();
		} catch (Exception e) {

			// TODO: handle exception
			session.rollback();
			throw new RuntimeException(e);
		}

	}
	public void saveListAirinfo(List<Airinfo> listAirinfo) {
		try {
			dao.saveListAirinfo(listAirinfo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			throw new RuntimeException(e);
		}
	}

	public Airinfo queryById(Integer id) {
		Airinfo airinfo = dao.queryById(id);
		session.close();
		return airinfo;
	}

}
