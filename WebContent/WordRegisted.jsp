<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">

		<link rel="stylesheet" type="text/css" href="css/commonStyle.css">
		<link rel="stylesheet" type="text/css" href="css/wordRegistedStyle.css">

		<title>Word Registed</title>
	</head>
	<body>
		<%@ include file="Header.jsp" %>
		<div class="main">
			<article>
				<h2>Input new English word</h2>

				<%@ include file="Error.jsp" %>

			</article>

			<form action="WordRegisted" action="post">
				<table class="registedWord">
					<tr>
						<td>New Word : <input type="text" name="newWord" placeholder="apple"></td>
					</tr>

					<tr>
						<td>Mean : <input type="text" name="mean" placeholder="リンゴ"></td>
					</tr>

					<tr>
						<td>
							Word Type :
							<select name="wordType">
								<option value="noun">Noun</option>
								<option value="verb">Verb</option>
								<option value="adjective">Adjection</option>
								<option value="adverb">Adverb</option>
							</select>
						</td>
					</tr>

					<tr>
						<td>
							Example Sentence :<textarea name="exampleSentence"></textarea>
						</td>
					</tr>
				</table>

				<input type="submit" value="Regist">
			</form>
		</div>
	</body>
</html>