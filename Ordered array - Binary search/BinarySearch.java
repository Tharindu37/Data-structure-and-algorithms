class BinarySearch{
	public static void main(String args[]){
		int[] ar={1,2,3,4,5,6,7,8,9,10};
		int searchValue = -3;
		int lowerBound = 0;
		int upperBound = ar.length-1;
		
		
		while(true){
			if(upperBound<lowerBound){
				System.out.println("Search value is not exists.");
				return;
			}
			
			int curIn = (lowerBound+upperBound)/2;
			
			if(ar[curIn] == searchValue){
				System.out.println("Search value is exists : index = "+curIn);
				return;
			}else if(searchValue>ar[curIn]){
				lowerBound=curIn+1;
			}else{
				upperBound=curIn-1;
			}
		}
	}
}
