package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TCaozuoyuanDAO;
import com.model.TAdmin;
import com.model.TCaozuoyuan;
import com.opensymphony.xwork2.ActionSupport;

public class caozuoyuanAction extends ActionSupport
{
	private int id;
	private String xingming;
	private String xingbie;
	private String nianling;
	private String loginname;
	private String loginpw;
	 
	private String message;
	private String path;
	
	private TCaozuoyuanDAO caozuoyuanDAO;
	
	
	public String caozuoyuanAdd()
	{
		TCaozuoyuan caozuoyuan=new TCaozuoyuan();
		
		caozuoyuan.setXingming(xingming);
		caozuoyuan.setXingbie(xingbie);
		caozuoyuan.setNianling(nianling);
		caozuoyuan.setLoginname(loginname);
		caozuoyuan.setLoginpw(loginpw);
		
		caozuoyuanDAO.save(caozuoyuan);
		
		this.setMessage("操作成功");
		this.setPath("caozuoyuanMana.action");
		return "succeed";
	}
	
	
	
	public String caozuoyuanMana()
	{
		List caozuoyuanList=caozuoyuanDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("caozuoyuanList", caozuoyuanList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String caozuoyuanDel()
	{
		caozuoyuanDAO.delete(caozuoyuanDAO.findById(id));
		this.setMessage("删除成功");
		this.setPath("caozuoyuanMana.action");
		return "succeed";
	}
	
	
	public String caozuoyuanEdit_ziji()
	{
		
		TCaozuoyuan caozuoyuan=caozuoyuanDAO.findById(id);
		caozuoyuan.setXingming(xingming);
		caozuoyuan.setXingbie(xingbie);
		caozuoyuan.setNianling(nianling);
		caozuoyuan.setLoginname(loginname);
		caozuoyuan.setLoginpw(loginpw);
		caozuoyuanDAO.getHibernateTemplate().update(caozuoyuan);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "修改成功。重新登录后生效");
		return "msg";
		
	}



	public TCaozuoyuanDAO getCaozuoyuanDAO()
	{
		return caozuoyuanDAO;
	}



	public void setCaozuoyuanDAO(TCaozuoyuanDAO caozuoyuanDAO)
	{
		this.caozuoyuanDAO = caozuoyuanDAO;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public String getLoginname()
	{
		return loginname;
	}



	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}



	public String getLoginpw()
	{
		return loginpw;
	}



	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
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
