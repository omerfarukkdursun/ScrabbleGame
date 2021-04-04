/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabblegame_;

import java.awt.Color;

/**
 *
 * @author omer
 */
public class Kare {

    int x;
    int y;
    int width;
    Color color;
    int id;

    public Kare(int x, int y,Color color ) {

        this.x = x;
        this.y = y;
        this.color = color;
        
    }
     public Kare(int x, int y, int width,Color color,int id) {

        this.x = x;
        this.y = y;
        this.width=width;
        this.color =color;
        this.id=id;
        
    }
    public void setColor(Color color){
    
       this.color = color; 
       
    
    
    }
    

}
