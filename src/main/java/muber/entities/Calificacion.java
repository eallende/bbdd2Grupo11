package muber.entities;

public class Calificacion {

	private Long idCalificacion;
	private String comentario;
	private int puntaje;
	private Pasajero calificacionPasajero;
	private Viaje calificacionViaje;
	public Long getIdCalificacion() {
		return idCalificacion;
	}
	public void setIdCalificacion(Long idCalificacion) {
		this.idCalificacion = idCalificacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public Pasajero getCalificacionPasajero() {
		return calificacionPasajero;
	}
	public void setCalificacionPasajero(Pasajero calificacionPasajero) {
		this.calificacionPasajero = calificacionPasajero;
	}
	public Viaje getCalificacionViaje() {
		return calificacionViaje;
	}
	public void setCalificacionViaje(Viaje calificacionViaje) {
		this.calificacionViaje = calificacionViaje;
	}
	
	
}
