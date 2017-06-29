package by.epam.nikolaev.ilya.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException ;
}
