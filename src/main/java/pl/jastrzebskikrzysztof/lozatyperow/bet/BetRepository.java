package pl.jastrzebskikrzysztof.lozatyperow.bet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BetRepository extends CrudRepository<Bet, Long> {
	public List<Bet> findAllByUserId(Long id);
	public List<Bet> findAllByGameId(Long id);
}
