package pl.jastrzebskikrzysztof.lozatyperow.bet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.jastrzebskikrzysztof.lozatyperow.game.Game;
import pl.jastrzebskikrzysztof.lozatyperow.user.User;

@Service
public class BetService {
	
	@Autowired
	private BetRepository betRepo;
	
	public Bet getOneBet(Long id) {
		return betRepo.findOne(id);
	}

	public List<Bet> getAllBets() {
		return (List<Bet>) betRepo.findAll();
	}

	public String addBet(Bet bet, Long userId, Long gameId) {
		bet.setUser(new User(userId));
		bet.setGame(new Game(gameId));
		try {
			betRepo.save(bet);
			return "SAVED";
		} catch(Exception e) {
			return e.toString();
		}
	}

	public String updateBet(Bet bet) {
		try {
			betRepo.save(bet);
			return "UPDATED";
		} catch(Exception e) {
			return e.toString();
		}
	}

	public String deleteBet(Long id) {
		try {
			betRepo.delete(id);
			return "DELETED";
		} catch(Exception e) {
			return e.toString();
		}
	}

	public List<Bet> getBetsByUserId(Long id) {
		return betRepo.findAllByUserId(id);
	}

	public List<Bet> getBetsByGameId(Long id) {
		return betRepo.findAllByGameId(id);
	}
	
}
