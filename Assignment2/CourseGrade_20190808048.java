package cse_fall_assignments.Assignment2;


import java.util.Scanner; //scanner imported

/**
 *
 * @author Muhammed Fatih ÖZDİL
 */
public class CourseGrade_20190808048 {


    public static String capitalize(String name) {
        name = name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        return name;
    }

    public static boolean validQuantity(int quantity) {
        if (quantity > 0) {
            return true;
        }
        return false;
    }

    public static boolean validWeight(int weight, int totalWeight) {
        if ((weight >= 0) && ((weight + totalWeight) <= 100)) {
            return true;
        }
        return false;
    }

    public static String gradeLetter(double grade) {
        if (grade >= 88) {
            return "AA";
        } else if (grade >= 81) {
            return "BA";
        } else if (grade >= 74) {
            return "BB";
        } else if (grade >= 67) {
            return "CB";
        } else if (grade >= 60) {
            return "CC";
        } else if (grade >= 53) {
            return "DC";
        } else if (grade >= 46) {
            return "DD";
        } else if (grade >= 35) {
            return "FD";
        } else {
            return "FF";
        }

    }

    public static double gpaPoints(double grade) {
        if (grade >= 88) {
            return 4.0;
        } else if (grade >= 81) {
            return 3.5;
        } else if (grade >= 74) {
            return 3.0;
        } else if (grade >= 67) {
            return 2.5;
        } else if (grade >= 60) {
            return 2.0;
        } else if (grade >= 53) {
            return 1.5;
        } else if (grade >= 46) {
            return 1.0;
        } else if (grade >= 35) {
            return 0.5;
        } else if (grade >= 0) {
            return 0.0;
        }
        return 0;

    }

