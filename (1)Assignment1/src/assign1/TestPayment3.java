/**
 * 
 */
package assign1;

/**
 * @author Peter
 *
 */
public class TestPayment3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("TestPayment1: tests CashPayment.equals");
		CashPayment cash1 = new CashPayment(100);
		CashPayment cash2 = new CashPayment(100);
		CreditCardPayment credit1 = new CreditCardPayment("Mickey Mouse","05/18","1234-5678-9000",100);
		CreditCardPayment credit2 = new CreditCardPayment("Mickey Mouse","05/18","1234-5678-9000",100);
		
		System.out.println("Payment Details:\n");
		cash1.paymentDetails();
		cash2.paymentDetails();
		credit1.paymentDetails();
		credit2.paymentDetails();
		
		if (cash1.equals(credit1)) System.out.println("Fail");
		else System.out.println("Pass");
	}
} // end of TestPayment3
