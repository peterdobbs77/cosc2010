/**
 * 
 */
package assign1;

/**
 * @author Peter
 * Class object for payment type: cash
 */
public class CashPayment extends Payment {

	/**
	 * 
	 * @param amount
	 * 				double amount of cash payment
	 */
	public CashPayment(double amount) {
		super(amount);
	}

	@Override
	public void paymentDetails(){
		System.out.println("Cash Payment Amount: "+amount);
	}
}
