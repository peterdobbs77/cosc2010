/**
 * 
 */
package assign1;

/**
 * Super Class for Payments
 * @author Peter
 *
 */
public class Payment {

	protected double amount;
	
	/**
	 * 
	 * @param amount -- the amount of the payment
	 */
	public Payment(double amount) {
		super();
		this.amount = amount;
	}
	
	/**
	 * 
	 * @return amount -- the amount of the payment
	 */
	public double getAmount(){
		return amount;
	}
	
	/**
	 * @param payment - Object - object to compare this to
	 * @return boolean -- result of comparison
	 */
	@Override
	public boolean equals(Object payment){
		return(this.getClass().equals(payment.getClass()) && this.getAmount() == ((Payment) payment).getAmount());
	}
	
	/**
	 * 
	 * @param amount -- parameter for setting the value of the payment amount
	 */
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	/**
	 * Prints to the command line the payment details
	 */
	public void paymentDetails(){
		System.out.println("Payment amount: "+amount);
	}

}
