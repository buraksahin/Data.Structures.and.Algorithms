import java.util.ArrayList;

public class Heap implements IHeap{
	
	// Heap Array List keep type of Vertex //
	ArrayList<Vertex> mheap;
	
	public Heap() {
		mheap = new ArrayList<>();
	}
	
	// - Add object to the heap - //
	public void insert(Vertex x) {
		mheap.add(x);
		a_heapify(mheap.size()-1);
		
	}
	
	@Override
	public Vertex deleteMin() {
		if (mheap.size() > 0) 
		{
			swap(0, mheap.size()-1);
			Vertex tmp = mheap.remove(mheap.size()-1);
			heapify(0);
			return tmp;
		}
		else {return null;}
	}
	

	@SuppressWarnings("unused")
	public void removeVertex(String V){
		for(int x=0; x<this.mheap.size(); x++){
			if(mheap.get(x).getVName().equals(V)){
				delete(x);
				break;
			}
			else{
				System.out.println("'" + V + "' doesn't exist.");
				break;
			}
		}
	}
	public void delete(int indx) {
		if (mheap.size() > 0) 
		{
			swap(indx, mheap.size()-1);
			mheap.remove(mheap.size()-1);
			heapify(indx);
			System.out.println("Removed...");
		}
	}

	public void a_heapify(int i) {
		while (i > 0 && mheap.get(Pindex(i)).getVName().compareTo(mheap.get(i).getVName())>0 ){
        	swap(Pindex(i), i);
            i = Pindex(i);
        }
    }
	
	// - Order Heap - //
	public void heapify(int i) {
		// - Keep index - //
		int left = Lindex(i);
        int right = Rindex(i);
        int indx = i;
        
        // - if left less than heap size and i swap with left
        if (left < this.mheap.size() &&  this.mheap.get(left).getVName().compareTo(this.mheap.get(indx).getVName())<0){
        	indx = left;
        }
        
        // - if right less than heap size and i swap with right
        if (right < this.mheap.size() &&  this.mheap.get(right).getVName().compareTo(this.mheap.get(indx).getVName())<0){
        	indx = right;
        }
        
        // - Swap Objects - //
        if (indx != i) {
            swap(indx, i);
            heapify(indx);
        }
    }
	
	@Override
	public Vertex findMin() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.mheap.size()==0){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swap(int c, int f) {
		Vertex tmp = mheap.get(c);
		mheap.set(c, mheap.get(f));
		mheap.set(f, tmp);
	}
	
	// - Return Parent index of i - //
	public int Pindex(int i) {
        return (i - 1) / 2;
    }
	// - Return Left child index of i - //
	public int Lindex(int i) {
        return 2 * i + 1;
    }
	// - Return Right child index of i - //
    public int Rindex(int i) {
        return 2 * i + 2;
    }
    
	public Vertex getVertex(int indx){
		return this.mheap.get(indx);
	}
	
	public Vertex getParent(int index){
		return mheap.get(index/2);
	}
	
	public Vertex getLeft(int index){
		return mheap.get(2*index);
	}
	
	public Vertex getRight(int index){
		return mheap.get((2*index)+1);
	}
}