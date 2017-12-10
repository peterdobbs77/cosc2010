/**
 * 
 */
package assign4;

/**
 * @author Peter Dobbs
 *
 */
public class Transaction {

	private String transactionType;
	private int shareNum;
	private double sharePrice;

	/**
	 * @param transactionType
	 *            the transactionType to set
	 * @param shareNum
	 *            the shareNum to set
	 * @param sharePrice
	 *            the sharePrice to set
	 */
	public Transaction(String transactionType, int shareNum, double sharePrice) {
		this.transactionType = transactionType;
		this.shareNum = shareNum;
		this.sharePrice = sharePrice;
	}

	/**
	 * @return the shareNum
	 */
	public int getShareNum() {
		return shareNum;
	}

	/**
	 * @param shareNum
	 *            the shareNum to set
	 */
	public void setShareNum(int shareNum) {
		this.shareNum = shareNum;
	}

	/**
	 * @return the sharePrice
	 */
	public double getSharePrice() {
		return sharePrice;
	}

	/**
	 * @param sharePrice
	 *            the sharePrice to set
	 */
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType
	 *            the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