    public static String status(double grade) {
        if (grade >= 60) {
            return "Passed";
        } else if (grade >= 46) {
            return "Conditionally Passed";
        } else {
            return "Failed";
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // declare int for total weight
        int TotalWeight = 0;
        
        // declare  ints for each category
        int itemNumber1 = 0;
        int itemNumber2 = 0;
        int itemNumber3 = 0;
        int itemNumber4 = 0;

        // declare Strings for each category to be capitalize
        String Capit1lCat1 = null;
        String Capit1lCat2 = null;
        String Capit1lCat3 = null;
        String Capit1lCat4 = null;
        
        // declare int weight for each category 
        int weight1 = 0;
        int weight2 = 0;
        int weight3 = 0;
        int weight4 = 0;

        System.out.println("\n******** Category Information Entry ********"
                + "\n\n");
        
        //With for loop we don't need to type sout for category names 4 times
        for (int i = 1; i < 5; i++) { 
            System.out.print("please enter the name of category " + i
                    + ": ");
            
            /*Using the "switch "and "for" together, the necessary codes 
            for different categories are executed in each loop.and variable 
            assignments are made*/
            switch (i) {
                case 1:
                    String Category1 = scanner.nextLine();
                    Capit1lCat1 = capitalize(Category1);
                    
                    //checks that itemNumber is valid
                    while (true) {
                        System.out.print("Please enter how many items of type "
                                + Capit1lCat1 + " were given: ");
                        itemNumber1 = scanner.nextInt();
                        if (validQuantity(itemNumber1)) {
                            break;
                        }
                    }
                    // checks that weight ia valld 
                    while (true) {
                        System.out.print("please enter the percentage weight"
                                + " of " + Capit1lCat1 + ": ");
                        weight1 = scanner.nextInt();
                        scanner.nextLine();
                        if (validWeight(weight1, TotalWeight)) {
                            TotalWeight += weight1;
                            break;
                        }
                    }
                    break;
                case 2:
                    String Category2 = scanner.nextLine();
                    Capit1lCat2 = capitalize(Category2);
                    while (true) {
                        System.out.print("Please enter how many items of type "
                                + Capit1lCat2 + " were given: ");
                        itemNumber2 = scanner.nextInt();
                        if (validQuantity(itemNumber2)) {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("please enter the percentage weight"
                                + " of " + Capit1lCat2 + ": ");
                        weight2 = scanner.nextInt();
                        scanner.nextLine();
                        if (validWeight(weight2, TotalWeight)) {
                            TotalWeight += weight2;
                            break;
                        }
                    }
                    break;
                case 3:
                    String Category3 = scanner.nextLine();
                    Capit1lCat3 = capitalize(Category3);
                    while (true) {
                        System.out.print("Please enter how many items of type "
                                + Capit1lCat3 + " were given: ");
                        itemNumber3 = scanner.nextInt();
                        if (validQuantity(itemNumber3)) {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("please enter the percentage weight "
                                + "of " + Capit1lCat3 + ": ");
                        weight3 = scanner.nextInt();
                        scanner.nextLine();
                        if (validWeight(weight3, TotalWeight)) {
                            TotalWeight += weight3;
                            break;
                        }
                    }
                    break;
                case 4:
                    String Category4 = scanner.nextLine();
                    Capit1lCat4 = capitalize(Category4);
                    while (true) {
                        System.out.print("Please enter how many items of type "
                                + Capit1lCat4 + " were given: ");
                        itemNumber4 = scanner.nextInt();
                        if (validQuantity(itemNumber4)) {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("please enter the percentage weight "
                                + "of " + Capit1lCat4 + ": ");
                        weight4 = scanner.nextInt();
                        if (validWeight(weight4, TotalWeight)) {
                            TotalWeight += weight4;
                            break;
                        }
                    }
                    break;

            }
        }
        
        if (TotalWeight == 100) {
            System.out.println("\n\n******** Student Grades Entry ********"
                    + "\n");
            System.out.println("Please enter values that the student earned"
                    + " for each item:");
            /*
            Displays 'inputs' as many items as ItemNumber and calculates the 
            total grade
            */
            double Grade1 = 0;
            for (int i = 1; i <= itemNumber1; i++) {
                System.out.print(Capit1lCat1 + " " + i + ": ");
                double value1 = scanner.nextDouble();
                Grade1 += value1;
            }
            double Grade2 = 0;
            for (int i = 1; i <= itemNumber2; i++) {
                System.out.print(Capit1lCat2 + " " + i + ": ");
                double value2 = scanner.nextDouble();
                Grade2 += value2;
            }
            double Grade3 = 0;
            for (int i = 1; i <= itemNumber3; i++) {
                System.out.print(Capit1lCat3 + " " + i + ": ");
                double value3 = scanner.nextDouble();
                Grade3 += value3;
            }
            double Grade4 = 0;
            for (int i = 1; i <= itemNumber4; i++) {
                System.out.print(Capit1lCat4 + " " + i + ": ");
                double value4 = scanner.nextDouble();
                Grade4 += value4;
            }

            System.out.println("\n\n******** Student Results ********" + "\n");
            // calculates average value for each category
            double avr1 = (Grade1 / itemNumber1);
            double avr2 = (Grade2 / itemNumber2);
            double avr3 = (Grade3 / itemNumber3);
            double avr4 = (Grade4 / itemNumber4);
            // calculates weighted average
            double result = ((avr1 * weight1 / 100) + (avr2 * weight2 / 100)
                    + (avr3 * weight3 / 100) + (avr4 * weight4 / 100));
            //results are shown
            System.out.println(Capit1lCat1 + ": " + avr1);
            System.out.println(Capit1lCat2 + ": " + avr2);
            System.out.println(Capit1lCat3 + ": " + avr3);
            System.out.println(Capit1lCat4 + ": " + avr4);
            System.out.println("The student has " + status(result) + " CSE 101"
                    + " with a score of " + result + ", GPA points of "
                    + gpaPoints(result) + ", and a grade letter of "
                    + gradeLetter(result));

        } else {
            System.out.println("ERROR: The values sum to " + TotalWeight
                    + " but should sum to 100.");
        }
        scanner.close();
    }
}
