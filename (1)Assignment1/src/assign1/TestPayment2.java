/**
 * 
 */
package assign1;

/**
 * @author Peter
 *
 */
public class TestPayment2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("TestPayment2: Tests CreditCardPayment.equals");
		CreditCardPayment credit1 = new CreditCardPayment("Mickey Mouse","05/18","1234-5678-9000",100);
		CreditCardPayment credit2 = new CreditCardPayment("Mickey Mouse","05/18","1234-5678-9000",100);

		System.out.println("Credit Details:\n");
		credit1.paymentDetails();
		credit2.paymentDetails();
		
		if (credit1.equals(credit2)) System.out.println("Pass");
		else System.out.println("Fail");
	}

} // end of TestPayment2
