import java.util.Scanner;

public class HighSchoolGrades{
    static Scanner gIN = new Scanner(System.in);
    static int gClassSize;
    static double [] gGrades = new double[100];
                                                                                                                
    public static void main(String[] args){
        System.out.println("UTSA - Fall 2020 - CS1083 - Project 2 - written by Matthew Long");
        
        //Gets Class Size
        System.out.print("Please enter the class size : ");                                                                 
        gClassSize = gIN.nextInt();                                                                             

        //Prints Main Menu and Gets option from user, then calls the function according to the option chosen 
        int input;
        do{
           System.out.println("MAIN MENU");
           System.out.println("0 - Exit, 1 - Add/Modify Grade, 2 - Swap Grades, 3 - List, 4 - Report");
           System.out.print("Select an option : ");
           input = gIN.nextInt();
           if(input > 4 | input < 0){
                System.out.println("Value out of range, please try again");
           }else if(input == 0){
                System.out.print("Thank you for using the grades program! Bye!");
           }else if(input == 1){
                addModifyGrade();
           }else if(input == 2){
                swapGrades();
           }else if(input == 3){
                listGrades();
           }else if(input == 4){
                Report();
           }

           System.out.println();
        }while(input != 0);

    } 

    public static void addModifyGrade(){
        int index;
        double grade;

        //Gets Index to be Modified
        do{
        System.out.print("Enter the index (0 to " + (gClassSize-1) + ") : ");
        index = gIN.nextInt();
        if(index < 0 | index > (gClassSize-1)){
            System.out.println("Value out of range, please, try again.");
            continue;
        }
        }while(index < 0 | index > (gClassSize-1));


        //Gets New Grade and Assigns to Index
        do{
        System.out.println("The current value of the grade in index " + index + " is : " + gGrades[index]);
        System.out.print("Enter the grade you want to assign (0.00 - 100.0) : ");
        grade = gIN.nextDouble();
        if(grade < 0.0 | grade > 100.00){
            System.out.println("Value out of range, please, try again.");
        }
        }while(grade < 0.0 | grade > 100.00);
        gGrades[index] = grade;
    }

    public static void swapGrades(){
        int idxFrom;
        int idxTo;
        
        //Gets idxFrom
        do{
            System.out.print("Enter the index (0 to " + (gClassSize-1) + ") : ");
            idxFrom = gIN.nextInt();
            if(idxFrom < 0 | idxFrom > (gClassSize-1)){
                System.out.println("Value out of range, please, try again.");
                continue;
            }
            }while(idxFrom < 0 | idxFrom > (gClassSize-1));

        //Gets idxTo and makes sure its not that same as idxFrom
        do{
            System.out.print("Enter an index (0 to " + (gClassSize-1) + ") that is not " + idxFrom + " : ");
            idxTo = gIN.nextInt();
            if(idxTo < 0 | idxTo > (gClassSize-1)){                                                  
                System.out.println("Value out of range, please, try again.");
                continue;
            }else if(idxTo == idxFrom){
                continue;
            }
        }while(idxTo < 0 | idxTo > (gClassSize-1) | idxTo == idxFrom);
        
        //Swaps the Two Grades Specified Above
        swapValues(idxTo, idxFrom);
    }

    //This is used for the swapGradesFunction - For readability 
    public static void swapValues(int from, int to){
        double temp = gGrades[from];
        gGrades[from] = gGrades[to];
        gGrades[to] = temp;
    }

    public static void listGrades(){
        System.out.println("LIST OF GRADES");
        for(int x = 0; x < gClassSize; ++x){                                                                   
            System.out.println("Grade[" + x + "] : " + gGrades[x]);                                                
        }
    }

    public static void Report(){ //Run each index through the lettergrade method then add 1 to each int letter grade in this method then print out total
        int a=0,b=0,c=0,d=0,f=0;

        //Gets the Number of Grades for Each Letter 
        for(int x = 0; x < gClassSize; ++x){
            if(getGradesLetter(x) == 'A'){
                a+=1;
            }else if(getGradesLetter(x) == 'B'){
                b+=1;
            }else if(getGradesLetter(x) == 'C'){
                c+=1;
            }else if(getGradesLetter(x) == 'D'){
                d+=1;
            }else if(getGradesLetter(x) == 'F'){
                f+=1;
            }
        }

        //Prints Report
        System.out.println("GRADES REPORT");
        System.out.println("A : " + a);
        System.out.println("B : " + b);
        System.out.println("C : " + c);
        System.out.println("D : " + d);
        System.out.println("F : " + f);

    }

    public static char getGradesLetter(int index){
        char letterGrade = 'e';

        if(gGrades[index] >= 90 && gGrades[index] <= 100){
            letterGrade = 'A';
        }else if(gGrades[index] >= 80 && gGrades[index] <= 90){
            letterGrade = 'B';
        }else if(gGrades[index] >= 70 && gGrades[index] <= 80){
            letterGrade = 'C';
        }else if(gGrades[index] >= 60 && gGrades[index] <= 70){
            letterGrade = 'D';
        }else{
            letterGrade = 'F';
        }

        return letterGrade;
    }





}