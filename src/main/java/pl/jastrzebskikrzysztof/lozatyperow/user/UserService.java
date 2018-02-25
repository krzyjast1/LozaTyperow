package pl.jastrzebskikrzysztof.lozatyperow.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void addUser(String username) {
		User user =  new User();
		
		user.setUsername(username);
		
		userRepository.save(user);
	}

	public List<User> getAllUSers() {
		return (List<User>) userRepository.findAll();
	}

	public List<User> getUsersByUsername(String username) {
		return userRepository.findAllByUsername(username);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public User getUserById(Long id) {
		return userRepository.findOneById(id);
	}

	public void deleteUser(Long id) {
		userRepository.delete(id);
	}
	
	public void deleteAllUsers() {
		userRepository.delete(userRepository.findAll());
	}
	
}
