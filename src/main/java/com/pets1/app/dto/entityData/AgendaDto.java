package com.pets1.app.dto.entityData;

public class AgendaDto {
	
	private Long codigoA;
	
	private String fecha;
	
	private String horaInicio;
	
	private String horaSalida;
	
	private String notas;
	
	private int estado;

	public Long getCodigoA() {
		return codigoA;
	}

	public void setCodigoA(Long codigoA) {
		this.codigoA = codigoA;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}