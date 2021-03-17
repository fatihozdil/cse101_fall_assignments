package cse_fall_assignments.Assignment4.src;

import java.io.*;
import java.util.*;

public class CourseGrade_20190808048 {

    public static int countCategory(String filename) throws Exception {
        File categoryCount = new File(filename);
        int count = 0;
        try (
                Scanner input = new Scanner(categoryCount);) {
            while (input.hasNext()) {
                input.nextLine();
                count++;
            }
        }
        return count;
    }

    public static int countStudent(String filename) throws Exception {
        File studentCount = new File(filename);
        int count = 0;
        try (
                Scanner input = new Scanner(studentCount);) {
            while (input.hasNext()) {
                input.nextLine();
                count++;
            }
        }
        return count;
    }

    public static void getCategory(String[] category, int[] quantity,
            int[] weight, String filename) throws Exception {
        File catagoryValues = new File(filename);
        int i = 0;
        try (
                Scanner input = new Scanner(catagoryValues);) {
            while (input.hasNext()) {
                String fileCategory = input.next();
                int fileQuantity = input.nextInt();
                int fileWeight = input.nextInt();
                category[i] = fileCategory;
                quantity[i] = fileQuantity;
                weight[i] = fileWeight;
                i++;
            }
        }
    }

    public static void GetStudents(String[] sName, double[][] sGrades,
            String filename) throws Exception {
        File StudentValues = new File(filename);
        int i = 0;
        try (
                Scanner input = new Scanner(StudentValues);) {
            while (input.hasNext()) {
                String name = input.next();

                sName[i] = name;
                int j = 0;
                while (j < sGrades[0].length) {
                    double grades = input.nextDouble();
                    sGrades[i][j] = grades;
                    j++;
                }

                i++;
            }
        }

    }

    public static void writeGrades(String[] student, double[] grade,
            String basefilename) throws Exception {

        for (int i = 0; i < grade.length; i++) {

            if (grade[i] == -1) {
                try (
                        PrintWriter Error = new PrintWriter(basefilename
                                + "_log.txt");) {
                    Error.println("ERROR: Student  " + student[i]
                            + " - cannot calculate due to invalid grade "
                            + "entered");

                }
                continue;

            }
            try (
                    FileOutputStream file
                    = new FileOutputStream(new File(basefilename
                            + "_StudentGrades.txt"), true);
                    PrintWriter results = new PrintWriter(file);) {
                results.println(student[i] + " " + grade[i] + " "
                        + gradeLetter(grade[i]) + " " + gpaPoints(grade[i])
                        + " " + status(grade[i]));

            }
        }
    }

    public static void main(String[] args) throws Exception {
        //create arrays for getcategory
        String[] category = new String[countCategory(args[0]
                + "_CourseDetails.txt")];
        int[] quantity = new int[countCategory(args[0]
                + "_CourseDetails.txt")];
        int[] weight = new int[countCategory(args[0] + "_CourseDetails.txt")];

        getCategory(category, quantity, weight, args[0]
                + "_CourseDetails.txt");
       

        //check valid weight
        int totalWeight = 0;
        for (int i = 0; i < weight.length; i++) {
            //check for negative  weight values
            if (weight[i] <= 0) {
                try (
                        PrintWriter Error = new PrintWriter(args[0]
                                + "_log.txt");) {
                    Error.println("ERROR: Course Details"
                            + " - invalid weight - cannot be negative value");

                }
                System.exit(0);
            }
            //check if total weight is greater than 100
            if ((weight[i] + totalWeight) > 100) {
                try (
                        PrintWriter studentGrades = new PrintWriter(args[0]
                                + "_log.txt");) {
                    studentGrades.println("ERROR: Course Details"
                            + " - invalid weight - Sum cannot be greater "
                            + "than 100");

                }
                System.exit(0);
            }

            totalWeight += weight[i];
        }
        //check if total weight is not equal 100
        if (totalWeight != 100) {
            try (
                    PrintWriter studentGrades = new PrintWriter(args[0]
                            + "_log.txt");) {
                studentGrades.println("ERROR: Course Details"
                        + " - invalid weight -  does not sum to 100 ");

            }
            System.exit(0);
        }
        //check valid quantity
        for (int i = 0; i < quantity.length; i++) {
            if (quantity[i] <= 0) {
                try (
                        PrintWriter studentGrades = new PrintWriter(args[0]
                                + "_log.txt");) {
                    studentGrades.println("ERROR: Course Details - invalid "
                            + "quantity - cannot be negative value");

                }
                System.exit(0);
            }
        }
        
         //get sum of the quantities to create array for grades 
        int sum = 0;
        for (int i = 0; i < quantity.length; i++) {
            sum += quantity[i];
        }
        //create arrays for getStudents
        String[] sName = new String[countStudent(args[0]
                + "_StudentScores.txt")];
        double[][] sGrades = new double[countStudent(args[0]
                + "_StudentScores.txt")][sum];

        GetStudents(sName, sGrades, args[0]
                + "_StudentScores.txt");
        
        
        //create array to get calculated grades for each student
        double[] resultGrade = new double[countStudent(args[0]
                + "_StudentScores.txt")];

        //calculate grades
        for (int i = 0; i < sGrades.length; i++) {
            int j = 0;
            int count = 0;
            //create array to separata grades for each category 
            double[] WeightedGrades = new double[countCategory(args[0]
                    + "_CourseDetails.txt")];
            
            for (int k = 0; k < quantity.length; k++) {
                count += quantity[k];
                for (; j < (count); j++) {
                    if (sGrades[i][j] < 0) {
                        WeightedGrades[k] = -1;
                        break;
                    }
                    WeightedGrades[k] += sGrades[i][j];
                }
                 if (WeightedGrades[k] == -1) {
                       
                        break;
                    }
              WeightedGrades[k] = (WeightedGrades[k] / quantity[k]);
            }
            for (int k = 0; k < WeightedGrades.length; k++) {
                if (WeightedGrades[k]==-1) {
                    resultGrade[i]= -1;
                    break;
                }
                
               resultGrade[i] += (WeightedGrades[k] * weight[k] / 100);
            }

        }

        writeGrades(sName, resultGrade, args[0]);

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
