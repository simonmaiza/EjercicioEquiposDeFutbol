package ar.edu.unlam.pb2.clases;

//Es Un Jugador
public class Arquero extends Persona {
	
	private Integer cantidadDePenalesAtajados;
	
	public Arquero(String nombre, Integer numeroCamiseta, Double costo, Integer cantidadDePenalesAtajados) {
		super(nombre, numeroCamiseta, costo);
		this.cantidadDePenalesAtajados = cantidadDePenalesAtajados;
	}

	@Override
	public Double calcularPuntaje() {
	Double puntaje = (double) (cantidadDePenalesAtajados * 10);
		return puntaje;
	}


	

	//Los puntos de los arqueros se es 10* la cantidad de penales atajados
	
}
