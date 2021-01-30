import java.util.*;
import java.awt.*;

public class MovingShapes{
    static Scanner scnr = new Scanner(System.in);
    static int numShapes = 20;  //Number of Shapes
    static int shapeMoves;      //How many Times the shapes move
    static String[] shape = new String[numShapes];
    static int[] shapeSize = new int[numShapes];
    static String[] shapeColor = new String[numShapes];
    static int[] shapeDirection = new int[numShapes];
    static int[] shapeSpeed = new int[numShapes];
    static int[] shapeX = new int[numShapes]; 
    static int[] shapeY = new int[numShapes];


    public static void main(String[] args){
        System.out.println("UTSA - Fall 2020 - CS1083 - Project 3 - written by Matthew Long");
        System.out.println();

        System.out.println("Please input width, height of the panel, # of shapes, # of times to move followed by the shape, size, color, direction, and speed of every shape:");
        int width = scnr.nextInt(); //Pixel Width of Panel
        int height = scnr.nextInt();    //Pixel Height of Panel
        numShapes = scnr.nextInt();  
        shapeMoves = scnr.nextInt();
       
        getShapeInformation();
        
        //display panel 
        DrawingPanel panel = new DrawingPanel(width, height);

        //Sets the x and y of all shapes to be centered on the panel
        intialPosition(panel);

        //Displays Shapes Moving on Panel
        showShapesMoving(panel);
    }

    public static void getShapeInformation(){ 
        for(int i = 0; i<numShapes; ++i){
            shape[i] = scnr.next();
            shapeSize[i] = scnr.nextInt();
            shapeColor[i] = scnr.next();
            shapeDirection[i] = scnr.nextInt();
            shapeSpeed[i] = scnr.nextInt();
        }
    }

    //Calculates the intial Posistion of each shape, centuring it on the panel
    public static void intialPosition(DrawingPanel panel){
        for(int i = 0; i<numShapes; ++i){
            shapeX[i] = ((panel.getWidth()/2) - (shapeSize[i])/2);
            shapeY[i] = ((panel.getHeight()/2)- (shapeSize[i])/2);
        }
        showShapes(panel, true);
        panel.sleep(100);
    }

    //Draws Shapes to Panel
    public static void showShapes(DrawingPanel panel, Boolean color){ 
        for(int i = 0; i<numShapes; ++i){
            if(color){
                graphicsSetColor(panel, i);
            }else{   
                setNoColor(panel);
            }

            if(shape[i].equals("Square")){
                showSquare(panel, i, color);
            }
            if(shape[i].equals("Circle")){   
                showCircle(panel, i, color);
            }
        }
    }

    //Relies on showShapes() - sets shape color
    public static void graphicsSetColor(DrawingPanel panel, int i){
        Graphics pen = panel.getGraphics();
        if (shapeColor[i].toUpperCase().equals("RED"))
            pen.setColor(Color.RED);
        else if (shapeColor[i].toUpperCase().equals("BLUE"))
             pen.setColor(Color.BLUE);
        else if (shapeColor[i].toUpperCase().equals("PINK"))
            pen.setColor(Color.PINK);
        else if (shapeColor[i].toUpperCase().equals("YELLOW"))
            pen.setColor(Color.YELLOW);
        else if (shapeColor[i].toUpperCase().equals("GREEN"))
            pen.setColor(Color.GREEN);
        else if (shapeColor[i].toUpperCase().equals("MAGENTA"))
            pen.setColor(Color.MAGENTA);
        else if (shapeColor[i].toUpperCase().equals("ORANGE"))
            pen.setColor(Color.ORANGE);
        else if (shapeColor[i].toUpperCase().equals("DARK_GRAY"))
            pen.setColor(Color.DARK_GRAY);
        else if (shapeColor[i].toUpperCase().equals("LIGHT_GRAY"))
            pen.setColor(Color.LIGHT_GRAY);
        else if (shapeColor[i].toUpperCase().equals("GRAY"))
            pen.setColor(Color.GRAY);
        else
             pen.setColor(Color.BLACK);

    }

    //Relies on showShapes() - sets shape to white
    public static void setNoColor(DrawingPanel panel){
        Graphics pen = panel.getGraphics();
        pen.setColor(Color.white);
    }

    //Draws Squares
    public static void showSquare(DrawingPanel panel, int i, Boolean color){
        Graphics pen = panel.getGraphics();
        pen.fillRect(shapeX[i], shapeY[i], shapeSize[i], shapeSize[i]);
        if(color){   
            pen.setColor(Color.black);
        }
        pen.drawRect(shapeX[i], shapeY[i], shapeSize[i], shapeSize[i]);
    }

    //Draws Circles
    public static void showCircle(DrawingPanel panel, int i, Boolean color){
        Graphics pen = panel.getGraphics();
        pen.fillOval(shapeX[i], shapeY[i], shapeSize[i], shapeSize[i]);
        if(color){   
            pen.setColor(Color.black);
        }
        pen.drawOval(shapeX[i], shapeY[i], shapeSize[i], shapeSize[i]);
    }

    //Moves shapes based on speed and direction 
    public static void showShapesMoving(DrawingPanel panel){
        for(int i=0; i<shapeMoves; ++i){
            showShapes(panel, false);
            changePositions();
            showShapes(panel, true);
            panel.sleep(100);
        }
    }

    //changes positions of shapes based on speed and direction
    public static void changePositions(){
        for(int i = 0; i < numShapes; ++i){
            if(shapeDirection[i]==0){               //Moves Left
                shapeX[i] = shapeX[i]-shapeSpeed[i];
                shapeY[i] = shapeY[i];
            }else if(shapeDirection[i]==2){         //Moves Up
                shapeX[i] = shapeX[i];
                shapeY[i] = shapeY[i]-shapeSpeed[i];
            }else if(shapeDirection[i]==4){         //Moves right
                shapeX[i] = shapeX[i]+shapeSpeed[i];
                shapeY[i] = shapeY[i];
            }else if(shapeDirection[i]==6){         //Moves Down
                shapeX[i] = shapeX[i];
                shapeY[i] = shapeY[i]+shapeSpeed[i];
            }else if(shapeDirection[i]==1){         //Moves 135 degrees
                shapeX[i] = shapeX[i]-shapeSpeed[i];
                shapeY[i] = shapeY[i]-shapeSpeed[i];
            }else if(shapeDirection[i]==3){         //Moves 45 degrees
                shapeX[i] = shapeX[i]+shapeSpeed[i];
                shapeY[i] = shapeY[i]-shapeSpeed[i];
            }else if(shapeDirection[i]==5){         //Moves 315 degrees
                shapeX[i] = shapeX[i]+shapeSpeed[i];
                shapeY[i] = shapeY[i]+shapeSpeed[i];
            }else if(shapeDirection[i]==7){         //Moves 225 degrees
                shapeX[i] = shapeX[i]-shapeSpeed[i];
                shapeY[i] = shapeY[i]+shapeSpeed[i];
            }
        }
    }
}