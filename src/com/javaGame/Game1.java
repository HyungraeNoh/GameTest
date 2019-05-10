package com.javaGame;

//종찬이형 게임
import java.util.Scanner;

public class Game1 {
	Scanner scan = new Scanner(System.in);
	String exit = "EXIT";

	public boolean map(int ai, int aj) {
		boolean result = false;
		int[][] map = { 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
				{ 1, 1, 0, 0, 0, 0, 0, 1, 1 }, 
				{ 1, 1, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1 }
		};
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {

				if (i == ai && j == aj) {
					System.out.print("㉿\t");
				} else if (map[i][j] == 0) {
					System.out.print("♡\t");
				} else {
					System.out.print("♥\t");
				}
			}
			System.out.println();
		}
		return result;

	}

	public void move() {
		int ai = 1;
		int aj = 7;
		map(ai, aj);

		while (true) {
			String input = scan.next();
			System.out.println(input.toUpperCase());
			switch (input.toUpperCase()) {
			case "W": // 위쪽
				ai--;
				break;
			case "S": // 아래쪽
				ai++;
				break;
			case "A": // 왼쪽
				aj--;
				break;
			case "D": // 오른쪽
				aj++;
				break;
			default:
				break;
			}
			System.out.println(ai + " , " + aj);
			map(ai, aj);
			
			if (ai == 4 && aj == 4 && input.toUpperCase().equals(exit)) {
				System.out.println("게임이 끝났습니다.");
				break;
			} 
		}
	}

}