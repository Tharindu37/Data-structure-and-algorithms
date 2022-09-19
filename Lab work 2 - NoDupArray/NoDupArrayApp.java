public class NoDupArrayApp{
	public static void main(String args[]){
		NoDupArray noDupArray = new NoDupArray(10);
		noDupArray.insert(10);
		noDupArray.insert(20);
		noDupArray.insert(30);
		noDupArray.insert(40);
		noDupArray.insert(50);
		noDupArray.display();
		noDupArray.delete(60);
		noDupArray.display();
		
	}
}
