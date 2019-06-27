package com.mycompany.a2;

public interface IIterator {
		
		public boolean hasNext();
		public Object getNext();
		public void remove(int index);

		public int current();
	
		
}
