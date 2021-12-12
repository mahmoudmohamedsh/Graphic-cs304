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
 * @author mahmoud
 */
public class tempListener implements GLEventListener{

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
    public void display(GLAutoDrawable glad) {
     }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
    }
    
}
