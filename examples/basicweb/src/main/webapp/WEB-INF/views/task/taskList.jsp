<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>任务管理</title>
    <script>
        $(document).ready(function() {
            $("#account-my-task").addClass("active");   // 控制菜单点击后样式
        });
    </script>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
			<form class="form-search" action="#">
				<label>名称：</label> <input type="text" name="search_LIKE_title" class="input-medium" value="${param.search_LIKE_title}"  placeholder="姓名">
				<button type="submit" class="btn" id="search_btn">Search</button>
                <tags:sort/>
		    </form>
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
        <tr>
            <th>任务</th>
            <th>管理</th>
        </tr>
        </thead>
		<tbody>
		<c:forEach items="${tasks.content}" var="task">
			<tr>
				<td>
				    ${task.title}
                </td>
				<td>
                    <a href="${ctx}/task/update/${task.id}">编辑</a>|
                    <a href="${ctx}/task/delete/${task.id}">删除</a>
                </td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${tasks}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/task/create">创建任务</a></div>
</body>
</html>
