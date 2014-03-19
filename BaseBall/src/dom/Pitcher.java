package dom;

import java.util.Scanner;

public class Pitcher {
	//
	 int num1;
	 int num2;
	 int num3;
	
	
	public Ball throwBall() {
		//
		System.out.println("���� 3���� �Է��ϼ���");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String nums = scanner.nextLine();
			try 
			{
				 String space1 = nums.substring(0,1);
				 String space2 = nums.substring(2,3);
				 String space3 = nums.substring(4,5);
				 
				 num1 = Integer.parseInt(space1);
				 num2 = Integer.parseInt(space2);
				 num3 = Integer.parseInt(space3);
				 break;
			}
			catch (Exception e)
			{
				System.out.println("�߸� �ԷµǾ���ϴ�.");
				return null;
			}
		}
		
			
		Ball ball = new Ball(num1, num2, num3);
		return ball;
		
	}
	
}


