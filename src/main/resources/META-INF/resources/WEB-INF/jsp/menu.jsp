<%@ include file="common/header.jspf" %>

<head>
    <link rel="stylesheet" type="text/css" href="common/css/menu.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
</head>
<div class="container">
    <button onclick="window.location.href='/createFeedback'" class="submit-button">Create New Feedback Form</button>
    <button onclick="window.location.href='/feedbackSummaries'" class="submit-button">Feedback Summaries</button>
</div>
<button id="logout-button" class="logout-button"><i class="bi bi-box-arrow-right"></i> Logout</button>

<%@ include file="common/footer.jspf" %>

<script>
	document.getElementById('logout-button').addEventListener('click', function(event) {
    	window.location.href = "login";
	});
</script>