<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/AdminProduct?method=addProductUI";
	}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/user/list.jsp"
		method="post">
		<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray"
			border="1" id="DataGrid1"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr
				style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

				<td align="center" width="18%">序号</td>
				<td align="center" width="17%">商品图片</td>
				<td align="center" width="17%">商品名称</td>
				<td align="center" width="17%">商品价格</td>
				<td align="center" width="17%">是否热门</td>
				<td width="7%" align="center">编辑</td>
			</tr>
			<c:if test="${page.totalRecords==0 }">
				<b><p>抱歉没有商品</p></b>
			</c:if>
			<c:if test="${page.totalRecords!=0 }">
				<c:forEach items="${page.list }" var="p" varStatus="status">
					<tr onmouseover="this.style.backgroundColor = 'white'"
						onmouseout="this.style.backgroundColor = '#F5FAFE';">
						<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
							${ status.count }</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
							<img width="40" height="45"
							src="${ pageContext.request.contextPath }/${p.pimage}">
						</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
							${ p.pname }</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
							${ p.shop_price }</td>
						<c:if test="${p.is_host==1 }">
						<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
							是(1)</td>
							</c:if>
							<c:if test="${p.is_host==0 }">
						<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
							否(0)</td>
							</c:if>
						<td align="center" style="HEIGHT: 22px"><a href=""> <img
								src="${pageContext.request.contextPath}//img/admin/i_edit.gif"
								border="0" style="CURSOR: hand">
						</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<%@ include file="/jsp/pageFile.jsp"%>
		</TBODY>
	</form>
</body>
</HTML>

