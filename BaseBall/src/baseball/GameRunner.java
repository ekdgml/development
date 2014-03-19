package baseball;

import helper.GameEngine;

import java.util.Scanner;

import windownhtml.RankListWindow;

public class GameRunner {

	public static void main(String[] args) {
		//
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("---------------------");
			System.out.println("       게임메뉴    ");
			System.out.println("---------------------");
			System.out.println(" 1. 게임 시작");
			System.out.println(" 2. 랭킹 보기");
			System.out.println(" 0. 게임 종료");
			System.out.println("--------------------");
			System.out.println(" 선택 >");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				gameStart();
				break;
			case 2:
				
				gameRank();
				break;
			case 0:
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			}
		} while (true);
	}

	public static void gameStart() {
		//
		GameEngine engine = new GameEngine();
		// �����غ�
		engine.prepare();
		// ���ӽ���
		engine.start();
	}

	private static void gameRank() {
		//
		RankListWindow.show();
	}

}
