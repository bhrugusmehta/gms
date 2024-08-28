<%@ page import="java.util.List" %>
<%@ page import="com.gym.BatchDAO" %>
<%@ page import="com.gym.Batch" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Batches</title>
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
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #eaeaea;
        }
        a {
            color: #007BFF;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .actions {
            display: flex;
            gap: 10px;
        }
    </style>
</head>
<body>
    <h2>List of Batches</h2>
    <a href="index.html">Back to Home</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Time of Day</th>
            <th>Actions</th>
        </tr>
        <%
            List<Batch> batches = (List<Batch>) request.getAttribute("batches");
            for (Batch b : batches) {
        %>
        <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getName() %></td>
            <td><%= b.getTimeOfDay() %></td>
            <td class="actions">
                <a href="batch?action=delete&id=<%= b.getId() %>">Delete</a>
                <a href="batch?action=update&id=<%= b.getId() %>">Update</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
