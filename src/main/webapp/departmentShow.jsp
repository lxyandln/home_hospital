<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<script>

    $(function () {

        $("#table").jqGrid({
            styleUI: "Bootstrap",
            url: "${path}/department/selectDepartmentsPageController",
            datatype: "json",
            mtype: "post",
            colNames: ["编号", "名称"],
            autowidth: true,
            pager: "#page",
            rowNum: 4,
            viewrecords: true,
            editurl: "${path}/department/edit",
            rowList: [4, 6, 8, 10],
            colModel: [
                {name: "id"},
                {name: "depart", editable: true},
            ],
            multiselect: true,
            toolbar: ['true', 'top'],
            caption: "部门管理",
        }).jqGrid("navGrid", "#page", {});

    });

</script>

<table id="table"></table>

<div id="page"></div>