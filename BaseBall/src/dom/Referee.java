package dom;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Referee {
	//
	private Ball answerBall;
	
	public void creatAnswerBall() {
		//
//		Random rand = new Random(System.currentTimeMillis());
//		
//		Set<Integer> numberSet = new HashSet<>(); 
//		while(true) {
//			int randomNumber = rand.nextInt(10);
//			if (randomNumber == 0) continue;
//			
//			numberSet.add(randomNumber);
//			if (numberSet.size() == 3) {
//				break;
//			}
//		}
		
//		Integer[] arr = new Integer[3];
//		numberSet.toArray(arr);
//		this.answerBall = new Ball(arr[0], arr[1], arr[2]);
//		
//		Iterator<Integer> iter = numberSet.iterator();
//		int num1 = iter.next();
//		int num2 = iter.next();
//		int num3 = iter.next();
		
		this.answerBall = new Ball(3, 4, 5);
	}
	
	public boolean decide(Ball userBall) {
		//
		
		int ballCount = this.answerBall.getBallCount(userBall);
		int strikeCount = this.answerBall.getStrikeCount(userBall);
		
		System.out.println("Strike: " + strikeCount);
		System.out.println("Ball: " + ballCount);
		
		if (strikeCount == 3) {
			return true;
		}
		
		return false;
	}

}
