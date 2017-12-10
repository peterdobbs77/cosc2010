package sorting;

public class TestComparableSorts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] testArray = { "a", "b", "o", "apple", "banana", "orange" };

		ComparableSorts.insertionSort(testArray);

		for (String value : testArray) {
			System.out.print(value + " ");
		}

	}

}
