<%@ page import="com.gym.Batch" %>
<%@ page import="com.gym.BatchService" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Batch</title>
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
        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        button {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>Update Batch</h2>
    <form action="batch" method="post">
            <input type="hidden" name="_method" value="PUT">

        <input type="hidden" name="id" value="<%= request.getAttribute("batch") != null ? ((Batch) request.getAttribute("batch")).getId() : "" %>">
        <label for="name">Batch Name:</label>
        <input type="text" id="name" name="name" value="<%= request.getAttribute("batch") != null ? ((Batch) request.getAttribute("batch")).getName() : "" %>" required>
        <label for="time">Time of Day:</label>
        <select id="time" name="timeOfDay" required>
            <option value="morning" <%= request.getAttribute("batch") != null && "morning".equals(((Batch) request.getAttribute("batch")).getTimeOfDay()) ? "selected" : "" %>>Morning</option>
            <option value="evening" <%= request.getAttribute("batch") != null && "evening".equals(((Batch) request.getAttribute("batch")).getTimeOfDay()) ? "selected" : "" %>>Evening</option>
        </select>
        <button type="submit">Update Batch</button>
    </form>
</body>
</html>
