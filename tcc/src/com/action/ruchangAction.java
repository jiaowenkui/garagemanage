package com.action;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TCardDAO;
import com.dao.TRuchangDAO;
import com.model.TCard;
import com.model.TRuchang;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Util;

public class ruchangAction extends ActionSupport
{
	private int id;
	private String rushijian;
	private String chexing;
	private String chehao;
	
	private String kahao;
	private String beizhu;
	private String chushijian;
	private int feiyong;
	
	 
	private String message;
	private String path;
	
	private TRuchangDAO ruchangDAO;
	private TCardDAO cardDAO;;
	
	
	public String ruchangAdd()
	{
        HttpServletRequest request=ServletActionContext.getRequest();
		
		if(panduan_kahao(kahao.trim())=="bucunzai")
		{
			request.setAttribute("msg", "你输入的卡号不存在，请重新输入");
			return "msg";
		}
		else
		{
			TRuchang ruchang=new TRuchang();
			
			ruchang.setRushijian(rushijian);
			ruchang.setChexing(chexing);
			ruchang.setChehao(chehao);
			ruchang.setKahao(kahao);
			
			ruchang.setBeizhu(beizhu);
			ruchang.setChushijian("");
			ruchang.setFeiyong(0);
			
			ruchangDAO.save(ruchang);
			
			request.setAttribute("msg", "录入成功");
			return "msg";
		}
	}
	
	
	public String chuchangMana()
	{
		String sql="from TRuchang where chushijian=''";
		List ruchangList=ruchangDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("ruchangList", ruchangList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String che_chuchang() throws ParseException
	{
		HttpServletRequest request=ServletActionContext.getRequest();
	    int id=Integer.parseInt(request.getParameter("id"));
	    String rushijian=request.getParameter("rushijian");
	    String chushijian=request.getParameter("chushijian");
	    
	    System.out.println(id+"^^^"+rushijian+"^^^"+"^^^"+chushijian);
	    
    	
    	int feiyong=5;
    	Date aa=Util.newDate1(rushijian);
    	Date bb=Util.newDate1(chushijian);
    	
    	long gg=bb.getTime()-aa.getTime();
    	long fenzhong=gg/1000/60;
    	
    	if(fenzhong<60)
    	{
    		feiyong=feiyong+0;
    	}
    	if(fenzhong>60 && fenzhong<120)
    	{
    		feiyong=feiyong * 2;
    	}
    	if(fenzhong>120 && fenzhong<180)
    	{
    		feiyong=feiyong * 3;
    	}
    	if(fenzhong>180 && fenzhong<240)
    	{
    		feiyong=feiyong * 4;
    	}
    	if(fenzhong>240 && fenzhong<300)
    	{
    		feiyong=feiyong * 5;
    	}
    	if(fenzhong>300 && fenzhong<360)
    	{
    		feiyong=feiyong * 6;
    	}
    	if(fenzhong>360 && fenzhong<420)
    	{
    		feiyong=feiyong * 7;
    	}
    	if(fenzhong>420 && fenzhong<480)
    	{
    		feiyong=feiyong * 8;
    	}
    	if(fenzhong>480 && fenzhong<540)
    	{
    		feiyong=feiyong * 9;
    	}
    	if(fenzhong>540 && fenzhong<600)
    	{
    		feiyong=feiyong * 10;
    	}
    	if(fenzhong>600)
    	{
    		feiyong=100;
    	}
    	
    	
    	TRuchang ruchang=ruchangDAO.findById(id);
    	ruchang.setChushijian(chushijian);
    	ruchang.setFeiyong(feiyong);
    	ruchangDAO.getHibernateTemplate().update(ruchang);
    	
    	request.setAttribute("rushijian", rushijian);
    	request.setAttribute("chushijian", chushijian);
    	request.setAttribute("fenzhong", fenzhong);
    	request.setAttribute("feiyong", feiyong);
	    
	    return ActionSupport.SUCCESS;
	    
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

	public String tingche_jilu()
	{
		String sql="from TRuchang where chushijian !=''";
		List ruchangList=ruchangDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("ruchangList", ruchangList);
		return ActionSupport.SUCCESS;
	}
	
	public String tingche_tongji()
	{
		String sql="from TRuchang where chushijian !='' and chehao like '%"+chehao+"%'";

		List ruchangList=ruchangDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("ruchangList", ruchangList);
		request.put("chehao", chehao);
		return ActionSupport.SUCCESS;
	}
	
	
	public String tingche_daochu()
	{
		String sql="from TRuchang where chushijian !='' and chehao like '%"+chehao+"%'";

		List ruchangList=ruchangDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("ruchangList", ruchangList);
		return ActionSupport.SUCCESS;
	}
	

	public String getBeizhu()
	{
		return beizhu;
	}


	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}


	public String getChexing()
	{
		return chexing;
	}


	public TCardDAO getCardDAO()
	{
		return cardDAO;
	}


	public void setCardDAO(TCardDAO cardDAO)
	{
		this.cardDAO = cardDAO;
	}


	public void setChexing(String chexing)
	{
		this.chexing = chexing;
	}


	public String getChushijian()
	{
		return chushijian;
	}


	public void setChushijian(String chushijian)
	{
		this.chushijian = chushijian;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getChehao()
	{
		return chehao;
	}


	public void setChehao(String chehao)
	{
		this.chehao = chehao;
	}


	public int getFeiyong()
	{
		return feiyong;
	}


	public void setFeiyong(int feiyong)
	{
		this.feiyong = feiyong;
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


	public String getPath()
	{
		return path;
	}


	public void setPath(String path)
	{
		this.path = path;
	}


	public TRuchangDAO getRuchangDAO()
	{
		return ruchangDAO;
	}


	public void setRuchangDAO(TRuchangDAO ruchangDAO)
	{
		this.ruchangDAO = ruchangDAO;
	}


	public String getRushijian()
	{
		return rushijian;
	}


	public void setRushijian(String rushijian)
	{
		this.rushijian = rushijian;
	}

}
