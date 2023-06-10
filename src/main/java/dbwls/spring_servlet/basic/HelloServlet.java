package dbwls.spring_servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // http request, response 사용해보기
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username"); // 쿼리 파라미터 가져오기
        System.out.println("username = " + username);

        response.setContentType("text/plain"); // 응답 데이터 설정 후 보내기
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);


    }
}
