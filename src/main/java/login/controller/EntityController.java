package login.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import login.crud.CRUD;
import login.model.Entity_;
import login.repository.EntityRepository;
import login.services.EntityService;

public class EntityController<M extends Entity_, S extends EntityService<M, R> , R extends EntityRepository<M>> implements CRUD<M> {

	protected S service;

	
	
	@Override
	@DELETE
	@Path("delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean delete(@PathParam("id")long id) {
		// TODO Auto-generated method stub
		return service.delete(id);
		
	}

}
