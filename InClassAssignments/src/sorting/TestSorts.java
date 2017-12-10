package sorting;

public class TestSorts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] testArray = { 59, 46, 32, 80, 46, 55, 50, 43, 44, 81, 12, 95, 17,
				80, 75, 33, 40, 61, 16, 87 };

		Sorts.quickSort(testArray);

		for (int value : testArray) {
			System.out.print(value + " ");
		}
	}

}
