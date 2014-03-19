package baseball;

import dom.Ball;
import dom.Pitcher;

public class PitcherTest {
	
	public static void main(String[] args) {
		//
		Pitcher pitcher = new Pitcher();
		
		Ball ball = pitcher.throwBall();
		
		ball.print();
		
	}

}
