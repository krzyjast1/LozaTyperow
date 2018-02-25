package pl.jastrzebskikrzysztof.lozatyperow.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/add")
	public @ResponseBody String addUser(@RequestParam String username) {
		userService.addUser(username);
		return "ADDED USING USERNAME PARAMETER";
	}
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return userService.getAllUSers();
	}
	
	@GetMapping("/byusername/{username}")
	public List<User> getUsersByUsername(@PathVariable String username) {
		return userService.getUsersByUsername(username);
	}
	
	@GetMapping("/byid/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public @ResponseBody String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "DELETED";
	}
	
	@DeleteMapping("/deleteallusers")
	public @ResponseBody String deleteAllUsers() {
		userService.deleteAllUsers();
		return "ALL USERS DELETED";
	}
	
	@PutMapping("/{username}")
	public @ResponseBody String updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return "UPDATED";
	}
}
