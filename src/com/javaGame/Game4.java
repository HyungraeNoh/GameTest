package com.javaGame;

import java.util.Scanner;

public class Game4 {
	Scanner scan = new Scanner(System.in);

	int map[][] = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,2,0,0,1,1,0,1,0},
			{0,1,1,2,0,1,0,1,1,0},
			{0,1,1,0,2,1,1,0,1,0},
			{0,1,1,0,1,2,0,1,1,0},
			{0,1,0,1,1,0,2,1,1,0},
			{0,1,0,1,0,0,1,2,1,0},
			{0,1,1,1,1,1,1,0,1,0},
			{0,0,0,0,0,0,0,0,0,0}
	};

	public boolean map(int ax, int ay, int bx, int by) {
		boolean str = false;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {

				if (map[ay][ax] == 0) {
					ax = bx;
					ay = by;
					str = true;
				}

				if (i == ay && j == ax && map[i][j] == 2) {
					map[i][j] = 1;

				}

				if (i == ay && j == ax) {
					System.out.print("㉾\t");
				} else if (map[i][j] == 0) {
					System.out.print("■\t");
				} else if (map[i][j] == 2) {
					System.out.print("♥\t");
				} else {
					System.out.print("□\t");
				}

			}
			System.out.println();
		}

		return str;
	}

	public void move() {
		int ax = 1;
		int ay = 1;
		int bx = 1;
		int by = 1;
		map(ax, ay, bx, by);

		while (true) {
			String input = scan.next();
			System.out.println(input.toUpperCase());
			switch (input.toUpperCase()) {
			case "W":
				ay--;
				break;
			case "S":
				ay++;
				break;
			case "A":
				ax--;
				break;
			case "D":
				ax++;
				break;
			default:
				break;
			}

			System.out.println(ax + " , " + ay + " , " + bx + " , " + by);

			if (map(ax, ay, bx, by)) {
				ax = bx;
				ay = by;
			} else {
				bx = ax;
				by = ay;
			}
		}

	}
}
