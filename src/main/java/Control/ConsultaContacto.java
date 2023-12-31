package Control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ConsultaContacto
 */
public class ConsultaContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrintWriter out;
	private HttpSession sesion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaContacto() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Comprueba inicio de sesion previo
		sesion = request.getSession(false);
		if (sesion.getAttribute("usuario") == null) {
			//En caso que no haya iniciado sesion, muestra alerta y redirije a login
			out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Debes iniciar sesion primero');");
			out.println("location='Login'"); 
			out.println("</script>");
			out.close();
			
		} else {
			
			getServletContext().getRequestDispatcher("/contacto.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String NAME = request.getParameter("nombre");
        final String EMAIL = request.getParameter("email");
        final String MESSAGE = request.getParameter("mensaje");
        
        // Enviar a base de datos o a un correo electronico
        
        out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
		out.println("alert('Gracias por contactarnos');");
		out.println("location='Inicio'"); 
		out.println("</script>");
		out.close();

        // Redirige a página de confirmación
        //response.sendRedirect("Contacto.jsp");
	}

}
