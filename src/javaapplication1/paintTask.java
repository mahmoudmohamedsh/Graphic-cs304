/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mahmoud
 */

public class paintTask extends JFrame  implements ActionListener{
    static GLCanvas glcanvas = null;
    public static ArrayList xList , yList , UnxList , UnyList;
   
    paintTaskLis listener = new paintTaskLis();
    public static void main(String[] args) {
        
       final paintTask app = new paintTask();
// show what we've done
        
        
    }
    

public paintTask() {
//set the JFrame title
        super("KeyListener Example");
//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp = new JPanel();
       
        paintTaskLis mmd = new paintTaskLis();
        JButton jb1 = new JButton("Clear");
        jb1.setActionCommand("Clear");
        jb1.addActionListener(mmd);
        
        
        
        JButton jb2 = new JButton("Undo");
        jb2.setActionCommand("Undo");
        jb2.addActionListener(mmd);
        
        
        JButton jb3 = new JButton("redo");
        jb3.setActionCommand("redo");
        jb3.addActionListener(mmd);
        
        JButton jb4 = new JButton("color");
        jb2.setActionCommand("color");
        jb2.addActionListener(mmd);
       
        
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
        
        getContentPane().add("South",jp);

        
        GLCapabilities glcaps = new GLCapabilities();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(mmd);
        glcanvas.addMouseMotionListener(mmd);
        //we'll want this for our repaint requests
        mmd.setGLCanvas(glcanvas);
        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        //center the JFrame on the screen
        setLocationRelativeTo(this);
        setVisible(true);
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        listener.g = e.getActionCommand();
        glcanvas.repaint();
    }

    
   
}
