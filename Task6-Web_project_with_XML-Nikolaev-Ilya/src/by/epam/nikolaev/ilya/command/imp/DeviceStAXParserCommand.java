package by.epam.nikolaev.ilya.command.imp;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.nikolaev.ilya.bean.Device;
import by.epam.nikolaev.ilya.command.Command;
import by.epam.nikolaev.ilya.command.CommandNotFoundException;
import by.epam.nikolaev.ilya.service.ServiceFactory;
import by.epam.nikolaev.ilya.service.iml.DeviceStAXParserService;

public class DeviceStAXParserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		ArrayList<Device> devices = null;
		String page = null;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		DeviceStAXParserService staxParserService = serviceFactory.getDeviceStAXParserService();
		try{
			devices = staxParserService.getDevices();
			if(devices != null){
				HttpSession session = request.getSession();
				session.setAttribute("stax", devices);
				page = "showStAX.jsp";
			}else{
				page = "/error.jsp";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return page;
	}

}
