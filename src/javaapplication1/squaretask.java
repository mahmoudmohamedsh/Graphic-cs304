
package javaapplication1;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLDrawableFactory;
import javax.swing.JFrame;


public class squaretask extends JFrame{
    public static void main (String args [] ) {
        new squaretask();
    }
     public squaretask() {
        //set the JFrame title
        super("square cubes");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        GLDrawableFactory.getFactory();
        glcanvas.addGLEventListener(new squaretaskeventlist());
        //add the GLCanvas just like we would any Component
        this.add(glcanvas, BorderLayout.CENTER);
        setSize(500, 500);
        //center the JFrame on the screen
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
