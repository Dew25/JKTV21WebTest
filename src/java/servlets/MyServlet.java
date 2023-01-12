/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Melnikov
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet","/page1","/pageJsp2","/pageJsp1"})
public class MyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        switch (request.getServletPath()) {
            case "/page1":
                request.setAttribute("info", "Эта информация передана из кода Java!");
                request.getRequestDispatcher("/WEB-INF/page1.html").forward(request, response);
                break;
            case "/MyServlet":
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet MyServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet MyServlet at " + request.getContextPath() + "</h1>");
                    out.println("<h2>паттерн " + request.getServletPath() + "</h2>");
                    out.println("<h2>query " + request.getQueryString() + "</h2>");
                    out.println("</body>");
                    out.println("</html>");
                }
            case "/pageJsp2":
                request.setAttribute("info", "Эта информация передана из кода Java!");
                request.getRequestDispatcher("/WEB-INF/pageJsp2.jsp").forward(request, response);
                break;
            case "/pageJsp1":
                request.setAttribute("info", "Эта информация передана из кода Java!");
                request.getRequestDispatcher("/pageJsp1.jsp").forward(request, response);
                break;    
            default:
                throw new AssertionError();
        
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
