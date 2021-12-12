/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author mahmoud
 */
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author H S
 */

public class quiz1eventListener implements GLEventListener{
    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;
    @Override
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//        gl.glLineWidth(2.0f);
        gl.glPointSize(2.0f);
        gl.glViewport(-250, -350, 250, 350);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-250.0, 250.0, -350.0, 350.0, -1.0, 1.0);
        }

    @Override
    public void display(GLAutoDrawable gld) {
       GL gl = gld.getGL();
        double x, y;
        double radius = 50;
        float red;
        float green;
        float blue;
        
        //blue
        red = 0.0f;
        green = 0.2f;
        blue = 0.4f;
        gl.glColor3f(red, green, blue);
        //draw the circle
        gl.glBegin(GL.GL_POINTS);
         for (double a = 0;
                a < THREE_SIXTY;
                a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x, y+50);
        }
        gl.glEnd();
        //red
        red = 1.0f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
        // draw the triangle
        gl.glBegin(GL.GL_LINES);
        //base side
        gl.glVertex2d(-100, 0);
        gl.glVertex2d(100, 0);
        //right
        gl.glVertex2d(100, 0);
        gl.glVertex2d(0, 150);
        //left
        gl.glVertex2d(-100, 0);
        gl.glVertex2d(0, 150);
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable gld, int i, int i1, int i2, int i3) {
        }

    @Override
    public void displayChanged(GLAutoDrawable gld, boolean bln, boolean bln1) {
        }
    
}
