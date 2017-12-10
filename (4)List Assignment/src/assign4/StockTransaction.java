/**
 * 
 */
package assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Peter Dobbs
 *
 */
public class StockTransaction {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("Java StockTransaction");

		ListCompany companies = new ListCompany();
		File stocks = new File("stocks.txt");
		File transactions = new File("transactions.txt");

		Scanner input = new Scanner(stocks);
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] words = line.split(";");
			Company c = new Company(words[0], words[1]);
			companies.addCompany(c);
		}
		input.close();
		input = new Scanner(transactions);
		while (input.hasNext()) {
			String line = input.nextLine();
			String words[] = line.split(";");
			String ticker = words[0];
			Transaction trans = new Transaction(words[1],
					Integer.parseInt(words[2]), Double.parseDouble(words[3]
							.substring(1)));
			companies.addTransaction(trans, ticker);
		}

		System.out.println("--sucessfully read " + stocks.getName() + " and "
				+ transactions);
		input.close();
		input = new Scanner(System.in);

		while (true) {
			System.out
					.print("Please enter a input stock quote for realized gain(or loss) for the stock :");
			String ticker = input.next();
			if (ticker.equals("END")) {
				break;
			}

			int count = 0;
			DLLNode<Company> node = companies.getFirst();

			while (node.getInfo() != null) {
				if (node.getInfo().getTickerName().equals(ticker)) {
					double gains;
					try {
						gains = node.getInfo().calculateGains();
					} catch (RuntimeException e) {
						System.out
								.println("Sorry, there is an error condition associated with "
										+ node.getInfo().getFullName()
										+ " The number of sold shares exceeds the total buy quantity.");
						break;
					}
					if (gains > 0) {
						System.out
								.println("Congratulations, your realized gain for "
										+ node.getInfo().getFullName()
										+ " is : $"
										+ node.getInfo().calculateGains());
						break;
					} else if (gains == 0) {
						System.out
								.println("Sorry, no realized gain(or loss) reported for "
										+ node.getInfo().getFullName());
						break;
					} else {
						System.out.println("Sorry, your realized loss for "
								+ node.getInfo().getFullName() + " is : $"
								+ Math.abs(gains));
						break;
					}
				}
				node = companies.getNext(node);
				count++;
				if (count == companies.getSize()) {
					System.out
							.println("Sorry, the stock quote does not exist in the system.");
					break;
				}
			}
		}
		System.out.println("Ending");
		input.close();
	}
}
