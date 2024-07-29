package com.example.rps;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ScoreController {
	
	@GetMapping("health-check")
	public String getHealthCheck() {
		
		return "Situation Normal All Fired Up -- (SNAFU)";
	}
	
	Score score = new Score(30, 50, 100);
	
	
	@GetMapping(value = "score", produces = "application/json")
	public Score scores() {
		
		return score;
	}
	
	@PutMapping("score")
	public Score newSc(@RequestBody Score newScore) {
		
		score = newScore;
		return score;
	}
	
	@DeleteMapping("score")
	public void deleteScore() {
		
		score = null;
	}
	
	
	@PostMapping("/score/wins")
	public Score increaseWins() {
		
		score.wins++;
		return score;
		
	}
	
	@PostMapping("/score/losses")
	public Score increaseLosses() {
		
		score.losses++;
		return score;
		
	}
	
	@PostMapping("/score/ties")
	public Score increaseTies() {
		
		score.ties++;
		return score;
	}
	
	@PatchMapping("score/wins")
	public Score updateWins(@RequestParam(name = "new-value")int newValue) {
		
		score.wins = newValue;
		return score;
		
	}
	
	@PatchMapping("score/losses")
	public Score updateLosses(@RequestParam(name="losses-value")int lossesValue) {
		
		score.losses = lossesValue;
		return score;
	}
	
	
	@PatchMapping("score/ties")
	public Score updateTies(@RequestParam(name="ties-value")int tiesValue) {
		
		score.ties = tiesValue;
		return score;
	}
	
	
//	@GetMapping("score/wins")
//	public int getWins() {
//		
//		return score.getWins();
//	}
//	
//	@GetMapping("score/losses")
//	public int getLoss() {
//		
//		return score.getLosses();
//	}
//	
//	@GetMapping("score/ties")
//	public int getTies() {
//		
//		return score.getTies();
//	}
	
	
	@GetMapping("/score/{winslossesorties}")
	public int getWinsLossesOrTies(@PathVariable String winslossesorties) {
		
		if(winslossesorties.equalsIgnoreCase("wins")) {
			
			return score.getWins();
		}
		
		if(winslossesorties.equalsIgnoreCase("losses")) {
			
			return score.getLosses();
		}
		
			return score.getTies();
	}
	
	
}
