import java.util.Scanner;


public class Unification {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter no. of predicate: ");
		int predicate = sc.nextInt();
		int previousArgs = 0;
		
		for(int p=0; p<predicate; p++){
			
			
			System.out.println("Enter no. of arguments: ");
			int temp = sc.nextInt();
			 
			if(p != 0 && temp != previousArgs)
			{
				System.out.println("Invalid no of arguments...");
				return;
			}
			previousArgs = temp;
		}
		
		char variableList[][] = new char[predicate][previousArgs];
		
		for(int i=0; i<predicate; i++){
			System.out.println("Enter the arguments for "+ (i+1) );
			for(int j=0; j<previousArgs; j++){
				System.out.println("Enter " + (j+1) +" argument:");
				variableList[i][j] = sc.next().charAt(0);
				
			}
		}
		boolean hasSet = false;
		for(int i=0; i<previousArgs; i++){
			for(int j=0; j<predicate; j++){
				if(variableList[j][i] > 65){
					hasSet = true;
					break;
				}
			}
			if(!hasSet){
				System.out.println("Unification failed...");
				return;
			}
			hasSet = false;
		}
		
		System.out.println("Unification Passed");
		
	}

}

/*OUTPUT:
student@ubuntu:~$ javac Unification.java
student@ubuntu:~$ java Unification
Enter no. of predicate: 
2
Enter no. of arguments: 
1
Enter no. of arguments: 
1
Enter the arguments for 1
Enter 1 argument:
x
Enter the arguments for 2
Enter 1 argument:
3
Unification Passed
student@ubuntu:~$ 
*/

