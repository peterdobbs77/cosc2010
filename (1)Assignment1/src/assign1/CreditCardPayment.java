/**
 * 
 */
package assign1;

/**
 * @author Peter
 *
 */
public class CreditCardPayment extends Payment {

	private String name;
	private String expirationDate;
	private String ccNumber;
	
	/**
	 * 
	 * @param name
	 * 				The name on the credit card
	 * @param expirationDate
	 * 				The expiration date of the credit card
	 * @param ccNumber
	 * 				The credit card number
	 * @param amount
	 * 				The amount of the payment
	 */
	public CreditCardPayment(String name, String expirationDate, String ccNumber, double amount) {
		super(amount);
		
		this.name = name;
		this.expirationDate = expirationDate;
		this.ccNumber = ccNumber;
	}
	
	/**
	 * 
	 * @return - String - returns name on the credit card
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @return - String - returns expiration date of the credit card
	 */
	public String getExpirationDate(){
		return expirationDate;
	}
	
	/**
	 * 
	 * @return - String - returns the credit card number
	 */
	public String getCreditCardNumber(){
		return ccNumber;
	}
	
	@Override
	public void paymentDetails(){
		System.out.println("Credit Amount Paid: "+amount+" using Credit Card of "+name+", CC#: "+ccNumber+""
				+ ", Expiration Date: "+expirationDate);
	}

	/**
	 * 
	 * @param name
	 * 				String name for setting the name on the credit card
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * 
	 * @param expirationDate
	 * 				String expirationDate for setting the expiration date on the credit card
	 */
	public void setExpirationDate(String expirationDate){
		this.expirationDate = expirationDate;
	}
	
	/**
	 * 
	 * @param ccNumber
	 * 				String ccNumber for setting the credit card number
	 */
	public void setCreditCardNumber(String ccNumber){
		this.ccNumber = ccNumber;
	}
}
