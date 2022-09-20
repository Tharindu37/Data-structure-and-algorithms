import java.util.*;
class OrdArrayApp{
	public static void main(String args[]){
		OrdArray ordArray = new OrdArray();
		int[] a={10,50,30,60,90,20,1,7};
		ordArray.generateOrdArray(a);
		System.out.println(Arrays.toString(a));
	}
}

