package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TCard;

/**
 * Data access object (DAO) for domain model class TCard.
 * 
 * @see com.model.TCard
 * @author MyEclipse Persistence Tools
 */

public class TCardDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TCardDAO.class);

	// property constants
	public static final String XINGMING = "xingming";

	public static final String XINGBIE = "xingbie";

	public static final String NIANLING = "nianling";

	public static final String BANLISHIJIAN = "banlishijian";

	public static final String YUSHU = "yushu";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TCard transientInstance)
	{
		log.debug("saving TCard instance");
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

	public void delete(TCard persistentInstance)
	{
		log.debug("deleting TCard instance");
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

	public TCard findById(java.lang.Integer id)
	{
		log.debug("getting TCard instance with id: " + id);
		try
		{
			TCard instance = (TCard) getHibernateTemplate().get(
					"com.model.TCard", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TCard instance)
	{
		log.debug("finding TCard instance by example");
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
		log.debug("finding TCard instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TCard as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
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

	public List findByBanlishijian(Object banlishijian)
	{
		return findByProperty(BANLISHIJIAN, banlishijian);
	}

	public List findByYushu(Object yushu)
	{
		return findByProperty(YUSHU, yushu);
	}

	public List findAll()
	{
		log.debug("finding all TCard instances");
		try
		{
			String queryString = "from TCard";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TCard merge(TCard detachedInstance)
	{
		log.debug("merging TCard instance");
		try
		{
			TCard result = (TCard) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TCard instance)
	{
		log.debug("attaching dirty TCard instance");
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

	public void attachClean(TCard instance)
	{
		log.debug("attaching clean TCard instance");
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

	public static TCardDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TCardDAO) ctx.getBean("TCardDAO");
	}
}