package org.techtestbackend.notas.model;

import java.util.List;

public class Response {

	private Integer codRespuesta;
	private String mensajeRespuesta;
	private List<?> data;
	
	public Response() {
		super();
	}
	
	public Response(Integer codRespuesta, String mensajeRespuesta, List<?> data) {
		super();
		this.codRespuesta = codRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
		this.data = data;
	}
	
	public Integer getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(Integer codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
	
}
