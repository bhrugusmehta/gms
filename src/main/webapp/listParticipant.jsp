<%@ page import="java.util.List" %>
<%@ page import="com.gym.ParticipantDAO" %>
<%@ page import="com.gym.Participant" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Participants</title>
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
    <h2>List of Participants</h2>
        <a href="index.html">Back to Home</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Batch ID</th>
            <th>Actions</th>
        </tr>
        <%
            List<Participant> participants = (List<Participant>) request.getAttribute("participants");
            for (Participant p : participants) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getBatchId() %></td>
           <td class="actions">
              <a href="participant?action=delete&id=<%= p.getId() %>">Delete</a>
              <a href="participant?action=update&id=<%= p.getId() %>">Update</a>
          </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
