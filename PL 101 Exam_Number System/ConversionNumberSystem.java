import java.util.*;

public class ConversionNumberSystem {
    public static Scanner Scanner = new Scanner(System.in);

    public static void main(String args[]) {
        IntroductionScreen();
        PressKeytoContinue();
        SelectionScreen();
    }

    // Menu Screens
    private static void IntroductionScreen() {
        System.out.println();
        System.out.println("+----------+ Welcome to NUMBER SYSTEM CONVERTER +----------+");
        System.out.println("Program created by:\n   HINGCO, Renier Antony R.\n   PERALTA, Trisha Marie R.\n");
        System.out.println("BS Computer Science\n2nd Year Students of Block 2G\n");
        System.out.println("In Partial Fulfillment for PL 101.1");
        System.out.println("University of Sto. Tomas - Legazpi");
    }

    public static void SelectionScreen() {
        System.out.println();
        System.out.println("+----------+ Please SELECT an OPTION from the Menu +----------+");
        System.out.println("A - BINARY to Other Number Systems\n" +
                "B - OCTAL to Other Number Systems\n" +
                "C - DECIMAL to Other Number Systems\n" +
                "D - HEXADECIMAL to Other Number Systems\n" +
                "E - TERMINATE the Program");
        System.out.println();

        System.out.print("Selected Option: ");
        String InputChoice = Scanner.nextLine();

        switch (InputChoice) {
            case "A":
            case "a":
                BinaryInputValidation();
                break;
            case "B":
            case "b":
                OctalInputValidation();
                break;
            case "C":
            case "c":
                DecimalInputValidation();
                break;
            case "D":
            case "d":
                HexadecimalInputValidation();
                break;
            case "E":
            case "e":
                ClearScreen();
                SystemExitMsg();
                break;
            default:
                ClearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println("! INVALID Option Selected.\n   Please try a VALID input.");
                System.out.println();
                SelectionScreen();
                break;
        }

    }

    public static void ContinueScreen() {
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.println("Would you like to CONTINUE converting other values?");
        System.out.println("A - CONTINUE to Selection Screen\n" +
                "B - TERMINATE the Program");
        System.out.println();

        System.out.print("Selected Option: ");
        String InputChoice = Scanner.nextLine();

        switch (InputChoice) {
            case "A":
            case "a":
                ClearScreen();
                SelectionScreen();
                break;
            case "B":
            case "b":
                ClearScreen();
                SystemExitMsg();
                break;
            default:
                ClearScreen();
                System.out.println();
                System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
                System.out.println("! INVALID Option Selected.\n   Please try a VALID input.");
                System.out.println();
                ContinueScreen();
                break;
        }
    }

    // Input Validation Methods for each number system
    public static void BinaryInputValidation() {
        ClearScreen();
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.print("Enter Binary Value to convert: ");
        String BinaryInput = Scanner.nextLine();
        boolean validation = true;

        for (int loop = 0; loop < BinaryInput.length(); loop++) {
            char character = BinaryInput.charAt(loop);
            if (character != '0'
                    && character != '1'
                    && character != '.') {
                validation = false;
                break;
            }
        }

        int countDot = 0;
        for (int loop = 0; loop < BinaryInput.length(); loop++) {
            char character = BinaryInput.charAt(loop);
            if (character == '.') {
                countDot++;
            }
        }
        if (countDot > 1) {
            validation = false;
        }

        if (validation) {
            String[] section = BinaryInput.split("\\.");
            String IntegralPart = section[0];
            String FractionalPart = section.length > 1 ? section[1] : "";

            for (int loop = 0; loop < IntegralPart.length(); loop++) {
                char character = IntegralPart.charAt(loop);
                if (character != '0' && character != '1') {
                    validation = false;
                    break;
                }
            }

            for (int loop = 0; loop < FractionalPart.length(); loop++) {
                char character = FractionalPart.charAt(loop);
                if (character != '0' && character != '1') {
                    validation = false;
                    break;
                }
            }
        }

        if (validation) {
            double DecimalValue = BinaryToDecimal(BinaryInput);
            String OctalValue = DecimalToOctal(DecimalValue);
            String HexadecimalValue = DecimalToHexadecimal(DecimalValue);

            ClearScreen();
            System.out.println();
            System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
            System.out.println("VALIDATION SUCCESSFUL...");
            System.out.println("Current Binary Value: " + BinaryInput);
            DisplayConversion(BinaryInput, OctalValue, DecimalValue + "", HexadecimalValue);
            ContinueScreen();
        }

        else {
            ClearScreen();
            System.out.println();
            System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
            System.out.println(
                    "! INVALID BINARY NUMBER.\n" +
                            "     Please enter a VALID Binary Number.\n" +
                            "     NOTE: Valid Binary Numbers include - 0 and 1.");
            PressKeytoContinue();
            BinaryInputValidation();
        }
    }

