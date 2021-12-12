/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author mahmoud
 */
public class CircleCollisionListener implements GLEventListener{
    final static double  ONE_DEGREE = (Math.PI / 180);
    final static double  THREE_SIXTY = 2 * Math.PI;
    //
    double red [];
    double green[];
    double blue[];
    GLCanvas glcanvas;
    int centers_x [];
    int centers_y [];
    
    double centers_x_ac [];
    double centers_y_ac [];
    
    public void set_canvas(GLCanvas glcanvas){
     this.glcanvas   = glcanvas;
    }
    public CircleCollisionListener(){
        red = new double[10];
        green = new double[10];
        blue = new double[10];
        centers_x = new int[10];
        centers_y = new int[10];
        centers_x_ac = new double[10];
        centers_y_ac = new double[10];
        for(int i = 0; i < 10 ; i ++){
		red [i] = Math.random();
	}

	for(int i = 0; i < 10 ; i ++){
		blue [i] = Math.random();
	}

	for(int i = 0; i < 10 ; i ++){
		green [i] = Math.random();
	}
        for(int i = 0; i < 10 ; i ++){
		centers_x [i] = (int) (Math.random() * 400 + 50);
                centers_y [i] = (int) (Math.random() * 400 + 50);
                
	}
        for(int i = 0; i < 10 ; i ++){
		centers_x_ac [i] =  Math.random() >=  .5 ? 1 : -1  ;
                centers_y_ac [i] =  Math.random() >=  .5 ? 1 : -1 ;
                
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
        gl.glOrtho(0, 500.0, 0.0, 500.0, -1.0, 1.0);
       }

    @Override
    public void display(GLAutoDrawable drawable) {
        
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
         for(int i = 0; i < 10 ; i ++){
            drawCircle(gl, centers_x[i],centers_y[i],30, red[i], green[i],blue[i]);
             System.out.println(i + "   "+centers_x[i]+ "   "+centers_y[i]);
            String a = detectCollision(centers_x[i],centers_y[i],30);
            System.out.println(a);
            if(a == "left" || a == "right")
                centers_x_ac[i] = - centers_x_ac[i]; 
            else if(a == "top" || a == "down")
                centers_y_ac[i] = - centers_y_ac[i]; 
                
	}
        for(int i = 0; i < 10 ; i ++){
            
            centers_x[i] = centers_x[i] +  (int)centers_x_ac[i];
            centers_y[i] = centers_y[i] + (int)centers_y_ac[i] ;
            
	}
         glcanvas.repaint();
     }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
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
   
    public static double getDistanceBetween2Point(double x1 , double y1 , double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
    }
    
    public static String detectCollision(double x , double y , double radius){
        double x_top,y_top,x_right,y_right,x_down,y_down,x_left,y_left;
        
        //top at 90 degree
        x_top = radius * (Math.cos(90 * ONE_DEGREE)) + x;
        y_top = radius * (Math.sin(90 * ONE_DEGREE)) + y;
        //right at 0 degree
        x_right = radius * (Math.cos(0 * ONE_DEGREE)) + x;
        y_right = radius * (Math.sin(0 * ONE_DEGREE)) + y;
        //left at 180 degree
        x_left = radius * (Math.cos(180 * ONE_DEGREE)) + x;
        y_left = radius * (Math.sin(180 * ONE_DEGREE))+ y;
        //down at 270 degree
        x_down = radius * (Math.cos(270 * ONE_DEGREE)) + x;
        y_down = radius * (Math.sin(270 * ONE_DEGREE)) + y;
        
        if( x_left < 0)
            return "left";
        if( x_right > 500)
            return "right";
        if( y_down < 0)
            return "down";
        if(y_top > 500)
            return "top";
        return "";
    }
}

