/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * Ali Albayrak P304320
 */
public class GUI extends JFrame implements ActionListener {
    // creating instance variables; creates a frame,panel,url,htmlfile and two button
    JFrame frame = new JFrame("JFrame");
    JButton button = new JButton("Help");
    JButton button2 = new JButton("Do not Help");
    JPanel panel;
    String url;
    File htmlFile;
   
    GUI(){
        //sets title of frame
        frame.setTitle("JFrame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        // adds actionlistener to button
        button.addActionListener(this);
        //adds button to panel
        panel.add(button);
       // sets frame and its size
        frame.setContentPane(panel);
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        //adds another button to panel
        panel.add(button2);
        //defines the url
        url = "help.html";
        //defines the htmlfile
        htmlFile = new File(url);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //opens the htmlfile when clicked
        try{
        Desktop.getDesktop().browse(htmlFile.toURI());
        System.exit(0);}
        catch(IOException ex){
            System.out.println("IOException occurs: " + ex);
        }
    }
    
    public static void main(String[] args){
        GUI f = new GUI();
    }

   
    
}
