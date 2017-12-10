package collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * This program tests the ArrayList class.
 */
public class LinkedListTester {
	public static void main(String[] args) {
		List<BankAccount> accounts = new LinkedList<BankAccount>();

		accounts.add(new BankAccount(1000));
		accounts.add(new BankAccount(2000));
		accounts.add(new BankAccount(2000));

		accounts.add(1, new BankAccount(1100));
		accounts.remove(0);

		System.out.println("size=" + accounts.size());

		BankAccount first = accounts.get(0);
		System.out.println("first account balance= " + first.getBalance());
		BankAccount last = accounts.get(accounts.size() - 1);
		System.out.println("last account balance= " + last.getBalance());

		// enhanced for loop to access ArrayList
		for (BankAccount account : accounts)
			System.out.println(account);

		// demo of using ListIterator with ArrayList
		// Get a list iterator to traverse the list.
		ListIterator<BankAccount> it = accounts.listIterator();

		System.out.println("Print using ListIterator");
		// Use the iterator to display the items in accounts.
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("Print in reverse order using ListIterator");
		// Now display the them in reverse order.
		while (it.hasPrevious()) {
			System.out.println(it.previous());
		}

	}
}
