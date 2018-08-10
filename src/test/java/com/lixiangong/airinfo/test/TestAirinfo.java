package com.lixiangong.airinfo.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.lixianghong.airinfo.biz.AirinfoBiz;
import com.lixianghong.airinfo.pojo.Airinfo;

@SuppressWarnings("all")
public class TestAirinfo {

	@Test
	public void queryAll() {
		Scanner sc = new Scanner(System.in);
		System.out.print("输入查询的页数:");
		Integer frist = sc.nextInt();
		System.out.println("输入查询条数：");
		Integer size = sc.nextInt();
		AirinfoBiz biz = new AirinfoBiz();
		List<Airinfo> list = biz.queryAll(frist, size);
		for (Airinfo airinfo : list) {
			System.out.println(airinfo);
		}

	}

	@Test
	public void queryByFlight_date() {
		Scanner sc = new Scanner(System.in);
		System.out.print("输入查询的日期:");
		String flight_date = sc.next();
		System.out.print("输入查询的页数:");
		Integer frist = sc.nextInt();
		System.out.println("输入查询条数：");
		Integer size = sc.nextInt();
		AirinfoBiz biz = new AirinfoBiz();
		List<Airinfo> list = biz.queryByFlight_date(flight_date, frist, size);
		for (Airinfo airinfo : list) {
			System.out.println(airinfo);
		}

	}

	@Test
	public void queryByDestination() {
		AirinfoBiz biz = new AirinfoBiz();
		List<Airinfo> list = biz.queryByDestination("加拿大", 1, 2);
		for (Airinfo airinfo : list) {
			System.out.println(airinfo);
		}
	}

	@Test
	public void removeAirinfoById() {
		AirinfoBiz biz = new AirinfoBiz();
		biz.removeAirinfoById(6);
	}

	@Test
	public void updateAirinfo() {
		AirinfoBiz biz = new AirinfoBiz();
		biz.updateAirinfo(new Airinfo(1, "H8008", "英国", new Date()));
	}

	@Test
	public void saveAirinfo() throws Exception {
		AirinfoBiz biz = new AirinfoBiz();
		Airinfo airinfo = new Airinfo("H6609", "加拿大", new Date());
		biz.saveAirinfo(airinfo);
		Airinfo airinfos = biz.queryById(airinfo.getId());
		System.out.println(airinfos);
	}

	@Test
	public void saveListAirinfo() throws Exception {
		AirinfoBiz biz = new AirinfoBiz();

		List<Airinfo> listAirinfo = new ArrayList<Airinfo>();

		Airinfo airinfo = new Airinfo("H7009", "俄罗斯", new Date());
		// Airinfo airinfo1 = new Airinfo("H9009", "加拿大", new Date());

		listAirinfo.add(airinfo);
		listAirinfo.get(0).getId();
		// listAirinfo.add(airinfo1);
		biz.saveListAirinfo(listAirinfo);
		// for (Airinfo airinfo2 : listAirinfo) {
		// Airinfo airinfos = biz.queryById(airinfo2.getId());
		// System.out.println(airinfos);
		// }

	}

}
