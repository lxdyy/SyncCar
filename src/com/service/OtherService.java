package com.service;

import java.util.List;

import com.model.OtherAll;
import com.model.Otherbrand;
import com.model.Othercar;
import com.model.Othercfg;
import com.model.Otheryear;

public interface OtherService {

	/**从配置文件添加竞品品牌 */
	public void addbrand (Otherbrand otherbrand);
	/**从配置文件添加竞品车型 */
	public void addcar(Othercar othercar);
	/**从配置文件添加竞品车系*/
	public void addcfg(Othercfg othercfg);
	/**从配置文件添加竞品年款*/
	public void addyear(Otheryear otheryear);
	/**查找所有竞品品牌 */
	public List<Otherbrand> findallbrand();
	/**通过品牌Id查找所有竞品车型*/
	public  List<Othercar> findcar(String id );
	/**通过车型Id查找所有竞品年款*/
	public List <Otheryear> findyear(String id );
	/**通过年款Id查找所有竞品配置*/
	public List <Othercfg> findcfg(String id );
	/**通过车型Id查找所有配置名称*/
	public List <Othercfg> findbycar(String id );
	/**查找所有竞品配置信息*/
	public List<OtherAll> findall();
	/**查找所有竞品配置信息，带分页*/
	public List<OtherAll> findall(int first , int max);
	/**刪除竞品品牌表數據*/
	public Boolean delbrand();
	/**刪除竞品车系表數據*/
	public Boolean delcar();
	/**刪除竞品年款表數據*/
	public Boolean delyear();
	/**刪除竞品配置表數據*/
	public Boolean delcfg();
		
}
