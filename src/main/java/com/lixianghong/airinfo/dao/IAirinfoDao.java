package com.lixianghong.airinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lixianghong.airinfo.pojo.Airinfo;

/**
 * 
 * @ClassName: IAirinfoDao
 * @Description: TODO(对航班表操作的实现接口)
 * @author lxh800109@gmail.com
 * @date 2018年5月5日 下午2:27:27
 *
 */
public interface IAirinfoDao {

	/**
	 * 
	 * @Title: queryAllAifinfo @Description: TODO(查询所有航班信息) @param @return
	 * 设定文件 @return List<Airinfo> 返回类型 @throws
	 */
	List<Airinfo> queryAllAifinfo(@Param("frist") Integer frist, @Param("size") Integer size);

	/**
	 * 
	 * @Title: queryByFlight_date @Description: TODO(按照起飞时间查询) @param @param
	 * flight_date @param @return 设定文件 @return List<Airinfo> 返回类型 @throws
	 */
	List<Airinfo> queryByFlight_date(@Param("flight_date") String flight_date, @Param("frist") Integer frist,
			@Param("size") Integer size);

	/**
	 * 
	 * @Title: queryByDestination @Description: TODO(按照目的地查询) @param @param
	 * destination @param @return 设定文件 @return List<Airinfo> 返回类型 @throws
	 */
	List<Airinfo> queryByDestination(@Param("destination") String destination, @Param("frist") Integer frist,
			@Param("size") Integer size);

	/**
	 * 
	 * @Title: removeAirinfoById @Description: TODO(按照id删除) @param @param id
	 * 设定文件 @return void 返回类型 @throws
	 */
	void removeAirinfoById(@Param("id") Integer id);

	/**
	 * 
	 * @Title: updateAirinfo @Description: TODO(更新航班对象) @param @param airinfo
	 * 设定文件 @return void 返回类型 @throws
	 */
	void updateAirinfo(@Param("airinfo") Airinfo airinfo);

	/**
	 * 
	 * @Title: saveAirinfo @Description: TODO(新增航班信息) @param @param airinfo
	 * 设定文件 @return void 返回类型 @throws
	 */
	void saveAirinfo(@Param("airinfo") Airinfo airinfo);

	void saveListAirinfo(@Param("listAifinfo") List<Airinfo> listAifinfo);

	Airinfo queryById(@Param("id") Integer id);
}
