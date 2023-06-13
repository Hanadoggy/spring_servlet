package dbwls.spring_servlet.web.frontcontroller.v2;

import dbwls.spring_servlet.web.frontcontroller.MyView;
import dbwls.spring_servlet.web.frontcontroller.v1.ControllerV1;
import dbwls.spring_servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import dbwls.spring_servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import dbwls.spring_servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 요청 주소 가져오기
        String requestURI = request.getRequestURI();
        // 다형성에 의해서 인터페이스로 받음, URI 에 맞는 객체 반환
        ControllerV2 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}
