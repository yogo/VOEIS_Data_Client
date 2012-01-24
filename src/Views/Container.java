/*
 * To change this template, choose Tools | Templates
 * and openItem the template in the editor.
 */
package Views;

import Controllers.ToolBarController;
import Controllers.UploadController;
import Models.ToolBarModel;
import Models.UploadModel;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;

/**
 *
 * @author afannin1
 */
public class Container extends JFrame {
    MainView panel = new MainView();
    ToolBarModel tModel = new ToolBarModel();
    UploadModel uModel = new UploadModel();
    //File Menu Members
    JMenuItem openItem = new JMenuItem("Open");
    JMenuItem saveItem = new JMenuItem("Save");
    JMenuItem resetFieldsItem = new JMenuItem("Reset Fields");
    JMenuItem exitItem = new JMenuItem("Exit");
    //Edit Menu Members
    JMenuItem cutItem = new JMenuItem("Cut");
    JMenuItem copyItem = new JMenuItem("Copy");
    JMenuItem pasteItem = new JMenuItem("Paste");
    //Tools Menu Members
    JMenuItem pushItem = new JMenuItem("Push Settings");
    JMenuItem logItem = new JMenuItem("View Push Logs");
    JMenuItem intervalItem = new JMenuItem("Data Interval");
    //Help Menu Members
    JMenuItem helpItem = new JMenuItem("Help");
    JMenuItem aboutItem = new JMenuItem("About");
    
    public Container()
    {
        initComponents();
        ToolBarController tController = new ToolBarController(tModel, panel, this, uModel);
    }

    private void initComponents() throws HeadlessException {
        UploadController uController = new UploadController(uModel, panel);
        setFrame();
    }
    
    private void setFrame() {    
        JFrame frame = new JFrame();   
        frame.setJMenuBar(setMenu());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("VOEIS Data Utility");
        frame.pack();
        frame.setVisible(true);
    }
    
    private JMenuBar setMenu() {
        //File Menu
        JMenu file = new JMenu("File");
        file.add(openItem);
        file.add(saveItem);
        file.add(new JSeparator());
        file.add(resetFieldsItem);
        file.add(new JSeparator());
        file.add(exitItem);
        
        //Edit Menu
        JMenu edit = new JMenu("Edit");
        edit.add(cutItem);
        edit.add(copyItem);
        edit.add(pasteItem);
        
        //Tools Menu
        JMenu tools = new JMenu("Tools");
        tools.add(pushItem);
        tools.add(logItem);
        tools.add(intervalItem);
        
        //Help Menu
        JMenu help = new JMenu("Help");
        help.add(helpItem);
        help.add(new JSeparator());
        help.add(aboutItem);
        
        //Add menus to the menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(file); 
        menuBar.add(edit);
        menuBar.add(tools);
        menuBar.add(help);
        
        return menuBar;
    }
    
    public void setActionListeners(ActionListener al) {
        openItem.setActionCommand("open");
        openItem.addActionListener(al);
        saveItem.setActionCommand("save");
        saveItem.addActionListener(al);
        resetFieldsItem.setActionCommand("reset");
        resetFieldsItem.addActionListener(al);
        exitItem.setActionCommand("exit");
        exitItem.addActionListener(al);
        
        aboutItem.setActionCommand("about");
        aboutItem.addActionListener(al);
    }
}
