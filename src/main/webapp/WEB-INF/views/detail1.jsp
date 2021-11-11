<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!-- Main content -->
    <section class="content container-fluid">
  <table class="table">

	<form>
	<div class="form-group1">
	<table>
	<c:forEach var="boardreply" items="${list}">
		<tr>
			<td>작성자 : ${boardreply.rewriter}    작성일자 : ${boardreply.redate} </td>
		</tr>
		<tr>
			<td><textarea name="rememo" rows="5" cols="40"
				readonly="readonly" class="form-control1">${boardreply.rememo}</textarea>
			</td>
			<td><a href="replyupdate?reno=${boardreply.reno}">댓글 수정</a></td>
			   
		</tr>
	</c:forEach>
	</table>
	</div>


</form>	
    </section>
