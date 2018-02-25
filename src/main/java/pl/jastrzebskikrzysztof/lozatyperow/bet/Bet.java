package pl.jastrzebskikrzysztof.lozatyperow.bet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import pl.jastrzebskikrzysztof.lozatyperow.game.Game;
import pl.jastrzebskikrzysztof.lozatyperow.user.User;

@Entity
public class Bet {
	@Id
	@GeneratedValue
	private Long id;
	private Integer score;

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Game game;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
}
