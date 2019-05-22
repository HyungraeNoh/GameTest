package com.javaGame;
//노형래님
import java.util.Random;
import java.util.Scanner;

public class Game6 {
	int map[][] = {
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,0,0,0,0,0,0,0,0,1},	
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},	
			{1,0,0,0,0,0,0,0,0,0,0,1},	
			{1,0,0,0,0,0,0,0,0,0,0,1},	
			{1,0,0,0,0,0,0,0,0,0,0,1},	
			{1,0,0,0,0,0,0,0,0,0,0,1},	
			{1,0,0,0,0,2,0,0,0,0,0,1},	
			{1,1,1,1,1,1,1,1,1,1,1,1}
	};
	
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	
	int x = 5; 	int y = 8;  	int bx = 5; 	int by = 8;
	
	public boolean map() {
		boolean str = true;	
		if(map[y][x] == 1) {
			x = bx;
			y = by;
			str = false;
		}
		
		for(int i = 0; i < map.length; i++) {
			
			for(int j = 0; j<map[i].length; j++) {
					map[0][j] = random.nextInt(2);
				
				
					if(map[i][j] == 1) {
						System.out.print("■\t");
					}
					else if(j == x && i == y) {
						System.out.print("㉾\t");
					}
					else if(map[i][j] == 0)  {
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

