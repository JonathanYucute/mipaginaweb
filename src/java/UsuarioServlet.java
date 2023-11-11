

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {    private static final long serialVersionUID = 1L;
    private final UsuarioDAO UsuarioDAO = new UsuarioDAO();

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> usuarios = UsuarioDAO.obtenerUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
    int id = 0;

        Usuario nuevoUsuario = new Usuario(id, nombre, apellido, email);
        UsuarioDAO.agregarUsuario(nuevoUsuario);

        response.sendRedirect(request.getContextPath() + "/UsuarioServlet");
    }
}

