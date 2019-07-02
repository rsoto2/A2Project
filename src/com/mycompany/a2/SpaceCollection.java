package com.mycompany.a2;

import java.util.Vector;

public class SpaceCollection implements ICollection {

	private Vector<GameObject> theCollection;
	
	public SpaceCollection()
	{
		theCollection = new Vector<GameObject>();
	}
	@Override
	public void add(GameObject obj) {
		// TODO Auto-generated method stub
		theCollection.add(obj);
		
		
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
			this.currElementIndex = 0;
			this.theCollection = theCollection;
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub

		 if(currElementIndex >= theCollection.size()) 
			 return false; 
		 else 
			 return true;
		}

		@Override
		public GameObject getNext() {
			// TODO Auto-generated method stub

		GameObject o = theCollection.get(currElementIndex);
		currElementIndex++;
		return o;
		
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
