package pl.jastrzebskikrzysztof.lozatyperow.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> findAllByUsername(String username);
	public User findOneById(Long id);
	
}
