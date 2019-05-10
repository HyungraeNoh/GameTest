package com.javaGame;
//김민정님 게임
import java.util.Scanner;

public class Game2 {
	Scanner scan = new Scanner(System.in);

	public boolean map(int ai, int aj, int bi, int bj) {
		boolean str = false;

		int map[][] = {
				{0,0,0,0,0,0},
				{1,1,1,1,0,1},
				{1,0,0,1,0,1},
				{1,1,0,1,0,1},
				{0,1,1,1,1,1},
				{0,0,0,0,0,0}
				
		};

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {

				if (map[aj][ai] == 0) {
					ai = bi;
					aj = bj;
					str = true;
				}

				if (map[i][j] == 0) {
					System.out.print("■\t");
				} else if (i == aj && j == ai) {
					System.out.print("㈜\t");
				} else {
					System.out.print("□\t");
				}

			}
			System.out.println();
		}

		return str;
	}

	public void move() {
		int ai = 1;
		int aj = 1;
		int bi = 1;
		int bj = 1;
		map(ai, aj, bi, bj);

		while (true) {
			String input = scan.next();
			System.out.println(input.toUpperCase());
			switch (input.toUpperCase()) {
			case "W":
				aj--;
				break;
			case "S":
				aj++;
				break;
			case "A":
				ai--;
				break;
			case "D":
				ai++;
				break;

			default:
				break;
			}
			System.out.println(ai + " , " + aj + " , " + bi + " , " + bj);

			if (ai == 1 && aj == 3) {
				ai = 0;
				aj = 3;
			} else if (ai == 3 && aj == 1) {
				ai = 3;
				aj = 4;
			}

			if (map(ai, aj, bi, bj)) {
				ai = bi;
				aj = bj;
			} else {
				bi = ai;
				bj = aj;
			}

			if (ai == 5 && aj == 1) {
				System.out.println("종료 되었습니다.");
				break;
			}
		}

	}
}