
package javaapplication1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.swing.JFrame;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.GL;
import javax.swing.*;

public class EventListenerSectionCode extends  JFrame{
    GLCanvas glcanvas = null;
    public EventListenerSectionCode(){
        super("task");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add key and mouse listener
        EventListenerSectionCodeLis lis = new EventListenerSectionCodeLis();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(lis);
        glcanvas.addKeyListener(lis);
        glcanvas.addMouseListener(lis);
        glcanvas.addMouseMotionListener(lis);
        // bass the canvase to lis class
        lis.setGLCanvas(glcanvas);
        this.add(glcanvas, BorderLayout.CENTER);
        setSize(500,300);
        //center the JFrame on the screen
        setLocationRelativeTo(this);
        setVisible(true);
    }
    public static void main(String args []){
        EventListenerSectionCode a = new EventListenerSectionCode();
    }
}

