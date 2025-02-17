package Deber_BaseDatosPck;

public class Estudiantes {

		public String id;
		public String nombre;
		public String apellido;
		public String edad;
		public String carrera;
	    public String semestre;
	    
		public Estudiantes() {
			super();
		}
	    
	    public Estudiantes(String id, String nombre, String apellido, String edad, String carrera, String semestre) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.edad = edad;
			this.carrera = carrera;
			this.semestre = semestre;
		}

	
		public void Imprimir() {
			System.out.println("Id: "+ this.id);
			System.out.println("Nombre: "+ this.nombre);
			System.out.println("Apellidos: "+ this.apellido);
			System.out.println("Edad: "+ this.edad);
			System.out.println("Carrera: "+ this.carrera);
			System.out.println("Semestre: "+ this.semestre);
		}
		

}

