package ar.edu.unlam.pb2.clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.pb2.exceptions.PersonaNoEncontradaException;
import ar.edu.unlam.pb2.exceptions.faltaPresupuestoException;
import ar.edu.unlam.pb2.exceptions.plantelExcedidoExeption;

public class Equipo {
	private String nombre;
	public List<Persona> plantel;
	private Double presupuestoMaximoEquipo;

	public Equipo(String nombre, Double presupuestoMaximoEquipo) {
		this.nombre = nombre;
		this.presupuestoMaximoEquipo = presupuestoMaximoEquipo;
		this.plantel = new ArrayList<Persona>();
	
	}

	// No se puede agregar mas de 23 jugadores
	// No puede agregar mas jugadores del presupuesto del equipo
	public Boolean agregarPersona(Persona Persona) throws plantelExcedidoExeption, faltaPresupuestoException {
		Double costoPlantel = 0.0;
		for (Persona it : plantel) {
			costoPlantel += it.getCosto();
			if (plantel.size() > 23 ) {
				throw new plantelExcedidoExeption();
			}else if(costoPlantel > getPresupuestoMaximoEquipo()) {
				throw new faltaPresupuestoException();
			}	
		}
		this.plantel.add(Persona);

		return true;
	}

	public Double calcularPresupuestoDisponible() {
		Double costoPlantel = 0.0;
		Double presupuestoDisponible = 0.0;
		
		for (Persona persona : plantel) {
			costoPlantel += persona.getCosto();
		}
		
		presupuestoDisponible = getPresupuestoMaximoEquipo() - costoPlantel;
		
		return presupuestoDisponible;

	}

	public Persona buscarPersona(Integer numeroDeCamiseta) throws PersonaNoEncontradaException {

		for (Persona persona : plantel) {
			if(persona.getNumeroCamiseta().equals(numeroDeCamiseta)) {
				return persona;
			}
		}
		throw new PersonaNoEncontradaException();
	}

	public void eliminarPersona(Persona persona) throws PersonaNoEncontradaException {
		if(plantel.contains(persona)) {
			plantel.remove(persona);
		}
		
	//	throw new PersonaNoEncontradaException();
	}

	public Set<Persona> obtenerPlantelPorNumeroDeCamiseta() {

		Set<Persona> plantelOrdenado = new TreeSet<Persona>(new OrdenEmpleados());
		plantelOrdenado.addAll(this.plantel);
		return plantelOrdenado;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getPlantel() {
		return plantel;
	}

	public void setPlantel(List<Persona> plantel) {
		this.plantel = plantel;
	}

	public Double getPresupuestoMaximoEquipo() {
		return presupuestoMaximoEquipo;
	}

	public void setPresupuestoMaximoEquipo(Double presupuestoMaximoEquipo) {
		this.presupuestoMaximoEquipo = presupuestoMaximoEquipo;
	}

	public Integer obtenerCantidadDeJugadoresEnElPlantel() {
		return this.plantel.size();
	}

	

}
