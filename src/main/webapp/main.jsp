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

<nav class="navbar navbar-default ">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                欣雨健康儿童医院人员管理系统
            </a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false"><span class="glyphicon glyphicon-signal"></span> <span
                        class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false"><span class="glyphicon glyphicon-tint"></span> <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false"><span class="glyphicon glyphicon-globe"></span> <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

<div class="row">
    <div class="col-md-2">

        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                           aria-expanded="true" aria-controls="collapseOne">
                            医护人员管理
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body">
                        <a href="javascript:$('#divtable').load('${path}/hospitalShow.jsp')">
                            医护人员查询
                        </a>
                    </div>
                    <div class="panel-body">
                        <a href="javascript:$('#divtable').load('${path}/departmentShow.jsp')">
                            部门查询
                        </a>
                    </div>
                    <div class="panel-body">
                        <a href="javascript:$('#divtable').load('${path}/gradeShow.jsp')">
                            等级查询
                        </a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingTwo">
                    <h4 class="panel-title">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                           href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            病人管理
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                    <div class="panel-body">
                        <a href="">
                            病人查询
                        </a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingThree">
                    <h4 class="panel-title">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                           href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            医疗器械药品管理
                        </a>
                    </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                    <div class="panel-body">
                        <a href="">
                            医疗器械查询
                        </a>
                    </div>
                    <div class="panel-body">
                        <a href="">
                            药品查询
                        </a>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="col-md-10" id="divtable">
        <%--<img src="${path}/img/1.jpg" class="img-circle" style="width: 960px;height: 960px">--%>
    </div>
</div>
</body>
</html>