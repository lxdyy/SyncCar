package com.test;

import com.util.DownloadURLFile;
import com.util.Update;

public class Demotest {


	public static void main(String[] args) {
		Long a = System.nanoTime();
		new Update().update("d:\\sale_new.js");/**��js�ļ����복�����ݣ���ʱ47����*/
		new DownloadURLFile();
		DownloadURLFile.downloadFromUrl("http://car.autohome.com.cn/javascript/sale_new.js", "d:\\");/**���ͶԱ�js�ļ����أ�����ֵΪsuccessfullΪ�ɹ���failΪʧ��*/
		System.out.println("����ִ�й��ƺ�ʱ��"+(System.nanoTime()-a)*1/1000000000+"��");/**��λ������*/
		
	}
}



