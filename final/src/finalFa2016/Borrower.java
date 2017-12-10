package finalFa2016;

import java.util.HashSet;
import java.util.Set;

public class Borrower {

	private String cardNo;
	private String name;
	public Set<Loan> BookLoans;

	public Borrower(String cardNo, String name) {
		this.cardNo = cardNo;
		this.name = name;
		BookLoans = new HashSet<Loan>();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
