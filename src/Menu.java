import java.util.Locale;

public class Menu
{
    static String[] ordinalIndicators = {"st","nd","rd","th","th","th","th"};

    public static int[] getGrades() {
        //Task 1: Registering the grades
        int[] studentsGrades=new int[7];

        for(int i=0;i<studentsGrades.length;i++)
        {
            studentsGrades[i]=IOScanner.inputInt("Enter the score for the " + (i + 1) +  ordinalIndicators[i] + " student ");
            while(studentsGrades[i] > 100 || studentsGrades[i] < 0)
            {
                System.out.print("Error - Input out of bound. Score can only be between 0  and 100.");
                studentsGrades[i]=IOScanner.inputInt("Enter the score for the " + (i + 1) +  ordinalIndicators[i] + " student ");
            }
        }
        System.out.print("\nThank you for your input.");
        return studentsGrades;
    }

    public static void printGrades(int[] studentsGrades) {
        //Task 2: Printing the grades
        System.out.println("\nYour entered scores are:");

        for (int i = 0; i < studentsGrades.length; i++)
        {
            System.out.print(studentsGrades[i]);
            if (i < studentsGrades.length - 1)
            {
                System.out.print(", "); //puts a comma and a space after every score except the last one.
            }
        }
    }

    public static double calculateMean(int[] studentsGrades) {
        // Task 3: Calculating mean
        double gradesSum = 0;

        for(int i = 0; i < studentsGrades.length; i++)
        {
            gradesSum += studentsGrades[i];
        }

        return gradesSum /(double)studentsGrades.length;
    }

    public static void twoHighestANDLowest(int[] studentsGrades) {
        // Task 4: Finding the two highest scores and two lowest scores
        int firstLowest = studentsGrades[0];
        int secondLowest = studentsGrades[0];
        int firstHighest = studentsGrades[0];
        int secondHighest = studentsGrades[0];

        for(int i = 0; i < studentsGrades.length; i++) {
            if(studentsGrades[i] < firstLowest)
            {
                secondLowest = firstLowest;
                firstLowest = studentsGrades[i];
            }
            else if (studentsGrades[i] < secondLowest)
            {
                secondLowest = studentsGrades[i];
            }

            if (studentsGrades[i] > firstHighest) {
                secondHighest = firstHighest;
                firstHighest = studentsGrades[i];
            } else if (studentsGrades[i] > secondHighest) {
                secondHighest = studentsGrades[i];
            }
        }

        System.out.print("\nThe two lowest scores provided are "+ firstLowest+", and "+ secondLowest);
        System.out.print("\nThe two highest scores provided are "+ firstHighest+", and "+ secondHighest);

    }

    public static void highestGrade(int[] studentsGrades) {
        // Task 5: Finding the highest score and its position
        int maxGrade = studentsGrades[0];

        int maxIndex= 0;

        for( int i=1;i< studentsGrades.length;i++) {
            if(maxGrade<studentsGrades[i]) {
                maxGrade=studentsGrades[i];
                maxIndex=i;
            }
        }

        System.out.print("\nThe highest score is " +maxGrade+ " and belongs to the " + (maxIndex+1)+ ordinalIndicators[maxIndex]+ " student");
    }

    public static void collectHashtags() {
        // Task 6: Collecting hashtags from sentence
        String hashtagsFound="";
        String post=IOScanner.inputString("Type your post:");
        String[] wordCheck= post.split(" ");

        for(int i=0;i< wordCheck.length;i++) {
            if(wordCheck[i].startsWith("#")) {
                hashtagsFound=hashtagsFound + " " +wordCheck[i];
            }
        }

        if(hashtagsFound.isEmpty()) {
            System.out.print("\nNo hashtags were typed.");
        } else {
            System.out.print("\nHashtags found:"+hashtagsFound);
        }
    }


    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        // create the array and store the grades inputted by the instructor to use them later for the tasks.
        int[] studentsGrades = getGrades();

        printGrades(studentsGrades);

        // Declaring and initializing the menu array
        String[] menuOptions = new String[]
                {
                        "Register new scores for students.",
                        "Print all registered grades.",
                        "Calculate the mean of the entered scores.",
                        "Find the two highest and two lowest scores.",
                        "Find the highest score and its position.",
                        "Collect hashtags from a post.",
                        "To exit."
                };

        int userChoice=0;

        // looping with while to return the user keep the program running till 7 is chosen
        while(userChoice!=7) {

            System.out.println("\n\nWelcome to the menu. Choose one of the options below:");

            for(int optIndex = 0; optIndex < menuOptions.length; optIndex++)// Looping over the options to display them for the user
            {
                System.out.println( (optIndex+1) +". "+menuOptions[optIndex]);
            }

            userChoice=IOScanner.inputInt("\nType your option: ");

            // Using switch to allow the user to choose an option from the menu
            switch(userChoice)
            {
                case 1 -> {
                    studentsGrades=getGrades();
                    printGrades(studentsGrades);
                }

                case 2 -> printGrades(studentsGrades);

                case 3 -> System.out.printf("The mean of the numbers is %.2f", calculateMean(studentsGrades));

                case 4 -> twoHighestANDLowest(studentsGrades);

                case 5 -> highestGrade(studentsGrades);

                case 6 -> collectHashtags();

                case 7 -> {

                    System.out.print("\nThank you for using our grading system. Have a nice day!");
                    IOScanner.closeScanner();
                }

                default -> System.out.print("Error - Invalid value. Please type between 1 and 7 ");

            }
        }
    }
}