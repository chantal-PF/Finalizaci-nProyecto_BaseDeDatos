package Deber_BaseDatosPck;

public class Main {

	public static void main(String[] args) {
		Estudiantes objEstudiante = new Estudiantes("955453987","Carla Xiomara", "Perez Fernandez", "18", "Desarrollo de software", "4to semestre");
		BaseDatos  objBaseDatos = new BaseDatos();
		
		
		objBaseDatos.getEstudiante("955453987").Imprimir();
		
		
	}

}

