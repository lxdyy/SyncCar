package com.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.dao.OtherDAO;
import com.model.OtherAll;
import com.model.Otherbrand;
import com.model.Othercar;
import com.model.Othercfg;
import com.model.Otheryear;

public class OtherServiceImpl implements OtherService{

	public void addbrand(Otherbrand otherbrand) {
		new OtherDAO().addbrand(otherbrand);
	}

	public void addcar(Othercar othercar) {
		new OtherDAO().addcar(othercar);
	}

	public void addcfg(Othercfg othercfg) {
		new OtherDAO().addcfg(othercfg);
	}

	public void addyear(Otheryear otheryear) {
		new OtherDAO().addyear(otheryear);
	}

	public List<Otherbrand> findallbrand() {
		return new OtherDAO().findallbrand();
	}

	public List<OtherAll> findall() {
		return new OtherDAO().findall();
	}

	public List<Othercar> findcar(String id) {
		return new OtherDAO().findcar(id);
	}

	public List<Otheryear> findyear(String id) {
		return new OtherDAO().findyear(id);
	}

	public List<Othercfg> findcfg(String id) {
		return new OtherDAO().findcfg(id);
	}

	public List<Othercfg> findbycar(String id) {
		return new OtherDAO().findbycar(id);
	}

	public List<OtherAll> findall(int first, int max) {
		return new OtherDAO().findall(first,max);
	}

	public Boolean delbrand() {
		try {
			return new OtherDAO().delbrand();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean delcar() {
		try {
			return new OtherDAO().delcar();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean delyear() {
		try {
			return new OtherDAO().delyear();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean delcfg() {
		try {
			return new OtherDAO().delcfg();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
