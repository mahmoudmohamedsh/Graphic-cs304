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
public class CircleCollisionMain extends JFrame {
    public static void main(String args []){
        new CircleCollisionMain();
    }
    public CircleCollisionMain(){
         //set the JFrame title
        super("CirclesWindow ");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        GLDrawableFactory.getFactory();
        CircleCollisionListener a = new CircleCollisionListener();
        a.set_canvas(glcanvas);
        glcanvas.addGLEventListener(a);
        //add the GLCanvas just like we would any Component
        this.add(glcanvas, BorderLayout.CENTER);
        setSize(500, 500);
        //center the JFrame on the screen
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
