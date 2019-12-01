<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<script>

    $(function () {

        $("#table").jqGrid({
            styleUI: "Bootstrap",
            url: "${path}/hospital/selectHospitalsAllController",
            datatype: "json",
            mtype: "post",
            colNames: ["编号", "姓名", "出生日期", "部门", "等级", "电话", "工资", "操作"],
            autowidth: true,
            pager: "#page",
            rowNum: 2,
            viewrecords: true,
            editurl: "${path}/hospital/edit",
            rowList: [2, 4, 6, 8],
            colModel: [
                {name: "id"},
                {name: "name", editable: true},
                {name: "birth", editable: true},
                {
                    name: "department.id",
                    editable: true,
                    edittype: "select",
                    editoptions: {
                        dataUrl: "${path}/department/selectDepartmentsAllController",
                    },
                    formatter: function (cellvalue, options, rowObject) {
                        return rowObject.department.depart;
                    }
                },
                {
                    name: "grade.id",
                    editable: true,
                    edittype: "select",
                    editoptions: {
                        dataUrl: "${path}/grade/selectGradesAllController",
                    },
                    formatter: function (cellvalue, options, rowObject) {
                        return rowObject.grade.grade;
                    }
                },
                {name: "phone", editable: true},
                {name: "salary", editable: true},
                {
                    name: "xxxxx",
                    formatter: function (cellvalue, options, rowObject) {
                        return "<a  href=\"javascript:edit('" + rowObject.id + "')\" class=\"btn btn-default btn-primary\"><span class=\"glyphicon glyphicon-pencil\"></span> </a> <a href=\"javascript:del('" + rowObject.id + "')\" class=\"btn btn-default btn-danger\"><span class=\"glyphicon glyphicon-trash\"></span> </a>"
                    }
                }
            ],
            multiselect: true,
            toolbar: ['true', 'top'],
            caption: "医护人员管理",
            onSelectAll: function (aRowids, status) {

            },
            ondblClickRow: function (rowid, iRow, iCol, e) {

            }

        }).jqGrid("navGrid", "#page", {edit: false, add: false, del: false, search: false, refresh: false});

        $("#add").click(function () {
            $("#table").jqGrid('editGridRow', "new", {
                height: 350,
                reloadAfterSubmit: true,

            });
        })
        $("#del").click(function () {
            var gr = $("#table").jqGrid('getGridParam', 'selrow');
            alert(gr);
            if (gr != null)
                $("#table").jqGrid('delGridRow', gr, {
                    reloadAfterSubmit: true
                });
            else
                alert("Please Select Row to delete!");

        })
        $("#update").click(function () {
            var gr = $("#table").jqGrid('getGridParam', 'selrow');
            if (gr != null)
                $("#table").jqGrid('editGridRow', gr, {
                    height: 350,
                    reloadAfterSubmit: true
                });
            else
                alert("Please Select Row");
        })
        $("#t_table").append("<a href=\"javascript:add()\" class=\"btn btn-default btn-info\"><span class=\"glyphicon glyphicon-plus\"></span> 添加</a>\n")
    });

    function add() {
        $("#table").jqGrid('editGridRow', "new", {
            height: 300,
            reloadAfterSubmit: true
        });
    }

    function del(gr) {

        if (gr != null)
            $("#table").jqGrid('delGridRow', gr, {
                reloadAfterSubmit: true
            });
        else
            alert("Please Select Row to delete!");
    }

    function edit(gr) {
        // var gr = $("#tb").jqGrid('getGridParam', 'selrow');
        if (gr != null)
            $("#table").jqGrid('editGridRow', gr, {
                height: 300,
                reloadAfterSubmit: true
            });
        else
            alert("Please Select Row");
    }

</script>

<table id="table"></table>

<div id="page"></div>
<button class="btn btn-primary" id="add">添加</button>
<button class="btn btn-primary" id="del">删除</button>
<button class="btn btn-primary" id="update">修改</button>