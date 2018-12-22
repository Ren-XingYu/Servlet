package x.y.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //reqByPost(request,response);
        //respByWriter(request,response);
        respByStream(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ReqByGet(request,response);
        doPost(request,response);
    }

    private void respByStream(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setHeader("Content-Type","text/html;charset=utf-8");
        //String类的getBytes默认使用的编码是utf-8,String csn = Charset.defaultCharset().name();
        response.getOutputStream().write("琴瑟琵琶".getBytes("utf-8"));

        //响应可以直接使用下面这句设置编码
        //response.setContentType("text/html;charset=utf-8");
    }

    private void respByWriter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type","text/html;charset=utf-8");
        //上面两句可用下面一句代替
        //response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("魑魅魍魉");
    }

    private void reqByGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String encoding=request.getCharacterEncoding();
        System.out.println("encoding="+encoding);

        //String username=request.getParameter("username");
        String username=new String(request.getParameter("username").getBytes("iso8859-1"),"utf-8");
        String password=request.getParameter("password");
        System.out.println("username="+username+",password="+password);
    }

    private void reqByPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String encoding=request.getCharacterEncoding();
        System.out.println("encoding="+encoding);

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("username="+username+",password="+password);
    }
}
