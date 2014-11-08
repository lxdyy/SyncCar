package com.service;

import java.util.List;

import com.model.OtherAll;
import com.model.Otherbrand;
import com.model.Othercar;
import com.model.Othercfg;
import com.model.Otheryear;

public interface OtherService {

	/**�������ļ���Ӿ�ƷƷ�� */
	public void addbrand (Otherbrand otherbrand);
	/**�������ļ���Ӿ�Ʒ���� */
	public void addcar(Othercar othercar);
	/**�������ļ���Ӿ�Ʒ��ϵ*/
	public void addcfg(Othercfg othercfg);
	/**�������ļ���Ӿ�Ʒ���*/
	public void addyear(Otheryear otheryear);
	/**�������о�ƷƷ�� */
	public List<Otherbrand> findallbrand();
	/**ͨ��Ʒ��Id�������о�Ʒ����*/
	public  List<Othercar> findcar(String id );
	/**ͨ������Id�������о�Ʒ���*/
	public List <Otheryear> findyear(String id );
	/**ͨ�����Id�������о�Ʒ����*/
	public List <Othercfg> findcfg(String id );
	/**ͨ������Id����������������*/
	public List <Othercfg> findbycar(String id );
	/**�������о�Ʒ������Ϣ*/
	public List<OtherAll> findall();
	/**�������о�Ʒ������Ϣ������ҳ*/
	public List<OtherAll> findall(int first , int max);
	/**�h����ƷƷ�Ʊ픵��*/
	public Boolean delbrand();
	/**�h����Ʒ��ϵ�픵��*/
	public Boolean delcar();
	/**�h����Ʒ���픵��*/
	public Boolean delyear();
	/**�h����Ʒ���ñ픵��*/
	public Boolean delcfg();
		
}
