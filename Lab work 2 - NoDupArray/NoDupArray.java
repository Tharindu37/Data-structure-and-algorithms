import java.util.*;
class NoDupArray{
	private long[] a;// ref to array a
	private int nElems;//number of data items
	
	public NoDupArray(int max){//constructor
		a=new long[max];
	}
	
	public boolean find(long searchKey){//find specified value
		for(int i=0;i<nElems;i++){
			if(a[i]==searchKey){
				return true;
			}
		}
		return false;
	}
		
	public void insert(long value){//put element into array
		if(a.length==nElems){
			System.out.println("Array is Full!");
		}else{
			if(!find(value)){
				a[nElems++]=value;
			}else{
				System.out.println("Value is already exists!");
			}
		}
	}
		
	public boolean delete(long value){//delete the element if it found
		int index=0;
		if(!find(value)){
			System.out.println("Value is notFound!");
			return false;
		}
		for(int i=0;i<nElems;i++){
			if(a[i]==value){
				index=i;
				break;
			}
		}
		for(int i=index;i<nElems-1;i++){
			a[i]=a[i+1];
		}
		nElems--;
		return true;
	}
		
	public void display(){//display array contents
		System.out.print("[");
		for(int i=0;i<nElems;i++){
			System.out.print(a[i]+", ");
		}
		System.out.println(nElems==0?"empty]":"\b\b]");
	}
}
