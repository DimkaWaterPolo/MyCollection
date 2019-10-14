package ru.sds.ArrayList;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayList implements List{
	
	private int capacity;
	private int size;
	private Object[] elementData;
	
	public int iteratorCount = 0;
	
	
	

	public ArrayList() {
		this.capacity = 3;
		this.size = 0;
		this.elementData = new Object[capacity];
	}

	public int size() {
		return size;
	}

	public void clear() {
		elementData = new Object[capacity];
		size = 0;
	}

	public boolean containts(Object o) {
		for(int i=0; i< size; i++) {
			if(elementData[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasNext() {
		if(iteratorCount<size) {
			return true;
		}
		return false;
	}

	public Object next() {
		return elementData[iteratorCount++];
		
	}

	public Object get(int index) {
		if(index<size && index>0) {
			return elementData[index];
		}
		return null;
	}

	public void add(Object o) {
		if(size==capacity) {
			capacity=capacity * 2;
			elementData = Arrays.copyOf(elementData, capacity);
		}
		elementData[size]=o;
		size++;
	}

	public void remove(int index) {
		int b=0;
		Object[] newElementData = new Object[capacity];
		for(int i=0;i<size;i++) {
			if(i!=index) {
				newElementData[b] = elementData[i];
				b++;
			}
		}
		size--;
		elementData = newElementData;
		
	}

	public int indexOf(Object o) {
	
		for(int i=0; i< size; i++) {
			if(elementData[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	


	
	public void printList() {
		for(int i=0; i<elementData.length;i++) {
			System.out.println(elementData[i]);
		}
	}
	
	public String showList1() {
		String str = "";
		for(int i=0; i<elementData.length;i++) {
			str= str+" "+elementData[i];
		}
		return str;
	}
	
	private String getElem(int index) {
		if(index>=size) {
			return "";
		}
		String str = "";
		 str = elementData[index].toString();
		str = str+ " " + getElem(index+1);
		return str;
	}
	
	public String showList() {
		return getElem(0);
	}
	
	private int factorial(int n) {
		int result = 1;
	    if (n == 1 || n == 0) {
	        return result;
	    }
	    result = n * factorial(n-1);
	    return result;
	    
	}

	@Override
	public String toString() {
		return "ArrayList [capacity=" + capacity + ", size=" + size + ", elementData=" + Arrays.toString(elementData)
				+ "]";
	}

	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		//System.out.println(arrayList.size());
		arrayList.add(5);
		arrayList.add(4);
		arrayList.add(3);
		arrayList.add(3);
		arrayList.add(5);
		arrayList.add(4);
		arrayList.add(3);
		//arrayList.add(3);
		System.out.println(arrayList.toString());
		
		System.out.println(arrayList.get(4));
		System.out.println(arrayList.toString());
		
		System.out.println(arrayList.containts(4));
		System.out.println(arrayList.toString());
		
		System.out.println(arrayList.indexOf(6));
		System.out.println(arrayList.toString());
		
		arrayList.remove(1);
		System.out.println(arrayList.toString());
		
		arrayList.add(10);
		System.out.println(arrayList.toString());
		
		arrayList.add(10);
		System.out.println(arrayList.toString());
		
		arrayList.remove(6);
		System.out.println(arrayList.toString());
		
		while(arrayList.hasNext()) {
			System.out.println(arrayList.next());
		}
		
		//arrayList.clear();
		System.out.println(arrayList.toString());
		System.out.println(arrayList.get(-1));
		arrayList.clear();
		
		arrayList.add("Дима");
		arrayList.add("Даша");
		arrayList.add("Сергей");
		arrayList.add("Наташа");
		arrayList.add("Мила");
		
		System.out.println("Дима".compareTo("Даша"));
		
		System.out.println(arrayList.toString());
		
		arrayList.sort(new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				String o11 = o1.toString();
				String o22 = o2.toString();
				
			if (o11.compareTo(o22) > 1) {
				return -1;
				}
			if (o11.compareTo(o22) < 1) {
				return 1;
				}
			return 0;
			}
		});
		System.out.println(arrayList.toString());
		
		String[] a = { "foo", "bar", "baz"};
		Collections.sort(Arrays.asList(a), new Comparator<String>() {

			public int compare(String o1, String o2) {
				return (-1) * o1.compareTo(o2);
			}
		});
		System.out.println(Arrays.asList(a));
		
		arrayList.clear();
		System.out.println(arrayList.toString());
		arrayList.add(new Person(22, "Дима"));
		arrayList.add(new Person(21, "Даша"));
		arrayList.add(new Person(44, "Сергей"));
		arrayList.add(new Person(43, "Наташа"));
		arrayList.add(new Person(12, "Мила"));
		System.out.println(arrayList.toString());
		
		/**Collections.sort(arrayList., new Comparator<Person>() {

			public int compare(Person o1, Person o2) {
				if(o1.age > o2.age) {
					return 1;
				}
				if(o1.age< o2.age) {
					return -1;
				}
				return 0;
			}
		});**/
		
		arrayList.sort(new Comparator<Object>() {

			public int compare(Object o1, Object o2) {
				Person person1 = (Person) o1;
				Person person2 = (Person) o2;
				
				if(person1.age < person2.age) {
					return 1;
				}
				if(person1.age > person2.age) {
					return -1;
				}
				return 0;
			}
		});
		System.out.println(arrayList.toString());
		System.out.println(arrayList.showList());
		System.out.println(arrayList.factorial(4));
	}

	
	public void sort(Comparator<Object> comparator) {
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (comparator.compare(elementData[i], elementData[j]) == 1) {
					Object temp = elementData[i];
					elementData[i] = elementData[j];
					elementData[j]=temp;
				}
			}
			
		}
	}
}
