import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
  private static final String RUTA_ARCHIVO = "usuarios.txt";


    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String apellido = partes[2];
                String email = partes[3];
                usuarios.add(new Usuario(id, nombre, apellido, email));
            }
        } catch (IOException e) {
        }

        return usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
            bw.write(usuario.getId() + "," + usuario.getNombre() + "," + usuario.getApellido() + "," + usuario.getEmail());
            bw.newLine();
        } catch (IOException e) {
        }
    }

    // Implementa métodos para actualizar y eliminar usuarios según tus necesidades
}
