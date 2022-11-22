package ar.edu.unlam.pb2.clases;

public class Jugador extends Persona {

	private Integer cantidadGoles;
	
	public Jugador(String nombre, Integer numeroCamiseta, Double costo, Integer cantidadDeGoles) {
		super(nombre, numeroCamiseta, costo);
		this.cantidadGoles = cantidadDeGoles;
	}

	

	public Integer getCantidadGoles() {
		return cantidadGoles;
	}



	public void setCantidadGoles(Integer cantidadGoles) {
		this.cantidadGoles = cantidadGoles;
	}



	@Override
	public Double calcularPuntaje() {
		Double puntaje = (double) (cantidadGoles *5);
		return puntaje;
	}

	//Los puntos de los Jugadores es 5 * la cantidad de penales atajados

}
