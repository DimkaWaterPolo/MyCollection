package ru.sds.ArrayList;

import java.util.Comparator;

public class LinkedList implements List {
	
	private Node firstNode;
	private int size;
	public Node lastNode;
	int iteratorCount=0;
	public Node iteratorNode = firstNode;
	
	
	public class Node {
		Object element;
		Node next;
		Node prev;
				
		public Node() {
			super();
		}
		
		
		public Node(Object element) {
			this();
			this.element = element;
		}

		public Node(Object element, Node next, Node prev) {
			this(element);
			this.next = next;
			this.prev = prev;
		}
		
		@Override
		public String toString() {
			return "Node [element=" + element +  "]";
		}	
		
	}

	
	public LinkedList() {
		super();
	}

	public LinkedList(Node node) {
		super();
		this.firstNode = node;
	}

	public int size() {
		return size;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public boolean containts(Object o) {

		Node node = firstNode;
		if(firstNode.element.equals(o)) {
			return true;
		}
		while(node.next!=null) {
			node = node.next;
			if(node.element.equals(o)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasNext() {
		if(iteratorNode.equals(lastNode)) {
			return false;
		}
		//return (iteratorCount<size) ;
		return true;
	}

	public Object next() {
		Node node = firstNode;
		int count=1;
		if(iteratorNode==firstNode) {
			//iteratorCount++;
			iteratorNode = firstNode;
			return firstNode.element;
		}
		while(iteratorNode.next!=null) {
			node = iteratorNode.next;
			iteratorNode = node;
			return node;
			/**if(count==iteratorCount) {
				iteratorCount++;
				return node.element;
			}
			count++;**/
		}
		return null;
	}

	public Object get(int index) {
		if(index>size || index<0) {
			return null;
		}
		if(index==0) {
			return firstNode;
		}
		if(index==size-1) {
			return lastNode;
		}
		
		
		int count=1;
		Node node = firstNode;
		
		while(node.next!=null) {
			node = node.next;
			if(index==count) {
				return node;
			}
			count++;
		}
		return null;
	}

	public void add(Object o) {
		
		if(size==0) {
			lastNode=firstNode = new Node(o);
		}else {
			Node node1 = new Node(o,null,lastNode);
			//node1.setElement(o);
			//node1.setNext(null);
			//node1.setPrev(lastNode);
			lastNode.next=node1;
			lastNode=node1;
		}
		size++;
		
	}

	public void remove(int index) {
		Node node = firstNode;
		
		if(index==0) {
			firstNode=node.next;
			firstNode.prev = null;
			size--;
			return;
		}
		
		if(index==size-1) {
			Node prevNode = lastNode.prev;
			prevNode.next=null;
			lastNode=prevNode;
			size--;
			return;
		}
	
		int count = 1;
		while(node.next!=null) {
			node = node.next;
			if(index==count) {
				Node prevNode = node.prev;
				Node nextNode = node.next;
				prevNode.next = nextNode;
				nextNode.prev=prevNode;
				//node.prev.next=node.next;
				//node.next.prev=node.prev;
				size--;
				return;
			}
			count++;
		}
		
	}

	public int indexOf(Object o) {
		if(firstNode.element.equals(o)) {
			return 0;
		}
		
		int count=1;
		Node node = firstNode;
		while(node.next!=null) {
			node = node.next;
			if(node.element.equals(o)) {
				return count;
			}
			count++;
		}
		
		return -1;
	}
	
	@Override
	public String toString() {
		
		String str = "LinkedList [size=" + size + "] ";
		Node node = firstNode;
		str = str + ", " + node.toString();
		while(node.next!=null) {
			node = node.next;
			str = str + ", " + node.toString();
		}
		return str;
	}
	
	private String  showNode(Node node) {
		if (node == null)
			return "";
		return node.toString() + " "  +showNode(node.next);
	}
	
	public String showList() {
		return showNode(firstNode);
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(9);
		linkedList.add(8);
		linkedList.add(7);
		linkedList.add(6);
		linkedList.add(5);
		linkedList.add(4);
		linkedList.add(3);
		linkedList.add(2);
		linkedList.add(1);
		/*System.out.println(linkedList.toString());
		System.out.println(linkedList.size);
		System.out.println(linkedList.get(0));
		System.out.println(linkedList.indexOf(7));
		//linkedList.remove(8);
		linkedList.remove(1);
		System.out.println(linkedList.toString());
		
		System.out.println(linkedList.containts(9));
		
		while(linkedList.hasNext()) {
			System.out.println(linkedList.next());
		}*/
		System.out.println(linkedList.showList());
		
	}

	public void sort(Comparator<Object> comparator) {
		// TODO Auto-generated method stub
		
	}

}
