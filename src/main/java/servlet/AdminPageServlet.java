package servlet;

import dto.UserDto;
import utils.SessionCookieManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class processes requests for "/adminPage"  url
 */
@WebServlet("/adminPage")
public class AdminPageServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public AdminPageServlet() {
            super();
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            HttpSession session= request.getSession();
            UserDto userDto=SessionCookieManager.getLoginedUser(session);

            request.setAttribute("userDto",userDto);
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JSPFILES.ADMIN_PAGE.getPath())
                    .forward(request, response);

        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);

        }
    }
