/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadragdrop;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

/**
 *
 * Ali Albayrak - P304320
 */
public class JavaDragDrop extends JFrame {
    JTextField field;
    JButton button;
    JButton button1;
    JLabel picture;
    JLabel picture2;
    

   public JavaDragDrop(){
       setTitle("Java Drag & Drop");            // Sets the title
       setLayout(null); // layout management is now manual
       
       //declares button and set size 
       button = new JButton("Button"); 
       button.setBounds(200, 10, 80, 25);
       
       
       //if we want to add another button we can do it like this
       /*
       button1 = new JButton("Button"); 
       button1.setBounds(200, 10, 90, 50);*/
       
       
       // declares a image icon and set its size
       picture = new JLabel();
       picture.setBounds(10,50,160,100);
       picture.setIcon(new ImageIcon("C:\\Users\\aliay\\Documents\\NetBeansProjects\\JavaDragDrop\\image.jpg"));
       
       // declares another image
       picture2 = new JLabel();
       picture2.setBounds(180,50,160,100);
       picture2.setIcon(new ImageIcon("C:\\Users\\aliay\\Documents\\NetBeansProjects\\JavaDragDrop\\image2.jpg"));
       
       
       // declares a mouselistener for dragging images
       MouseListener ml = new MouseListener(){
           @Override
           public void mouseClicked(MouseEvent me) {
               
           }

           @Override
           public void mousePressed(MouseEvent me) {
             JComponent jc = (JComponent)me.getSource();
             TransferHandler th  = jc.getTransferHandler();
             th.exportAsDrag(jc,me,TransferHandler.COPY);
           }

           @Override
           public void mouseReleased(MouseEvent me) {
               
           }

           @Override
           public void mouseEntered(MouseEvent me) {
               
           }

           @Override
           public void mouseExited(MouseEvent me) {
              
           }
           
       };
       
       //declares textfield and set size
       field = new JTextField(); 
       field.setBounds(30, 10, 150, 25);
       
       // implements mouselistener method to pictures
       picture.addMouseListener(ml);
       picture2.addMouseListener(ml);
       
       
       //add button and textfield in JFrame 
       add(button);
       //add(button1);
       add(field);
       // adds pictures
       add(picture);
       add(picture2);
       
       field.setDragEnabled(true); // make in-built DnD enabled.
       
       button.setTransferHandler(new TransferHandler("text")); // text data is transable onto this component
       // icon is transable onto components
       picture.setTransferHandler(new TransferHandler("icon"));
       picture2.setTransferHandler(new TransferHandler("icon"));
       
       //button1.setTransferHandler(new TransferHandler("text"));
       

       // set window size and visibility 
       setSize(350, 200);
       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       setLocationRelativeTo(null); 
       setVisible(true);
   }
    public static void main(String[] args) {
       JavaDragDrop javaDnD = new JavaDragDrop();
    }
    
}
