package com.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.model.Otherbrand;
import com.model.Othercar;
import com.model.Othercfg;
import com.model.Otheryear;
import com.service.OtherService;
import com.service.OtherServiceImpl;

public class Update {

	/**
	 * 
	 * @param url sale_new.js 文件存放位置
	 */
	public void update(String url) {
		File file = new File(url);
		OtherService os= new OtherServiceImpl();
		os.delbrand();
		os.delcar();
		os.delcfg();
		os.delyear();
		Otherbrand ob = new Otherbrand();
		Othercar oc = new Othercar ();
		Othercfg ocfg = new Othercfg ();
		Otheryear oy = new Otheryear();
		String fctid = "";
		String fctcontent = "";
		String brid = "";
		String brcontent = "";
		String spec_year_name = "";
		String spec_year_namecontent = "";
		String spl = "";
		String splcontent = "";
		try {
			// 使用readLines读取每一行，生成List
			List<String> contents = FileUtils.readLines(file, "UTF-8");
			// 遍历输出contents
			for (String line : contents) {
				if (line.indexOf("function") == -1) {
					if (line.indexOf("fct[") != -1) {
						String[] resolve = line.split("'");
						fctid = resolve[1];
						fctcontent = resolve[3];
						String s1[] = fctcontent.split("\\,");
						for (int x = 0; x < s1.length; x = x + 2) {
							ob.setBrandid(s1[x]);
							ob.setBrandname(s1[x + 1]);
							os.addbrand(ob);
						}
					} else if (line.indexOf("br[") != -1) {
						String[] resolve = line.split("'");
						brid = resolve[1];
						brcontent = resolve[3];
						String s1[] = brcontent.split("\\,");
						for (int x = 0; x < s1.length; x = x + 2) {
							oc.setBid(brid);
							oc.setCarid(s1[x]);
							oc.setCarname(s1[x + 1]);
							os.addcar(oc);
						}
					} else if (line.indexOf("spec_year_name[") != -1) {
						String[] resolve = line.split("'");
						spec_year_name = resolve[1];
						spec_year_namecontent = resolve[3];
						String s1[] = spec_year_namecontent.split("\\,");
						for (int x = 0; x < s1.length; x = x + 2) {
							oy.setCid(spec_year_name);
							oy.setYearid(s1[x]);
							oy.setYearname(s1[x + 1]);
							os.addyear(oy);
						}
					} else if (line.indexOf("spl[") != -1) {
						String[] resolve = line.split("'");
						spl = resolve[1];
						splcontent = resolve[3];
						String s1[] = splcontent.split("\\,");
						for (int x = 0; x < s1.length; x = x + 2) {
							System.out.println(spl + "---->" + s1[x] + "---->" + s1[x + 1]);
							ocfg.setYid(spl);
							ocfg.setCfgid(s1[ x ]);
							ocfg.setCfgname(s1[x + 1]);
							os.addcfg(ocfg);
						}
					}
				} else {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
