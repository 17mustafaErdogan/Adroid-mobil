/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2d;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 *  Ali Albayrak - P304320
 */
public class Java2D extends JFrame {

   Font font = new Font("Arial", Font.BOLD, 24);                // creating a font with declaring the font values
   
    public static void main(String[] args) {
        new Java2D();
    }

    public Java2D() {
        super("Java Oval Example");         // This is our Jframe title
        setSize(400, 300);  // this code sets the size of the jframe box
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // if the x(close) button is clicked, exit this program
        setVisible(true); // shows this program

    }

    @Override
    public void paint(Graphics g) {             // overriden paint() methods with the Graphics parameter
        super.paint(g);                         // use the super class' paint() method for initialisation 
        g.setFont(font);                           // uses the font values declared above
        g.drawString("This is an oval:", 30, 70);       // Draws a String. First part is our string to show. 
                                                        // Second part is x coordinate and third one is y coordinate.
                                                        //We can arrange to position of text by manipulating these values.
        int x = 150;                        // integer values for position and size of oval
        int y = 100;
        int width= 100;
        int height = 150;
        g.drawOval(x,y,width,height);       // draws a oval wirth specific size on the specific position 
    }
}
