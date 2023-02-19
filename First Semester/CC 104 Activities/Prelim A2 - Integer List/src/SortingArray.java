import java.util.*;

public class SortingArray {
    public static void main(String[] args) {
        Choices();
    }

    public static void Choices() {
        Scanner scan = new Scanner(System.in);
        System.out.println("       GENERATE A RANDOM NUMBER        ");
        System.out.println("         SELECT AN UPPERBOUND          ");

        System.out.println(
                "A - Up to Ninety-Nine (99) \nB - Up to Nine (9)");

        String choice = scan.nextLine();

        switch (choice) {
            case "A":
            case "a":
                RandomToNineNine();
                break;

            case "B":
            case "b":
                RandomToNine();
                break;

            default:
                System.out.println("INVALID. TRY AGAIN.");
                System.out.println("=======================================");
                Choices();
        }
        scan.close();
    }

    public static void RandomToNineNine() {
        Random random = new Random();
        int upperbound = 100;

        System.out.println("=======================================");
        System.out.println("           10 RANDOM NUMBERS           ");

        ArrayList<Integer> ninenine_numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int random_ninenine = random.nextInt(upperbound);

            while (ninenine_numbers.contains(random_ninenine))
                random_ninenine = random.nextInt(upperbound);

            ninenine_numbers.add(random_ninenine);
        }
        System.out.println(ninenine_numbers);
        System.out.println("=======================================");
        System.out.println();

        System.out.println("=======================================");
        System.out.println("            ASCENDING ORDER            ");
        Collections.sort(ninenine_numbers);
        System.out.println(ninenine_numbers);
        System.out.println("=======================================");
        System.out.println();

        System.out.println("=======================================");
        System.out.println("           DESCENDING ORDER            ");
        Collections.sort(ninenine_numbers, Collections.reverseOrder());
        System.out.println(ninenine_numbers);
        System.out.println("=======================================");
        System.out.println();

        System.out.println("=======================================");
        CalculateTime();
        System.out.println("=======================================");
    }

    public static void RandomToNine() {
        Random random = new Random();
        int upperbound = 10;

        System.out.println("=======================================");
        System.out.println("           05 RANDOM NUMBERS           ");

        ArrayList<Integer> nine_numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int random_nine = random.nextInt(upperbound);

            while (nine_numbers.contains(random_nine))
                random_nine = random.nextInt(upperbound);

            nine_numbers.add(random_nine);
        }

        System.out.println(nine_numbers);
        System.out.println("=======================================");
        System.out.println();

        System.out.println("=======================================");
        System.out.println("            ASCENDING ORDER            ");
        Collections.sort(nine_numbers);
        System.out.println(nine_numbers);
        System.out.println("=======================================");
        System.out.println();

        System.out.println("=======================================");
        System.out.println("           DESCENDING ORDER            ");
        Collections.sort(nine_numbers, Collections.reverseOrder());
        System.out.println(nine_numbers);
        System.out.println("=======================================");
        System.out.println();

        System.out.println("=======================================");
        CalculateTime();
        System.out.println("=======================================");
    }

    public static void CalculateTime() {
        long start, end, execution;

        start = System.nanoTime();
        end = System.nanoTime();

        execution = end - start;
        System.out.println("EXECUTION TIME: \n" + execution + " nanoseconds");
    }
}