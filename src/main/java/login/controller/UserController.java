package login.controller;

import java.util.Collection;

import javax.management.BadAttributeValueExpException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import login.model.User;
import login.repository.UserRepository;
import login.services.UserService;

//caracteres repetidos e um numero
@Path("user")
public class UserController extends EntityController<User, UserService, UserRepository>{

	
	public UserController() {
		this.service = new UserService();
	}
	
	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String create(User e) {
		try{
			return service.create(e);
		}catch(BadAttributeValueExpException e1) {
			return "Erro na introdução dos campos";
		}
		
	}
	
	@Path("read/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User read(@PathParam("id") long id) {
		// TODO Auto-generated method stub
		if(service.getContainsKey(id)) {
			return service.read(id);
		}
		return null;
	}
	
	@Path("read")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> readAll() {
		// TODO Auto-generated method stub
		
		return service.getAll();
	}
	
	@Path("login")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String login(User u) {
		// TODO Auto-generated method stub
		return service.existUser(u.getUsername(), u.getPassword());
	}
	
	
	
	

	
}
