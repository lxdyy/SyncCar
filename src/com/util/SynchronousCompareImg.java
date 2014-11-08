package com.ian.hint.v2.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;
//
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author <王鑫>
 * @Time <2014-10-10>
 * 
 */
public class SynchronousCompareImg {
	
	/**
	 * @author 	<王鑫>
	 * @version <V1.2>
	 * @see <传入汽车之家中车型ID，将结果转换成对应格式  （Map）>
	 * @param  <carIds 传入对比车型的配置ID 格式:"0,0,0,0" 或  "0">
	 * @return <返回JSONObject类型  JSON格式>
	 * @exception <出现异常返回错误map  转换成JSON格式如下{"state":"1","html":"访问失败……"}或{"state":"2","html":"连接超时……"}>
	 * 
	 */
	public static Map SynchronousCompareImgJSON(String url){
		SynchronousCompareImg c = new SynchronousCompareImg();
		Map map2 = new LinkedHashMap();
		Map map1 = new LinkedHashMap();
		List list = new ArrayList ();
		String [] test = url.split(",");
		for(int i = 0;i<test.length;i++){
//			System.out.println("=============================="+i+"===========================");
			Map map = new LinkedHashMap();
			//map.put("id",test[i]);
//			map.put("value", c.contrastImg2(test[i]));
			list.add(c.contrastImg2(test[i]));
			//map1.put(String.valueOf(i), map);
		}
//		System.out.println(JSONObject.fromObject(map1));
			map2.put("list", list);
		return map2;
	}

	/**
	 * @author 	<王鑫>
	 * @version <V1.2>
	 * @see <传入汽车之家中车型ID，将结果转换成对应格式  （Map）>
	 * @param  <carIds 传入对比车型的配置ID  "0">
	 * @return <返回map类型  <大类名称，小类Map>>
	 * @exception <出现异常返回错误map  转换成JSON格式如下{"state":"1","html":"访问失败……"}或{"state":"2","html":"连接超时……"}>
	 * 
	 */
	public Map contrastImg(String carIds) {
		Map CategoryLevelTwo = new LinkedHashMap();//返回带二级类别的map
		String url = "http://car.autohome.com.cn/duibi/tupian/carIDs="
				+ carIds.trim();//汽车之家路径
		Document document = null;
		try {
			document = Jsoup.connect(url).timeout(8000).get();
		} catch (IOException e) {
			CategoryLevelTwo.put("state", "1");
			CategoryLevelTwo.put("html", "访问失败……");
			return CategoryLevelTwo;
		} catch (RuntimeException e) {
			CategoryLevelTwo.put("state", "2");
			CategoryLevelTwo.put("html", "连接超时……");
			return CategoryLevelTwo;
		}
		Elements ListDiv = document.getElementsByClass("title-content");//截取返回页面中对比区域
		for (Element element : ListDiv) {
			for (int y = 0; y < 5; y++) {
				String CategoryName = document.getElementsByClass("content-title")
						.get(y).text();//大类名称：外观 /外观明细
				for (Element e : ListDiv) {
					Map CategoryLevelOne = new LinkedHashMap() ;//小类Map<类别名称，类别值>
					List list = new ArrayList();
					for (int x = 0; x < 20; x += 4) {
						CategoryLevelOne.put(document.getElementsByClass("content-list")
								.get(y).select("div.list-ul-link").get(x)
								.text(),
								document.getElementsByClass("content-list")
										.get(y).select("div.list-ul-img")
										.get(x).select("img").attr("src"));
					}
					CategoryLevelTwo.put(CategoryName, list);
				}
			}
		}
		return CategoryLevelTwo;
	}
	
	
	public List contrastImg2(String carIds) {
		Map CategoryLevelTwo = new LinkedHashMap();//返回带二级类别的map
		List list1 = new ArrayList();
		String url = "http://car.autohome.com.cn/duibi/tupian/carIDs="
				+ carIds.trim();//汽车之家路径
		Document document = null;
		try {
			document = Jsoup.connect(url).timeout(8000).get();
		} catch (IOException e) {
			return list1;
		} catch (RuntimeException e) {
			CategoryLevelTwo.put("state", "2");
			CategoryLevelTwo.put("html", "连接超时……");
			return list1;
		}
		Elements ListDiv = document.getElementsByClass("title-content");//截取返回页面中对比区域
		for (Element element : ListDiv) {
			for (int y = 0; y < 5; y++) {
				String CategoryName = document.getElementsByClass("content-title")
						.get(y).text();//大类名称：外观 /外观明细
				for (Element e : ListDiv) {
					Map CategoryLevelOne = new LinkedHashMap() ;//小类Map<类别名称，类别值>
					List list = new ArrayList();
					for (int x = 0; x < 20; x += 4) {
						list1.add(document.getElementsByClass("content-list")
										.get(y).select("div.list-ul-img")
										.get(x).select("img").attr("src"));
					}
					//CategoryLevelTwo.put(CategoryName, list);
				}
			}
		}
		return list1;
	}
	
}
