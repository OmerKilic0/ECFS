<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<head>
    <link rel="stylesheet" type="text/css" href="common/css/viewFeedback.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
</head>
<div class="container">
    <h2>Feedback Details</h2>
    <div class="course-info">
        <div class="course-name">Course Name: ${feedback.courseName}</div>
        <div class="course-feedback">Feedback: ${feedback.feedback}</div>
    </div>
</div>
<button id="logout-button"><i class="bi bi-box-arrow-right"></i> Logout</button>

<%@ include file="common/footer.jspf" %>

<script>
        document.getElementById('logout-button').addEventListener('click', function(event) {
            window.location.href = "login";
        });
</script>
</html>
