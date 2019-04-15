package com.servlet;

import com.entity.User;
import com.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : liuxulong
 * date : 19:32 2019/4/15
 */
@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("annotation.xml");
    UserService userService = classPathXmlApplicationContext.getBean("userService", UserService.class);

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("query".equals(action)){
            query(request,response);
        }else if ("add".equals(action)){
            add(request,response);
        }else if ("update".equals(action)){
            update(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if ("queryOne".equals(action)){
            queryOne(request,response);
        }
    }
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageIndex=1;
        int pageCount=5;
        String index = request.getParameter("pageIndex");
        if (index!=null){
            pageIndex = Integer.parseInt(index);
        }
        List<User> list = userService.queryPage(pageIndex, pageCount);
        int page = userService.Page(pageCount);
        request.setAttribute("list",list);
        request.setAttribute("page",page);
        request.setAttribute("pageIndex",pageIndex);
        request.getRequestDispatcher("/background/query.jsp").forward(request,response);


    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        User user=new User(name);
        int add = userService.add(user);
        response.sendRedirect(request.getContextPath()+"/UserServlet?action=query");

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        User user=new User(name);
        int update = userService.update(user);
        response.sendRedirect(request.getContextPath()+"/UserServlet?action=query");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath()+"/UserServlet?action=query");
    }
    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = userService.queryOne(Integer.parseInt(id));
        request.setAttribute("user",user);
        request.getRequestDispatcher("/background/update.jsp").forward(request,response);
    }


}
