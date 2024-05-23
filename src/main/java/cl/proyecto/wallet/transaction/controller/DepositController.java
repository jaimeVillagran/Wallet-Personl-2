package cl.proyecto.wallet.transaction.controller;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;

@WebServlet("/bienvenida")
public class DepositController extends HttpServlet {


    private static final long serialVersionUID = 1L;
    
    public void init() {
    	
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/login.jsp");
        dispatcher.forward(req, resp);
	}
	
	

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
		
		super.doPost(req, resp);
	}

	public void destroy() {
    }
}