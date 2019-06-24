package hu.zerotohero.example.javaee;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/personServlet")
public class PersonServlet extends HttpServlet {

	@Inject
	private PersonBean personBean;

	@Override
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException,
			IOException {
		personBean.setName(httpServletRequest.getParameter("name"));
		httpServletResponse.sendRedirect("index.jsp");
	}
}