    public static void OctalInputValidation() {
        ClearScreen();
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.print("Enter Octal Value to convert: ");
        String OctalInput = Scanner.nextLine();
        boolean validation = true;

        for (int loop = 0; loop < OctalInput.length(); loop++) {
            char character = OctalInput.charAt(loop);
            if (character != '.' && (character < '0' || character > '7')) {
                validation = false;
                break;
            }
        }

        int countDot = 0;
        for (int loop = 0; loop < OctalInput.length(); loop++) {
            char character = OctalInput.charAt(loop);
            if (character == '.') {
                countDot++;
            }
        }
        if (countDot > 1) {
            validation = false;
        }

        if (validation) {
            String[] section = OctalInput.split("\\.");
            String IntegralValue = section[0];
            String FractionalValue = section.length > 1 ? section[1] : "";

            for (int loop = 0; loop < IntegralValue.length(); loop++) {
                char character = IntegralValue.charAt(loop);
                if (character < '0' || character > '7') {
                    validation = false;
                    break;
                }
            }

            for (int loop = 0; loop < FractionalValue.length(); loop++) {
                char character = FractionalValue.charAt(loop);
                if (character < '0' || character > '7') {
                    validation = false;
                    break;
                }
            }
        }

        if (validation) {
            double DecimalValue = OctalToDecimal(OctalInput);
            String BinaryValue = DecimalToBinary(DecimalValue);
            String HexadecimalValue = DecimalToHexadecimal(DecimalValue);

            ClearScreen();
            System.out.println();
            System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
            System.out.println("VALIDATION SUCCESSFUL...");
            System.out.println("Current Octal Value: " + OctalInput);
            DisplayConversion(BinaryValue, OctalInput, DecimalValue + "", HexadecimalValue);
            ContinueScreen();
        }

        else {
            ClearScreen();
            System.out.println();
            System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
            System.out.println(
                    "! INVALID OCTAL NUMBER.\n" +
                            "     Please enter a VALID Octal Number.\n" +
                            "     NOTE: Valid Octal Numbers include -\n" +
                            "          0, 1, 2, 3, 4, 5, 6, and 7.");
            PressKeytoContinue();
            OctalInputValidation();
        }
    }

    public static void DecimalInputValidation() {
        ClearScreen();
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.print("Enter Decimal Value to convert: ");
        String DecimalInput = Scanner.nextLine();
        boolean validation = true;

        for (int loop = 0; loop < DecimalInput.length(); loop++) {
            char character = DecimalInput.charAt(loop);
            if (character != '.' && (character < '0' || character > '9')) {
                validation = false;
                break;
            }
        }

        int countDot = 0;
        for (int loop = 0; loop < DecimalInput.length(); loop++) {
            char character = DecimalInput.charAt(loop);
            if (character == '.') {
                countDot++;
            }
        }
        if (countDot > 1) {
            validation = false;
        }

        if (validation) {
            String[] section = DecimalInput.split("\\.");
            String IntegralValue = section[0];
            String FractionalValue = section.length > 1 ? section[1] : "";

            for (int loop = 0; loop < IntegralValue.length(); loop++) {
                char character = IntegralValue.charAt(loop);
                if (character < '0' || character > '9') {
                    validation = false;
                    break;
                }
            }

            for (int loop = 0; loop < FractionalValue.length(); loop++) {
                char character = FractionalValue.charAt(loop);
                if (character < '0' || character > '9') {
                    validation = false;
                    break;
                }
            }
        }

        if (validation) {
            double DecimalValue = Double.parseDouble(DecimalInput);
            String BinaryValue = DecimalToBinary(DecimalValue);
            String OctalValue = DecimalToOctal(DecimalValue);
            String HexadecimalValue = DecimalToHexadecimal(DecimalValue);

            ClearScreen();
            System.out.println();
            System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
            System.out.println("VALIDATION SUCCESSFUL...");
            System.out.println("Current Decimal Value: " + DecimalInput);
            DisplayConversion(BinaryValue, OctalValue, DecimalValue + "", HexadecimalValue);
            ContinueScreen();
        }

        else {
            ClearScreen();
            System.out.println();
            System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
            System.out.println(
                    "! INVALID DECIMAL NUMBER.\n" +
                            "     Please enter a VALID Decimal Number.\n" +
                            "     NOTE: Valid Decimal Numbers include - \n" +
                            "          0, 1, 2, 3, 4, 5, 6, 7, 8, and 9.");
            PressKeytoContinue();
            DecimalInputValidation();
        }
    }

