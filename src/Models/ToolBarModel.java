/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Views.AboutView;

/**
 *
 * @author afannin1
 */
public class ToolBarModel implements IModel{

    public void exitApplication() {
        System.exit(0);
    }

    public String[] resetFields() { //Maybe needs more?
        String[] resetArray = new String[4];
        return resetArray;
    }

    public void loadAbout() {
        AboutView aView = new AboutView();
        aView.setVisible(true);
    }
    
}
