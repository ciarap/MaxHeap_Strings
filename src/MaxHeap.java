/*import java.util.ArrayList;

public class MaxHeap implements MaxHeapInterface<String> {
	
	private ArrayList<String> heapArray;

	public MaxHeap() {
		heapArray=new ArrayList<String>();
	}

	@Override
	public void add(String newEntry) {
		heapArray.add(newEntry);
		siftUp();
		
	}

	private void siftUp() {
		int k=heapArray.size()-1;
		while(k>0){
			int p=(k-1)/2;
			String item= heapArray.get(k);
			String parent=heapArray.get(p);
			if (item.compareTo(parent)<0){
				//swap
				heapArray.set(k, parent);
				heapArray.set(p, item);
				//move up one level
				k=p;
			}
			else{
				break;
			}
		}
		
	}

	@Override
	public String removeMax() {
		String max="";
		if(!heapArray.isEmpty()){
		max=heapArray.get(0);
		heapArray.set(0, heapArray.get(heapArray.size()-1));
		heapArray.remove(heapArray.size()-1);
		siftdown();
		}
		return max;	
	}

	private void siftdown() {
		int k=0;
		int l=2*k+1;
		while(l<heapArray.size()){
			int max=l,r=l+1;
			if(r<heapArray.size()){
				if(heapArray.get(r).compareTo(heapArray.get(l))<0){
					max++;
				}
			}
			if(heapArray.get(k).compareTo(heapArray.get(max))>0){
				//switch
				String temp=heapArray.get(k);
				heapArray.set(k, heapArray.get(max));
				heapArray.set(max, temp);
				k=max;
				l=2*k+1;
			}
			else{
				break;
			}
		}
		
	}

	@Override
	public String getMax() {
		return heapArray.get(0);
	}

	@Override
	public boolean isEmpty() {
		if (heapArray.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public int getSize() {
		return heapArray.size();
	}

	@Override
	public void clear() {
		heapArray.clear();
		
	}
	
	public String display(){
		String display="";
		for(String item:heapArray){
			display+="\n" + item;
		}
		return display;
	}
	

}
*/
import java.util.ArrayList;

public class MaxHeap implements MaxHeapInterface{

	private ArrayList<Comparable> heapArray;
	Comparable match=null;
	int treeTraversal=0;
	boolean debug=true;


	public MaxHeap() {
		heapArray=new ArrayList<Comparable>();
	}

	@Override
	public void add(Comparable newEntry) {
		heapArray.add(newEntry);
		if(debug){
			System.out.println("---------\n New Entry added: "+newEntry+"\nHeap Size: "+heapArray.size()+"\n---------");
		}
		siftUp();
	}

	public int getTreeTraversal() {
		return treeTraversal;
	}

	private void siftUp() {
		if(debug){
			System.out.println("---------\nSIFT UP\n---------");
		}
		int k=heapArray.size()-1;
		while(k>0){
			int p=(k-1)/2;
			if(debug){
				System.out.println("---------\nChild Index: "+k+"\nParent Index: "+p+"\n---------");
			}
			Comparable child= heapArray.get(k);
			Comparable parent=heapArray.get(p);
			if(debug){
				System.out.println("---------\nChild Spanish: "+( child)+"\nParent Spanish: "+parent+"\n---------");
			}
			if (child.compareTo(parent)>0){
				//swap
				heapArray.set(k, parent);
				heapArray.set(p, child);
				//move up one level
				k=p;
				if(debug){
					System.out.println("---------\nSWAPPED UP\n---------");
				}
			}
			else{
				if(debug){
					System.out.println("---------\nSIFT UP END\n---------");
				}

				break;
			}
		}

	}

