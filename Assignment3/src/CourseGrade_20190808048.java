package cse_fall_assignments.Assignment3.src;

import java.util.Scanner;

/**
 *
 * @author Muhammed Fatih ÖZDİL
 * @since 24-Dec-2020
 */
public class CourseGrade_20190808048 {

    public static void main(String[] args) {
        
        String[] category = {"QUIZ", "HOMEWORK", "MidTerm exam", "FINAL exam"};
        int[] quantity = {4, 3, 1, 1};
        int[] weight = {10, 20, 30, 40};
        courseGrade(category, quantity, weight);
    }

    public static int displayMenu(String[][] item, Scanner scanner) {
        System.out.println(item[0][0]);
        //shows menu informations
        for (int i = 0; i < item[1].length; i++) {
            System.out.println((i + 1) + " - " + item[1][i]);
        }
        //shows the  exit information
        System.out.println(0 + " - " + item[item.length - 1][0]);
        //take an interge operation number
        int oprNum = scanner.nextInt();
        return oprNum;
    }

    public static void courseGrade(String[] category, int[] quantity,
            int[] weight) {
        //create a scanner object 
        Scanner scanner = new Scanner(System.in);
        
        //makes first letter capitalcase other letters lowercase
        
        //check walid quantity
        for (int i = 0; i < quantity.length; i++) {
            if (!validQuantity(quantity[i])) {
                System.out.println("Error: invalid quantity entered");
                System.exit(0);
            }
        }
        
        //checks valid weight
        int total = 0;
        for (int j = 0; j < weight.length; j++) {

            if (!validWeight(weight[j], total)) {
                System.out.println("Error: invalid weight entered");
                System.exit(0);
            }
            total += weight[j];
        }
        //checks if total weights equals 100
        if (total != 100) {
            System.out.println("ERROR: The values sum to " + total
                    + " but should sum to 100.");
            System.exit(0);
        }
        
        
      //declare menu descriptions as an array
        String[][] description = {
            {
                "PLease enter a choice below"
            },
            {
                "Enter all grades",
                "Change a single grade",
                "Display grade information",},
            {
                "to Exit"
            }};
        
        //creates a two dimension array to 
        //keep grades using quantity and category
        double[][] arr = new double[category.length][];
        for (int i = 0; i < category.length; i++) {
            arr[i] = new double[quantity[i]];
        }
        //assign default value to avoid error
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }
        
        while (true) {
            //display menu and assign return value to oprnum
            int oprNum = displayMenu(description, scanner);
            
            //check oprnum
            if (oprNum == 1) {



                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        //ask for each  category
                        System.out.print("Please enter grade for " +category[i]
                                + " " + (j + 1) + " >> ");
                        //take each grade
                        double check = scanner.nextDouble();
                        //check valid grade
                        if (check > 0 || check < 100) {
                            arr[i][j] = check;
                        } else {
                            System.out.println("Grade must be 0 - 100 "
                                    + "interval");
                        }

                    }
                }
                //make an empty line for visuality
                System.out.println();
            } else if (oprNum == 2) {

                System.out.println("\nPlease enter the category:");
                //shows categories
                for (int i = 0; i < category.length; i++) {
                    System.out.println((i + 1) + " - " + category[i]);

                }
                System.out.println("0 - to Exit");
                //take category number
                int catNum = scanner.nextInt();
                //check  valid catergory number
                if (catNum > category.length || catNum < 0) {
                     System.out.println("invalid choice");
                } else {
                    
                    System.out.println("Please enter which "
                            + category[catNum - 1] + " you would like to  "
                            + "change"
                            + "(1 - " + arr[catNum - 1].length + ") >>");
                    
                    int courseNum = scanner.nextInt();
                    //checks quantity
                    if (courseNum < 1 || courseNum > arr[catNum - 1].length) {
                        System.out.println("invalid choice");
                    } else {
                        System.out.println("The current grade for"
                                + category[catNum - 1] + " is "
                                + arr[catNum - 1][courseNum - 1]);
                        System.out.print("Please enter the new grade value: ");
                        arr[catNum - 1][courseNum - 1] = scanner.nextDouble();
                    }
                }

            } else if (oprNum == 3) {
                System.out.println("Category information:");
                //create new array to keep avrgrade for each catergory
                double[] avrGrade = new double[category.length];
                
                //calculate avr grade 
                for (int i = 0; i < category.length; i++) {
                    double categoryTotal = 0;
                    for (int j = 0; j < arr[i].length; j++) {
                        categoryTotal += arr[i][j];
                    }
                    avrGrade[i] = (categoryTotal / arr[i].length);
                    System.out.println(category[i] + " - " + avrGrade[i]);
                }
                double overall = 0;
                
                //calculate averall grade
                for (int i = 0; i < avrGrade.length; i++) {
                    overall += avrGrade[i] * weight[i] / 100;
                }
                System.out.print("\nOverall Grade - " + overall + "\n"
                        + "Grade Letter - " + gradeLetter(overall) + "\n"
                        + "GPA Points - " + gpaPoints(overall) + "\n"
                        + "Status - " + status(overall) + "\n");
                System.out.println();
            } else if (oprNum == 0) {
                System.out.println("Thank you  for using our system."
                        + " Have a nice day");
                break;

            } else {
                System.out.println("invalid choice");
            }

        }

    }

    public static void capitalize(String[] name) {
        for (int i = 0; i < name.length; i++) {
            name[i] = name[i].substring(0, 1).toUpperCase()
                    + name[i].substring(1).toLowerCase();
        }

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

}
