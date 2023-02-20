import java.util.*;

public class ConversionNumberSystem {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        showIntroductionScreen();
        displayPressContinue();
        showSelectionScreen();
    }

    // Menu Screens
    private static void showIntroductionScreen() {
        System.out.println();
        System.out.println("+----------+ Welcome to NUMBER SYSTEM CONVERTER +----------+");
        System.out.println("Program created by:\n   HINGCO, Renier Antony R.\n   PERALTA, Trisha Marie R.\n");
        System.out.println("BS Computer Science\n2nd Year Students of Block 2G\n");
        System.out.println("In Partial Fulfillment for PL 101.1");
        System.out.println("University of Sto. Tomas - Legazpi");
    }

    public static void showSelectionScreen() {
        System.out.println();
        System.out.println("+----------+ Please SELECT an OPTION from the Menu +----------+");
        System.out.println("A - BINARY to Other Number Systems\n" +
                "B - OCTAL to Other Number Systems\n" +
                "C - DECIMAL to Other Number Systems\n" +
                "D - HEXADECIMAL to Other Number Systems\n" +
                "E - TERMINATE the Program");
        System.out.println();

        System.out.print("Selected Option: ");
        String inputChoice = scanner.nextLine();

        switch (inputChoice) {
            case "A":
            case "a":
                validateBinaryInput();
                break;
            case "B":
            case "b":
                validateOctalInput();
                break;
            case "C":
            case "c":
                validateDecimalInput();
                break;
            case "D":
            case "d":
                validateHexadecimalInput();
                break;
            case "E":
            case "e":
                clearScreen();
                displaySystemExitMsg();
                break;
            default:
                clearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println("! INVALID Option Selected.\n   Please try a VALID input.");
                System.out.println();
                showSelectionScreen();
                break;
        }

    }

    public static void showContinueScreen() {
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.println("Would you like to CONTINUE converting other values?");
        System.out.println("A - CONTINUE to Selection Screen\n" +
                "B - TERMINATE the Program");
        System.out.println();

        System.out.print("Selected Option: ");
        String InputChoice = scanner.nextLine();

        switch (InputChoice) {
            case "A":
            case "a":
                clearScreen();
                showSelectionScreen();
                break;
            case "B":
            case "b":
                clearScreen();
                displaySystemExitMsg();
                break;
            default:
                clearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println("! INVALID Option Selected.\n   Please try a VALID input.");
                System.out.println();
                showContinueScreen();
                break;
        }
    }

    // Input Validation Methods for each number system
    public static void validateBinaryInput() {
        clearScreen();
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.print("Enter Binary Value to convert: ");
        String inputBinary = scanner.nextLine();
        boolean validation = true;

        if (inputBinary.isEmpty() || inputBinary.isBlank()) {
            validateBinaryInput();
        } else {
            for (int loop = 0; loop < inputBinary.length(); loop++) {
                char character = inputBinary.charAt(loop);
                if (character != '0'
                        && character != '1'
                        && character != '.') {
                    validation = false;
                    break;
                }
            }

            int countDot = 0;
            for (int loop = 0; loop < inputBinary.length(); loop++) {
                char character = inputBinary.charAt(loop);
                if (character == '.') {
                    countDot++;
                }
            }
            if (countDot > 1) {
                validation = false;
            }

            if (validation) {
                String[] section = inputBinary.split("\\.");
                String integralSection = section[0];
                String fractionalSection = section.length > 1 ? section[1] : "";

                for (int loop = 0; loop < integralSection.length(); loop++) {
                    char character = integralSection.charAt(loop);
                    if (character != '0' && character != '1') {
                        validation = false;
                        break;
                    }
                }

                for (int loop = 0; loop < fractionalSection.length(); loop++) {
                    char character = fractionalSection.charAt(loop);
                    if (character != '0' && character != '1') {
                        validation = false;
                        break;
                    }
                }
            }

            if (validation) {
                double decimalValue = convertBinaryToDecimal(inputBinary);
                String octalValue = convertDecimalToOctal(decimalValue);
                String hexadecimalValue = convertDecimalToHexadecimal(decimalValue);

                clearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println("VALIDATION SUCCESSFUL...");
                System.out.println("Current Binary Value: " + inputBinary);
                displayConversion(inputBinary, octalValue, decimalValue + "", hexadecimalValue);
                showContinueScreen();
            } else {
                clearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println(
                        "! INVALID BINARY NUMBER.\n" +
                                "     Please enter a VALID Binary Number.\n" +
                                "     NOTE: Valid Binary Numbers include - 0 and 1.");
                displayPressContinue();
                validateBinaryInput();
            }
        }
    }

    public static void validateOctalInput() {
        clearScreen();
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.print("Enter Octal Value to convert: ");
        String octalInput = scanner.nextLine();
        boolean validation = true;

        if (octalInput.isEmpty() || octalInput.isBlank()) {
            validateOctalInput();
        } else {

            for (int loop = 0; loop < octalInput.length(); loop++) {
                char character = octalInput.charAt(loop);
                if (character != '.' && (character < '0' || character > '7')) {
                    validation = false;
                    break;
                }
            }

            int countDot = 0;
            for (int loop = 0; loop < octalInput.length(); loop++) {
                char character = octalInput.charAt(loop);
                if (character == '.') {
                    countDot++;
                }
            }
            if (countDot > 1) {
                validation = false;
            }

            if (validation) {
                String[] section = octalInput.split("\\.");
                String integralSection = section[0];
                String fractionalSection = section.length > 1 ? section[1] : "";

                for (int loop = 0; loop < integralSection.length(); loop++) {
                    char character = integralSection.charAt(loop);
                    if (character < '0' || character > '7') {
                        validation = false;
                        break;
                    }
                }

                for (int loop = 0; loop < fractionalSection.length(); loop++) {
                    char character = fractionalSection.charAt(loop);
                    if (character < '0' || character > '7') {
                        validation = false;
                        break;
                    }
                }
            }

            if (validation) {
                double decimalValue = convertOctalToDecimal(octalInput);
                String binaryValue = convertDecimalToBinary(decimalValue);
                String hexadecimalValue = convertDecimalToHexadecimal(decimalValue);

                clearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println("VALIDATION SUCCESSFUL...");
                System.out.println("Current Octal Value: " + octalInput);
                displayConversion(binaryValue, octalInput, decimalValue + "", hexadecimalValue);
                showContinueScreen();
            } else {
                clearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println(
                        "! INVALID OCTAL NUMBER.\n" +
                                "     Please enter a VALID Octal Number.\n" +
                                "     NOTE: Valid Octal Numbers include -\n" +
                                "          0, 1, 2, 3, 4, 5, 6, and 7.");
                displayPressContinue();
                validateOctalInput();
            }
        }
    }

    public static void validateDecimalInput() {
        clearScreen();
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.print("Enter Decimal Value to convert: ");
        String decimalInput = scanner.nextLine();
        boolean validation = true;

        if (decimalInput.isEmpty() || decimalInput.isBlank()) {
            validateDecimalInput();
        } else {

            for (int loop = 0; loop < decimalInput.length(); loop++) {
                char character = decimalInput.charAt(loop);
                if (character != '.' && (character < '0' || character > '9')) {
                    validation = false;
                    break;
                }
            }

            int countDot = 0;
            for (int loop = 0; loop < decimalInput.length(); loop++) {
                char character = decimalInput.charAt(loop);
                if (character == '.') {
                    countDot++;
                }
            }
            if (countDot > 1) {
                validation = false;
            }

            if (validation) {
                String[] section = decimalInput.split("\\.");
                String integralSection = section[0];
                String fractionalSection = section.length > 1 ? section[1] : "";

                for (int loop = 0; loop < integralSection.length(); loop++) {
                    char character = integralSection.charAt(loop);
                    if (character < '0' || character > '9') {
                        validation = false;
                        break;
                    }
                }

                for (int loop = 0; loop < fractionalSection.length(); loop++) {
                    char character = fractionalSection.charAt(loop);
                    if (character < '0' || character > '9') {
                        validation = false;
                        break;
                    }
                }
            }

            if (validation) {
                double decimalValue = Double.parseDouble(decimalInput);
                String binaryValue = convertDecimalToBinary(decimalValue);
                String octalValue = convertDecimalToOctal(decimalValue);
                String hexadecimalValue = convertDecimalToHexadecimal(decimalValue);

                clearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println("VALIDATION SUCCESSFUL...");
                System.out.println("Current Decimal Value: " + decimalInput);
                displayConversion(binaryValue, octalValue, decimalValue + "", hexadecimalValue);
                showContinueScreen();
            } else {
                clearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println(
                        "! INVALID DECIMAL NUMBER.\n" +
                                "     Please enter a VALID Decimal Number.\n" +
                                "     NOTE: Valid Decimal Numbers include - \n" +
                                "          0, 1, 2, 3, 4, 5, 6, 7, 8, and 9.");
                displayPressContinue();
                validateDecimalInput();
            }
        }
    }

    public static void validateHexadecimalInput() {
        clearScreen();
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.print("Enter Hexadecimal Value to convert: ");
        String hexadecimalInput = scanner.nextLine();
        boolean validation = true;

        if (hexadecimalInput.isEmpty() || hexadecimalInput.isBlank()) {
            validateHexadecimalInput();
        } else {

            for (int loop = 0; loop < hexadecimalInput.length(); loop++) {
                char character = hexadecimalInput.charAt(loop);
                if (character != '.' && !((character >= '0'
                        && character <= '9')
                        || (character >= 'A'
                                && character <= 'F')
                        || (character >= 'a'
                                && character <= 'f'))) {
                    validation = false;
                    break;
                }
            }

            int countDot = 0;
            for (int loop = 0; loop < hexadecimalInput.length(); loop++) {
                char character = hexadecimalInput.charAt(loop);
                if (character == '.') {
                    countDot++;
                }
            }
            if (countDot > 1) {
                validation = false;
            }

            if (validation) {
                String[] section = hexadecimalInput.split("\\.");
                String integralSection = section[0];
                String fractionalSection = section.length > 1 ? section[1] : "";

                for (int loop = 0; loop < integralSection.length(); loop++) {
                    char character = integralSection.charAt(loop);
                    if (!((character >= '0'
                            && character <= '9')
                            || (character >= 'A'
                                    && character <= 'F')
                            || (character >= 'a'
                                    && character <= 'f'))) {
                        validation = false;
                        break;
                    }
                }

                for (int i = 0; i < fractionalSection.length(); i++) {
                    char c = fractionalSection.charAt(i);
                    if (!((c >= '0'
                            && c <= '9')
                            || (c >= 'A'
                                    && c <= 'F')
                            || (c >= 'a'
                                    && c <= 'f'))) {
                        validation = false;
                        break;
                    }
                }
            }

            if (validation) {
                double decimalValue = convertHexadecimalToDecimal(hexadecimalInput);
                String binaryValue = convertDecimalToBinary(decimalValue);
                String octalValue = convertDecimalToOctal(decimalValue);

                clearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println("VALIDATION SUCCESSFUL...");
                System.out.println("Current Hexadecimal Value: " + hexadecimalInput);
                displayConversion(binaryValue, octalValue, decimalValue + "", hexadecimalInput);
                showContinueScreen();
            } else {
                clearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println(
                        "! INVALID HEXADECIMAL NUMBER.\n" +
                                "     Please enter a VALID Hexadecimal Number.\n" +
                                "     NOTE: Valid Hexadecimal Numbers include - \n" +
                                "          0, 1, 2, 3, 4, 5, 6, 7, 8, 9,\n" +
                                "          A, B, C, D, E, and F.");
                displayPressContinue();
                validateHexadecimalInput();
            }
        }
    }

    // Other Number Systems to Decimal -- Conversion Methods
    public static double convertBinaryToDecimal(String convertBinary) {
        String[] section = convertBinary.split("\\.");

        String integralSection = section[0];
        String fractionalSection = "0";

        if (section.length > 1) {
            fractionalSection = section[1];
        }
        double integralDecimal = 0;
        for (int loop = 0; loop < integralSection.length(); loop++) {
            int digit = Character.getNumericValue(integralSection.charAt(loop));
            integralDecimal += digit * Math.pow(2, integralSection.length() - loop - 1);
        }

        double fractionalDecimal = 0;
        for (int loop = 0; loop < fractionalSection.length(); loop++) {
            int digit = Character.getNumericValue(fractionalSection.charAt(loop));
            fractionalDecimal += digit * Math.pow(2, -(loop + 1));
        }

        return integralDecimal + fractionalDecimal;
    }

    public static double convertOctalToDecimal(String ConvertOctal) {
        String[] Section = ConvertOctal.split("\\.");
        String integralSection = Section[0];
        String fractionalSection = Section.length > 1 ? Section[1] : "0";

        int integralDecimal = 0;
        int expPower = 0;
        for (int loop = integralSection.length() - 1; loop >= 0; loop--) {
            int digit = Character.getNumericValue(integralSection.charAt(loop));
            integralDecimal += digit * Math.pow(8, expPower);
            expPower++;
        }

        double fractionalDecimal = 0;
        if (!fractionalSection.equals("0")) {
            expPower = -1;
            for (int loop = 0; loop < fractionalSection.length(); loop++) {
                int digit = Character.getNumericValue(fractionalSection.charAt(loop));
                fractionalDecimal += digit * Math.pow(8, expPower);
                expPower--;
            }
        }

        return integralDecimal + fractionalDecimal;
    }

    public static double convertHexadecimalToDecimal(String convertHexadecimal) {
        String[] section = convertHexadecimal.split("\\.");

        int integralDecimal = 0;
        int expPower = 0;
        for (int loop = section[0].length() - 1; loop >= 0; loop--) {
            char digit = section[0].charAt(loop);
            int digitValue = Character.digit(digit, 16);
            integralDecimal += digitValue * Math.pow(16, expPower);
            expPower++;
        }

        double fractionalDecimal = 0;
        if (section.length == 2) {
            expPower = -1;
            for (int loop = 0; loop < section[1].length(); loop++) {
                char digit = section[1].charAt(loop);
                int digitValue = Character.digit(digit, 16);
                fractionalDecimal += digitValue * Math.pow(16, expPower);
                expPower--;
            }
        }

        return integralDecimal + fractionalDecimal;
    }

    // Decimal to Other Number Systems -- Conversion Methods
    public static String convertDecimalToBinary(double convertBase2) {
        String binaryValue = "";

        int integralSection = (int) convertBase2;
        while (integralSection > 0) {
            binaryValue = (integralSection % 2) + binaryValue;
            integralSection /= 2;
        }

        double fractionalSection = convertBase2 - (int) convertBase2;
        if (fractionalSection > 0) {
            binaryValue += ".";
            while (fractionalSection > 0) {
                double product = fractionalSection * 2;
                if (product >= 1) {
                    binaryValue += "1";
                    fractionalSection = product - 1;
                } else {
                    binaryValue += "0";
                    fractionalSection = product;
                }
            }
        }
        return binaryValue;
    }

    public static String convertDecimalToOctal(double ConvertBase8) {
        String octalValue = "";
        int integralSection = (int) ConvertBase8;
        while (integralSection > 0) {
            octalValue = (integralSection % 8) + octalValue;
            integralSection /= 8;
        }
        double fractionalSection = ConvertBase8 - (int) ConvertBase8;
        if (fractionalSection > 0) {
            octalValue += ".";
            for (int temp = 0; temp < 5; temp++) {
                double product = fractionalSection * 8;
                int digit = (int) product;
                octalValue += digit;
                fractionalSection = product - digit;
            }
        }
        return octalValue;
    }

    public static String convertDecimalToHexadecimal(double ConvertBase16) {
        String hexadecimalValue = "";
        int integralSection = (int) ConvertBase16;
        while (integralSection > 0) {
            int remainder = integralSection % 16;
            char hexDigit = (remainder < 10) ? (char) (remainder + '0') : (char) (remainder - 10 + 'A');
            hexadecimalValue = hexDigit + hexadecimalValue;
            integralSection /= 16;
        }

        double fractionalSection = ConvertBase16 - (int) ConvertBase16;
        if (fractionalSection > 0) {
            hexadecimalValue += ".";
            for (int temp = 0; temp < 5; temp++) {
                double product = fractionalSection * 16;
                int digit = (int) product;
                char hexDigit = (digit < 10) ? (char) (digit + '0') : (char) (digit - 10 + 'A');
                hexadecimalValue += hexDigit;
                fractionalSection = product - digit;
            }
        }
        return hexadecimalValue;
    }

    // Display Converted Values
    public static void displayConversion(String binaryValue, String octalValue, String decimalValue,
            String hexadecimalValue) {
        System.out.println();
        System.out.println("+----------+ CONVERSION TABLE for EACH Number System: +----------+");
        System.out.println("BINARY (Base 2)        ==>     " + binaryValue);
        System.out.println("OCTAL (Base 8)         ==>     " + octalValue);
        System.out.println("DECIMAL (Base 10)      ==>     " + decimalValue);
        System.out.println("HEXADECIMAL (Base 16)  ==>     " + hexadecimalValue);
    }

    // Methods for Clearing the Menu
    private static void displaySystemExitMsg() {
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+");
        System.out.println("Conversion has ENDED. \nThe Program will now TERMINATE...\n");
        System.out.println("Thank you for using the \nNUMBER SYSTEM CONVERTER.");
        System.out.println("+----------+ +----------+ +----------+");
        System.out.println();
        System.exit(0);
    }

    private static void displayPressContinue() {
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.println("Press ENTER KEY to continue...");
        try {
            System.in.read();
            scanner.nextLine();
            clearScreen();
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
