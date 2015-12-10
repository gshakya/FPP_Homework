package week3.lesson8;

class MyStringLinkedList {
	Node header;

	MyStringLinkedList() {
		header = null;
	}

	public void addFront(String item) {
		if (this.isEmpty())
			header = new Node(null, item, null);
		else {
			Node n = new Node(null, item, header);
			header.previous = n;
			header = n;
		}
	}

	// Implement the code

	public void addLast(String item) {
		if (this.isEmpty())
			header = new Node(null, item, null);
		else {
			Node travellinNode = header;
			while (travellinNode.next != null) {
				travellinNode = travellinNode.next;
			}
			travellinNode.next = new Node(travellinNode, item, null);
		}
	}

	// implement the code
	public void postAddNode(Node n, String value) {
		if (this.isEmpty())
			return;
		else {
			Node travellinNode = header;
			while (!travellinNode.value.equals(n.value)) {

				travellinNode = travellinNode.next;
			}
			if (travellinNode.next == null) {
				travellinNode.next = new Node(travellinNode, value, null);
			} else {
				Node newNode = new Node(travellinNode, value, travellinNode.next);
				travellinNode.next.previous = newNode;
				travellinNode.next = newNode;
			}
		}

	}
	// implement the code

	public int Size() {
		int size = 1;
		Node travellinNode = header;
		if (travellinNode == null)
			return 0;
		while (travellinNode.next != null) {
			size++;
			travellinNode = travellinNode.next;
		}
		return size;
	}

	// implement code
	public boolean isEmpty() {
		return (header == null ? true : false);
	}

	public void preAddNode(Node n, String value) {
		Node newNode;
		if (n == null) {
			// List is empty
			newNode = new Node(null, value, null);
		} else if (n.previous == null) {
			// n is the first node
			addFront(value);
		} else {
			newNode = new Node(n.previous, value, n);
			n.previous.next = newNode;
			n.previous = newNode;
		}

	}

	public Node findLast() {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp.next != null)
				temp = temp.next;
			return temp;
		}
	}

	public Node findItem(String str) {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp != null)
				if (str.equals(temp.value))
					return temp;
				else
					temp = temp.next;
			return null;
		}
	}

	public void deleteNode(Node n) {
		if (header != null && n != null) {
			if (n.next == null && n.previous == null) {
				// only one node
				header = null;
				n = null;
				System.out.println("I am here 1");

			} else if (n.previous == null) {
				// remove first node
				n.next.previous = null;
				header = n.next;
				n = null;
				System.out.println("I am here 2");
			} else if (n.next == null) {
				// remove last node
				n.previous.next = null;
				n = null;
				System.out.println("I am here 3");
			} else {
				// general case
				n.next.previous = n.previous;
				n.previous.next = n.next;
				n = null;
				System.out.println("I am here 4");
			}

		}

	}

	public void deleteList() {
		Node tempOne = header;
		Node tempTwo = header;
		while (tempOne != null) {
			tempOne = tempOne.next;
			tempTwo = null;
			tempTwo = tempOne;
		}
		header = null;
	}

	public String toString() {
		String str = "";
		Node temp = header;
		while (temp != null) {
			str = str + "-->[" + temp.value.toString() + "]";
			temp = temp.next;
		}
		str = str + "-->[" + "NULL" + "]";
		return str;
	}

	public void printReverse() {
		String str = "";
		Node temp = findLast();
		while (temp != null) {
			str = str + "==>[" + temp.value.toString() + "]";
			temp = temp.previous;
		}
		str = str + "==>[" + "NULL" + "]";
		System.out.println(str);
	}

	public Object getFirst() {
		if (this.isEmpty())
			return null;
		return header;
	}

	public Object getLast() {
		if (this.isEmpty())
			return null;
		Node travellinNode = header;
		while (travellinNode.next != null) {
			travellinNode = travellinNode.next;
		}
		return travellinNode;
	}

	public void removeFirst() {
		header.next.previous = null;
		header = header.next;
	}

	public void removeLast() {
		Node last = (Node) getLast();
		last.previous.next = null;
		last.previous = null;
	}

	public class Node {
		String value;
		Node next;
		Node previous;

		Node(Node previous, String value, Node next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}

		public String toString() {
			return value;
		}
	}

}

public class Question3 {
	public static void main(String[] args) {
		MyStringLinkedList mySL = new MyStringLinkedList();
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addFront("Carrot Cake");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addFront("Blueberry Muffin");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addFront("Apple Pie");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addLast("Orange Juice");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addLast("Peach Sauce");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.deleteNode(mySL.findItem("Apple Pie"));
		System.out.println(mySL);
		mySL.printReverse();
		mySL.deleteNode(mySL.findItem("Peach Sauce"));
		System.out.println(mySL);
		mySL.printReverse();
		mySL.deleteNode(mySL.findItem("Carrot Cake"));
		System.out.println(mySL);
		mySL.printReverse();
		mySL.postAddNode(mySL.findItem("Blueberry Muffin"), "Carrot Cake");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.preAddNode(mySL.findItem("Blueberry Muffin"), "Apple Pie");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.postAddNode(mySL.findItem("Carrot Cake"), "Danish Delight");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.preAddNode(mySL.findItem("Orange Juice"), "Mango Smoothie");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.postAddNode(mySL.findItem("Orange Juice"), "Peach Sauce");
		System.out.println(mySL);
		mySL.printReverse();
		// -->[Apple Pie]-->[Blueberry Muffin]-->[Carrot Cake]-->[Danish
		// Delight]-->[Mango Smoothie]-->[Orange Juice]-->[Peach Sauce]-->[NULL]
		// ==>[Peach Sauce]==>[Orange Juice]==>[Mango Smoothie]==>[Danish
		// Delight]==>[Carrot Cake]==>[Blueberry Muffin]==>[Apple Pie]==>[NULL]
		System.out.println(mySL.Size());

		System.out.println(mySL.getFirst());
		System.out.println(mySL.getLast());
		mySL.removeFirst();
		System.out.println(mySL);
		mySL.printReverse();

		mySL.removeLast();
		System.out.println(mySL);
		mySL.printReverse();

		// mySL.deleteList();
		// System.out.println(mySL);
		// mySL.printReverse();
	}

}
