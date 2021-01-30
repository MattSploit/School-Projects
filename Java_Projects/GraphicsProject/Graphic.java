import java.awt.*;

public class Graphic{
    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(300,200);
        Graphics pen = panel.getGraphics();
        pen.setColor(Color.green);
        pen.fillRect(0,25,200,150);
        pen.setColor(Color.black);
        pen.drawRect(50,25,200,150);
        pen.setColor(Color.red);
        pen.fillOval(75,25,150,150);
        pen.setColor(Color.black);
        pen.drawOval(75,25,150,150);
        pen.setColor(Color.yellow);
        pen.drawLine(50,25,250,175);
        pen.drawLine(250,25,50,175);
        pen.setColor(Color.magenta);
        pen.drawString("Matthew Long",20,20);
    }
}