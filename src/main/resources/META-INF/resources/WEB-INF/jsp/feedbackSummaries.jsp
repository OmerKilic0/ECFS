<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="common/css/feedbackSummaries.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
</head>
<div class="container">
	<h2>Feedback Summaries</h2>
	<table>
		<thead>
			<tr>
				<th>Course Name</th>
				<th>Date</th>
				<th>Topic</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${feedbackForms}" var="feedbackForm">
				<tr>
					<td>${feedbackForm.courseName}</td>
					<td>${feedbackForm.date}</td>
					<td>${feedbackForm.topic}</td>
					<td><a href="viewFeedback?feedbackId=${feedbackForm.id}">View</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<button id="logout-button"><i class="bi bi-box-arrow-right"></i> Logout</button>
<%@ include file="common/footer.jspf" %>

<script>
	document.getElementById('logout-button').addEventListener('click', function(event) {
    	window.location.href = "login";
	});
</script>
</html>
