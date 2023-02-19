import java.util.*;

public class NumberList {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> arr = new ArrayList<Integer>();

	public static void main(String[] args) {
		System.out.println("--------------------WELCOME--------------------");
		Choice();
		MethodTime();
	}

	public static void Choice() {
		System.out.println(
				"Choose from the following: \n1 - Ascending\n2 - Descending\n3 - Random generated number/s\n4 - Exit");
		String choice = sc.nextLine().trim();
		if (choice.equals("1")) {
			Ascending();
		} else if (choice.equals("2")) {
			Descending();
		} else if (choice.equals("3")) {
			RandomGenerated();
		} else if (choice.equals("4")) {
			System.out.println("-------Thank you for using this program.-------");
		} else {
			System.out.println("Invalid Input! \n-----------------------------------------------");
			Choice();
		}
	}

	public static void Ascending() {
		System.out.println("-------------------ASCENDING-------------------");
		System.out.println("Enter a value that would not be over 9: ");
		String inputString = sc.nextLine().trim();
		int input = Integer.parseInt(inputString);
		if (input > 9) {
			System.out.println("Input is over 9. Try again!");
			Ascending();
		} else if (input < 0) {
			System.out.println("Input is over 0. Try again!");
			Ascending();
		} else {
			input = input + 1;
			AddArrayList(input);
			System.out.println("The values are: ");
			for (int x = 0; x < input; x++) {
				if (x == 0) {
					System.out.print("{ " + arr.get(x));
				} else if (x == (input - 1)) {
					System.out.print(", " + arr.get(x) + " }");
				} else {
					System.out.print(", " + arr.get(x));
				}
			}
		}
		System.out.println("\n-----------------------------------------------");
	}

	public static void Descending() {
		System.out.println("-------------------DESCENDING------------------");
		System.out.println("Enter a value that would not be over 9: ");
		String inputString = sc.nextLine().trim();
		int input = Integer.parseInt(inputString);
		if (input > 9) {
			System.out.println("Input is over 9. Try again!");
			Descending();
		} else if (input < 0) {
			System.out.println("Input is over 0. Try again!");
			Descending();
		} else {
			input = input + 1;
			AddArrayList(input);
			System.out.println("The values are: ");
			for (int x = (input - 1); x >= 0; x--) {
				if (x == (input - 1)) {
					System.out.print("{ " + arr.get(x));
				} else if (x == 0) {
					System.out.print(", " + arr.get(x) + " }");
				} else {
					System.out.print(", " + arr.get(x));
				}
			}
		}
		System.out.println("\n-----------------------------------------------");
	}

	public static void AddArrayList(int input) {
		for (int x = 0; x < input; x++) {
			arr.add(x);
		}
	}

	public static void RandomGenerated() {
		System.out.println("------------RANDOM GENERATED NUMBERS-----------");
		System.out.println("Enter a value that would not be over 9: ");
		String inputString = sc.nextLine().trim();
		int input = Integer.parseInt(inputString);
		if (input > 9) {
			System.out.println("Input is over 9. Try again!");
			Descending();
		} else if (input < 0) {
			System.out.println("Input is over 0. Try again!");
			Descending();
		} else {
			int min = 0;
			int max = 9;
			for (int x = 0; x < input; x++) {
				int RandomInt = (int) Math.floor(Math.random() * (int) (max - min + 1) + (int) min);
				arr.add(RandomInt);
			}
			for (int x = 0; x < input; x++) {
				if (x == 0) {
					System.out.print("{ " + arr.get(x));
				} else if (x == (input - 1)) {
					System.out.print(", " + arr.get(x) + " }");
				} else {
					System.out.print(", " + arr.get(x));
				}
			}
		}
		System.out.println("\n-----------------------------------------------");
	}

	public static void MethodTime() {
		// get the start time
		long start = System.nanoTime();
		System.out.println("Calculating Method execution time:");
		// get the end time
		long end = System.nanoTime();
		// execution time
		long execution = end - start;
		System.out.println("Execution time: " + execution + " nanoseconds");
	}

}
