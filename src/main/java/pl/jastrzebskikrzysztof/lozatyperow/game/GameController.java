package pl.jastrzebskikrzysztof.lozatyperow.game;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@PostMapping("/addgame")
	public @ResponseBody String addMatch(@RequestBody Game game) {
		return gameService.addGame(game);
	}
	
	@GetMapping("/addtestgame")
	public @ResponseBody String addTestGame(){
		Game game = new Game();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String strdate = "17/02/2018 17:00";
		HashMap<String, Integer> map = new HashMap<>();
		map.put("MKS Perla Lublin", 46);
		map.put("KGHM Zaglebie Lubin", 22);
		game.setTeamsandresult(map);
		try {
			Date date = dateformat.parse(strdate);
			game.setDate(date);
			gameService.addGame(game);
			return "SAVED";
		} catch(Exception e) {
			return e.toString();
		}
	}
	
	@GetMapping("/getgame/{id}")
	public Game getMatch(@PathVariable Long id) {
		return gameService.getGame(id);
	}
	
	@GetMapping("/getgame/all")
	public List<Game> getAllGames(){
		return gameService.getAllGames();
	}
	
	@DeleteMapping("/deletegame/{id}")
	public @ResponseBody String deleteGame(@PathVariable Long id) {
		return gameService.deleteGame(id);
	}
	
	@PutMapping("/updategame")
	public @ResponseBody String updateGame(@RequestBody Game game) {
		return gameService.updateGame(game);
	}
}
