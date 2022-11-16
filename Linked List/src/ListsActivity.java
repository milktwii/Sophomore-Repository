import java.util.*;

public class ListsActivity {
	static Scanner scanner = new Scanner(System.in);
	static LinkedList<String> list = new LinkedList<String>();

	public static void main(String[] args) {
		System.out.println("\n+========================================+");
		System.out.println("NOW GENERATING A LINKED LIST...");
		System.out.print("Please Enter the number of Nodes: ");
		String sizeString = scanner.nextLine();

		System.out.println("+--------------------------------------+");
		int listSize = Integer.parseInt(sizeString);
		for (int listIndex = 0; listIndex < listSize; listIndex++) {
			System.out.print("Enter the value of Node " + listIndex + ": ");
			String input = scanner.nextLine();
			list.add(input);
		}
		printList(listSize);
	}

	public static void menu(int size) {
		System.out.println("\n+========================================+");
		System.out.println("OPERATIONS MENU for the LINKED LIST");
		System.out.println(
				"   1. Insert a Node Value \n   2. Delete a Node Value \n   3. Terminate Program");
		System.out.print("Chosen Option: ");
		int choice = scanner.nextInt();
		switch (choice) {
			case 1:
				insertNode(size);
				break;
			case 2:
				deleteNode(size);
				break;
			case 3:
				clearScreen();
				System.out.println("Thank you for using the system.");
				break;
			default:
				System.out.println("Invalid input. Please Try again.");
				menu(size);
		}
	}

	public static void printList(int size) {
		clearScreen();
		System.out.println("\n+--------------------------------------+");
		System.out.println("NOW PREVIEWING CURRENT LIST...");
		for (int listIndex = 0; listIndex < size; listIndex++) {
			System.out.print("Node " + listIndex + ": ");
			System.out.println(list.get(listIndex));
		}
		menu(size);
	}

	public static void insertNode(int size) {
		System.out.println("\n+========================================+");
		System.out.println("NOW INSERTING A NEW NODE...");
		System.out.print("Enter the index where to insert: ");
		int listIndex = scanner.nextInt();

		String tempString = scanner.nextLine();
		System.out.print("Enter the new value of a Node: " + tempString);

		String newValue = scanner.nextLine();
		list.add(listIndex, newValue);

		printList(size + 1);
	}

	public static void deleteNode(int size) {
		System.out.println("+========================================+");
		System.out.println("NOW REMOVING A NODE...");

		System.out.print("Enter the index of the node you want to remove: ");
		int listIndex = scanner.nextInt();
		list.remove(listIndex);

		printList(size - 1);
	}

	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}