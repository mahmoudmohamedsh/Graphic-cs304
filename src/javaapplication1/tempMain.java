/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLDrawableFactory;
import javax.swing.JFrame;

/**
 *
 * @author mahmoud
 */
public class tempMain extends JFrame {
    public static void main(String args []){
        new tempMain();
    }
    public tempMain(){
         //set the JFrame title
        super("temp code for the cs304 ");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        GLDrawableFactory.getFactory();
        glcanvas.addGLEventListener(new quiz1eventListener());
        //add the GLCanvas just like we would any Component
        this.add(glcanvas, BorderLayout.CENTER);
        setSize(500, 700);
        //center the JFrame on the screen
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
