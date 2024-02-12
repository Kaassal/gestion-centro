package api;

import java.sql.*;
import java.util.Scanner;

public class Api {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/centro";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            // Establecer la conexión a la base de datos
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Solicitar el nombre del centro
            System.out.print("Ingrese el nombre del centro: ");
            Scanner scanner = new Scanner(System.in);
            String nombreCentro = scanner.nextLine();

            // Consultar la información del centro
            String query = "SELECT * FROM centro WHERE nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombreCentro);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Recuperar los campos del centro
                int idCentro = resultSet.getInt("ID");
                String nombre = resultSet.getString("nombre");
                // Recuperar más campos según sea necesario

                // Consultar y sumar el número de ciclos
                int numeroCiclos = obtenerNumeroRegistros(connection, "ciclos");

                // Consultar y sumar el número de docentes
                int numeroDocentes = obtenerNumeroRegistros(connection, "docentes");

                // Consultar y sumar el número de alumnos
                int numeroAlumnos = obtenerNumeroRegistros(connection, "alumnos");

                // Imprimir los resultados
                System.out.println("Información del centro:");
                System.out.println("ID: " + idCentro);
                System.out.println("Nombre: " + nombre);
                // Imprimir más campos según sea necesario
                System.out.println("Número de ciclos: " + numeroCiclos);
                System.out.println("Número de docentes: " + numeroDocentes);
                System.out.println("Número de alumnos: " + numeroAlumnos);
            } else {
                System.out.println("Centro no encontrado.");
            }

            // Cerrar recursos
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int obtenerNumeroRegistros(Connection connection, String tabla) throws SQLException {
        String query = "SELECT COUNT(*) FROM " + tabla;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }

        resultSet.close();
        preparedStatement.close();

        return count;
    }
}
