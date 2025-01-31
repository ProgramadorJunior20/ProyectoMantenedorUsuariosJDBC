package co.jmurillo.java.jdbc;

import co.jmurillo.java.jdbc.conexion.ConexionBaseDatos;
import co.jmurillo.java.jdbc.modelo.Usuario;
import co.jmurillo.java.jdbc.repositorio.Repositorio;
import co.jmurillo.java.jdbc.repositorio.UsuarioRepositorioImpl;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {
    public static void main(String[] args) {
        Repositorio<Usuario> repositorio = new UsuarioRepositorioImpl();
        int opcionIndice = 0;
        Map<String, Integer> operaciones = new HashMap<>();
        operaciones.put("Actualizar", 1);
        operaciones.put("Eliminar", 2);
        operaciones.put("Agregar", 3);
        operaciones.put("Listar", 4);
        operaciones.put("Salir", 5);

        do {
            Object[] opArreglo = operaciones.keySet().toArray();
            Object opcion = JOptionPane.showInputDialog(
                    null,
                    "Seleccione una operación",
                    "Mantenedor de Usuarios",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opArreglo,
                    opArreglo[0]
            );

            if (opcion == null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una operación");
                continue;
            }

            opcionIndice = operaciones.get(opcion.toString());

            switch (opcionIndice) {
                case 1: // Actualizar
                    actualizarUsuario(repositorio);
                    break;
                case 2: // Eliminar
                    eliminarUsuario(repositorio);
                    break;
                case 3: // Agregar
                    crearUsuario(repositorio);
                    break;
                case 4: // Listar
                    listarUsuarios(repositorio);
                    break;
                case 5: // Salir
                    try {
                        ConexionBaseDatos.cerrarConexion();
                        JOptionPane.showMessageDialog(null, "¡Hasta Luego!");

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion inválida");
            }
        } while (opcionIndice != 5);
    }

    private static void crearUsuario (Repositorio<Usuario> repositorio) {
        Usuario u = new Usuario();
        u.setUsername(JOptionPane.showInputDialog("Nuevo usuario:", u.getUsername()));
        u.setPassword(JOptionPane.showInputDialog("Nueva contraseña:", u.getPassword()));
        u.setEmail(JOptionPane.showInputDialog("Nuevo correo:", u.getEmail()));
        repositorio.crear(u);
        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
    }

    private static void actualizarUsuario (Repositorio<Usuario> repositorio) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del usuario a actualizar:"));
        Usuario u = repositorio.porId(id);
        if (u != null) {
            u.setUsername(JOptionPane.showInputDialog("Nuevo usuario", u.getUsername()));
            u.setPassword(JOptionPane.showInputDialog("Nueva contraseña:", u.getPassword()));
            u.setEmail(JOptionPane.showInputDialog("Nuevo correo:", u.getEmail()));
            repositorio.actualizar(u);
            JOptionPane.showMessageDialog(null, "Usuario actualizado");
        }else {
            JOptionPane.showMessageDialog(null, "Ususario no encontrado");
        }
    }

    private static void eliminarUsuario(Repositorio<Usuario> repositorio) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del usuario a eliminar:"));
        repositorio.eliminar(id);
        JOptionPane.showMessageDialog(null, "Usuario eliminado");
    }

    private static void listarUsuarios(Repositorio<Usuario> repositorio) {
        List<Usuario> usuarios = repositorio.listar();
        StringBuilder sb = new StringBuilder();
        for (Usuario u: usuarios) {
            sb.append(u).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
