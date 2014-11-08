package com.test;

import com.util.DownloadURLFile;
import com.util.Update;

public class Demotest {


	public static void main(String[] args) {
		Long a = System.nanoTime();
		new Update().update("d:\\sale_new.js");/**从js文件导入车型数据：耗时47分钟*/
		new DownloadURLFile();
		DownloadURLFile.downloadFromUrl("http://car.autohome.com.cn/javascript/sale_new.js", "d:\\");/**车型对比js文件下载：返回值为successfull为成功，fail为失败*/
		System.out.println("本次执行共计耗时："+(System.nanoTime()-a)*1/1000000000+"分");/**单位：分钟*/
		
	}
}



