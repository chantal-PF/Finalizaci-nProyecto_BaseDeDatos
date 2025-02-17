package Deber_BaseDatosPck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {
	    private static final String URL = "jdbc:mysql://localhost:3306/";
	    private static final String USUARIO = "root";
	    private static final String CONTRASENA = "root";
	    private static final String BASE_DATOS = "istlc_poo";
	    
	    private Connection conexion;
	    
	    public BaseDatos() {
	        try {
	            conexion = DriverManager.getConnection(URL + BASE_DATOS, USUARIO, CONTRASENA);
	            System.out.println("Conexión exitosa.");
	        } catch (SQLException e) {
	            System.out.println("Error al conectar la base de datos.");
	        }
	    }
	    
	    public void InsertarEstudiante(Estudiantes objEstudiante) {
	        String sql = "INSERT INTO ESTUDIANTE(id, nombre, apellido, edad, carrera, semestre) "
	                + "VALUES('"+objEstudiante.id+"','"+objEstudiante.nombre+"', '"+objEstudiante.apellidos+"', '"+objEstudiante.edad+"', '"+objEstudiante.carrera+"', '"+objEstudiante.semestre+"');";
	        try {
	            PreparedStatement ps = conexion.prepareStatement(sql);
	            ps.execute();
	            ps.close();
	            System.out.println("Estudiante registrado exitosamente.");
	        } catch (SQLException e) {
	            System.out.println("Error al insertar en la base de datos.");
	        }
	    }
	    
	    public Estudiantes getEstudiante(String id) {
	        String sql = "SELECT * FROM estudiante WHERE id = ?";
	        Estudiantes objEstudiante = null;
	        try {
	            PreparedStatement ps = conexion.prepareStatement(sql);
	            ps.setString(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                objEstudiante = new Estudiantes(
	                    rs.getString("ID"),
	                    rs.getString("NOMBRE"),
	                    rs.getString("APELLIDO"),
	                    rs.getInt("EDAD"),
	                    rs.getString("CARRERA"),
	                    rs.getString("SEMESTRE")
	                );
	            } else {
	                System.out.println("No se encontró un estudiante con ID: " + id);
	            }
	            
	            rs.close(); 
	            ps.close(); 
	        } catch (SQLException e) {
	            System.out.println("Error al consultar en la base de datos: " + e.getMessage());
	        }

	        return objEstudiante;
	    }
	    
	}

