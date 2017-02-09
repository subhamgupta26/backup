package com.tienda.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider		//component classes
public class TiendaExceptionMapper implements ExceptionMapper<TiendaException> {

	@Override
	public Response toResponse(TiendaException ex) {
		
		return Response.status(Response.Status.BAD_REQUEST).entity(ex.getExceptionMessage()).build();
	}

}
