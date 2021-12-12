/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author mahmoud
 */
public class animationsinListener implements GLEventListener{
    final static double  ONE_DEGREE = (Math.PI / 180);
    final static double  THREE_SIXTY = 2 * Math.PI;
    GLCanvas glcanvas;
    GLCanvas glc;
   
    
    float red [] = new float [10];
    float green[] = new float [10];
    float blue[] = new float [10];
    int ac =  0;
    animationsinListener(){
        for(int i = 0; i < 10; i ++){
		red [i] = (float)Math.random();
	}

	for(int i = 0; i < 10 ; i ++){
		blue [i] = (float)Math.random();
	}

	for(int i = 0; i < 10 ; i ++){
		green [i] = (float)Math.random();
	}
       
    }
    @Override
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//        gl.glLineWidth(2.0f);
        gl.glPointSize(2.0f);
        gl.glViewport(-250, -350, 250, 350);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 800.0, -250.0, 250.0, -1.0, 1.0);
       }
    public void set_canvas(GLCanvas glcanvas){
     this.glcanvas   = glcanvas;
    }
    @Override
    public void display(GLAutoDrawable gld) {
        
         GL gl = gld.getGL();
         gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        
        
        
        for (int x = 0,i = 0; x < 1000; x += 10,i++) {
            i = i % 10;
            drawCircle(gl, x, (Math.sin((x +ac )/ 60.0) * 100.0) , 25, red[i], green[i], blue[i]);
            drawCircle(gl, x, (Math.sin((x +ac ) / 60.0) * 100.0) , 5, red[i], green[i], blue[i]);
            System.out.println(x+ac + " - - " + Math.sin((x +ac ) / 60.0) * 100.0  );
            }
        
        gl.glEnd();
//        System.out.println(Math.sin((ac)/ 60.0) * 100.0);
        ac+=1;
        
        ac = ac % 380;
        
        glcanvas.repaint();
     }
    
    public void drawCircle(GL gl,double x_c,double y_c, double radius , double red, double green , double blue){
        
        double x,y;
        gl.glColor3f((float)red, (float)green, (float)blue);

        gl.glBegin(GL.GL_LINES);
        for (double a = 0;a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a)) + x_c;
            y = radius * (Math.sin(a)) + y_c;
            gl.glVertex2d(x, y);
        }
       
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
    }
    
}
