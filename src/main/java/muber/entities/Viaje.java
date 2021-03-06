package muber.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import muber.util.EstadoEnum;

public class Viaje {

	private Long idViaje;
	private String destino;
	private String origen;
	private double costoTotal;
	private Date fechaViaje;
	private int cantidadMaximaPasajeros;
	private Conductor conductorViaje;
	private List<Pasajero> pasajerosViaje;
	private String estado;
	
	public Viaje(){
		pasajerosViaje = new ArrayList<Pasajero>();
	}
	
	public Long getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	public double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	public Date getFechaViaje() {
		return fechaViaje;
	}
	public void setFechaViaje(Date fechaViaje) {
		this.fechaViaje = fechaViaje;
	}
	public int getCantidadMaximaPasajeros() {
		return cantidadMaximaPasajeros;
	}
	public void setCantidadMaximaPasajeros(int cantidadMaximaPasajeros) {
		this.cantidadMaximaPasajeros = cantidadMaximaPasajeros;
	}
	public Conductor getConductorViaje() {
		return conductorViaje;
	}
	public void setConductorViaje(Conductor conductorViaje) {
		this.conductorViaje = conductorViaje;
	}
	public List<Pasajero> getPasajerosViaje() {
		return pasajerosViaje;
	}
	public void setPasajerosViaje(List<Pasajero> pasajerosViaje) {
		this.pasajerosViaje = pasajerosViaje;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
