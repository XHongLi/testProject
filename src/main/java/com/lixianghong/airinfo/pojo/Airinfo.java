package com.lixianghong.airinfo.pojo;

import java.util.Date;

/**
 * 
 * @ClassName: Airinfo
 * @Description: TODO(持久化航班实体类)
 * @author lxh800109@gmail.com
 * @date 2018年5月5日 下午2:25:53
 *
 */
public class Airinfo {
	private Integer id; // 航班编号
	private String filght_number; // 航班号
	private String destination; // 飞行目的地
	private Date flight_date; // 起飞时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilght_number() {
		return filght_number;
	}

	public void setFilght_number(String filght_number) {
		this.filght_number = filght_number;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFlight_date() {
		return flight_date;
	}

	public void setFlight_date(Date flight_date) {
		this.flight_date = flight_date;
	}

	public Airinfo(Integer id, String filght_number, String destination, Date flight_date) {
		super();
		this.id = id;
		this.filght_number = filght_number;
		this.destination = destination;
		this.flight_date = flight_date;
	}

	public Airinfo(String filght_number, String destination, Date flight_date) {
		super();
		this.filght_number = filght_number;
		this.destination = destination;
		this.flight_date = flight_date;
	}

	public Airinfo() {
		super();
	}

	@Override
	public String toString() {
		return "Airinfo [id=" + id + ", filght_number=" + filght_number + ", destination=" + destination
				+ ", flight_date=" + flight_date + "]";
	}

}
