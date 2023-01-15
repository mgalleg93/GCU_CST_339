package business;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService  {
	public boolean authenticate(String username, String password) {
		System.out.println("Hello from security business service");
		return true;
	}
}
