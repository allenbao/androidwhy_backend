<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>BasicWeb:登录</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta http-equiv="Cache-Control" content="no-store" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <meta name="title" content="BasicWeb|<sitemesh:title/>" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="author" content="黄国兴" />
    <meta name="publisher" content="黄国兴" />
    <meta name="copyright" content="(c) 2009 - 2012 www.androidwhy.com" />
    <meta name="Content-Language" content="utf-8" />
    <meta name="robots" content="INDEX, FOLLOW" />
    <meta name="revisit-after" content="7 days" />
    <meta name="MSSmartTagsPreventParsing" content="true" />
    <link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">

    <link href="${ctx}/static/bootstrap/2.1.1/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link href="${ctx}/static/jquery-validation/1.9.0/validate.css" type="text/css" rel="stylesheet" />
    <link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
    <script src="${ctx}/static/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/jquery-validation/1.9.0/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/jquery-validation/1.9.0/messages_bs_cn.js" type="text/javascript"></script>

    <sitemesh:head/>
</head>

<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp"%>
    <div class="row">
        <p/>
        <div id="main" class="span10">
            <form id="loginForm" action="${ctx}/login" method="post" class="form-horizontal">
                <%
                    String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
                    if(error != null){
                %>
                <div class="alert alert-error input-medium controls">
                    <button class="close" data-dismiss="alert">×</button>登录失败，用户名或密码有误，或者帐户被锁定，请重试或联系管理员.
                </div>
                <%
                    }
                %>
                <div class="control-group">
                    <label for="username" class="control-label">手机:</label>
                    <div class="controls">
                        <input type="text" id="username" name="username"  value="${username}" class="input-medium required"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="password" class="control-label">密码:</label>
                    <div class="controls">
                        <input type="password" id="password" name="password" class="input-medium required"/>
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <label class="checkbox" for="rememberMe"><input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我</label>
                        <input id="submit_btn" class="btn btn-primary" type="submit" value="登录"/> <!-- <a class="btn" href="${ctx}/register">注册</a>  -->
                    </div>
                </div>
            </form>
        </div>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp"%>
</div>
<script src="${ctx}/static/bootstrap/2.1.1/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
