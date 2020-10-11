
public class FirstText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		int twoNumbersTotal = addTwoNumbers(4,8);
		System.out.println("The total is: " + twoNumbersTotal);
	}

	
	public static int addTwoNumbers(int addendOne, int addendTwo) {
		int total = 0;
		total = addendOne + addendTwo;
		return total;
	}
}
