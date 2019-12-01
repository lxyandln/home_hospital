<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<script>

    $(function () {

        $("#table").jqGrid({
            styleUI: "Bootstrap",
            url: "${path}/grade/selectGradesPageController",
            datatype: "json",
            mtype: "post",
            colNames: ["编号", "等级"],
            autowidth: true,
            pager: "#page",
            rowNum: 4,
            viewrecords: true,
            editurl: "${path}/grade/edit",
            rowList: [4, 6, 8, 10],
            colModel: [
                {name: "id"},
                {name: "grade", editable: true},
            ],
            multiselect: true,
            toolbar: ['true', 'top'],
            caption: "等级管理",
        }).jqGrid("navGrid", "#page", {});

    });

</script>

<table id="table"></table>

<div id="page"></div>