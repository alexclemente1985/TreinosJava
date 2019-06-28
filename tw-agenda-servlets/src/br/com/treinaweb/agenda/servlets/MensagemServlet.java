package br.com.treinaweb.agenda.servlets;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MensagemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2729038205237024561L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * PrintWriter out = resp.getWriter(); out.println("<html>");
		 * out.println("	<head>"); out.println("	<title>Nome do usu�rio...</title>");
		 * out.println("	</head>"); out.println("	<body>"); out.
		 * println("		<form action=\"/tw-agenda-servlets/mensagem\" method=\"POST\">"
		 * ); out.println("			<p>Digite seu nome:</p>");
		 * out.println("			<p><input type=\"text\" name=\"nomeUsuario\"></p>");
		 * out.println("			<p><button type=\"submit\">Enviar!</button></p>");
		 * out.println("		</form>"); out.println("	</body>");
		 * out.println("</html>");
		 */
		
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/FormularioMensagem.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * String nomeUsuario = req.getParameter("nomeUsuario"); PrintWriter out =
		 * resp.getWriter(); out.println("<html>"); out.println("	<head>");
		 * out.println("		<title>Nome do Usu�rio!</title>");
		 * out.println("	</head>"); out.println("	<body>");
		 * out.println("		<p>Ol�, "+ nomeUsuario +"!</p>");
		 * out.println("	</body>"); out.println("</html>");
		 */
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/ResultadoMensagem.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
