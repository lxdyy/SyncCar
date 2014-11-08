package com.util;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class DownloadURLFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String res = downloadFromUrl("http://nb.baidupcs.com/file/d424378036665ad75a3ea9d4dbdc9959?fid=1226797422-250528-1021221719349673&time=1408692011&sign=FDTAXER-DCb740ccc5511e5e8fedcff06b081203-m2eYhfXcDvNssoYgSzQoYMW3SBQ%3D&to=nbb&fm=Nin,B,U,ny&newver=1&newfm=1&flow_ver=3&expires=8h&rt=pr&r=297012941&mlogid=3247847599&vuk=1226797422&vbdid=458935162&fn=shopname.zip","f:\\1\\");
		
		//String startfilename = "update_07_30.bat";
		System.out.println(res);
		
		
	}


	/**
	 * 
	 * @param url 素材下载地址
	 * @param dir 文件存放位置
	 * @return 返回状态
	 */
	public static String downloadFromUrl(String url,String dir) {

		try {
			URL httpurl = new URL(url);
			String fileName = getFileNameFromUrl(url);
			System.out.println(fileName);
			File f = new File(dir + fileName);
			FileUtils.copyURLToFile(httpurl, f);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fault!";
		} 
		return "Successful!";
	}
	
	public static String getFileNameFromUrl(String url){
		String name = new Long(System.currentTimeMillis()).toString() + ".X";
		int index = url.lastIndexOf("/");
		if(index > 0){
			name = url.substring(index + 1);
			if(name.trim().length()>0){
				return name;
			}
		}
		return name;
	}
}

