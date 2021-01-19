/*
 * HelloWorld.java
 *
 */

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * The Hello World Servelet.
 *
 * @author Deepak Kumar
 * http://www.roseindia.net
 * deepak@roseindia.net
 */

public class HelloWorld extends HttpServlet {


    public void service(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
	  out.println("<title>Hello World Servlet!</title>");
	  out.println("<title>Hello TDHS</title>");
	  out.println("<title>Hello CC</title>");
        out.println("</head>");
        out.println("<body>");
		  out.println("<p align=\"center\"><font size=\"5\" color=\"#000080\">Hello World!</font></p>");
		  out.println("<p align=\"center\"><a href=\"javascript:history.back()\">Go to Home</a></p>");
        out.println("</body>");
        out.println("</html>");
    }
}



