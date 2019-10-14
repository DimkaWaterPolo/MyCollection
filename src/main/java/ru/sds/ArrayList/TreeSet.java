package ru.sds.ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class TreeSet implements List {
	
	private int size;
	private Node headNode;
	
	
	
	public TreeSet(Node headNode) {
		super();
		this.headNode = headNode;
	}
	

	public TreeSet() {
		super();
	}
	
	


	@Override
	public String toString() {
		return "TreeSet [size=" + size + ", headNode=" + headNode + "]";
	}


	public class Node{
		Object o;
		Node leftNode;
		Node righNode;
		
		public Node() {
		}

		public Node(Object o, Node leftNode, Node righNode) {
			this.o = o;
			this.leftNode = leftNode;
			this.righNode = righNode;
		}

		@Override
		public String toString() {
			return "Node [o=" + o + ", leftNode=" + leftNode + ", righNode=" + righNode + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((o == null) ? 0 : o.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (o == null) {
				if (other.o != null)
					return false;
			} else if (!o.equals(other.o))
				return false;
			return true;
		}

		private TreeSet getOuterType() {
			return TreeSet.this;
		}

		
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public boolean containts(Object o) {
		
		Node node = headNode;
		while (node != null) {
			int resultCompare = ((Comparable)o).compareTo(node.o);
			if (resultCompare == 0)
				return true;
			else if (resultCompare >= 1)
				node = node.righNode;
			else if (resultCompare <= -1)
				node = node.leftNode;
		}
		
/*		
		
	Node first = new Node();
		
		if(headNode.o.equals(o)) {
			return true;
		}
		if(((Comparable)o).compareTo(headNode.o) > 1) {
			first = headNode.righNode;
			while(first != null) {
				if(first.o == (Integer) o) {
					return true;
				}
				if((Integer)o>first.o) {
					first = first.righNode;
				}else {
					first = first.leftNode;
				}
			}
		}
		
		if((Integer)o<headNode.o) {
			first = headNode.leftNode;
			while(first != null) {
				if(first.o == (Integer) o) {
					return true;
				}
				if((Integer)o>first.o) {
					first = first.righNode;
				}else {
					first = first.leftNode;
				}
			}
		}
*/		
		
		
		return false;
	}

	public void sort(Comparator<Object> comparator) {
		// TODO Auto-generated method stub
		
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object get(Object o) {
		/*Node first = new Node();
		
		if(headNode.o == (Integer)o) {
			return headNode;
		}
		if((Integer)o>headNode.o) {
			first = headNode.righNode;
			while(first != null) {
				if(first.o == (Integer) o) {
					return first;
				}
				if((Integer)o>first.o) {
					first = first.righNode;
				}else {
					first = first.leftNode;
				}
			}
		}
		
		if((Integer)o<headNode.o) {
			first = headNode.leftNode;
			while(first != null) {
				if(first.o == (Integer) o) {
					return first;
				}
				if((Integer)o>first.o) {
					first = first.righNode;
				}else {
					first = first.leftNode;
				}
			}
		}
		
		
		*/
		return null;
	}

	public void add(Object o) {
		
		Node node = new Node();
		if(headNode == null) {
			node.o = (Integer)o;
			node.leftNode = null;
			node.righNode = null;
			headNode = node;
			size++;
			return;
		}
		node=headNode;
		while (node != null) {
			int resultCompare = ((Comparable)o).compareTo(node.o);
			if (resultCompare == 0)
				return ;
			else if (resultCompare >= 1) {
				if(node.righNode==null) {
					Node node1 = new Node();
					node1.o = o;
					node.righNode = node1;
					size++;
					return;
				}
				node = node.righNode;
			}
			else if (resultCompare <= -1) {
				if(node.leftNode==null) {
					Node node1 = new Node();
					node1.o = o;
					node.leftNode = node1;
					size++;
					return;
				}
				node = node.leftNode;
			}
		}
		
	}
	
	public java.util.List<Node> toList() {
		java.util.List<Node> list = new ArrayList<Node>();
		
		if(headNode == null) {
			return null;
		}
		
		list.add(headNode);
		for(int i=0; i<list.size();i++) {
			if(list.get(i).leftNode!=null) {
				list.add(list.get(i).leftNode);
			}
			if(list.get(i).righNode!=null) {
				list.add(list.get(i).righNode);
			}
			
		}
		
		return list;
		
	}

	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		TreeSet treeSet = new TreeSet();
		treeSet.add(12);
		treeSet.add(10);
		treeSet.add(25);
		treeSet.add(9);
		treeSet.add(26);
		treeSet.add(11);
		treeSet.add(24);
		treeSet.add(24);
		
		System.out.println(treeSet.toString());
		
		//System.out.println(treeSet.get((Integer)10));
		System.out.println(treeSet.containts((Integer)244));
		for (Node node :treeSet.toList()) {
			System.out.println(node.o);
		}
	}

}
