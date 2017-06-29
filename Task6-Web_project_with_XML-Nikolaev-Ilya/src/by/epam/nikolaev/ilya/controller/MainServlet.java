package by.epam.nikolaev.ilya.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.nikolaev.ilya.command.Command;
import by.epam.nikolaev.ilya.command.CommandHelper;
import by.epam.nikolaev.ilya.command.CommandNotFoundException;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am here");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		provessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		provessRequest(request, response);
	}
	private void provessRequest(HttpServletRequest request, HttpServletResponse response) {
		CommandHelper commandHelper = CommandHelper.getInstance();
		Command command = null;
		String page = null;
		String commandName = request.getParameter("command");
		try{
			command = commandHelper.getCommand(commandName);
			page = command.execute(request, response);
		}catch (CommandNotFoundException e) {
			page = "error.jsp";
		}
		try {
			System.out.println(page);
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
