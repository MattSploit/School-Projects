import java.util.*;
import java.awt.*;


public class Review{
    public static Scanner scnr = new Scanner(System.in);

    public static String question1(String input){
        String output="";
        String month = input.substring(0,2);
        String day = input.substring(3,5);
        String year = input.substring(6,10);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        output = (months[Integer.parseInt(month)-1] + " " + day + ", " + year);
        System.out.println(output);
        return output;
    }

    public static void question2(){
        int[] random = new int[10];
        for(int i = 0; i<random.length; ++i){ 
            random[i] = (int)((100*i)+(Math.random() * 100));
            System.out.println(random[i]);
        }
    }

    public static void question3(double a, double b, double c, boolean flag){
        //boolean true means positive in quadratics equation
        double output;
        if(flag){
            output = ((-b+Math.sqrt(b*b-(4*a*c)))/(2*a));
        }else{
            output = ((-b-Math.sqrt(b*b-(4*a*c)))/(2*a));
        }
        System.out.println("The answer is: " + output);
    }

    public static void question4(){
        String[] plays = {"rock", "paper", "scissors"};
        boolean quit = false;
        int wins = 0;
        int losses = 0;
        int ties = 0;
        int round = 1;
        System.out.println("Welcoms to Rock, Paper, Scissors vs me the computer :)");
        while(!quit){
        System.out.println("Enter Your Play (rock, paper,scissors, or q to quit): ");
        String input = scnr.next().toLowerCase();
        String computerPlay = plays[(int)(Math.random()*3)];
        if(input.equals("q")){
            quit = true;
            break;
        }else if(input.equals(computerPlay)){
            System.out.println("TIE!");
            ties +=1;
        }else if(input.equals("rock") && computerPlay.equals("scissors")){
            System.out.println("You win, I guessed scissors :(");
            wins += 1;
        }else if(input.equals("scissors") && computerPlay.equals("paper")){
            System.out.println("You win, I guessed paper!");
            wins +=1;
        }else if(input.equals("paper") && computerPlay.equals("rock")){
            System.out.println("You win, I quessed a rock.");
            wins +=1;
        }else{
            System.out.println("I win, I guessed " + computerPlay);
            losses +=1;
        }
        round +=1;
        System.out.print("\nRound " + round + "\nRecord:\nWins\tLosses\tTies\n" + wins + "\t" + losses + "\t" + ties + "\n");
        }
        System.out.println("Cya next time.");
    }

    public static void question5(int[][] arr){

        //Gets Sum and outputs it
        int [] sum = new int[arr.length];
        for(int i =0; i<arr.length; ++i){
            for(int j =0; j<arr[i].length; ++j){
                sum[i]+=arr[i][j];
            }
        }
        for(int i = 0; i<sum.length; ++i){
            System.out.println("Sum of row " + i + " is: " + sum[i]);
        }

        //Gets Max of each row and outputs it
        int [] max = new int[arr.length];
        for(int i =0; i<arr.length; ++i){
            max[i] = arr[i][0];
            for(int j = 0; j<arr[i].length; ++j){
                max[i] = (max[i] < arr[i][j]) ? arr[i][j]: max[i];             //Learn this to save time and lives... as in your brain cells:)
            }
        }
        for(int i = 0; i<max.length; ++i){
            System.out.println("The max of row " + i + " is: " + max[i]);
        }

        //Gets Minimum of each row and outputs it
        int[] min = new int[arr.length];
        for(int i = 0; i<arr.length; ++i){
            min[i] = arr[i][0];
            for(int j = 0; j<arr[i].length; ++j){
                min[i] = (min[i] > arr[i][j]) ? arr[i][j] : min[i];
            }
        }
        for(int i = 0; i<min.length; ++i){
            System.out.println("The minimum of row " + i + " is: " + min[i]);
        }

        //Gets Average of each row and outputs it
        double [] avg = new double[arr.length];
        for(int i =0; i<arr.length; ++i){
            avg[i] = sum[i]/arr[i].length;
        }
        for(int i = 0; i<avg.length; ++i){
            System.out.println("The average of row " + i + " is: " + avg[i]);
        }   
    }

    public static void question6(){
        String [][] seasons = new String [][] {
            { "Winter", "Spring", "Summer", "Autumn" },
           { "Inverno", "Primavera", "Estate", "Autunno" },
           { "Hiver", "Printemps", "Été", "Automne" },
           { "Invierno", "Primavera", "Verano", "Otoño" },
           { "Inverno", "Primavera", "Verão", "Outono" }
           };
           int counter = 0;
           int rowCount = 0;
        for(int i = 0; i<(seasons.length*seasons[1].length); ++i){
            if(counter %4 == 0 && counter !=0){
                System.out.println();
                rowCount +=1;
                counter = 0;
            }
            System.out.print(i + "\t" + seasons[rowCount][counter] + "\t");
            counter+=1;
        }
    }

    public static void question12(){
        DrawingPanel panel = new DrawingPanel(500,500);
        Graphics pen = panel.getGraphics();
        System.out.print("Enter x and y coordinates separated by a space (less than 500): ");
        int x = scnr.nextInt();
        int y = scnr.nextInt();
        if(x <= panel.getWidth() && y <= panel.getHeight()){
            pen.setColor(Color.green);
            pen.drawLine(panel.getWidth()/2,panel.getHeight()/2,x,y);
        }else{
            System.out.println("Coordinates too big, cya loser");
        }
    }

    public static void question13(int width, int height){
        DrawingPanel panel = new DrawingPanel(width,height);
        Graphics pen = panel.getGraphics();
        pen.setColor(Color.red);
        pen.fillRect(panel.getWidth()/4,panel.getHeight()/4,width/2, height/2);
        pen.setColor(Color.blue);
        pen.fillOval(width/4, height/4, width/2, height/2);
        pen.setColor(Color.green);
        //For double checking shapes are in the middle
        pen.drawLine(0,0,width,height);
        pen.drawLine(0,height,width,0);


    }
    public static void main(String[] args){
        //question1("11/14/2010");
        //question2();
        //question3(1,12,36,true);
        //question4();
        //int[][] testarr = { { 3, 0, 7, 9 },
        //                    { 2, 1, 0, 1 },
        //                    { 9, 3, 4, 6 } };
        //question5(testarr);
        //question6(); To make the output look like the exam review you need to do alot or just use built in methods not covered in this class so i left it as is... if teacher reading and not running code it will work
        //question12();
        //question13(500,500); //takes input to test code works 
        
        String test = "Words are really cool Words";
        System.out.println(test.lastIndexOf("Words"));

    }





}