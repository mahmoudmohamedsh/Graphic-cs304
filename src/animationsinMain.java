/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLDrawableFactory;
import javax.swing.JFrame;

/**
 *
 * @author mahmoud
 */
public class animationsinMain extends JFrame {
    public static void main(String args []){
        new animationsinMain();
    }
    public animationsinMain(){
         //set the JFrame title
        super("temp code for the cs304 ");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        GLDrawableFactory.getFactory();
        animationsinListener a = new animationsinListener();
        a.set_canvas(glcanvas);
        glcanvas.addGLEventListener(a);
        //add the GLCanvas just like we would any Component
        this.add(glcanvas, BorderLayout.CENTER);
        setSize(800, 500);
        //center the JFrame on the screen
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
