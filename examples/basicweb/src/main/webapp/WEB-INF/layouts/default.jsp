<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>BasicWeb|<sitemesh:title/></title>
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
    <link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
    <link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
    <script src="${ctx}/static/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>
    <script src="${ctx}/static/scripts/jquery-palceholder.js" type="text/javascript"></script>
    <sitemesh:head />
    <script language="javascript">
        function p_del(message) {
            var msg = message + "\n\n请确认！";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }
        $(window).resize(changeContentHeight);
        $(document).ready(changeContentHeight);
        function changeContentHeight(){
            var leftbar=$("#leftbar").height();
            var windowh=$(document).height()*0.75;
            if(leftbar>windowh){
                $("#content").height(leftbar);
            }else{
                $("#content").height(windowh);
            }
        }
    </script>
</head>

<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp"%>
    <div id="content" class="row" style="*width:960px;">
        <%@ include file="/WEB-INF/layouts/left.jsp"%><br>
        <div id="main" class="span10">
            <sitemesh:body />
        </div>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp"%>
</div>
<script src="${ctx}/static/bootstrap/2.1.1/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>