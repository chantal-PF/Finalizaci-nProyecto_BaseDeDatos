package Deber_BaseDatosPck;

public class Main {

	public static void main(String[] args) {
		Estudiantes objEstudiante = new Estudiantes("0955253679","Chantal Xiomara", "Peñafiel Fernandez", 19, "Desarrollo de software", "2do semestre");
		BaseDatos  objBaseDatos = new BaseDatos();
		
		
		objBaseDatos.getEstudiante("0955253679").Imprimir();
		
		
	}

}