	@Override
	public Comparable removeMax() {
		if(debug){
			System.out.println("---------\nREMOVE MAX\n---------");
		}
		Comparable max = null;
		if(!heapArray.isEmpty()){
			max=heapArray.get(0);
			if(debug){
				System.out.println("---------\nCurrent Max: "+max+"\n---------");
			}
			heapArray.set(0, heapArray.get(heapArray.size()-1));
			heapArray.remove(heapArray.size()-1);
			siftdown();
			if(debug){
				System.out.println("---------\nNew Max: "+heapArray.get(0)+"\n---------");
			}
		}
		return max;	
	}

	private void siftdown() {
		if(debug){
			System.out.println("---------\nSIFT DOWN\n---------");
		}
		int parentIndex=0;
		int leftChildIndex=2*parentIndex+1;
		while(leftChildIndex<heapArray.size()){
			int max=leftChildIndex;
			int rightChildIndex=leftChildIndex+1;
			
			if(rightChildIndex<heapArray.size()){
				if(heapArray.get(rightChildIndex).compareTo(heapArray.get(leftChildIndex))>0){
					if(debug){
							System.out.println("---------\nLeft: "+heapArray.get(max)+"\nRight: "+heapArray.get(rightChildIndex)+"\n---------");
						System.out.println("---------\nRight Child Greater\n---------");
					}
					max++;
				}
			}
			if(heapArray.get(parentIndex).compareTo(heapArray.get(max))<0){
				//switch
				if(debug){
					System.out.println("---------\nParent is smaller\n---------");
				}
				Comparable temp=heapArray.get(parentIndex);
				heapArray.set(parentIndex, heapArray.get(max));
				heapArray.set(max, temp);
				parentIndex=max;
				leftChildIndex=2*parentIndex+1;
			}
			else{
				break;
			}
		}
		if(debug){
			System.out.println("---------\nSIFT DOWN END\n---------");
		}

	}

	public ArrayList<Comparable> getHeapArray() {
		return heapArray;
	}

	public void setHeapArray(ArrayList<Comparable> heapArray) {
		this.heapArray = heapArray;
	}

	@Override
	public Comparable getMax() {
		return heapArray.get(0);
	}

	@Override
	public boolean isEmpty() {
		if (heapArray.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public int getSize() {
		return heapArray.size();
	}

	@Override
	public void clear() {
		heapArray.clear();

	}

	public String display(){
		String display="";
		for(Comparable item:heapArray){
			display+="\n"+item.toString();
		}
		return display;
	}

	public Comparable searchHeap(Comparable item,int parent,boolean leftChecked,boolean rightChecked){
		if (parent==0 && !leftChecked){
			match = null;
			treeTraversal=0;
		}
		int leftOrRight;
		if (rightChecked || !leftChecked)
			leftOrRight=1;
		else
			leftOrRight=2;

		if(leftChecked && rightChecked ){
			if(parent==0){
				return match;
			}
			else if(parent%2==0){
				treeTraversal++;
				searchHeap(item,(parent-1)/2,true, true);
			}else{
				treeTraversal++;
				searchHeap(item,(parent-1)/2,true, false);
			}
		}
		else {
			if ((item).compareTo(heapArray.get(parent))==0){
				System.out.println(heapArray.get(parent));
				match=heapArray.get(parent);
			}
			else if (( item).compareTo(( heapArray.get(parent)))>0){
				if(parent%2==1){
					treeTraversal++;
					searchHeap(item,(parent-1)/2,true,false);
				}

				else if (parent%2==0){
					treeTraversal++;
					searchHeap(item,(parent-1)/2,true,true);
				}
			}
			else if(2*parent+leftOrRight<heapArray.size() ){
				int child=2*parent+leftOrRight;
				treeTraversal++;
				searchHeap(item,child,false,false);
			}
			else{
				if(parent%2==1){
					treeTraversal++;
					searchHeap(item,(parent-1)/2,true,false);
				}

				else if (parent%2==0){
					treeTraversal++;
					searchHeap(item,(parent-1)/2,true,true);
				}
			}
		}
		return match;
	}
}
