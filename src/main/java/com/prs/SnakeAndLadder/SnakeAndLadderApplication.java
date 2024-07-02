package com.prs.SnakeAndLadder;

import com.prs.SnakeAndLadder.model.Game;
import com.prs.SnakeAndLadder.model.Player;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SnakeAndLadderApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of board :: ");
		int n = scanner.nextInt();
		System.out.println("Enter number of dices :: ");
		int dice = scanner.nextInt();
		Game game = new Game(n, dice);
		System.out.println("Enter number of players :: ");
		int players = scanner.nextInt();
		for (int i = 0; i < players; i++) {
			game.addPlayers(new Player(String.valueOf(i+1)));
		}
		game.launchGame();
	}

}
