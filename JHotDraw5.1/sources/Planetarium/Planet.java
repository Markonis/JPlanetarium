/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Planetarium;

import CH.ifa.draw.figures.EllipseFigure;
import CH.ifa.draw.standard.RelativeLocator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

/**
 *
 * @author marko
 */
class Planet extends EllipseFigure {

    public static final int maxDiameter = 120;
    
    public Planet(){
        super();
        setAttribute("maxDiameter", new Integer(maxDiameter));
    }
    
    @Override
    public void basicDisplayBox(Point origin, Point corner) {
        int dx = corner.x - origin.x;
        int dy = corner.y - origin.y;
        int size = Math.max(dx, dy);
        
        if(size >= maxDiameter) size = maxDiameter;
        
        corner = new Point(origin.x + size, origin.y + size);
        super.basicDisplayBox(origin, corner);
    }

    @Override
    public void drawBackground(Graphics g) {
        Rectangle r = this.displayBox();
        if(r.width < 40) 
            this.setAttribute("FillColor", Color.yellow);
        else if(r.width < 80)
            this.setAttribute("FillColor", Color.orange);
        else
            this.setAttribute("FillColor", Color.red);
        
        super.drawBackground(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Vector handles() {
        Vector vector = new Vector();
        vector.add(new CenterHandle(this, (RelativeLocator) RelativeLocator.southEast()));
        vector.add(new CenterHandle(this, (RelativeLocator) RelativeLocator.northEast()));
        vector.add(new CenterHandle(this, (RelativeLocator) RelativeLocator.southWest()));
        vector.add(new CenterHandle(this, (RelativeLocator) RelativeLocator.northWest()));
        return vector;
    }
}
