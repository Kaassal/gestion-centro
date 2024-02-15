package api;

import java.sql.*;
import java.util.Scanner;

public class Api {

    // Configura tus credenciales y detalles de la base de datos aquí
    static final String URL = "jdbc:mysql://localhost:3306/centro";
    static final String USUARIO = "root";
    static final String CONTRASEÑA = "";

    public static void main(String[] args) {
        // Solicitar el nombre del centro por pantalla
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del centro: ");
        String nombreCentro = scanner.nextLine();

        obtenerInfoAlumnos(nombreCentro);
        obtenerInfoAsignaturas(nombreCentro);
        obtenerInfoCiclos(nombreCentro);
        obtenerInfoCentros(nombreCentro);
        obtenerInfoDocentes(nombreCentro);
    }

    static void obtenerInfoAlumnos(String nombreCentro) {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            String consulta = "SELECT ID_Alumnos, Nombre_Alumnos, Apellido_Alumnos, Telefono_Alumnos, DNI_Alumnos, centro.Nombre_Centro, ciclos.Nombre_Ciclo FROM alumnos " +
                    "JOIN centro ON alumnos.ID_Centro = centro.ID_Centro " +
                    "JOIN ciclos ON alumnos.ID_Ciclo = ciclos.ID_Ciclos " +
                    "WHERE centro.Nombre_Centro = ?";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setString(1, nombreCentro);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("ID_Alumnos") +
                            ", Nombre: " + resultSet.getString("Nombre_Alumnos") +
                            ", Apellidos: " + resultSet.getString("Apellido_Alumnos") +
                            ", Teléfono: " + resultSet.getInt("Telefono_Alumnos") +
                            ", DNI: " + resultSet.getString("DNI_Alumnos") +
                            ", Centro: " + resultSet.getString("Nombre_Centro") +
                            ", Ciclo: " + resultSet.getString("Nombre_Ciclo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void obtenerInfoAsignaturas(String nombreCentro) {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            String consulta = "SELECT asignaturas.ID_Asginaturas, asignaturas.Nombre_Asignaturas, asignaturas.NumeroHoras_Asignaturas, " +
                    "asignaturas.Descripcion_Asignaturas, ciclos.Nombre_Ciclo, docentes.Nombre_Docentes " +
                    "FROM asignaturas " +
                    "JOIN ciclos ON asignaturas.ID_Ciclo = ciclos.ID_Ciclos " +
                    "JOIN docentes ON asignaturas.ID_Docente = docentes.ID_Docentes " +
                    "WHERE ciclos.Nombre_Ciclo = ?";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setString(1, nombreCentro);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("ID_Asginaturas") +
                            ", Nombre: " + resultSet.getString("Nombre_Asignaturas") +
                            ", Horas: " + resultSet.getInt("NumeroHoras_Asignaturas") +
                            ", Descripción: " + resultSet.getString("Descripcion_Asignaturas") +
                            ", Ciclo: " + resultSet.getString("Nombre_Ciclo") +
                            ", Docente: " + resultSet.getString("Nombre_Docentes"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void obtenerInfoCiclos(String nombreCentro) {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            String consulta = "SELECT ciclos.ID_Ciclos, ciclos.Nombre_Ciclo, ciclos.NumeroHoras_Ciclo, ciclos.Descripcion_Ciclo, centro.Nombre_Centro " +
                    "FROM ciclos " +
                    "JOIN centro ON ciclos.ID_Centro = centro.ID_Centro " +
                    "WHERE centro.Nombre_Centro = ?";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setString(1, nombreCentro);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("ID_Ciclos") +
                            ", Nombre: " + resultSet.getString("Nombre_Ciclo") +
                            ", Horas: " + resultSet.getInt("NumeroHoras_Ciclo") +
                            ", Descripción: " + resultSet.getString("Descripcion_Ciclo") +
                            ", Centro: " + resultSet.getString("Nombre_Centro"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void obtenerInfoCentros(String nombreCentro) {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            String consulta = "SELECT ID_Centro, Nombre_Centro, Telefono_Centro, Descripcion_Centro " +
                    "FROM centro " +
                    "WHERE Nombre_Centro = ?";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setString(1, nombreCentro);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("ID_Centro") +
                            ", Nombre: " + resultSet.getString("Nombre_Centro") +
                            ", Teléfono: " + resultSet.getInt("Telefono_Centro") +
                            ", Descripción: " + resultSet.getString("Descripcion_Centro"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void obtenerInfoDocentes(String nombreCentro) {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            String consulta = "SELECT docentes.ID_Docentes, docentes.Nombre_Docentes, docentes.Apellido_Docentes, " +
                    "docentes.Telefono_Docentes, docentes.DNI_Docentes, centro.Nombre_Centro " +
                    "FROM docentes " +
                    "JOIN centro ON docentes.ID_Centro = centro.ID_Centro " +
                    "WHERE centro.Nombre_Centro = ?";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setString(1, nombreCentro);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("ID_Docentes") +
                            ", Nombre: " + resultSet.getString("Nombre_Docentes") +
                            ", Apellidos: " + resultSet.getString("Apellido_Docentes") +
                            ", Teléfono: " + resultSet.getInt("Telefono_Docentes") +
                            ", DNI: " + resultSet.getString("DNI_Docentes") +
                            ", Centro: " + resultSet.getString("Nombre_Centro"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
