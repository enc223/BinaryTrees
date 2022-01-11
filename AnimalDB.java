import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
/*Emma Chiusano
 * ALA8
 * Date Created: 11 November 2021
 * Last Date Modified: 11 November 2021*/
public class AnimalDB {
	public static void main(String[]args) {
		BST<String> animalBST=new BST<>();
		Heap<String> animalHeap=new Heap<>();
		ArrayList<String> animalAL=new ArrayList<>();
		File file=new File("animals.txt");
		int count=0;
		int totalBST=0;
		int totalHeap=0;
		try {
			Scanner readFile=new Scanner(file);
			System.out.println("Testing add():");
			System.out.println("==============");
			System.out.println("Animal Name\t\t\tBST\t\tHeap");
			while (readFile.hasNextLine()) {
				String line=readFile.nextLine();
				int itBST=animalBST.add(line);
				int itHeap=animalHeap.add(line);
				animalAL.add(line);
				if (count%24==0) {
					System.out.printf("%-25s\t%-10d\t%-10d\n", line, itBST, itHeap);
				}
				count++;
				totalBST+=itBST;
				totalHeap+=itHeap;
			}
			System.out.printf("%-25s\t%-10d\t%-10d\n", "Average", totalBST/animalAL.size(), totalHeap/animalAL.size());
			System.out.println();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
		//testing contains
		totalBST=0;
		totalHeap=0;
		System.out.println("Testing contains():");
		System.out.println("====================");
		System.out.println("Animal Name\t\t\tBST\t\tHeap");
		for (int i=0; i<20; i++) {
			int index=(int)(Math.random()*animalAL.size());
			String name=animalAL.get(index);
			int itBST=animalBST.contains(name);
			int itHeap=animalHeap.contains(name);
			System.out.printf("%-25s\t%-10d\t%-10d\n", name, itBST, itHeap);
			count++;
			totalBST+=itBST;
			totalHeap+=itHeap;
		}
		System.out.printf("%-25s\t%-10d\t%-10d\n", "Average", totalBST/20, totalHeap/20);
		System.out.println();
		//testing removes
		totalBST=0;
		totalHeap=0;
		System.out.println("Testing remove():");
		System.out.println("==================");
		System.out.println("Animal Name\t\t\tBST\t\tHeap");
		for (int i=0; i<20; i++) {
			int index=(int)(Math.random()*animalHeap.size());
			String name=animalAL.get(index);
			int itBST=animalBST.contains(name);
			int itHeap=animalHeap.contains(name);
			System.out.printf("%-25s\t%-10d\t%-10d\n", name, itBST, itHeap);
			totalBST+=itBST;
			totalHeap+=itHeap;
		}
		System.out.printf("%-25s\t%-10d\t%-10d\n", "Average", totalBST/20, totalHeap/20);
	}
}
/*ALA Question:
 * Compare and discuss the results obtained with the big-O time complexity of the methods
 * contains, add and remove
 * 
 * Average Iterations:
 * Big-O for contains: HEAP: O(n)
 * Big-O for contains: BST: O(n)/O(log n)
 * Big-O for add: HEAP: O(log n)
 * Big-O for add: BST:  O(n)/O(log n)
 * Big-O for remove: HEAP: O(log n)
 * Big-O for remove: BST:  O(n)/O(log n)
 * 
 * Average Iterations:
 * contains: HEAP: 2
 * contains: BST: 9
 * add: HEAP: 190
 * add: BST: 10
 * remove: HEAP: 258
 * remove: BST: 11
 * 
 * Based upon the time complexity and number of iterations above, it makes sense that the
 * add and remove methods for heap require more iterations than those of the BST. This is because
 * O(n) takes a lot longer than O(log n). It appears that, due to the number of iterations, we might
 * be approaching the "worst case" of time complexity in either method. The contains method in both
 * HEAP and BST are iterated the fewest times, which shows that this method does not reach the worst
 * possible case scenario for HEAP or BST.
 * */
