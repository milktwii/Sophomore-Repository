import java.util.*;

public class QuickSort {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        System.out.println("\n+========================================+");
        System.out.println("OPERATIONS MENU for the SORTING ALGORITHM");
        System.out.println("   1. Quick Sorting \n   2. Terminate Program");
        System.out.print("Chosen Option: ");

        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                printQuickArray();
                break;
            case 2:
                clearScreen();
                System.out.println("Thank you for using the system.");
            default:
                System.out.println("Invalid input. Please Try again.");
                MainMenu();
                break;
        }
    }

    public static void printQuickArray() {
        clearScreen();

        // Generate array with random elements
        int[] randArr = randomArray();

        System.out.println("+--------------------------------------+");
        System.out.println("PREVIEWING the UNSORTED ARRAY:");
        displayArray(randArr);

        System.out.println("\n+--------------------------------------+");
        // Sorted array
        quickSort(randArr, 0, (randArr.length - 1));

        System.out.println("PREVIEWING the SORTED ARRAY:");
        displayArray(randArr);
        System.out.println("\n+--------------------------------------+");

    }

    public static int[] randomArray() {
        Random rd = new Random();
        int arrayLength;

        System.out.print("Enter Array Length: ");
        arrayLength = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++)
            arr[i] = rd.nextInt(0, 100);

        return arr;
    }

    public static void displayArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swapt the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    public static void quickSort(int array[], int low, int high) {
        if (low < high) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(array, low, high);

            // recursive call on the left of pivot
            quickSort(array, low, pi - 1);

            // recursive call on the right of pivot
            quickSort(array, pi + 1, high);
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}