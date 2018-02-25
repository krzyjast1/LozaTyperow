package pl.jastrzebskikrzysztof.lozatyperow.bet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bets")
public class BetController {
	
	@Autowired
	private BetService betService;
	
	@GetMapping("/getbet/{id}")
	public Bet getOneBet(@PathVariable Long id){
		return betService.getOneBet(id);
	}
	
	@GetMapping("/getbetsbyuserid/{id}")
	public List<Bet> getBetsByUserId(@PathVariable Long id){
		return betService.getBetsByUserId(id);
	}
	
	@GetMapping("/getbetsbygameid/{id}")
	public List<Bet> getBetsByGameId(@PathVariable Long id){
		return betService.getBetsByGameId(id);
	}
	
	@GetMapping("/getbet/all")
	public List<Bet> getAllBets(){
		return betService.getAllBets();
	}
	
	@PostMapping("/addbet")
	public String addBet(@RequestBody Bet bet, @RequestParam Long userId, @RequestParam Long gameId) {
		return betService.addBet(bet, userId, gameId);
	}
	
	@PutMapping("/updatebet")
	public String updateBet(Bet bet) {
		return betService.updateBet(bet);
	}
	
	@DeleteMapping("/deletebet/{id}")
	public String deleteBet(@PathVariable Long id) {
		return betService.deleteBet(id);
	}
}
