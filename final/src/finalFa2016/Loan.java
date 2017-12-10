package finalFa2016;

public class Loan {

	private String id;
	private String cardNo;
	private String dateOut;
	private String dueDate;

	public Loan(String id, String cardNo, String dateOut, String dueDate) {
		this.id = id;
		this.cardNo = cardNo;
		this.dateOut = dateOut;
		this.dueDate = dueDate;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * @param cardNo
	 *            the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * @return the dateOut
	 */
	public String getDateOut() {
		return dateOut;
	}

	/**
	 * @param dateOut
	 *            the dateOut to set
	 */
	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}

	/**
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

}
