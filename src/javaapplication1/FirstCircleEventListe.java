/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author H S
 */
class FirstCircleEventListe implements GLEventListener {

    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;

    @Override
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-250.0, 250.0, -150.0, 150.0, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable drawable) {

        double x, y;
        double radius = 100;
        float red = 0.5f;
        float green = 0.0f;
        float blue = 0.5f;
        GL gl = drawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glColor3f(red, green, blue);

        gl.glBegin(GL.GL_LINES);
        // angle is
        // x = radius * (cosine of angle)
        // y = radius * (sine of angle)
        for (double a = 0;
                a < THREE_SIXTY;
                a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glVertex2d(-100, 0);
        gl.glVertex2d(100, 0);
        gl.glVertex2d(0, 100);
        gl.glVertex2d(-100, 0);
        gl.glVertex2d(0, 100);
        gl.glEnd();
        
    }

    @Override
    public void reshape(GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height) {

    }

    @Override
    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }

}
