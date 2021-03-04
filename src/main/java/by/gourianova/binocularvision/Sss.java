package by.gourianova.binocularvision;//import javax.faces.context.FacesContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

@WebServlet(urlPatterns = "/sss")
@Slf4j
public class Sss extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Sss:Servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            //String checkEmail = @"^(?("")(""[^""]+?""@)|(([0-9a-z]((\.(?!\.))|[-!#\$%&'\*\+/=\?\^`\{\}\|~\w])*)(?<=[0-9a-z])@))" +
            //@"(?(\[)(\[(\d{1,3}\.){3}\d{1,3}\])|(([0-9a-z][-\w]*[0-9a-z]*\.)+[a-z0-9]{2,17}))$";
            //TODO: chek Email through pattern or contain
            //String checkPassword = @"(?=^.{8,132}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$";
            //TODO: logic of password managing


            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Description & contacts</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(
                    "T e a m&nbsp;&nbsp;o b j e c t i v e s :"+
                    "P e r f o r m&nbsp;&nbsp;l a r g e - s c a l e&nbsp;&nbsp;r e s e a r c h&nbsp;&nbsp;a n d&nbsp;&nbsp;  c e r t i f y&nbsp;&nbsp;i t"+
                    "v s ."+
                    "I n t r o d u c e&nbsp;&nbsp;o u r&nbsp;&nbsp;p r o d u c t&nbsp;&nbsp;a s&nbsp;&nbsp;a&nbsp;&nbsp;m e d i c a l&nbsp;&nbsp;r e m e d y  ");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

log.info("get method sss servlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post method sss servlet");

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();

        String login = null;
        Principal usernamePrincipal = req.getUserPrincipal();
        if (usernamePrincipal != null)
            login = usernamePrincipal.getName();

        printWriter.println(login);
    }
}
