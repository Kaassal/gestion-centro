package gestioncentro.model;

import java.sql.*;

/**
 * Consultas mejoradas
 * TODO: Integrar estas consultas en la parte model del MVC
 * @author diego
 */

public class Api {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/centro";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			// Consulta para obtener información de un alumno por nombre
			obtenerInformacionAlumno(stmt, "Joel");

			// Consulta para obtener información de una asignatura por nombre
			obtenerInformacionAsignatura(stmt, "Acceso a datos");

			// Consulta para obtener información de un centro por nombre
			obtenerInformacionCentro(stmt, "Campus Politecnico Aceimar");

			// Consulta para obtener información de un ciclo por nombre
			obtenerInformacionCiclo(stmt, "Desarrollo de aplicaciones mutiplataforma DAM");

			// Consulta para obtener información de un docente por nombre
			obtenerInformacionDocente(stmt, "Carlos");

			// Cerrar los recursos
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// Método para obtener información de un alumno por nombre
	private static void obtenerInformacionAlumno(Statement stmt, String nombreAlumno) throws SQLException {
		String query = "SELECT ID_Alumnos, Nombre_Alumnos, Apellido_Alumnos, DNI_Alumnos, Telefono_Alumnos, "
				+ "centro.Nombre_Centro, ciclos.Nombre_Ciclo " + "FROM alumnos "
				+ "JOIN centro ON alumnos.ID_Centro = centro.ID_Centro "
				+ "JOIN ciclos ON alumnos.ID_Ciclo = ciclos.ID_Ciclos " + "WHERE Nombre_Alumnos = '" + nombreAlumno
				+ "'";

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			System.out.println("ID_Alumnos: " + rs.getInt("ID_Alumnos"));
			System.out.println("Nombre_Alumnos: " + rs.getString("Nombre_Alumnos"));
			System.out.println("Apellido_Alumnos: " + rs.getString("Apellido_Alumnos"));
			System.out.println("DNI_Alumnos: " + rs.getString("DNI_Alumnos"));
			System.out.println("Telefono_Alumnos: " + rs.getInt("Telefono_Alumnos"));
			System.out.println("Centro: " + rs.getString("Nombre_Centro"));
			System.out.println("Ciclo: " + rs.getString("Nombre_Ciclo"));
		}

		rs.close();
	}

	// Método para obtener información de una asignatura por nombre
	private static void obtenerInformacionAsignatura(Statement stmt, String nombreAsignatura) throws SQLException {
		String query = "SELECT ID_Asginaturas, Nombre_Asignaturas, Descripcion_Asignaturas, "
				+ "ciclos.Nombre_Ciclo, docentes.Nombre_Docentes " + "FROM asignaturas "
				+ "JOIN ciclos ON asignaturas.ID_Ciclo = ciclos.ID_Ciclos "
				+ "JOIN docentes ON asignaturas.ID_Docente = docentes.ID_Docentes " + "WHERE Nombre_Asignaturas = '"
				+ nombreAsignatura + "'";

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			System.out.println("ID_Asginaturas: " + rs.getInt("ID_Asginaturas"));
			System.out.println("Nombre_Asignaturas: " + rs.getString("Nombre_Asignaturas"));
			System.out.println("Descripcion_Asignaturas: " + rs.getString("Descripcion_Asignaturas"));
			System.out.println("Ciclo: " + rs.getString("Nombre_Ciclo"));
			System.out.println("Docente: " + rs.getString("Nombre_Docentes"));
		}

		rs.close();
	}

	// Método para obtener información de un centro por nombre
	private static void obtenerInformacionCentro(Statement stmt, String nombreCentro) throws SQLException {
		String query = "SELECT centro.ID_Centro, centro.Nombre_Centro, centro.Telefono_Centro, centro.Direccion_Centro, ciclos.Nombre_Ciclo "
				+ "FROM centro " + "JOIN ciclos ON centro.ID_Ciclo = ciclos.ID_Ciclos "
				+ "WHERE centro.Nombre_Centro = '" + nombreCentro + "'";

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			System.out.println("ID_Centro: " + rs.getInt("ID_Centro"));
			System.out.println("Nombre_Centro: " + rs.getString("Nombre_Centro"));
			System.out.println("Telefono_Centro: " + rs.getInt("Telefono_Centro"));
			System.out.println("Direccion_Centro: " + rs.getString("Direccion_Centro"));
			System.out.println("Ciclo: " + rs.getString("Nombre_Ciclo"));
		}

		rs.close();
	}

	// Método para obtener información de un ciclo por nombre
	private static void obtenerInformacionCiclo(Statement stmt, String nombreCiclo) throws SQLException {
		String query = "SELECT ID_Ciclos, Nombre_Ciclo, NumeroHoras_Ciclo, Descripcion_Ciclo, centro.Nombre_Centro "
				+ "FROM ciclos " + "JOIN centro ON ciclos.ID_Centro = centro.ID_Centro " + "WHERE Nombre_Ciclo = '"
				+ nombreCiclo + "'";

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			System.out.println("ID_Ciclos: " + rs.getInt("ID_Ciclos"));
			System.out.println("Nombre_Ciclo: " + rs.getString("Nombre_Ciclo"));
			System.out.println("NumeroHoras_Ciclo: " + rs.getInt("NumeroHoras_Ciclo"));
			System.out.println("Descripcion_Ciclo: " + rs.getString("Descripcion_Ciclo"));
			System.out.println("Centro: " + rs.getString("Nombre_Centro"));
		}

		rs.close();
	}

	// Método para obtener información de un docente por nombre
	private static void obtenerInformacionDocente(Statement stmt, String nombreDocente) throws SQLException {
		String query = "SELECT ID_Docentes, Nombre_Docentes, Apellido_Docentes, DNI_Docentes, Telefono_Docentes, "
				+ "centro.Nombre_Centro, ciclos.Nombre_Ciclo " + "FROM docentes "
				+ "JOIN centro ON docentes.ID_Centro = centro.ID_Centro "
				+ "JOIN ciclos ON docentes.ID_Ciclo = ciclos.ID_Ciclos " + "WHERE Nombre_Docentes = '" + nombreDocente
				+ "'";

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			System.out.println("ID_Docentes: " + rs.getInt("ID_Docentes"));
			System.out.println("Nombre_Docentes: " + rs.getString("Nombre_Docentes"));
			System.out.println("Apellido_Docentes: " + rs.getString("Apellido_Docentes"));
			System.out.println("DNI_Docentes: " + rs.getString("DNI_Docentes"));
			System.out.println("Telefono_Docentes: " + rs.getInt("Telefono_Docentes"));
			System.out.println("Centro: " + rs.getString("Nombre_Centro"));
			System.out.println("Ciclo: " + rs.getString("Nombre_Ciclo"));
		}

		rs.close();
	}
}
