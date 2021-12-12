package javaapplication1;

import java.awt.*;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLDrawableFactory;
import javax.swing.*;

public class FirstCircle extends JFrame {


    public static void main(String[] args) {
       new FirstCircle();
    }

    public FirstCircle() {
        //set the JFrame title
        super("First Circle Using Sine and Cosine");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        GLDrawableFactory.getFactory();
        glcanvas.addGLEventListener(new FirstCircleEventListe());
        //add the GLCanvas just like we would any Component
        this.add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        //center the JFrame on the screen
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
