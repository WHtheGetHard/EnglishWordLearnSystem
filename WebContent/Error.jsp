<%@ page import="fieldformat.ErrorAndMessage" %>

<link rel="stylesheet" type="text/css" href="css/errorStyle.css">

<div id="errorArea">
	<%
		ErrorAndMessage errorAndMessage = new ErrorAndMessage();
		errorAndMessage = (ErrorAndMessage)request.getAttribute("errorAndMessage");
		if(errorAndMessage != null) {
			if(errorAndMessage.isShowError()) {
	%>
				<%= errorAndMessage.getMessage() %>
	<%
			}
		}
	%>
</div>