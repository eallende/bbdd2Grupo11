package muber.entities;

import java.util.Date;
import java.util.List;

public class Conductor extends Usuario {

	private Date fechaVencimientoLicencia;
	private List<Viaje> viajesRealizadosConductor;
	
	public Date getFechaVencimientoLicencia() {
		return fechaVencimientoLicencia;
	}
	public void setFechaVencimientoLicencia(Date fechaVencimientoLicencia) {
		this.fechaVencimientoLicencia = fechaVencimientoLicencia;
	}
	public List<Viaje> getViajesRealizadosConductor() {
		return viajesRealizadosConductor;
	}
	public void setViajesRealizadosConductor(List<Viaje> viajesRealizados) {
		this.viajesRealizadosConductor = viajesRealizados;
	}
	
	
}
