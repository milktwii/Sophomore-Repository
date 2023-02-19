import java.util.*;

public class SortRandomNumbers {

    static Scanner sc = new Scanner(System.in);
    static int[] array = new int[10];

    public static void main(String[] args) {

        Random random = new Random();
        System.out.println("Random Numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        runChoices();
    }

    public static void runChoices() {

        System.out.println("Would you like to sort the Array? "
                + "\n1. Yes"
                + "\n2. No");

        byte ui = sc.nextByte();
        if (ui == 1) {
            sortOrder();
        } else if (ui == 2) {
            exitConsole();
        }
    }

    public static void sortOrder() {

        System.out.println("-----------------------------------------------");
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        printAscendingOrder();
    }

    public static void printAscendingOrder() {
        System.out.println("Ascending order: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println();
        descendingOrder();
    }

    public static void descendingOrder() {

        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        printDescendingOrder();
    }

    public static void printDescendingOrder() {
        System.out.println("Descending order: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println("\n-----------------------------------------------");
        // print elapsed time
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Elapsed Time: " + time + " milli seconds");
    }

    public static void exitConsole() {
        System.out.println("Thank you!");
        sc.close();
    }
}
