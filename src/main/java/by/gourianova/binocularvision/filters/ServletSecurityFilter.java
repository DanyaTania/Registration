package by.gourianova.binocularvision.filters;

import by.gourianova.binocularvision.entity.PersonsType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(dispatcherTypes = {
DispatcherType.REQUEST,
DispatcherType.FORWARD,
DispatcherType.INCLUDE
}, urlPatterns = { "/jsp/regist.jsp" })
public class ServletSecurityFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		PersonsType type = (PersonsType) session.getAttribute("userType");
		if (type == PersonsType.ADMINISTRATOR) {
			request.getRequestDispatcher("/jsp/main_admin.jsp").forward(request, response);

		} if (type == PersonsType.USER) {
			request.getRequestDispatcher("/jsp/main_user.jsp").forward(request, response);
	
		}else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}
}
