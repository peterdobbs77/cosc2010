package assign4;

public class ListTransaction {

	DLLNode<Transaction> header;
	DLLNode<Transaction> trailer;
	int size;

	public ListTransaction() {
		header = new DLLNode<Transaction>(null);
		trailer = new DLLNode<Transaction>(null);
		header.setLink(trailer);
		trailer.setBack(header);
		size = 0;
	}

	public void add(Transaction trans) {
		DLLNode<Transaction> node = new DLLNode<Transaction>(trans);
		if (size == 0) {
			header.setLink(node);
			trailer.setBack(node);
			node.setBack(header);
			node.setLink(trailer);
		} else {
			DLLNode<Transaction> back = trailer.getBack();
			node.setBack(back);
			node.setLink(trailer);
			trailer.setBack(node);
			back.setLink(node);
		}
		size++;
	}

	public void remove() {
		if (size == 0) {
			throw new QueueUnderflowException();
		} else if (size == 1) {
			header.setLink(trailer);
		} else {
			header.setLink(header.getLink().getLink());
			((DLLNode<Transaction>) header.getLink()).setBack(header);
		}
		size--;
	}

	public String toString() {
		String s = " ";
		DLLNode<Transaction> node = header;
		while (node.getLink() != trailer) {
			node = (DLLNode<Transaction>) node.getLink();
			s = s + node.getInfo().toString();
		}
		return s;
	}

	public DLLNode<Transaction> getFirst() {
		return (DLLNode<Transaction>) header.getLink();
	}

	public DLLNode<Transaction> getNext(DLLNode<Transaction> n) {
		if ((DLLNode<Transaction>) n.getLink() == trailer) {
			return null;
		}
		return (DLLNode<Transaction>) n.getLink();
	}

}
