<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="fieldformat.ExamTypes"%>
<!DOCTYPE html>
	<html lang="ja">
		<head>
			<meta charset="UTF-8">

			<link rel="stylesheet" type="text/css" href="css/commonStyle.css">
			<link rel="stylesheet" type="text/css" href="css/examStyle.css">
			<title>Word Exam</title>
		</head>

	<body>
		<%@ include file="Header.jsp" %>

		<div class="main">
			<article>
				<h2>Choose exam type and word from.</h2>
			</article>

			<form action="ExamTypeChoose" method="post">
				<select name="examType">
					<option value="note">Vocabulary NoteBook</option>
					<option value="list">Vocabulary List</option>
				</select>

				<select name="wordFrom">
					<option value="1">One Punch Man</option>
					<option value="2">TOEIC</option>
				</select>

				<input type="submit" value="decide">
			</form>

			<%
				ExamTypes examTypes = new ExamTypes();
				examTypes = (ExamTypes) request.getAttribute("examTypes");

				if (examTypes != null) {
					if (examTypes.isNote()) {
			%>
						note
			<%
					} else if (examTypes.isList()) {
			%>
						list
			<%
					}
				}
			%>
		</div>
	</body>
</html>