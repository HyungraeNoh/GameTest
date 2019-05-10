package com.javaGame;
//김현정님 게임
import java.util.Scanner;

public class Game3 {
	Scanner scan = new Scanner(System.in);
	public boolean map(int ax, int ay, int bx, int by) {
		boolean str = false;
		
		int map[][] = {
				{0,0,0,0,0,0,0},
				{1,1,1,1,1,1,0},
				{0,1,0,0,0,1,0},
				{0,1,0,1,1,0,0},
				{0,1,0,0,1,0,0},
				{0,1,1,1,1,1,1},
				{0,0,0,0,0,0,0}
		};
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j <map[i].length; j++) {
				
				if(map[ay][ax] == 0) {
					ax = bx;
					ay = by;
					str = true;
				}
				
				if(map[i][j] == 0) {
					System.out.print("■\t");
				}else if(i == ay && j == ax) {
					System.out.print("＠\t");
				}else {
					System.out.print("□\t");
				}
				
			}
			System.out.println();
		}
		
		return str;
	}
	
	public void move() {
		int ax = 0;
		int ay = 1;
		int bx = 0;
		int by = 1;
		int check = 0;
		map(ax,ay,bx,by);
		
		while(true) {
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
			System.out.println(check);
			if(ax == 5 && ay == 2) {
				check++;
			}else if(ax == 2 && ay == 5) {
				if(check <= 0) {
					ax = 1;
					ay = 5;
				}
			}else if(ax == 3 && ay == 3) {
				ax = 0;
				ay = 1;
			}
			
			
			if(map(ax,ay,bx,by)) {
				ax = bx;
				ay = by;
			}else {
				bx = ax;
				by = ay;
			}
			
			if(ax == 6 && ay == 5) {
				System.out.println("성공하였습니다.");
				break;
			}
		}
	}
}
