package x.y.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(name = "ReadResourceServlet",urlPatterns = "/ReadResourceServlet")
public class ReadResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //readResource_1(request,response);
        //readResource_2(request,response);
        //readResource_3(request,response);
        readResource_4(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void readResource_1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Properties properties=new Properties();
        /**
         * 这里使用FileInputSteam获取Web资源是不OK的
         * 因为路径不对，这里的路径是相对路径，其实是根据jre来确定的，但是我们这是一个web工程
         * jre会面会交给tomcat来管理，所以这里真实的相对目录是tomcat的bin目录
         */
        InputStream is=new FileInputStream("src/config.properties");
        properties.load(is);
        String name=properties.getProperty("name");
        response.getWriter().write(name);
    }

    private void readResource_2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext context=getServletContext();
        Properties properties=new Properties();
        InputStream is=new FileInputStream(context.getRealPath("config/config.properties"));
        properties.load(is);
        String name=properties.getProperty("name");
        response.getWriter().write(name);
    }

    private void readResource_3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext context=getServletContext();
        Properties properties=new Properties();
        InputStream is=context.getResourceAsStream("config/config.properties");
        properties.load(is);
        String name=properties.getProperty("name");
        response.getWriter().write(name);
    }

    private void readResource_4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext context=getServletContext();
        Properties properties=new Properties();
        InputStream is=this.getClass().getClassLoader().getResourceAsStream("../../config/config.properties");//相对的是WEB-INF/class目录
        properties.load(is);
        String name=properties.getProperty("name");
        response.getWriter().write(name);
    }
}
