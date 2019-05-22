package com.javaGame;

//1차 코팅시험 엘레베이터 만들기!!!
import java.util.Scanner;

public class test {

	int[] Level = new int[3];
	int[] ELE = new int[4];
	int lastLevel = 1;

	Scanner scan = new Scanner(System.in);

	public void start() {

		while (true) {
			System.out.println("=======================================");
			System.out.println("엘레베이터 상태  [ 현재층 : " + lastLevel + "]");
			System.out.println("[" + ELE[0] + "]" + "[" + ELE[1] + "]" + "[" + ELE[2] + "]" + "[" + ELE[3] + "]");
			System.out.println("행동을 입력하세요.");
			System.out.println("1. 이동  2. 탑승  9. 종료");
			System.out.println("=======================================");
			int action = scan.nextInt();
			switch (action) {
			case 1:
				move();
				break;
			case 2:
				enter();
				break;
			case 9:
				exit();
				break;
			default:
				System.out.println("?? 다시입력하시오 ??");
				break;
			}
		}
	}

	public void enter() {

		while (true) {

			System.out.println("=======================================");
			System.out.println("=====몇번에 탑습하시겠습니다. [1] [2] [3] [4] (취소 : 9번)====");
			System.out.println("=======================================");
			int entInput2 = scan.nextInt();
			if (entInput2 == 1 && ELE[0] == 0) {
				ELE[0] = 1;
				break;
			} else if (entInput2 == 2 && ELE[1] == 0) {
				ELE[1] = 1;
				break;
			} else if (entInput2 == 3 && ELE[2] == 0) {
				ELE[2] = 1;
				break;
			} else if (entInput2 == 4 && ELE[3] == 0) {
				ELE[3] = 1;
				break;
			} else if (entInput2 == 9) {
				System.out.println("=======================================");
				System.out.println("===============탑승을 취소합니다===============");
				System.out.println("=======================================");
				start();
				break;
			} else {
				System.out.println(entInput2 + " 번 엘레베이터에 탑승할수 없습니다.");
				continue;
			}
		}
	}

	public boolean out() {

		boolean getOut = true;
//		int[] client = {1,2,3,4};
		System.out.println("=======================================");
		System.out.println("==========내리시겠습니까 ? [0 : 아니오, 1: 예]==========");
		System.out.println("=======================================");
		int cli1 = scan.nextInt();
		switch (cli1) {
		
		case 1:
//			 if (ELE[0] == 0 || ELE[1] == 0 || ELE[2] == 0 || ELE[3] == 0) {
//				 
//					start();
//					break;
//				}

			while (true) {
				System.out.println("=======================================");
				System.out.println("[" + ELE[0] + "]" + "[" + ELE[1] + "]" + "[" + ELE[2] + "]" + "[" + ELE[3] + "]");
				System.out.println("======몇번 손님이 내리시겠습니까? [5번은 아무도 안내림!!]======");
				System.out.println("=======================================");
				int cli2 = scan.nextInt();

				if (cli2 == 1 && ELE[0] == 1) {
					ELE[0] = 0;
					System.out.println("============1 번 손님이 내렸습니다.==============");
					if (ELE[0] == 0 && ELE[1] == 0 && ELE[2] == 0 && ELE[3] == 0) {
						System.out.println("=======================================");
						System.out.println(" ===============모두 내렸습니다.===============");
						System.out.println("=======================================");
						break;
					}

				} else if (cli2 == 2 && ELE[1] == 1) {
					ELE[1] = 0;
					System.out.println("============2 번 손님이 내렸습니다.==============");
					if (ELE[0] == 0 && ELE[1] == 0 && ELE[2] == 0 && ELE[3] == 0) {
						System.out.println("=======================================");
						System.out.println(" ===============모두 내렸습니다.===============");
						System.out.println("=======================================");
						break;
					}

				} else if (cli2 == 3 && ELE[2] == 1) {
					ELE[2] = 0;
					System.out.println("============3 번 손님이 내렸습니다.==============");
					if (ELE[0] == 0 && ELE[1] == 0 && ELE[2] == 0 && ELE[3] == 0) {
						System.out.println("=======================================");
						System.out.println(" ===============모두 내렸습니다.===============");
						System.out.println("=======================================");
						break;
					}

				} else if (cli2 == 4 && ELE[3] == 1) {
					ELE[3] = 0;
					System.out.println("============4 번 손님이 내렸습니다.==============");
					if (ELE[0] == 0 && ELE[1] == 0 && ELE[2] == 0 && ELE[3] == 0) {
						System.out.println("=======================================");
						System.out.println(" ===============모두 내렸습니다.===============");
						System.out.println("=======================================");
						break;
					}

				} else if (cli2 == 5) {
					System.out.println("============다른층으로 이동합니다.===============");
					break;
				} else if (ELE[0] == 0 || ELE[1] == 0 || ELE[2] == 0 || ELE[3] == 0) {
					System.out.println("=============그곳엔 손님이 없습니다.==============");
					break;
				} else {
					System.out.println("=============없는 엘레베이터입니다.==============");
					break;
				}
			}
			break;
		case 0:
			System.out.println("=============아무도 내리지 않습니다.==============");
			getOut = false;
			start();
			break;
		default:
			System.out.println("==============잘못된 입력입니다.================");
			break;
		}

		return getOut;
	}

	public void move() {

		while (true) {
			
			
			System.out.println("=======================================");
			System.out.println("===몇층으로 가시겠습니다. 1~3층 [ 현재층 : " + lastLevel + "]===");
			System.out.println("=======================================");
			int levInput = scan.nextInt();

			if (levInput == 1) {
				Level[0] = 1;
				lastLevel = levInput;
				out();
				continue;
			} else if (levInput == 2) {
				Level[1] = 1;
				lastLevel = levInput;
				out();
				continue;
			} else if (levInput == 3) {
				Level[2] = 1;
				lastLevel = levInput;
				out();
				continue;
			} else if (levInput == 9) {
				start();
				break;
			} else {
				System.out.println("===============해당층은 없습니다.==============");
				continue;
			}
		}

	}

	public void exit() {
		System.out.println("=======================================");
		System.out.println("==THE END===============엘리베이터 운행을 종료합니다.=");
		System.out.println("=======================================");
	}
}