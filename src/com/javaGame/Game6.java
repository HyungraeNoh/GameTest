package com.javaGame;

import java.util.Scanner;

public class Game6 {
	int map[][] = {
			{1,0,0,0,0,0,0,0,0,0,1,},
			{1,0,0,0,0,0,0,0,0,0,1,},	
			{1,0,0,0,0,0,0,0,0,0,1,},
			{1,0,0,0,0,0,0,0,0,0,1,},	
			{1,0,0,0,0,0,0,0,0,0,1,},	
			{1,0,0,0,0,0,0,0,0,0,1,},	
			{1,0,0,0,0,0,0,0,0,0,1,},	
			{1,0,0,0,0,0,0,0,0,0,1,},	
			{1,0,0,0,0,2,0,0,0,0,1,},	
			{1,1,1,1,1,1,1,1,1,1,1}
	};
	
	int x = 5; 	int y = 8;  	int bx = 5; 	int by = 8;
	
	Scanner scan = new Scanner(System.in);
	
	public boolean map() {
		boolean str = true;	
		if(map[y][x] == 1) {
			x = bx;
			y = by;
			str = false;
		}

		for(int j = 0; j < map.length; j++) {
			for(int i = 0; i<map[j].length; i++) {
				
				if(map[j][i] == 1) {
					System.out.print("■\t");
				}
				else if(i == x && j == y) {
					System.out.print("㉾\t");
				}
				else {
					System.out.print("□\t");
				}
			}
			System.out.println();
		}
		
		return str;
	}
	
	public void move() {
		
		map();
		
		while(true) {
			String input = scan.next();
			System.out.println(input.toUpperCase());
			switch(input.toUpperCase()) {
			case "A":
				x--;
				break;
			case "S":
				x = x;
				break;
			case "D":
				x++;
				break;
			default:
				break;
			}
			System.out.println(x+" , "+y+" , "+bx+" , "+by);
			
			if(map()){
				bx = x;
				by = y;
			}	
		}
	}
}

