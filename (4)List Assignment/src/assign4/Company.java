/**
 * 
 */
package assign4;

/**
 * @author Peter Dobbs
 *
 */
public class Company {

	private String tickerName;
	private String fullName;
	private ListTransaction transactions;

	/**
	 * @param tickerName
	 *            Shorthand name for company
	 * @param fullName
	 *            Company name
	 */
	public Company(String tickerName, String fullName) {
		this.tickerName = tickerName;
		this.fullName = fullName;
		transactions = new ListTransaction();
	}

	/**
	 * @param trans
	 *            transaction to add to the list
	 */
	public void addTransaction(Transaction trans) {
		transactions.add(trans);
	}

	/**
	 * @return the calculated capital gains
	 */
	public double calculateGains() {
		double gains = 0;
		ListTransaction buys = new ListTransaction();
		DLLNode<Transaction> node = transactions.getFirst();

		while (node != null) {
			if (node.getInfo().getTransactionType().equals("buy")) {
				Transaction r = new Transaction(node.getInfo()
						.getTransactionType(), node.getInfo().getShareNum(),
						node.getInfo().getSharePrice());
				buys.add(r);
			} else { // Sell off shares
				int sharesToSell = node.getInfo().getShareNum();
				DLLNode<Transaction> buyNode = buys.getFirst();
				if (buyNode.getInfo() == null)
					throw new RuntimeException();

				while (sharesToSell > 0) {
					int tempShares = buyNode.getInfo().getShareNum();
					if (sharesToSell > tempShares) {
						gains += (tempShares * node.getInfo().getSharePrice() - tempShares
								* buyNode.getInfo().getSharePrice());
						sharesToSell -= tempShares;
						buyNode = buys.getNext(buyNode);
						buys.remove();
					} else {
						gains += (sharesToSell * node.getInfo().getSharePrice() - sharesToSell
								* buyNode.getInfo().getSharePrice());
						tempShares -= sharesToSell;
						sharesToSell = 0;
						buyNode.getInfo().setShareNum(tempShares);
					}
				}
			}
			node = transactions.getNext(node);

		}
		return gains;
	}

	/**
	 * @return the tickerName
	 */
	public String getTickerName() {
		return tickerName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
}