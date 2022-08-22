package login.services;

import javax.management.BadAttributeValueExpException;

import login.model.User;
import login.repository.UserRepository;

public class UserService extends EntityService<User, UserRepository> {

	public UserService() {
		repository = UserRepository.getInstance();
	}

	public String create(User e) throws BadAttributeValueExpException {
		// TODO Auto-generated method stub
		if (repository.existUsername(e.getUsername())) {
			return "Já existe um utilizador com este username";
		}
		repository.addEntity(e);

		return "Bem vindo " + e.getUsername() + ",utilizador criado com sucesso ";

	}

	public String existUser(String username, String password) {
		// TODO Auto-generated method stub
		if (repository.existPasswordUsername(username, password)) {
			return "Login feito com sucesso";
		}
		return "Login sem sucesso";
	}

}
