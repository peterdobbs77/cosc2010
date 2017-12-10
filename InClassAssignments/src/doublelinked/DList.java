/**
 * 
 */
package doublelinked;

/**
 * @author Praveen Madiraju
 *
 */
public class DList<T> {

	protected DLLNode<T> header;
	protected DLLNode<T> trailer;

	protected int size;

	/**
 * 
 */
	public DList() {
		header = null;
		trailer = null;
		size = 0;

	}

	/**
	 * @return the header
	 */
	public DLLNode<T> getHeader() {
		return header;
	}

	/**
	 * @return the trailer
	 */
	public DLLNode<T> getTrailer() {
		return trailer;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	// add element to the front of the list
	public void addToFront(T elem) {
		DLLNode<T> newNode = new DLLNode<T>(elem);

		if (header == null) {
			header = newNode;
		}
		if (trailer == null)
			trailer = newNode;
		else {
			newNode.setLink(header);
			header.setBack(newNode);
			header = newNode;
		}
		size++;

	}

	// add element to the end of the list
	public void addToLast(T elem) {
		DLLNode<T> newNode = new DLLNode<T>(elem);
		newNode.setLink(null);

		if (trailer == null) {
			trailer = newNode;
			header = newNode;
		} else {
			trailer.setLink(newNode);
			newNode.setBack(trailer);
			trailer = newNode;
		}

		size++;
	}

	public void removeLast() throws Exception {
		if (isEmpty())
			throw new Exception("double linked list is empty");
		if (trailer != header) {
			DLLNode<T> temp = trailer;
			trailer = trailer.getBack();
			trailer.setLink(null);
			temp = null;
		}
	}

	public void remove(T element) throws Exception {
		if (isEmpty())
			throw new Exception("double linked list is empty");

	}

	public boolean isEmpty() {
		return header == null;
	}

	public void print() {
		DLLNode<T> v = header;
		while (v != null) {
			System.out.println(v.getInfo());
			v = (DLLNode) v.getLink();
		}

	}

}
