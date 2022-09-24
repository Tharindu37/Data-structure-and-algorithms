class Lists{
	private Node first;
	
	public void add(int data){
		Node node = new Node(data);
		if(first==null){
			first = node;
		}else{
			Node temp = first;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	public void printLists(){
		if(first != null){
			Node temp = first;
			System.out.print("["+temp.data+", ");
			while(temp.next != null){
				temp = temp.next;
				System.out.print(temp.data+", ");
			}
		}
		System.out.print(first==null?"empty]":"\b\b]");
	}
	
	public void delete(){
		if(first != null){
			first = first.next;
		}else{
			System.out.println("List is empty!");
		}
	}
	
	public Node search(int key){
		Node temp = first;
		while(temp != null){
			if(temp.data == key){
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
	
	public Node deleteKey(int key){
		if(first != null){
			Node current = first;
			Node previous = first;
			while(current != null){
				if(current.data == key){
					if(current == first){
						first = first.next;
					}else{
						previous.next = current.next;
					}
					return current;
				}else{
					previous = current;
					current = current.next;
				}
			}
		}else{
			System.out.println("List is empty!");
		}
		return null;
	}
	
	class Node{
		private int data;
		Node next;
		
		Node(int data){
			this.data=data;
		}
	}
}

class LinkedLists{
	public static void main(String args[]){
		Lists lists = new Lists();
		lists.add(10);
		lists.add(20);
		lists.add(30);
		lists.add(40);
		lists.add(50);
		lists.printLists();
		lists.delete();
		lists.printLists();
		if(lists.search(80) != null){
			System.out.println("Search value is in the list");
		}else{
			System.out.println("Search value is not in the list");
		}
		
		lists.deleteKey(40);
		lists.printLists();
		
	}
}
