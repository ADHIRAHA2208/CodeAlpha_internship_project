<%@ page import="java.util.*, com.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Report</title>
    <link rel="stylesheet" href="css/Style.css">
</head>
<body>
<center>
<div class="container">
    <h2>Student Report</h2>

    <table>
        <tr>
            <th>Name</th>
            <th>Marks</th>
        </tr>

        <%
            ArrayList<Student> students =
                (ArrayList<Student>) request.getAttribute("students");

            for (Student s : students) {
        %>
        <tr>
            <td><%= s.getName() %></td>
            <td><%= s.getMarks() %></td>
        </tr>
        <% } %>
    </table>

    <p>Average: <b><%= request.getAttribute("average") %></b></p>
    <p>Highest: <b><%= request.getAttribute("highest") %></b></p>
    <p>Lowest: <b><%= request.getAttribute("lowest") %></b></p>

    <a href="index.jsp">Add More</a>
</div>
</center>
</body>
</html>
