package ru.sds.ArrayList;

import java.util.Comparator;

public interface Collection extends Iterator {

	public int size();
	public void clear();
	public boolean containts(Object o);
	public void sort(Comparator<Object> comparator);
	
	
}
