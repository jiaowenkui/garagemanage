package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TRuchang;

/**
 * Data access object (DAO) for domain model class TRuchang.
 * 
 * @see com.model.TRuchang
 * @author MyEclipse Persistence Tools
 */

public class TRuchangDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TRuchangDAO.class);

	// property constants
	public static final String RUSHJIAN = "rushjian";

	public static final String CHEXING = "chexing";

	public static final String KAHAO = "kahao";

	public static final String BEIZHU = "beizhu";

	public static final String CHUSHIJIAN = "chushijian";

	public static final String FEIYONG = "feiyong";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TRuchang transientInstance)
	{
		log.debug("saving TRuchang instance");
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

	public void delete(TRuchang persistentInstance)
	{
		log.debug("deleting TRuchang instance");
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

	public TRuchang findById(java.lang.Integer id)
	{
		log.debug("getting TRuchang instance with id: " + id);
		try
		{
			TRuchang instance = (TRuchang) getHibernateTemplate().get(
					"com.model.TRuchang", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TRuchang instance)
	{
		log.debug("finding TRuchang instance by example");
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
		log.debug("finding TRuchang instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TRuchang as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRushjian(Object rushjian)
	{
		return findByProperty(RUSHJIAN, rushjian);
	}

	public List findByChexing(Object chexing)
	{
		return findByProperty(CHEXING, chexing);
	}

	public List findByKahao(Object kahao)
	{
		return findByProperty(KAHAO, kahao);
	}

	public List findByBeizhu(Object beizhu)
	{
		return findByProperty(BEIZHU, beizhu);
	}

	public List findByChushijian(Object chushijian)
	{
		return findByProperty(CHUSHIJIAN, chushijian);
	}

	public List findByFeiyong(Object feiyong)
	{
		return findByProperty(FEIYONG, feiyong);
	}

	public List findAll()
	{
		log.debug("finding all TRuchang instances");
		try
		{
			String queryString = "from TRuchang";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TRuchang merge(TRuchang detachedInstance)
	{
		log.debug("merging TRuchang instance");
		try
		{
			TRuchang result = (TRuchang) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TRuchang instance)
	{
		log.debug("attaching dirty TRuchang instance");
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

	public void attachClean(TRuchang instance)
	{
		log.debug("attaching clean TRuchang instance");
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

	public static TRuchangDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TRuchangDAO) ctx.getBean("TRuchangDAO");
	}
}