<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="leftbar" class="span2">
    <h1>个人中心</h1>
    <div class="submenu">
        <a id="account-my-profile" href="${ctx}/profile/">个人信息</a>
        <a id="account-my-task" href="${ctx}/task/">任务管理</a>
    </div>

    <shiro:hasRole name="admin">
    <h1>系统设置</h1>
    <div class="submenu">
        <a id="account-admin-user" href="${ctx}/admin/user/">帐户管理</a>
    </div>
    </shiro:hasRole>
</div>