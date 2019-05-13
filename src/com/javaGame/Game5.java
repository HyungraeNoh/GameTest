package com.javaGame;
//김수민님 게임
import java.util.Scanner;

public class Game5 {
	Scanner scan = new Scanner(System.in);
	
	int map[][] = {
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 0, 2, 0, 1, 2, 0, 1},
			{1, 0, 0, 0, 1, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 1, 1, 0, 0, 1},
			{1, 0, 2, 0, 0, 1, 1, 0, 0, 1},
			{1, 0, 2, 1, 0, 1, 1, 0, 0, 1},
			{1, 0, 0, 0, 2, 0, 0, 2, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			};
	
	int ax = 1;
	int ay = 1;
	int bx = 1;
	int by = 1;
	int count = -1;
	
	
	
	public boolean map(int ax, int ay, int bx, int by, int count) {
		boolean str = false;
		
		if(map[ay][ax] == 1) {
			ax = bx;
			ay = by;
			str = true;
		}
		if(map[ay][ax] == 2){
			System.out.println("박스를 만났을때 :  "  +  ax+" , "+ay+" , "+bx+" , "+by );
			switch(count) {
			
			case 0: //W
				if(map[ay-1][ax] == 1 || map[ay-1][ax] ==2 ) {
					ax = bx;
					ay = by;
					str = true;
				}
//				else if( map[by-2][bx] ==1 || map[by-2][bx] ==2) {
//					ax = bx;
//					ay = by;
//				}
				else {
					map[ay][ax] = 0;
					map[ay-1][ax] = 2;
				}break;
			
		case 1: //S
			if(map[ay+1][ax] == 1 || map[ay+1][ax] ==2) {
				ax = bx;
				ay = by;
				str = true;
			}
//			else if( map[ay+2][ax] ==1 || map[ay+2][ax] ==2) {
//				ax = bx;
//				ay = by;
//			}
			else {
				map[ay][ax] = 0;
				map[ay+1][ax] = 2;
			}break;
			
		case 2: //A
			if(map[ay][ax-1] == 1 || map[ay][ax-1] ==2 ) {
				ax = bx;
				ay = by;
				str = true;
			}
//			else if( map[by][bx-2] ==1 ||map[by][bx-2] ==2) {
//				bx = ax;
//				by = ay;
//			}	
			else {
				map[ay][ax] = 0;
				map[ay][ax-1] = 2;
			}break;
			
		case 3: //D
			if(map[ay][ax+1] == 1 || map[ay][ax+1] ==2) {
				ax = bx;
				ay = by;
				str = true;
			}
//			else if( map[by][bx+2] ==1 || map[by][bx+2] ==2) {
//				ax = bx;
//				ay = by;
//			}
			else {
	
				map[ay][ax] = 0;
				map[ay][ax+1] = 2;
			}break;
			
		}
	}
		
		for(int i= 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				
				if(i == ay && j == ax) {
					System.out.print("№\t");
				}else if(map[i][j] == 1) {
					System.out.print("■\t");
				}else if(map[i][j] == 2) {
					System.out.print("▣\t");
				}else {
					System.out.print("□\t");
				}
				
			}
			System.out.println();
		}
		
		return str;
	}
	
	public void move() {
		
		map(ax, ay, bx, by, count);

		while (true) {
			String input = scan.next();
			System.out.println(input.toUpperCase());
			switch (input.toUpperCase()) {
			case "W":
				ay--;
				count = 0;
				break;
			case "S":
				ay++;
				count = 1;
				break;
			case "A":
				ax--;
				count = 2;
				break;
			case "D":
				ax++;
				count = 3;
				break;
			default:
				break;
			}
//			System.out.println(ax+" , "+ay+" , "+bx+" , "+by + "\t"+tx+" , "+ty);
			System.out.println(ax+" , "+ay+" , "+bx+" , "+by );
		
			
			if(map(ax, ay, bx, by,count)) {
				System.out.println("ture : "+ax+" , "+ay+" , "+bx+" , "+by );
				ax = bx;
				ay = by;
			}
			else {
				System.out.println(map[6][2]);
				System.out.println("false : "+ax+" , "+ay+" , "+bx+" , "+by );
				bx = ax;
				by = ay;
				
			}
			
			if(			 map[3][3] == 2	&& map[3][5] == 2 
					&& map[4][4] == 2 && map[5][4] == 2 
					&& map[6][4] == 2 && map [5][3] == 2 	) {
				System.out.println("성공하였습니다.!!");
				break;
			}
			
			
		}
		
	}

}
