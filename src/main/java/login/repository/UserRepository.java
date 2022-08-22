package login.repository;

import java.util.Map;

import login.model.User;

public class UserRepository extends EntityRepository<User> {

	
	private static final UserRepository INSTANCE = new UserRepository();

	public UserRepository() {
	};

	public static UserRepository getInstance() {
		return INSTANCE;
	}

	public boolean existUsername(String username) {
		
		
		boolean aux = false;
		atum:
		for (Map.Entry<Long, User> entry : db.entrySet()) {
		    System.out.println(entry.getValue().getUsername());
		    System.out.println("***************************");
			System.out.println(username);
			System.out.println("***************************");

			if(entry.getValue().getUsername().equals(username)) {
				aux = true;
				break atum;
			}
		}
			
		return aux;
	
		
	}
public boolean existPasswordUsername(String username, String password) {
		
		
		boolean aux = false;
		atum:
		for (Map.Entry<Long, User> entry : db.entrySet()) {
			if(entry.getValue().getPassword().equals(password) && entry.getValue().getUsername().equals(username)) {
				aux = true;
				break atum;
			}
		}
			
		return aux;
	
		
	}
}
