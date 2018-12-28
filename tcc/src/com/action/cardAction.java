package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TCaozuoyuanDAO;
import com.dao.TCardDAO;
import com.model.TAdmin;
import com.model.TCaozuoyuan;
import com.model.TCard;
import com.opensymphony.xwork2.ActionSupport;

public class cardAction extends ActionSupport
{
	private int id;
	private String kahao;
	private String xingming;
	private String xingbie;
	private String nianling;
	private String banlishijian;
	 
	private String message;
	private String path;
	
	private TCardDAO cardDAO;
	
	
	public String cardAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		if(panduan_kahao(kahao.trim())=="cunzai")
		{
			request.setAttribute("msg", "卡号重复，请重新输入");
			return "msg";
		}
		else
		{
			TCard card=new TCard();
			
			card.setKahao(kahao);
			card.setXingming(xingming);
			card.setXingbie(xingbie);
			card.setNianling(nianling);
			card.setBanlishijian(banlishijian);
			
			cardDAO.save(card);
			
			this.setMessage("操作成功");
			this.setPath("cardMana.action");
			return "succeed";
		}
		
		
	}
	
	
	
	public String cardMana()
	{
		List cardList=cardDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cardList", cardList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String cardDel()
	{
		cardDAO.delete(cardDAO.findById(id));
		this.setMessage("删除成功");
		this.setPath("cardMana.action");
		return "succeed";
	}


	public String panduan_kahao(String kahao)
	{
		String s="";
		
		String sql="from TCard where kahao=?";
		Object[] c={kahao};
		
		List list=cardDAO.getHibernateTemplate().find(sql,c);
		if(list.size()==0)
		{
			s="bucunzai";
		}
		else
		{
			s="cunzai";
		}
		
		return s;
	}
	
	
	public String cardAll()
	{
		List cardList=cardDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cardList", cardList);
		return ActionSupport.SUCCESS;
	}
	
	
	public TCardDAO getCardDAO()
	{
		return cardDAO;
	}



	public void setCardDAO(TCardDAO cardDAO)
	{
		this.cardDAO = cardDAO;
	}



	public String getBanlishijian()
	{
		return banlishijian;
	}



	public void setBanlishijian(String banlishijian)
	{
		this.banlishijian = banlishijian;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public String getKahao()
	{
		return kahao;
	}



	public void setKahao(String kahao)
	{
		this.kahao = kahao;
	}



	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}



	public String getNianling()
	{
		return nianling;
	}



	public void setNianling(String nianling)
	{
		this.nianling = nianling;
	}



	public String getPath()
	{
		return path;
	}



	public void setPath(String path)
	{
		this.path = path;
	}



	public String getXingbie()
	{
		return xingbie;
	}



	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}



	public String getXingming()
	{
		return xingming;
	}



	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}
	
}
