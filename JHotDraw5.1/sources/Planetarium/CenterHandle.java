/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Planetarium;

import CH.ifa.draw.figures.EllipseFigure;
import CH.ifa.draw.framework.DrawingView;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.LocatorHandle;
import CH.ifa.draw.standard.RelativeLocator;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author marko
 */
class CenterHandle extends LocatorHandle {
    CenterHandle(EllipseFigure owner, RelativeLocator locator) {
        super(owner, locator);
    }

    @Override
    public void invokeStep (int x, int y, int anchorX, int anchorY, DrawingView view) {
        
        Rectangle r = owner().displayBox();
        Point center = new Point(r.x + r.width / 2, r.y + r.height / 2);
        
        int dist = (int) (Point.distance(center.x, center.y, x, y) / Math.sqrt(2));
        Integer maxDiameter = (Integer) owner().getAttribute("maxDiameter");
        if (maxDiameter != null){
            dist = Math.min(dist, maxDiameter.intValue() / 2);
        }
        
        owner().displayBox(
            new Point(center.x - dist, center.y - dist),
            new Point(center.x + dist, center.y + dist)
        );
    }
}
