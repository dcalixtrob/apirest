package org.techtestbackend.notas.commons;

import java.util.List;

import org.techtestbackend.notas.exception.NotFoundException;

public class CommonsUtils {

	public static void validarListaVacia(List<?> lista, String msg) {
		if (lista.isEmpty()) {
			throw new NotFoundException(msg);
		}
	}
}
