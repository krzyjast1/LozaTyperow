package pl.jastrzebskikrzysztof.lozatyperow.game;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Game {
	
	@Id
	@GeneratedValue
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone="CET")
	private Date date;
	private HashMap<String, Integer> teamsandresult;
	
	public Game() {
		
	}
	
	public Game(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public HashMap<String, Integer> getTeamsandresult() {
		return teamsandresult;
	}
	public void setTeamsandresult(HashMap<String, Integer> teamsandresult) {
		this.teamsandresult = teamsandresult;
	}
}
