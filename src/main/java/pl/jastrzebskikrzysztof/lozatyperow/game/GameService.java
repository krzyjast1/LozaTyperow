package pl.jastrzebskikrzysztof.lozatyperow.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepo;

	public String addGame(Game game) {
		try {
			gameRepo.save(game);
		} catch(Exception e) {
			return e.toString();
		}
		return "SAVED";
	}

	public Game getGame(Long id) {
		return gameRepo.findOne(id);
	}

	public List<Game> getAllGames() {
		return (List<Game>) gameRepo.findAll();
	}
	
	public String deleteGame(Long id) {
		try {
			gameRepo.delete(id);
			return "DELETED";
		} catch(Exception e) {
			return e.toString();
		}
	}

	public String updateGame(Game game) {
		try {
			gameRepo.save(game);
			return "UPDATED";
		} catch (Exception e) {
			return e.toString();
		}
	}
	
}
