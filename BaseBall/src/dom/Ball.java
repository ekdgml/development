package dom;

import java.util.ArrayList;
import java.util.List;

public class Ball {

	private List<Integer> numbers;  //private������ ���� Ŭ�����̹Ƿ� �ʵ����� ����.
	
	public Ball(int num1, int num2, int num3) {
		//
		
		this.numbers = new ArrayList<>();
		
		this.numbers.add(num1);
		this.numbers.add(num2);
		this.numbers.add(num3);
	}



	


	public Ball(int[] number) {
		// TODO Auto-generated constructor stub
	}

	public void print() {
		// 
		System.out.println(numbers);
	}

	public int getBallCount(Ball userBall) {
		// 
		int containsCount = 0;
		for (int i = 0; i < 3; i++) {
			if (userBall.numbers.contains(this.numbers.get(i))) {
				containsCount++;
			}
		}
		
		return containsCount - getStrikeCount(userBall);
	}

	public int getStrikeCount(Ball userBall) {
		// 
		int match = 0;
		
		for (int i = 0; i <3; i++) {
			
			if (this.numbers.get(i).equals(userBall.numbers.get(i))) {
				match++;
			}
		}
		
		return match;
	}
	
}
