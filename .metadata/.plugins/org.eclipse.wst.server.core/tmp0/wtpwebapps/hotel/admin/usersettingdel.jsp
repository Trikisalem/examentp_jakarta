<%@page import="java.sql.*" errorPage="error.jsp"%>

<%
    // Removed database operations
    // The logic for deleting an admin has been removed as well

    // Simulated response for deletion
    String eid = request.getParameter("eid");

    if (eid != null) {
        // Here, you would typically handle the deletion request, but since we removed DB operations,
        // we will simulate a successful deletion.

        // Simulate the deletion
        String message = "Admin name and password Deleted";

        // Show an alert (this can be customized to fit the non-database approach)
        out.println("<script language='javascript' type='text/javascript'>");
        out.println("alert('" + message + "');");
        out.println("</script>");
    }

    // Redirect to the user settings page after "deletion"
    response.sendRedirect("usersetting.jsp");
%>

