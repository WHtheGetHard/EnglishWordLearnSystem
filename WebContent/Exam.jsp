<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="fieldformat.ExamTypes"%>
<%@ page import="fieldformat.Words" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
	<html lang="ja">
		<head>
			<meta charset="UTF-8">

			<link rel="stylesheet" type="text/css" href="css/commonStyle.css">
			<link rel="stylesheet" type="text/css" href="css/examStyle.css">
			<link rel="shortcut icon" href="./img/icon.jpg">
			<title>Word Exam</title>
		</head>

	<body>
		<%@ include file="Header.jsp" %>

		<div class="main">
			<article>
				<%@ include file="MessageArea.jsp" %>
				<h2>Choose exam type and word from.</h2>
			</article>

			<form action="ExamTypeChoose" method="post">
				<select name="examType">
					<option value="note">Vocabulary NoteBook</option>
					<option value="list">Vocabulary List</option>
				</select>

				<input type="submit" value="decide">
			</form>

			<%
				ExamTypes examTypes = new ExamTypes();
				examTypes = (ExamTypes) request.getAttribute("examTypes");

				ArrayList<Words> wordList = new ArrayList<Words>();
				wordList = (ArrayList<Words>)request.getAttribute("wordList");

				if (examTypes != null) {
					if (examTypes.isNote()) {
			%>

			<%
					} else if (examTypes.isList()) {
			%>
							<table>
								<tr>
									<th>Word</th>
									<th>Input the mean</th>
									<th>Correct Answer</th>
								</tr>
							</table>
			<%
						for (int i = 0; i < wordList.size(); i++) {


			%>
							<table>
								<tr>
									<td><%= wordList.get(i).getWord() %></td>
									<td>
										<input type="text" autocomplete="off">
										<input type="hidden" value="<%= wordList.get(i).getMean()%>">
									</td>
									<td>
										<select name="correctOrNot">
											<option value="〇">〇</option>
											<option value="×">×</option>
										</select>
									</td>
								</tr>
							</table>
			<%
						}
					}
				}
			%>
		</div>
	</body>
</html>