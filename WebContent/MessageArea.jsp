<%@ page import="fieldformat.ShowMessage" %>

<link rel="stylesheet" type="text/css" href="css/messageAreaStyle.css">

<div id="messageArea">
	<%
		ShowMessage showMessage = new ShowMessage();
		showMessage = (ShowMessage) request.getAttribute("showMessage");
	%>
	<div id="error">
		<%
			if(showMessage != null) {
				if(showMessage.isAbEnd()) {
		%>
					<%= showMessage.getMessage() %>
		<%
				}
			}
		%>
	</div>

	<div id="normal">
		<%
			if(showMessage != null) {
				if(showMessage.isNomalEnd()) {
		%>
					<%= showMessage.getMessage() %>
		<%
				}
			}
		%>
	</div>
</div>