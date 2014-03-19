package baseball;

import dom.Ball;

public class BallTest {
	
	public static void main(String[] args) {
		//
		Ball answerBall = new Ball(3, 5, 7);
		Ball userBall = new Ball(3, 5, 7);
		
		int strikeCount = answerBall.getStrikeCount(userBall);
		int ballCount = answerBall.getBallCount(userBall);
		
		System.out.println("Strike Count : " + strikeCount);
		System.out.println("Ball Count : " + ballCount);
	}

}
