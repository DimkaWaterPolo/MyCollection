package ru.sds.ArrayList;

public interface List extends Collection{

	public Object get(int index);
	public void add(Object o);
	public void remove(int index);
	public int indexOf(Object o);
}
