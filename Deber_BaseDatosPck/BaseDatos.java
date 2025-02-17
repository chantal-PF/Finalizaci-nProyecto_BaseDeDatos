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
            System.out.println("Error al conectar la bd.");
        }
    }

    public void InsertarEstudiante(Estudiantes objEstudiante) {
        String sql = "INSERT INTO estudiante (id, nombre, apellido, edad, carrera, semestre)"
        		+ "VALUES ('" + objEstudiante.id + "','" + objEstudiante.nombre + "','" + objEstudiante.apellido + "','" 
                   + objEstudiante.edad + "','" + objEstudiante.carrera + "','" + objEstudiante.semestre +"');";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.execute();
            ps.close();
            System.out.println("Ingreso exitoso.");
        } catch (SQLException e) {
            System.out.println("Error al insertar en la bd.");
        }
    }

    public Estudiantes getEstudiante(String id) {
        String sql = "SELECT * FROM Estudiante WHERE id ='" + id + "';";
        Estudiantes objEstudiante = new Estudiantes();
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objEstudiante = new Estudiantes(rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"), 
                                              rs.getString("edad"), rs.getString("carrera"), rs.getString("semestre"));
            }
            ps.close();
            System.out.println("Consulta exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al consultar en la bd.");
            
        }
        return objEstudiante;
    }
}
