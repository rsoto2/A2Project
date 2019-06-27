package com.mycompany.a2;

import java.util.Vector;

public class SpaceCollection implements ICollection {

	private Vector<GameObject> theCollection;
	
	public SpaceCollection()
	{
		theCollection = new Vector<GameObject>();
	}
	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		theCollection.addElement((GameObject) obj);
		
		
	}


	@Override
	public IIterator getIterator() {
		// TODO Auto-generated method stub
		return new SpaceVectorIterator(this.theCollection);
	}

	
	private class SpaceVectorIterator implements IIterator 
	{
		private Vector<GameObject> theCollection; 
		private int currElementIndex;
		
		public SpaceVectorIterator(Vector<GameObject> theCollection) {
			currElementIndex = -1;
			this.theCollection = theCollection;
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(theCollection.size() <= 0)
				return false;
			if(currElementIndex == theCollection.size() - 1)
				return false;
			return true;
		}

		@Override
		public Object getNext() {
			// TODO Auto-generated method stub
			currElementIndex++;
			return  theCollection.elementAt(currElementIndex);
		
		}

		@Override
		public void remove(int index) {
			// TODO Auto-generated method stub
			//theCollection.get(currElementIndex);
			theCollection.remove(index);
			
			
		}
		
		@Override
		public int current() {
			// TODO Auto-generated method stub
			return currElementIndex;
		}
		
	}


	
	

}
