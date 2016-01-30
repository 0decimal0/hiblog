import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class userlogin extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String e=request.getParameter("email");
    String upass= request.getParameter("password");
    //String repass=request.getParameter("repassword");

    try{
      String dbURL="jdbc:mysql://localhost:3306/hiblog";
      String username="root";
      String password="rohit123";

      Connection con = DriverManager.getConnection(dbURL,username,password);
      PreparedStatement ps =con.prepareStatement("insert into user values(?,?)");
      ps.setString(1,e);
      ps.setString(2,upass);
      int i = ps.executeUpdate();
      if(i>0)
        out.print("congratulations");
    }
    catch(SQLException e2){
      out.print(e2);
    }
    out.close();
  }
}
