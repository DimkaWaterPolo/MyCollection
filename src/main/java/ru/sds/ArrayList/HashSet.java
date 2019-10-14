package ru.sds.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HashSet implements List {
	
	private int capasity;
	private int size;
	private Node[] table;
	
	private int iteratorIndex;
	private int iteratorCount;
	private Node iteratorNode;
	
	private int ostatoc;
	public Node nod =null;
	
	public HashSet() {
		this.capasity = 16;
		this.table = new Node[capasity];
	}
	
	
	public HashSet(int capasity) {
		this.capasity = capasity;
		this.table = new Node[capasity];
	}

	
	public class Node{
		int hashcode;
		Object value;
		Node next;
			
		public Node() {
		}
		
		public Node(Object value) {
			this();
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node [hashcode=" + hashcode + ", value=" + value + ", next=" + next + "]";
		}
		
		
	}

	public int size() {
		return size;
	}

	public void clear() {
		table = new Node[capasity];
		size = 0;
		
	}

	public boolean containts(Object o) {
		
		int index = o.hashCode() % capasity;
		
		if (table[index] == null)
			return false;
		
		
		Node node = table[index];
		while (node != null) {
			if (node.value.equals(o)) {
				return true;
			}
			node = node.next;
		}
		
		return false;
		
	}

	public void sort(Comparator<Object> comparator) {
		// TODO Auto-generated method stub
		
	}

	public boolean hasNext() {
		return (iteratorCount<size);
	}

	public Object next() {
		for (int i = iteratorIndex; i < table.length; i++) {
			Node node = table[i];
			iteratorNode = node;
			while(iteratorNode != null) {
				
					iteratorCount++;
					if(node.next!=null) {
						node = iteratorNode.next;
					}
					iteratorNode = node;
					if(node.next == null) {
						iteratorIndex = i + 1;
					}else {
						iteratorIndex = i ;
					}
					return node.value;
			}
			node = node.next;
		}
		return null;
	}

	public Object get(int index) {
		return table[index];
	}

	public void add(Object o) {
		
		Node newNode = new Node(o);
		newNode.hashcode = o.hashCode();
		int index = o.hashCode() % capasity;
		
		if (table[index] == null) {
			table[index] = newNode;
			size++;
			return;
		}
		
		Node node = table[index];
		while (node != null) {
			if (node.next == null) {
				node.next = newNode;
				size++;
				return;
			}
			node = node.next;
		}		
	}

	public void remove(int index) {	
	}
	
	public void remove(Object o) {
		
		int index = o.hashCode() % capasity;
		
		Node node = table[index];
		Node prevNode = null;
		Node nextNode = node.next;
		while(node != null) {
			if(node.value.equals(o)) {
				prevNode.next = nextNode;
				node=null;
				return;
			}
			prevNode = node;
			node=node.next;
			nextNode = node.next;
		}
	}

	public int indexOf(Object o) {
		int i ;
		i = o.hashCode() % capasity;
		return i;
	}
	
	

	@Override
	public String toString() {
		return "HashSet [capasity=" + capasity + ", size=" + size + ", node=" + Arrays.toString(table) + "OSTATOC: "+ostatoc+"]";
	}

	public static void main(String[] args) {
		HashSet hashSet = new HashSet();
		hashSet.add(1);
		hashSet.add(23);
		hashSet.add(24);
		hashSet.add(25);
		hashSet.add(26);
		//hashSet.add(1);
		//hashSet.add(1);
		hashSet.add(35);
		hashSet.add(3);
		hashSet.add(51);
		hashSet.add(67);
		System.out.println(hashSet.toString());
		System.out.println(hashSet.size());
		System.out.println(hashSet.indexOf(35));
		System.out.println(hashSet.get(3));
		System.out.println(hashSet.containts(2));
		hashSet.remove((Integer) 51);;
		System.out.println(hashSet.toString());
		while(hashSet.hasNext()) {
			System.out.println(hashSet.next());
		}
	}
}
