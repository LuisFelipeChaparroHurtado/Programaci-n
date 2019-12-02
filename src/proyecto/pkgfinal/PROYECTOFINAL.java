/*
 * AUTHOR: LUIS FELIPE CHAPARRO HURTADO
 * DATE: 21 NOVEMBER 2019
 * DESCRIPTION: Program that allows to have salary information 
   (random number between SMLV and SMLV * 4) of each of its N employees 
   for each quarter of the year
 */
package proyecto.pkgfinal;

import java.util.Scanner;
import java.io.PrintWriter;


public class PROYECTOFINAL {

    static int[][] Vector;
    static Scanner Keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            int[] mostSalary = new int[2];
            int[] lessSalary = new int[2];
            int Opt = 6;
            while (Opt != 0) {
                Show_menu();
                Opt = Keyboard.nextInt();
                switch (Opt) {
                    case 1:
                        Vector = Generate_Salary();
                        Generate_Files(Vector);
                        break;
                    case 2:
                        Show_result(Vector);
                    case 3:
                        System.out.println("The employees who earned more than $ 8,000,000 were " + Show_employees_won_most_of_8_millions(Vector));
                        break;
                    case 4:
                        System.out.println("The average salaries per quarter was " + Show_Average_1_Semester(Vector));
                        System.out.println("The average salaries per quarter was " + Show_Average_2_Semester(Vector));
                        System.out.println("The average salaries per quarter was " + Show_Average_3_Semester(Vector));
                        System.out.println("The average salaries per quarter was " + Show_Average_4_Semester(Vector));
                        break;
                    case 5:
                        mostSalary = Show_Employee_won_most(Vector);

                        if (mostSalary != null) {
                            System.out.println("The employee with the highest salary gain in the year was " + mostSalary[0] + " with " + mostSalary[1]);
                        }
                        break;
                    case 6:
                        lessSalary = Show_Employee_won_less(Vector);
                        if (lessSalary != null) {
                            System.out.println("The employee with the highest salary gain in the year was " + lessSalary[0] + " with " + lessSalary[1]);
                        }
                        break;
                }

            }

        } catch (Exception e) {
            System.err.println("Error. Aborted system by error: main(String[] args" + e.toString());
        }
    }

    public static void Show_menu() {
        try {

            System.out.println("\n------SOFTWARE OF AYROLL FOR BOYACA ANCESTRAL FOOD------\n"
                    + "CREATED BY: LUIS FELIPE CHAPARRO HURTADO\n");
            System.out.println("MENU PRINCIPAL:\n"
                    + "1. Generate Database\n"
                    + "2. Display database\n"
                    + "3. Employees who earned more than $ 8,000,000\n"
                    + "4. Average salaries per quarter.\n"
                    + "5. Employee with the highest salary gain in the year.\n"
                    + "6. Employee with lower salary gain in the year\n"
                    + "0. Exit the software\n");

            System.out.println("Select an option");

        } catch (Exception e) {
            System.err.println("Error. Aborted system for error: Show_menu() " + e.toString());
        }
    }

    public static int[][] Generate_Salary() {
        try {

            Scanner Keyboard = new Scanner(System.in);
            System.out.println("How many employees do you want to enter the program?");
            int N = Keyboard.nextInt();
            int[][] Vector = new int[N][4];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 4; j++) {
                    Vector[i][j] = (int) (Math.random() * (3312464 - 828116) + 828116);
                }
            }
            return Vector;
        } catch (Exception e) {
            System.err.println("Error. Aborted system for error: int Generate_Salary () " + e.toString());
            return null;
        }
    }

    public static void Show_result(int[][] Salary) {
        try {
            for (int i = 0; i < Salary.length; i++) {
                System.out.println("\nThe employee: " + (i + 1));
                System.out.println("In the 1° semester won " + Salary[i][0] + " millions of pesos");
                System.out.println("In the 2° semester won " + Salary[i][1] + " millions of pesos");
                System.out.println("In the 3° semester won " + Salary[i][2] + " millions of pesos");
                System.out.println("In the 4° semester won " + Salary[i][3] + " millions of pesos");

                int Total = Salary[i][0] + Salary[i][1] + Salary[i][2] + Salary[i][3];
                System.out.println("\nThe employee " + (i + 1) + " have a salary annual of " + Total);
            }
            
            System.out.println("\nThe employee with the highest salary gain in the year was " +Show_Employee_won_most(Salary)[0]);
            System.out.println("The employee with lower salary gain in the year was " + Show_Employee_won_less(Salary)[0]);
            System.out.println("The average salary for the first quarter was " + Show_Average_1_Semester(Salary));
            System.out.println("The average salary for the second quarter was " + Show_Average_2_Semester(Salary));
            System.out.println("The average salary for the third quarter was " + Show_Average_3_Semester(Salary));
            System.out.println("The average salary for the fourth quarter was " + Show_Average_4_Semester(Salary));

        } catch (Exception e) {

        }
    }

    public static int[] Show_Employee_won_most(int[][] Salary) {
        try {
            int[] Result = new int[2];
            int Max = 0;
            int Person = 0;
            for (int i = 0; i < Salary.length; i++) {
                int Total = Salary[i][0] + Salary[i][1] + Salary[i][2] + Salary[i][3];
                if (i == 0) {
                    Max = Total;
                    Person = i;
                } else if (Total > Max) {
                    Max = Total;
                    Person = i;
                }
            }

            Result[0] = Person + 1;
            Result[1] = Max;
            return Result;

        } catch (Exception e) {
            System.err.println("Error. Aborted system for error: Show_Employee_won_most (int [][] Salary) " + e.toString());
            return null;
        }
    }

    public static int [] Show_Employee_won_less(int[][] Salary) {
        try {
            int[] Result = new int[2];
            int Min = 0;
            int Person = 0;
            for (int i = 0; i < Salary.length; i++) {
                int Total = Salary[i][0] + Salary[i][1] + Salary[i][2] + Salary[i][3];
                if (i == 0) {
                    Min = Total;
                    Person = i;
                } else if (Total < Min) {
                    Min = Total;
                    Person = i;
                }
            }
            Result[0] = Person + 1;
            Result[1] = Min;
            
            return Result;


        } catch (Exception e) {
            System.err.println("Error. Aborted system for error: Show_Employee_won_less (int [][] Salary) " + e.toString());
            return null;
        }
    }

    public static double Show_Average_1_Semester(int[][] Salary) {
        try {
            int Sum = 0;
            for (int i = 0; i < Salary.length; i++) {
                Sum += Salary[i][0];
            }
            double Average = Sum / Salary.length;
            return Average;
        } catch (Exception e) {
            System.err.println("Error. Aborted system for error: Show_Average(int[][] Salary)" + e.toString());
            return 0;
        }
    }

    public static double Show_Average_2_Semester(int[][] Salary) {
        try {
            int Sum = 0;
            for (int i = 0; i < Salary.length; i++) {
                Sum += Salary[i][1];
            }
            double Average = Sum / Salary.length;
            return Average;
        } catch (Exception e) {
            System.err.println("Error. Aborted system for error: Show_Average(int[][] Salary)" + e.toString());
            return 0;
        }
    }

    public static double Show_Average_3_Semester(int[][] Salary) {
        try {
            int Sum = 0;
            for (int i = 0; i < Salary.length; i++) {
                Sum += Salary[i][2];
            }
            double Average = Sum / Salary.length;
            return Average;
        } catch (Exception e) {
            System.err.println("Error. Aborted system for error: Show_Average(int[][] Salary)" + e.toString());
            return 0;
        }
    }

    public static double Show_Average_4_Semester(int[][] Salary) {
        try {
            int Sum = 0;
            for (int i = 0; i < Salary.length; i++) {
                Sum += Salary[i][3];
            }
            double Average = Sum / Salary.length;
            return Average;
        } catch (Exception e) {
            System.err.println("Error. Aborted system for error: Show_Average(int[][] Salary)" + e.toString());
            return 0;
        }
    }

    public static int Show_employees_won_most_of_8_millions(int[][] Salary) {
        try {

            int Most_of_20 = 0;
            for (int i = 0; i < Salary.length; i++) {
                int Total = Salary[i][0] + Salary[i][1] + Salary[i][2] + Salary[i][3];
                if (Total >= 8000000) {
                    Most_of_20 += 1;
                }
            }
            return Most_of_20;
        } catch (Exception e) {
            System.err.println("Error. Aborted system for error: Show_employees_won_most_of_20_millions(int [][] Salary)" + e.toString());
            return 0;

        }
    }

    public static void Generate_Files(int[][] Salary) {
        try {

            PrintWriter Archivo = new PrintWriter("d:/ SALARY_EMPLOYEES.txt", "UTF-8");
            Archivo.println("-----------------SALARY EMPL0YEES------------------\n"
                    + "CREATED BY:LUIS FELIPE CHAPARRO HURTADO\n"
                    + "DATE: 21 NOVEMBER 2019");
            for (int i = 0; i < Salary.length; i++) {
                Archivo.println("\nThe employee: " + (i + 1));
                Archivo.println("In the 1° semester won " + Salary[i][0] + " millions of pesos");
                Archivo.println("In the 2° semester won " + Salary[i][1] + ""
                        + "1 millions of pesos");
                Archivo.println("In the 3° semester won " + Salary[i][2] + " millions of pesos");
                Archivo.println("In the 4° semester won " + Salary[i][3] + " millions of pesos");

                int Total = Salary[i][0] + Salary[i][1] + Salary[i][2] + Salary[i][3];
                Archivo.println("\nThe employee " + (i + 1) + " have a salary annual of " + Total);
            }

            Archivo.println("\nThe employee with the highest salary gain in the year was " +Show_Employee_won_most(Salary)[0]);
            Archivo.println("The employee with lower salary gain in the year was " + Show_Employee_won_less(Salary)[0]);
            Archivo.println("The average salary for the first quarter was " + Show_Average_1_Semester(Salary));
            Archivo.println("The average salary for the second quarter was " + Show_Average_2_Semester(Salary));
            Archivo.println("The average salaries per third was " + Show_Average_3_Semester(Salary));
            Archivo.println("The average salaries per fourth was " + Show_Average_4_Semester(Salary));

            Archivo.println("\nThe employees who earned more than $ 8,000,000 were " + Show_employees_won_most_of_8_millions(Salary));
            Archivo.close();
            System.out.println("Correct and finished process. The txt \"SALARY_EMPLOYEES\" was created and was located in the unit d");
        } catch (Exception e) {
            System.err.println("Error. Aborted system for error: Generate_Files (int [][] Salary)" + e.toString());
        }
    }
}
