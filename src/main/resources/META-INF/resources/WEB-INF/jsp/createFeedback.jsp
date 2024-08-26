<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<head>
    <link rel="stylesheet" type="text/css" href="common/css/createFeedback.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
</head>
<div class="container">
    <form action="/submitFeedback" method="post">
        <div class="section">
            <label for="course"><i class="bi bi-book-fill"></i> Select a course:</label>
            <select id="course" name="course">
                <option value="" disabled selected>Select course...</option>
                <option value="Software Architecture">Software Architecture</option>
                <option value="Software Design">Software Design</option>
                <option value="Database Modelling">Database Modelling</option>
                <option value="Data Intensive Applications">Data Intensive Applications</option>
            </select>
        </div>
        <div class="section">
            <label for="date"><i class="bi bi-calendar3"></i> Course Date:</label>
            <input type="text" id="date" name="date" placeholder="Select date...">
        </div>
        <div class="section">
            <label for="topic"><i class="bi bi-journal-text"></i> Topic:</label>
            <textarea id="topic" name="topic" placeholder="Enter topic..."></textarea>
        </div>
        <button type="submit" class="submit-button" id="submit-button"><i class="bi bi-check"></i> SUBMIT</button>
    </form>
    <button id="logout-button"><i class="bi bi-box-arrow-right"></i> Logout</button>
</div>

<%@ include file="common/footer.jspf" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script>
	document.getElementById('logout-button').addEventListener('click', function(event) {
    	window.location.href = "login";
	});
    $(function () {
        $("#date").datepicker({
            dateFormat: 'dd-mm-yy',
            showButtonPanel: true
        });
    });
</script>
