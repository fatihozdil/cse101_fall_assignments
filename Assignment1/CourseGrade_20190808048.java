package cse_fall_assignments.Assignment1;


/**
 *
 * @author Muhammed Fatih ÖZDİL
 * @since 29.10.2020
 */
import java.util.Scanner; //scanner imported

public class CourseGrade_20190808048 {

    public static void main(String[] args) {
        //create a scanner object 
        Scanner input = new Scanner(System.in);
        //prompt the user enter precentages of categories
        System.out.println("Please enter the grading weight(percentages) for "
                + "the following categories:");

        System.out.print("Quizzes: ");
        int Pquizzes = input.nextInt();
        if (Pquizzes < 0) {
            Pquizzes = Pquizzes * (-1);
        }

        System.out.print("Homework: ");
        int Phomework = input.nextInt();
        if (Phomework < 0) {
            Phomework = Phomework * (-1);
        }

        System.out.print("Midterm Exam: ");
        int Pmidterm = input.nextInt();
        if (Pmidterm < 0) {
            Pmidterm = Pmidterm * (-1);
        }

        System.out.print("Final Exam: ");
        int Pfinal = input.nextInt();
        if (Pfinal < 0) {
            Pfinal = Pfinal * (-1);
        }

        int Psum = (Pquizzes + Phomework + Pmidterm + Pfinal);
        if (Psum < 100 || Psum > 100) {
            System.out.println("ERROR: The values sum to " + Psum
                    + " but should sum to 100." );
        } else {

            System.out.println("Please enter the what Muhammed Fatih Özdil "
                    + "earned for each category:");

            System.out.print("Quizzes: ");
            double Quizzes = input.nextDouble();
            Quizzes = Quizzes * Pquizzes / 100;

            System.out.print("Homework: ");
            double Homework = input.nextDouble();
            Homework = Homework * Phomework / 100;

            System.out.print("Midterm Exam: ");
            double Midterm = input.nextDouble();
            Midterm = (Midterm * Pmidterm / 100);

            System.out.print("Final Exam: ");
            double Final = input.nextDouble();
            Final = (Final * Pfinal / 100);
            
            double Sum = (Quizzes + Homework + Midterm + Final);
            String message = "Muhammed Fatih Özdil passed CSE101 with a" +
           " score of ";
            if (Sum >= 88 ) {
                System.out.println(message + Sum + 
                ", GPA points of 4.0 and grade"
                                + " letter of AA");
            } else if  (Sum >= 81) {
                System.out.println(message + Sum + 
                ", GPA points of 3.5 and grade"
                                + " letter of BA");
            }  else if  (Sum >= 74) {
                System.out.println(message + Sum + 
                ", GPA points of 3.0 and grade"
                                + " letter of BB");
            }  else if  (Sum >= 67) {
                System.out.println(message + Sum + 
                ", GPA points of 2.5 and grade"
                                + " letter of CB");
            }  else if  (Sum >= 60) {
                System.out.println(message + Sum + 
                ", GPA points of 2.0 and grade"
                                + " letter of CC");
            }  else if  (Sum >= 53) {
                System.out.println(message + Sum + 
                ", GPA points of 1.5 and grade"
                                + " letter of DC");
            }  else if  (Sum >= 46) {
                System.out.println(message + Sum + 
                ", GPA points of 1.0 and grade"
                                + " letter of DD");
            }  else if  (Sum >= 35) {
                System.out.println(message + Sum +
                 ", GPA points of 0.5 and grade"
                                + " letter of FD");
            }  else if  (Sum >= 0) {
                System.out.println(message + Sum + 
                ", GPA points of 0.0 and grade"
                                + " letter of FF");
            }
        }

    }
}
