package helper;

import java.util.Scanner;

import dom.Ball;
import dom.Pitcher;
import dom.Referee;

public class GameEngine {

	private Pitcher pitcher;
	private Referee referee;
	Scanner scanner = new Scanner(System.in);

	public void prepare() {
		//
		this.pitcher = new Pitcher();
		this.referee = new Referee();

		// ���䰪 ���Ű��
		this.referee.creatAnswerBall();
	}

	public boolean start() {
		//
		boolean gameClear = false;
		long before = (System.currentTimeMillis()) / 1000;
		for (int count = 1; count < 10; count++) {
			System.out.println("----------------------");
			System.out.println((count + 1) + "�� ���� / �� 10ȸ");
			System.out.println("----------------------");

			Ball userBall = this.pitcher.throwBall();

			if (userBall == null) {
				System.out.println("��Ŀ� �°� �ٽ� �Է��� �ּ���.");
				continue;
			}

			gameClear = this.referee.decide(userBall);

			if (gameClear == true) {
				System.out.println("you are winner!!!!!!!!!");
				System.out.println("�̸��� �Է��ϼ���.");
				String name = scanner.nextLine();
				long after = (System.currentTimeMillis() / 1000);
				int time = (int) (after - before);
				System.out.println(name + "���� " + time + "�� ���� " + count 
						+ "ȸ ���� �����ϼ̽��ϴ�.");
				
				RankDataHandler.saveCSV(name, time, count);

				return gameClear;
			}
		}

		return gameClear;
	}


}
