package view.menu;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import model.MenuItem;

import net.miginfocom.swing.MigLayout;

public class PanelMenu extends JPanel {

    private final CardLayout cardLayout;
    private final JPanel panelKonten;        
    private JPanel panelSubMenu;
    private JPanel panelJudul;
    private JLabel labelJudul;
    private JLabel labelMenuItem;
    private PanelMenuItem panelMenuItem;
    private PanelMenuItem panelDashboard = null;

    public PanelMenu(List<MenuItem> listDaftarMenuItem, CardLayout cardLayout, JPanel panelKonten) {
        this.cardLayout = cardLayout;
        this.panelKonten = panelKonten;

        initializeUI();  
        buildMenu(listDaftarMenuItem);        
        selectDefaultMenu(); 
    }

    private void initializeUI() {
        setLayout(new MigLayout("fillx, wrap 1, insets 0, gap 0, hidemode 3", "[grow]", ""));                    
        setPreferredSize(new Dimension(280, 0));        
        setBackground(UIManager.getColor("Panel.background"));
        
        panelJudul = new JPanel(new MigLayout("fillx, h 60!, gap 0, insets 10"));
        labelJudul = new JLabel("Judul Aplikasi");
        labelJudul.setFont(UIManager.getFont("h2.font")); // FlatLaf heading font
        labelJudul.setForeground(UIManager.getColor("Label.foreground"));
        panelJudul.add(labelJudul, "center, pushy");
        panelJudul.setBackground(getBackground());
        add(panelJudul, "grow");
        
        add(new JSeparator(), "growx, gaptop 5, gapbottom 5, gapleft 10, gapright 10");
    }

    private void buildMenu(List<MenuItem> listDaftarMenuItem) {
        for (MenuItem menu : listDaftarMenuItem) {
            labelMenuItem = new JLabel(menu.getJudul());
            labelMenuItem.setFont(UIManager.getFont("h4.font"));

            /** Panel Menu Item */
            panelMenuItem = new PanelMenuItem(menu, this);            
            add(panelMenuItem, "growx, wrap, h 37!");       

            /** Panel (Sub) Menu Item */
            if (menu.hasSubMenuItem()) {
                panelSubMenu = panelMenuItem.getPanelCountainerSubMenu();
                add(panelSubMenu, "growx, wrap, gapleft 24, gapright 10, gaptop 5, gapbottom 0");                
                panelSubMenu.setVisible(false);
            }

            add(new JSeparator(), "growx, gaptop 5, gapbottom 5, gapleft 10, gapright 10");  
            
            if ("Dashboard".equals(menu.getJudul())) {
                panelDashboard = panelMenuItem;
            }            
        }
    }

    private void selectDefaultMenu() {
        if (panelDashboard != null) {
            selectMenuItem(panelDashboard);
        }
    }

    public void selectMenuItem(PanelMenuItem clickedPanel) {
        if (panelMenuItem != null && panelMenuItem != clickedPanel) {
            panelMenuItem.setSelectedByParent(false);
        }
        
        clickedPanel.setSelectedByParent(true);
        panelMenuItem = clickedPanel;

        String key = clickedPanel.getContentKey();
        if (key != null) {
            cardLayout.show(panelKonten, key);
        }
    }

}