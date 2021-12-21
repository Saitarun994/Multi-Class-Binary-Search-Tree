/**
 * A program to create a BST containing  different classes
 * as elements
 */

/**
 * @author Sai Tarun Sathyan
 *  @author Aarti
 */
public class SortedStorageSetWithNulls {
	Node root;
	String rootType;
	int nullCounter=0;
	
	/**
	 * Function to add an element to the BST 
	 * @param name		the name of the animal
	 * @param object		the animals object
	 * @param legs			number of legs
	 * @param classification	the type of animal
	 * @return boolean		returns true if element has been added else false
	 */
	public boolean add(Comparable userInput)
	{	
		if(root==null)		//root value and root type assignment  
		{	
			this.rootType=userInput.getClass().getSimpleName();
			
			this.root=new Node(userInput);
			return true;
		}
		else
		{
			if(userInput==null)
			{
				this.nullCounter++;
				return true;
			}
			else if(rootType.equals(userInput.getClass().getSimpleName()))
			{
				this.root.insert(userInput);
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	/**
	 * A function to find a given element 
	 * in the BST
	 * @param <T>
	 * @param userInput
	 * @return
	 */
	public boolean find(Comparable userInput)
	{
		if(root==null)
		{
			return false;
		}
		else
		{	if(userInput==null)
			{
				if(this.nullCounter>0)
					return true;
				else
					return false;
			}
			else if(this.rootType.equals(userInput.getClass().getSimpleName()))
				{
					return root.search(userInput);
				}
			else
				{	
					System.out.print("this does not match the root data type  ");
					return false;
				}
		}
	}
	
	/**
	 * Function to delete an element from the BST
	 * the function checks if user input matches the data type of 
	 * the tree's root node
	 * @param <T> an element of any data type
	 * @param userInput
	 * @return
	 */
	public boolean delete(Comparable userInput)
	{		
		if(userInput==null)//input is null
		{
			if(this.nullCounter>0)
			{
				this.nullCounter--;
				return true;
			}
			else
			{
				return false;
			}
		}
		else if((this.rootType.equals(userInput.getClass().getSimpleName()))&&this.root.search(userInput))
		{
			if((userInput.compareTo(this.root.object)==0)&&(countNodes(this.root)==1))//if node to be deleted is root
			{
				this.root=null;
				this.root.leftChild=this.root.rightChild=null;
				return true;
			}
			else
			{
				this.root.remove(this.root, userInput);
				return true;
			}
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Inorder print function		
	 * @param focusNode
	 */
	public void print(Node focusNode )
	{	
		if(focusNode!=null&&focusNode.object!=null)
		{
			print(focusNode.leftChild);
			System.out.println();
			System.out.print(focusNode.object);
			System.out.println();
			print(focusNode.rightChild);
		}
	}
	
	/**
	 * function to count total no nodes in the tree
	 * @param n
	 * @return
	 */
	public static int countNodes(Node n)
	{
		if(n==null)
		{
			return 0;
		}
		else
			return 1+countNodes(n.leftChild)+countNodes(n.rightChild);
		}
	
	/**
	 * A function to print the elements of the tree inorder
	 * the null count inside the tree and the data type of the root 
	 * node
	 * @param focusNode
	 */
	public void  treeInfoPrint(Node focusNode)
	{	System.out.println("********************Tree Info*********************");
		System.out.println("****************Ordered by weight******************");
		System.out.println("Null count: "+this.nullCounter+" \nData type : "+this.rootType);
		System.out.print("Elements of this tree:- \n");
		print(focusNode);
		System.out.println("************************************************");
	}

//<<<<<<<<<<<<<<<<<<<START OF MAIN>>>>>>>>>>>>>>>>>>>
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortedStorageSetWithNulls tree1 = new SortedStorageSetWithNulls();
		System.out.println("FISH TREE OPERATIONS");
		System.out.println("------------------------------------------");
		Fish f1= new Fish("Fish 1", 5, 3, "salmon");
		Fish f2= new Fish("Fish 2", 1, 3, "small salmon");
		Fish f3= new Fish("Fish 3", (float)0.5, 0, "almond");
		Fish f4= new Fish("Fish 4", 50, 4, "shark");
		LivingThings l1= new LivingThings("Living Thing1", 5, 0, "snake");
		System.out.println("Add f1: "+tree1.add(f1));
		System.out.println("Add f2: "+tree1.add(f2));
		System.out.println("Add f3: "+tree1.add(f3));
		System.out.println("Add f4: "+tree1.add(f4));
		System.out.println("Add null: "+tree1.add(null));
		System.out.println("Add L1: "+tree1.add(l1));
		System.out.println();
		System.out.println("Find f3: "+tree1.find(f3));
		System.out.println("Delete f3: "+tree1.delete(f3));
		System.out.println("Find f3: "+tree1.find(f3));
		tree1.treeInfoPrint(tree1.root);
		System.out.println("ANT TREE OPERATIONS");
		System.out.println("------------------------------------------");
		SortedStorageSetWithNulls tree2 = new SortedStorageSetWithNulls();
		Ant a1= new Ant("Ant 1", 0.00002, 6, "fire ant");
		Ant a2= new Ant("Ant 2", 0.000021, 6, "water ant");
		Ant a3= new Ant("Ant 3", 0.00003, 6, "black ant");
		Ant a4= new Ant("Ant 4", 0.00001, 6, "bull ant");
		Mouse m1=new Mouse("Mouse 1",1,4,"sewer rat");
		System.out.println("Add a1: "+tree2.add(a1));
		System.out.println("Add a2: "+tree2.add(a2));
		System.out.println("Add a3: "+tree2.add(a3));
		System.out.println("Add a4: "+tree2.add(a4));
		System.out.println("Add m1: "+tree2.add(m1));
		System.out.println("Delete m1: "+tree1.delete(m1));
		tree2.treeInfoPrint(tree2.root);
		
	}
//<<<<<<<<<<<<<<<<<<<END OF MAIN>>>>>>>>>>>>>>>>>>>
}


/**
 * Class node is used to store a element of the BST
 * along with it's left and right child objects
 *
 */
class Node{
	Comparable object;
	Node leftChild;
	Node rightChild;
	
	Node(Comparable userInput)
	{
		this.object=userInput;
		this.leftChild=this.rightChild=null;
	}
	
	/**
	 * Function to add a object
	 * @param s	the string that needs to be added
	 * @return boolean true if element was added else false
	 */
	public boolean insert(Comparable userInput)
	{ boolean added=false;
		if(this.object.compareTo(userInput)==1)
		{
			if(this.leftChild==null)
			{
				this.leftChild= new Node(userInput);
				return true;
			}
			else
			{
				added=this.leftChild.insert(userInput);
			}
		}
		else if (this.object.compareTo(userInput)==-1)
		{
			if(this.rightChild==null)
			{
				this.rightChild=new Node(userInput);
				return true;
			}
			else
			{
				added=this.rightChild.insert(userInput);
			}
		}
		return added;
	}
	
	/**
	 * Function to search a node in a BST
	 * @param s s the string object to be removed
	 * @return boolean true if s has been found, else returns false
	 */
	public boolean search(Comparable userInput)
	{	boolean found=false;
		if(this.object==null)//exception handle
			return false;
		if(this.object!=null &&this.object.compareTo(userInput)==0)
		{	
			found=true;
			return true;
		}
		else if((this.object.compareTo(userInput)==-1) && this.rightChild!=null)
		{
			found=this.rightChild.search(userInput);
		}
		else if((this.object.compareTo(userInput)==1) && this.leftChild!=null)
		{
			found=this.leftChild.search(userInput);
		}
		return found;
	}
	
	/**
	 * Function to delete node in BST
	 * @param s the string object to be removed
	 * @return node returns the node element to be reallocated in the BST
	 */
	public Node remove(Node n,Comparable userInput)
	{	
		if(n.object.compareTo(userInput)==1)
		{
			n.leftChild=n.leftChild.remove(n.leftChild,userInput);//go left	
		}
		else if(n.object.compareTo(userInput)==-1)
		{
			n.rightChild=n.rightChild.remove(n.rightChild,userInput);//go right
		}
		else//arrive at focus node
		{
			if(n.leftChild==null && n.rightChild==null)//no child
			{	
				n.object=null;//n=null
				return n;
			}
			else if(n.leftChild==null &&n.rightChild!=null)//LC null
			{	
				n.object=n.rightChild.object;//n=n.rightChild
				n=n.rightChild;
				n.rightChild.object=null;
				return n;
			}
			else if(n.leftChild!=null &&n.rightChild==null)//RC null
			{	
				n.object=n.leftChild.object;//n=n.leftChild
				n.leftChild.object=null;
				return n;
			}
			else	//subtree
			{
				Node temp=n.minobject(n.rightChild);
				n.object=temp.object;
				n.rightChild=remove(n.rightChild, userInput);//verify n.rightChild.remove
				return n;
			}
		}
		return n;	
	}
	/**
	 * Finds the minimum object in a sub tree and 
	 * returns the node data
	 * @param root
	 * @return node that contains the minimum object
	 */
	public Node minobject(Node start)
	{
		Node minVal=start;
		while(start!=null)
		{
			minVal=start.leftChild;
			start.leftChild=start.leftChild;
		}
		return minVal;
	}
	
}
//<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>
//<<<<<<<<<<<<<ALL 4 CLASS DEFINITIONS>>>>>>>>>>>>>
//<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>
class LivingThings implements Comparable<LivingThings> {
	String name;
	int legs;
	float weight;
	String classification;
	
	LivingThings(String name, float weight, int legs,String classification)
	{
		this.name=name;
		this.weight=weight;
		this.legs=legs;
		this.classification=classification;
	}
	
	public int compareTo(LivingThings f)
	{
		
		if(this.weight>f.weight)
		{
			return 1;
		}
		else if(this.weight<f.weight)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	public String toString()
	{
		return "Name: " + this.name+"\n"+"Legs: "+
				+this.legs+"\n"+"Weight: "+this.weight+"lbs"+"\n"
				+"Classified as: "+this.classification+"\n";
	}
}


class Fish implements Comparable<Fish>{
	String name;
	int legs;
	float weight;
	String classification;
	
	Fish(String name, float weight, int legs,String classification)
	{
		this.name=name;
		this.weight=weight;
		this.legs=legs;
		this.classification=classification;
	}
	
	public int compareTo(Fish f)
	{
		
		if(this.weight>f.weight)
		{
			return 1;
		}
		else if(this.weight<f.weight)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	public String toString()
	{
		return "Name: " + this.name+"\n"+"Fins: "+
				+this.legs+"\n"+"Weight: "+this.weight+"lbs"+"\n"
				+"Classified as: "+this.classification+"\n";
	}
}


class Ant implements Comparable<Ant>{
String name;
	int legs;
	double weight;
	String classification;
	
	Ant(String name, double weight, int legs,String classification)
	{
		this.name=name;
		this.weight=weight;
		this.legs=legs;
		this.classification=classification;
	}
	
	public int compareTo(Ant f)
	{
		
		if(this.weight>f.weight)
		{
			return 1;
		}
		else if(this.weight<f.weight)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	public String toString()
	{
		return "Name: " + this.name+"\n"+"Legs: "+
				+this.legs+"\n"+"Weight: "+this.weight+"lbs"+"\n"
				+"Classified as: "+this.classification+"\n";
	}

}


class Mouse implements Comparable<Mouse> {
	String name;
	int legs;
	float weight;
	String classification;
	
	Mouse(String name,float weight, int legs,String classification)
	{
		this.name=name;
		this.weight=weight;
		this.legs=legs;
		this.classification=classification;
	}
	
	public int compareTo(Mouse f)
	{
		
		if(this.weight>f.weight)
		{
			return 1;
		}
		else if(this.weight<f.weight)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	public String toString()
	{
		return "Name: " + this.name+"\n"+"Legs: "+
				+this.legs+"\n"+"Weight: "+this.weight+"lbs"+"\n"
				+"Classified as: "+this.classification+"\n";
	}


}


