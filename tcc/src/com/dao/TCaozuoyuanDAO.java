package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TCaozuoyuan;

/**
 * Data access object (DAO) for domain model class TCaozuoyuan.
 * 
 * @see com.model.TCaozuoyuan
 * @author MyEclipse Persistence Tools
 */

public class TCaozuoyuanDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TCaozuoyuanDAO.class);

	// property constants
	public static final String LOGINNAME = "loginname";

	public static final String LOGINPW = "loginpw";

	public static final String XINGMING = "xingming";

	public static final String XINGBIE = "xingbie";

	public static final String NIANLING = "nianling";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TCaozuoyuan transientInstance)
	{
		log.debug("saving TCaozuoyuan instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TCaozuoyuan persistentInstance)
	{
		log.debug("deleting TCaozuoyuan instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TCaozuoyuan findById(java.lang.Integer id)
	{
		log.debug("getting TCaozuoyuan instance with id: " + id);
		try
		{
			TCaozuoyuan instance = (TCaozuoyuan) getHibernateTemplate().get(
					"com.model.TCaozuoyuan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TCaozuoyuan instance)
	{
		log.debug("finding TCaozuoyuan instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TCaozuoyuan instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TCaozuoyuan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLoginname(Object loginname)
	{
		return findByProperty(LOGINNAME, loginname);
	}

	public List findByLoginpw(Object loginpw)
	{
		return findByProperty(LOGINPW, loginpw);
	}

	public List findByXingming(Object xingming)
	{
		return findByProperty(XINGMING, xingming);
	}

	public List findByXingbie(Object xingbie)
	{
		return findByProperty(XINGBIE, xingbie);
	}

	public List findByNianling(Object nianling)
	{
		return findByProperty(NIANLING, nianling);
	}

	public List findAll()
	{
		log.debug("finding all TCaozuoyuan instances");
		try
		{
			String queryString = "from TCaozuoyuan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TCaozuoyuan merge(TCaozuoyuan detachedInstance)
	{
		log.debug("merging TCaozuoyuan instance");
		try
		{
			TCaozuoyuan result = (TCaozuoyuan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TCaozuoyuan instance)
	{
		log.debug("attaching dirty TCaozuoyuan instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TCaozuoyuan instance)
	{
		log.debug("attaching clean TCaozuoyuan instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TCaozuoyuanDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (TCaozuoyuanDAO) ctx.getBean("TCaozuoyuanDAO");
	}
}