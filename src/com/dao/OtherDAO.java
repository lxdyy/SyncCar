package com.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.HibernateUtil;
import com.model.OtherAll;
import com.model.Otherbrand;
import com.model.Othercar;
import com.model.Othercfg;
import com.model.Otheryear;
import com.util.HibernateUtils;

public class OtherDAO {

	private HibernateUtil h;
	private HibernateUtils util;

	/**
	 * @author 王鑫
	 * @param otherbrand
	 */
	public void addbrand(Otherbrand otherbrand) {
		Session session = h.getSession();
		session.beginTransaction();
		session.save(otherbrand);
		session.getTransaction().commit();
		h.closeSession(session);

	}

	/**
	 * 
	 * @param othercar
	 */
	public void addcar(Othercar othercar) {
		Session session = h.getSession();
		session.beginTransaction();
		session.save(othercar);
		session.getTransaction().commit();
		h.closeSession(session);

	}

	/**
	 * 
	 * @param othercfg
	 */
	public void addcfg(Othercfg othercfg) {
		Session session = h.getSession();
		session.beginTransaction();
		session.save(othercfg);
		session.getTransaction().commit();
		h.closeSession(session);

	}

	/**
	 * 
	 * @param otheryear
	 */
	public void addyear(Otheryear otheryear) {
		Session session = h.getSession();
		session.beginTransaction();
		session.save(otheryear);
		session.getTransaction().commit();
		h.closeSession(session);

	}

	/**
	 * 
	 * @return 所有竞品品牌
	 */
	public List<Otherbrand> findallbrand() {
		Session session = util.getSession();
		List<Otherbrand> list = session.createQuery(" from Otherbrand ").list();
		util.closeSession();
		return list;
	}

	/**
	 * 
	 * @param id 品牌Id
	 * @return 通过品牌ID查找返回精品车系数据
	 */
	public List<Othercar> findcar(String id ) {
		Session session = util.getSession();
		Query query = session.createQuery(" from Othercar o where o.bid = ?");
		query.setParameter(0, id); 
		List<Othercar> list = query.list();
		util.closeSession();
		return list;
	}

	/**
	 * 
	 * @param id 车系ID
	 * @return 返回车系所有年款信息
	 */
	public List<Otheryear> findyear(String id) {
		Session session = util.getSession();
		Query query = session.createQuery(" from Otheryear o where o.cid = ?");
		query.setParameter(0, id); 
		List<Otheryear> list = query.list();
		util.closeSession();
		return list;
	}

	/**
	 * 
	 * @param id 年款ID
	 * @return 通过年款ID查询所有配置信息
	 */
	public List<Othercfg> findcfg(String id) {
		Session session = util.getSession();
		Query query = session.createQuery(" from Othercfg o where o.yid = ?");
		query.setParameter(0, id); 
		List<Othercfg> list = query.list();
		for (Othercfg o : list ){
			System.out.print(o.getCfgname());
		}
		util.closeSession();
		return list;
	}

	/**
	 * 
	 * @param id 车系ID
	 * @return 通过车系ID车系下所有配置信息
	 */
	public List<Othercfg> findbycar(String id) {
		Session session = util.getSession();
		Query query = session.createQuery(" from Othercfg o where o.yid in ( select b.yearid from Otheryear b where b.cid = ?)");
		query.setParameter(0, id); 
		List<Othercfg> list = query.list();
		for (Othercfg o : list ){
			System.out.print(o.getCfgname());
		}
		util.closeSession();
		return list;
	}

	/**
	 * 
	 * @return 查询所有竞品车型信息
	 */
	public List<OtherAll> findall() {
		List<OtherAll> lists= new ArrayList<OtherAll>();
		String sql = "select c1.brandname ,c2.carname ,c4.yearname ,c3.cfgname ,c3.cfgid from Otherbrand c1 , Othercar c2 , Othercfg c3 , Otheryear c4  where c1.brandid = c2.bid and c2.carid = c4.cid and c4.yearid = c3.yid";
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(sql);
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			OtherAll oa = new OtherAll();
			oa.setBrandname((String)obj[0]);
			oa.setCarname((String)obj[1]);
			oa.setYearname((String)obj[2]);
			oa.setCfgname((String)obj[3]);
			oa.setCfgid((String)obj[4]);
			lists.add(oa);
		}
		return lists;
	}

	/**
	 * 
	 * @param first 分页页数
	 * @param max 显示多少数据
	 * @return 查询所有竞品车型信息
	 */
	public List<OtherAll> findall(int first, int max) {
		List<OtherAll> lists= new ArrayList<OtherAll>();
		String sql = "select c1.brandname ,c2.carname ,c4.yearname ,c3.cfgname ,c3.cfgid from Otherbrand c1 , Othercar c2 , Othercfg c3 , Otheryear c4  where c1.brandid = c2.bid and c2.carid = c4.cid and c4.yearid = c3.yid";
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(sql);
		query.setCacheable(true);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			OtherAll oa = new OtherAll();
			oa.setBrandname((String)obj[0]);
			oa.setCarname((String)obj[1]);
			oa.setYearname((String)obj[2]);
			oa.setCfgname((String)obj[3]);
			oa.setCfgid((String)obj[4]);
			lists.add(oa);
		}
		return lists;
	}

	/**
	 * 
	 * @return 删除品牌
	 * @throws HibernateException
	 * @throws Exception
	 */
	public Boolean delbrand() throws HibernateException, Exception {
		Boolean f = false;
		Session session = HibernateUtils.getSession(); 
		Transaction tx = session.beginTransaction(); 
		String sql="delete from Otherbrand "; 
		session.beginTransaction();
		Query query = session.createQuery(sql);
		f=query.executeUpdate()>0;
		tx.commit(); 
		session.close();
		return f ;
	}
	
	/**
	 * 
	 * @return 删除车系
	 * @throws HibernateException
	 * @throws Exception
	 */
	public Boolean delcar() throws HibernateException, Exception {
		Boolean f = false;
		Session session = HibernateUtils.getSession(); 
		Transaction tx = session.beginTransaction(); 
		String sql="delete from Othercar "; 
		session.beginTransaction();
		Query query = session.createQuery(sql);
		f=query.executeUpdate()>0;
		tx.commit(); 
		session.close();
		return f ;
	}
	
	/**
	 * 
	 * @return 删除年款
	 * @throws HibernateException
	 * @throws Exception
	 */
	public Boolean delyear() throws HibernateException, Exception {
		Boolean f = false;
		Session session = HibernateUtils.getSession(); 
		Transaction tx = session.beginTransaction(); 
		String sql="delete from Otheryear "; 
		session.beginTransaction();
		Query query = session.createQuery(sql);
		f=query.executeUpdate()>0;
		tx.commit(); 
		session.close();
		return f ;
	}
	
	/**
	 * 
	 * @return 删除配置
	 * @throws HibernateException
	 * @throws Exception
	 */
	public Boolean delcfg() throws HibernateException, Exception {
		Boolean f = false;
		Session session = HibernateUtils.getSession(); 
		Transaction tx = session.beginTransaction(); 
		String sql="delete from Othercfg "; 
		session.beginTransaction();
		Query query = session.createQuery(sql);
		f=query.executeUpdate()>0;
		tx.commit(); 
		session.close();
		return f ;
	}

}
