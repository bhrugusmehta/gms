<%@ page import="java.util.List" %>
<%@ page import="com.gym.Participant" %>
<!DOCTYPE html>
<html>
<head>
    <title>Participants in Batch</title>
    <style>
         body {
                    font-family: Arial, sans-serif;
                    background-color: #f4f4f4;
                    margin: 0;
                    padding: 20px;
                }
                h2 {
                    text-align: center;
                    color: #333;
                    margin-bottom: 20px;
                }
                table {
                    width: 100%;
                    border-collapse: collapse;
                    margin: 0 auto;
                    background-color: #ffffff;
                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                }
                th, td {
                    padding: 12px;
                    text-align: left;
                    border-bottom: 1px solid #ddd;
                }
                th {
                    background-color: #007BFF;
                    color: #ffffff;
                }
                tr:nth-child(even) {
                    background-color: #f9f9f9;
                }
                tr:hover {
                    background-color: #eaeaea;
                }
                a {
                    color: #007BFF;
                    text-decoration: none;
                    font-weight: bold;
                }
                a:hover {
                    text-decoration: underline;
                }
                .actions {
                    display: flex;
                    gap: 10px;
                }
                .back-link {
                    display: block;
                    text-align: center;
                    margin-top: 20px;
                    font-size: 16px;
                }
    </style>
</head>
<body>
    <h1>Participants in Batch </h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Batch ID</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Participant> participants = (List<Participant>) request.getAttribute("participants");
                if (participants != null) {
                    for (Participant participant : participants) {
            %>
                <tr>
                    <td><%= participant.getId() %></td>
                    <td><%= participant.getName() %></td>
                    <td><%= participant.getBatchId() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="3">No participants found for this batch.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <br>
    <a href="index.html">Back to home</a>
</body>
</html>

