<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%--引入bootstrap的核心css--%>
    <link rel="stylesheet" href="${path}/statics/boot/css/bootstrap.min.css">
    <%--引入jqgrid的核心css--%>
    <%--<link rel="stylesheet" href="${path}/jqgrid/css/ui.jqgrid.css">--%>
    <%--jqgird的主题css--%>
    <%-- <link rel="stylesheet" href="${path}/jqgrid/css/css/start/jquery-ui-1.8.16.custom.css">--%>
    <link rel="stylesheet" href="${path}/statics/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <%--引入jquery的js--%>
    <script src="${path}/statics/boot/js/jquery-3.3.1.min.js"></script>
    <%--引入bootstrap的js--%>
    <script src="${path}/statics/boot/js/bootstrap.min.js"></script>
    <%--jqgird的国际化js--%>
    <script src="${path}/statics/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <%--jqgird的js--%>
    <script src="${path}/statics/jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="jumbotron">
        <h1 class="text-center">欢迎使用欣雨医院管理系统</h1>
        <p class="text-center">管理员，您好</p>
        <p class="text-center"><a class="btn btn-primary btn-lg" href="${path}/main.jsp" role="button">点击进入</a></p>
    </div>
</div>
</body>
</html>