    public static void HexadecimalInputValidation() {
        ClearScreen();
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.print("Enter Hexadecimal Value to convert: ");
        String HexadecimalInput = Scanner.nextLine();
        boolean validation = true;

        for (int loop = 0; loop < HexadecimalInput.length(); loop++) {
            char character = HexadecimalInput.charAt(loop);
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
        for (int loop = 0; loop < HexadecimalInput.length(); loop++) {
            char character = HexadecimalInput.charAt(loop);
            if (character == '.') {
                countDot++;
            }
        }
        if (countDot > 1) {
            validation = false;
        }

        if (validation) {
            String[] section = HexadecimalInput.split("\\.");
            String IntegralPart = section[0];
            String FractionalPart = section.length > 1 ? section[1] : "";

            for (int loop = 0; loop < IntegralPart.length(); loop++) {
                char character = IntegralPart.charAt(loop);
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

            for (int i = 0; i < FractionalPart.length(); i++) {
                char c = FractionalPart.charAt(i);
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
            double DecimalValue = HexadecimalToDecimal(HexadecimalInput);
            String BinaryValue = DecimalToBinary(DecimalValue);
            String OctalValue = DecimalToOctal(DecimalValue);

            ClearScreen();
            System.out.println();
            System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
            System.out.println("VALIDATION SUCCESSFUL...");
            System.out.println("Current Hexadecimal Value: " + HexadecimalInput);
            DisplayConversion(BinaryValue, OctalValue, DecimalValue + "", HexadecimalInput);
            ContinueScreen();
        }

        else {
            ClearScreen();
            System.out.println();
            System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
            System.out.println(
                    "! INVALID HEXADECIMAL NUMBER.\n" +
                            "     Please enter a VALID Hexadecimal Number.\n" +
                            "     NOTE: Valid Hexadecimal Numbers include - \n" +
                            "          0, 1, 2, 3, 4, 5, 6, 7, 8, 9,\n" +
                            "          A, B, C, D, E, and F.");
            PressKeytoContinue();
            HexadecimalInputValidation();
        }
    }

    // Other Number Systems to Decimal -- Conversion Methods
    public static double BinaryToDecimal(String ConvertBinary) {
        String[] Section = ConvertBinary.split("\\.");

        String IntegralValue = Section[0];
        String FractionalValue = "0";

        if (Section.length > 1) {
            FractionalValue = Section[1];
        }
        double IntegralValue_Decimal = 0;
        for (int temp = 0; temp < IntegralValue.length(); temp++) {
            int digit = Character.getNumericValue(IntegralValue.charAt(temp));
            IntegralValue_Decimal += digit * Math.pow(2, IntegralValue.length() - temp - 1);
        }

        double FractionalValue_Decimal = 0;
        for (int temp = 0; temp < FractionalValue.length(); temp++) {
            int digit = Character.getNumericValue(FractionalValue.charAt(temp));
            FractionalValue_Decimal += digit * Math.pow(2, -(temp + 1));
        }

        return IntegralValue_Decimal + FractionalValue_Decimal;
    }

    public static double OctalToDecimal(String ConvertOctal) {
        String[] Section = ConvertOctal.split("\\.");
        String IntegralValue = Section[0];
        String FractionalValue = Section.length > 1 ? Section[1] : "0";

        int IntegralValue_Decimal = 0;
        int ExpPower = 0;
        for (int i = IntegralValue.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(IntegralValue.charAt(i));
            IntegralValue_Decimal += digit * Math.pow(8, ExpPower);
            ExpPower++;
        }

        double FractionalValue_Decimal = 0;
        if (!FractionalValue.equals("0")) {
            ExpPower = -1;
            for (int i = 0; i < FractionalValue.length(); i++) {
                int Digit = Character.getNumericValue(FractionalValue.charAt(i));
                FractionalValue_Decimal += Digit * Math.pow(8, ExpPower);
                ExpPower--;
            }
        }

        return IntegralValue_Decimal + FractionalValue_Decimal;
    }

    public static double HexadecimalToDecimal(String ConvertHexadecimal) {
        String[] section = ConvertHexadecimal.split("\\.");

        int IntegralValue_Decimal = 0;
        int ExpPower = 0;
        for (int i = section[0].length() - 1; i >= 0; i--) {
            char digit = section[0].charAt(i);
            int digitValue = Character.digit(digit, 16);
            IntegralValue_Decimal += digitValue * Math.pow(16, ExpPower);
            ExpPower++;
        }

        double FractionalValue_Decimal = 0;
        if (section.length == 2) {
            ExpPower = -1;
            for (int i = 0; i < section[1].length(); i++) {
                char digit = section[1].charAt(i);
                int digitValue = Character.digit(digit, 16);
                FractionalValue_Decimal += digitValue * Math.pow(16, ExpPower);
                ExpPower--;
            }
        }

        return IntegralValue_Decimal + FractionalValue_Decimal;
    }

    // Decimal to Other Number Systems -- Conversion Methods
    public static String DecimalToBinary(double ConvertBase2) {
        String BinaryValue = "";

        int IntegralValue = (int) ConvertBase2;
        while (IntegralValue > 0) {
            BinaryValue = (IntegralValue % 2) + BinaryValue;
            IntegralValue /= 2;
        }

        double FractionalValue = ConvertBase2 - (int) ConvertBase2;
        if (FractionalValue > 0) {
            BinaryValue += ".";
            while (FractionalValue > 0) {
                double product = FractionalValue * 2;
                if (product >= 1) {
                    BinaryValue += "1";
                    FractionalValue = product - 1;
                }

                else {
                    BinaryValue += "0";
                    FractionalValue = product;
                }
            }
        }
        return BinaryValue;
    }

    public static String DecimalToOctal(double ConvertBase8) {
        String OctalValue = "";
        int IntegralValue = (int) ConvertBase8;
        while (IntegralValue > 0) {
            OctalValue = (IntegralValue % 8) + OctalValue;
            IntegralValue /= 8;
        }
        double FractionalValue = ConvertBase8 - (int) ConvertBase8;
        if (FractionalValue > 0) {
            OctalValue += ".";
            for (int temp = 0; temp < 5; temp++) {
                double product = FractionalValue * 8;
                int digit = (int) product;
                OctalValue += digit;
                FractionalValue = product - digit;
            }
        }
        return OctalValue;
    }

    public static String DecimalToHexadecimal(double ConvertBase16) {
        String HexadecimalValue = "";

        int IntegralValue = (int) ConvertBase16;
        while (IntegralValue > 0) {
            int remainder = IntegralValue % 16;
            char hexDigit = (remainder < 10) ? (char) (remainder + '0') : (char) (remainder - 10 + 'A');
            HexadecimalValue = hexDigit + HexadecimalValue;
            IntegralValue /= 16;
        }

        double FractionalValue = ConvertBase16 - (int) ConvertBase16;
        if (FractionalValue > 0) {
            HexadecimalValue += ".";
            for (int temp = 0; temp < 5; temp++) {
                double product = FractionalValue * 16;
                int digit = (int) product;
                char hexDigit = (digit < 10) ? (char) (digit + '0') : (char) (digit - 10 + 'A');
                HexadecimalValue += hexDigit;
                FractionalValue = product - digit;
            }
        }
        return HexadecimalValue;
    }

    // Display Converted Values
    public static void DisplayConversion(String Binary_Value, String Octal_Value, String Decimal_Value,
            String Hexadecimal_Value) {
        System.out.println();
        System.out.println("+----------+ CONVERSION TABLE for EACH Number System: +----------+");
        System.out.println("BINARY (Base 2)        ==>     " + Binary_Value);
        System.out.println("OCTAL (Base 8)         ==>     " + Octal_Value);
        System.out.println("DECIMAL (Base 10)      ==>     " + Decimal_Value);
        System.out.println("HEXADECIMAL (Base 16)  ==>     " + Hexadecimal_Value);
    }

    // Methods for Clearing the Menu
    private static void SystemExitMsg() {
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+");
        System.out.println("Conversion has ENDED. \nThe Program will now TERMINATE...\n");
        System.out.println("Thank you for using the \nNUMBER SYSTEM CONVERTER.");
        System.out.println("+----------+ +----------+ +----------+");
        System.out.println();
        System.exit(0);
    }

    private static void PressKeytoContinue() {
        System.out.println();
        System.out.println("+----------+ +----------+ +----------+ +----------+ +----------+");
        System.out.println("Press ENTER KEY to continue...");
        try {
            System.in.read();
            Scanner.nextLine();
            ClearScreen();
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void ClearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}