package com.tew.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet(name = "HolaMundo", urlPatterns = { "/HolaMundoCordial" })
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
				
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
		out.println("<BODY>");
		
		String nombre = (String) request.getParameter("NombreUsuario");
		
		@SuppressWarnings("unchecked")
		Vector<String> listado = (Vector<String>) request.getSession().getAttribute("listado");
		
		if (listado==null) {
			listado = new Vector<String>();
		}
		
		if (nombre != null) {
			out.println("<br>Hola " + nombre + "<br>");
			listado.addElement(nombre);
		}
		
		request.getSession().setAttribute("listado", listado);

		out.println("Bienvenido a mi primera p�gina web!");
		out.println("<br>");
		out.println("Contigo, hoy me han visualizado:<br>");
		for (int i=0; i < listado.size(); i++) {
			out.println("<br>" + (String)listado.elementAt(i));
		}
		out.println("<center><a href=\"index.html\">volver</a></center>");
		out.println("</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
