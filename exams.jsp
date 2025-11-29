<h2>Available Exams</h2>

<table border="1">
<tr><th>ID</th><th>Name</th><th>Action</th></tr>

<%
    ResultSet rs = (ResultSet) request.getAttribute("examList");
    while (rs.next()) {
%>

<tr>
<td><%= rs.getInt("exam_id") %></td>
<td><%= rs.getString("exam_name") %></td>
<td><a href="RegisterExamServlet?exam_id=<%= rs.getInt("exam_id") %>">Register</a></td>
</tr>

<% } %>
</table>
