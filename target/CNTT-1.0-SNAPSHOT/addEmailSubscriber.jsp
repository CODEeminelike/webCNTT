<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dbAdapter.DBEmail" %>
<%@ page import="dataModel.EmailSubscriber" %>
<%@ page import="jakarta.persistence.EntityManager" %>
<%@ page import="jakarta.persistence.EntityTransaction" %>

<!DOCTYPE html>
<html>
<head>
    <title>Thêm Người Đăng Ký Email</title>
</head>
<body>
    <h2>Thêm Người Đăng Ký Email</h2>
    
    <!-- Form nhập liệu -->
    <form action="addEmailSubscriber.jsp" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required/><br><br>

        <label for="firstName">Tên:</label>
        <input type="text" id="firstName" name="firstName" required/><br><br>

        <label for="lastName">Họ:</label>
        <input type="text" id="lastName" name="lastName" required/><br><br>

        <input type="submit" value="Thêm Email"/>
    </form>

    <%-- Kiểm tra nếu đã gửi form và thêm email vào cơ sở dữ liệu --%>
    <%
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if (email != null && firstName != null && lastName != null) {
            // Tạo đối tượng EmailSubscriber
            EmailSubscriber emailSubscriber = new EmailSubscriber();
            emailSubscriber.setEmail(email);
            emailSubscriber.setFirstName(firstName);
            emailSubscriber.setLastName(lastName);
            
            // Thêm vào cơ sở dữ liệu
            DBEmail.addEmailSubscriber(emailSubscriber);
    %>
        <p style="color: green;">Đã thêm người đăng ký email thành công!</p>
    <% 
        }
    %>

</body>
</html>
