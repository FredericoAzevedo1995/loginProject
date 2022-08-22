package login.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.BadAttributeValueExpException;

public class User extends Entity_ {

	private String username;
	private String password;
	private int age;

	public User() {
	};

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) throws BadAttributeValueExpException {
		if (username.contains(" ")) {
			throw new BadAttributeValueExpException(username);
		}
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	
	//indexof e distigue
	public void setPassword(String password) throws BadAttributeValueExpException {
		List<Character> letras = new ArrayList<Character>();
		List<Character> numeros = new ArrayList<Character>();

		for (int i = 0; i < password.length(); i++) {

			if (!letras.contains(password.charAt(i))) {
				letras.add(password.charAt(i));
			} else {
				throw new BadAttributeValueExpException(password);
			}
			
		}

		numeros = letras.stream().filter(it -> Character.isDigit(it)).collect(Collectors.toList());
		
		

		if (numeros.size() <= 1) {
			this.password = password;
		}
		else {
			throw new BadAttributeValueExpException(password);

		}
		
		/*
		 *System.out.println(Stream.of(input)
           .map(w -> w.split(""))
           .flatMap(Arrays::stream)
           .distinct()
           .collect(Collectors.toList()));
		 */
		

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + "]";
	}

}
