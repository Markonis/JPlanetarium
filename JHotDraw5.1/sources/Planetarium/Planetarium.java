/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Planetarium;

import CH.ifa.draw.application.DrawApplication;
import CH.ifa.draw.framework.Tool;
import CH.ifa.draw.standard.CreationTool;
import java.awt.Panel;

/**
 *
 * @author marko
 */
public class Planetarium extends DrawApplication {

    @Override
    protected void createTools(Panel palette) {
        super.createTools(palette);
        
        Tool tool = new CreationTool(view(), new Planet());
        palette.add(createToolButton(IMAGES + "ELLIPSE", "Planet tool", tool));
    }
    
    
    public static void main(String[] args) {
        Planetarium window = new Planetarium();
        window.open();
    }
}
