/**
 * 
 */
package finalFa2016;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Peter
 *
 */
public class LibraryDemo {

	static Map<String, Book> books = new HashMap<String, Book>();
	static Map<String, Borrower> borrowers = new HashMap<String, Borrower>();

	private static void printBookLoans(Borrower borrower) {
		if (borrower.BookLoans.isEmpty()) {
			System.out.println("This card holder has no books checked out");
		}
		for (Loan book : borrower.BookLoans) {
			System.out.println(books.get(book.getId()).getTitle()
					+ ", due date: " + book.getDueDate());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java LibraryDemo");

		/* Setup Library */
		String fName = "";
		String line = null;
		try {
			System.out.println("--reading books.txt, "
					+ "borrowers.txt, and book-loan.txt");
			fName = "books.txt";
			FileReader fr = new FileReader(fName);
			BufferedReader buff = new BufferedReader(fr);
			line = buff.readLine(); // skip first line
			while ((line = buff.readLine()) != null) {
				String contents[] = line.split(",");
				Book newBook = new Book(contents[0], contents[1], contents[2]);
				books.put(contents[0], newBook);
			}
			buff.close();
			fName = "borrowers.txt";
			fr = new FileReader(fName);
			buff = new BufferedReader(fr);
			line = buff.readLine(); // skip first line
			while ((line = buff.readLine()) != null) {
				String contents[] = line.split(",");
				Borrower newBorrower = new Borrower(contents[0], contents[1]);
				borrowers.put(contents[0], newBorrower);
			}
			buff.close();
			fName = "book-loan.txt";
			fr = new FileReader(fName);
			buff = new BufferedReader(fr);
			line = buff.readLine(); // skip first line
			while ((line = buff.readLine()) != null) {
				String contents[] = line.split(",");
				Borrower borrower = borrowers.get(contents[1]);
				Loan newLoan = new Loan(contents[0], contents[1], contents[2],
						contents[3]);
				borrower.BookLoans.add(newLoan);
			}
			buff.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fName + "'");
		}

		/* Begin User Experience */
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a borrower card number:");
		String borrowerCardNo = scan.next();
		scan.close();
		if (borrowers.get(borrowerCardNo) == null) {
			System.out.println("Not a valid borrower");
			return;
		}
		System.out
				.println("Books borrowed by " + borrowerCardNo + "("
						+ borrowers.get(borrowerCardNo).getName()
						+ ") are as follows:");
		printBookLoans(borrowers.get(borrowerCardNo));
	}
}
