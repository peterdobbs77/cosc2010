package assign1;

/**
 * 
 * @author Peter
 *
 */
public class TestPayment1 {

	public TestPayment1() {
		
	}

	public static void main(String[] args) {
		System.out.println("TestPayment1: tests CashPayment.equals");
		CashPayment cash1 = new CashPayment(100);
		CashPayment cash2 = new CashPayment(100);
		
		System.out.println("Cash Details:\n");
		cash1.paymentDetails();
		cash2.paymentDetails();
		
		if (cash1.equals(cash1)) System.out.println("Pass");
		else System.out.println("Fail");
	}

} // end of TestPayment1
