<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.text.SimpleDateFormat"/>
<jsp:directive.page import="java.util.Date"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
		
        <script language="javascript">
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="32" background="<%=path %>/img/tbg.gif">&nbsp;停车记录信息&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22"">
				    <td width="5%">序号</td>
				    <td width="11%">入场时间</td>
					<td width="11%">车型</td>
					<td width="11%">车牌号</td>
					<td width="11%">入场卡号</td>
					<td width="11%">备注信息</td>
					<td width="11%">出场时间</td>
					<td width="11%">停车费用(￥)</td>
		        </tr>	
				<c:forEach items="${requestScope.ruchangList}" var="ruchang" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${sta.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ruchang.rushijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ruchang.chexing}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${ruchang.chehao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${ruchang.kahao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ruchang.beizhu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ruchang.chushijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ruchang.feiyong}
					</td>
				</tr>
				</c:forEach>
			</table>
			<br/>
			
			<form action="<%=path %>/tingche_daochu.action" name="f" method="post">
			<table width="98%" border="0">
				<tr align='left'>
					<td>
					    &nbsp;&nbsp;
						<input type="hidden" name="chehao" value="${requestScope.chehao }"/>
						<input type="submit" value="导出数据"/>
					</td>
				</tr>
			</table>
			</form>
	</body>
</html>
