<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<head>
    <link rel="stylesheet" type="text/css" href="common/css/writeFeedback.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="course-info">
            <div class="course-name">Course Name: ${feedback.courseName}</div>
            <div class="course-date">Date: ${feedback.date}</div>
            <div class="course-topic">Topic: ${feedback.topic}</div>
        </div>
        <div class="feedback-form">
            <label for="feedback"><i class="bi bi-chat-left-text"></i> Feedback:</label>
            <textarea id="feedback" name="feedback" placeholder="Write your feedback here..."></textarea>
            <input type="hidden" name="courseName" value="${feedback.courseName}" />
            <button id="submit-button" class="submit-button"><i class="bi bi-check"></i> SUBMIT</button>
        </div>
    </div>

    <%@ include file="common/footer.jspf" %>

    <script>
		document.getElementById('submit-button').addEventListener('click', function(event) {
    		window.location.href = "login";
		});
        $(function () {
            $("#submit-button").click(function() {
                var feedbackText = $("#feedback").val();
                var courseName = $("input[name='courseName']").val();

                if (feedbackText) {
                    $.ajax({
                        url: '/submitFb',
                        type: 'POST',
                        data: {
                            courseName: courseName,
                            feedback: feedbackText
                        },
                        success: function(response) {
                            alert("Feedback submitted successfully!");
                            $("#feedback").val('');
                            window.location.href = "feedbackSummaries";
                        },
                        error: function(xhr, status, error) {
                            console.error('Error submitting feedback:', error, xhr.responseText);
                            alert("Error submitting feedback.");
                        }
                    });
                } else {
                    alert("Please provide your feedback!");
                }
            });
        });
    </script>
</body>
</html>
