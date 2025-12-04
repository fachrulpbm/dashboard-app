package view.menu;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import model.MenuItem;

import net.miginfocom.swing.MigLayout;

public class PanelMenuItem extends JPanel {

    private final String contentKey;
    private boolean isSubMenu;
    private boolean selected = false;
    
    private JPanel panelContainerSubMenu;   
    private JLabel labelMenu;    
    private PanelMenuItem panelSubMenuItem;
    private PanelMenu panelMenu;
    
    public PanelMenuItem(MenuItem item, PanelMenu panelMenu) {
        this(item, panelMenu, false);
    }

    private PanelMenuItem(MenuItem item, PanelMenu panelMenu, boolean isSubMenu) {
        this.contentKey = item.getKeyCardLayout();
        this.panelMenu = panelMenu;
        this.isSubMenu = isSubMenu;
        
        initializeUI(item);
        setupEventHandlers();
    }    

    private void initializeUI(MenuItem item) {
        panelContainerSubMenu = new JPanel(
            new MigLayout(
                "fillx, insets 0, gap 0, hidemode 3", 
                "[grow]", 
                ""
            )
        );

        panelContainerSubMenu.setBackground(getBackgroundNormal());
        panelContainerSubMenu.setOpaque(true);

        setLayout(new MigLayout("fill, insets 0, gap 0", "[grow]", "[]"));        
        setBackground(getBackgroundNormal());

        labelMenu = new JLabel();
        labelMenu.setText(item.getJudul());

        labelMenu.setForeground(getTextNormal());

        if (isSubMenu) {
            labelMenu.setFont(UIManager.getFont("medium.font"));
            add(labelMenu, "gapleft 10, grow, pushy, wrap");
        } else {
            labelMenu.setFont(UIManager.getFont("h4.font"));
            add(labelMenu, "gapleft 24, grow, pushy, wrap");
        }    

        for (MenuItem sub : item.getListSubMenuItem()) {
            panelSubMenuItem = new PanelMenuItem(sub, panelMenu, true);
            panelContainerSubMenu.add(panelSubMenuItem, "growx, h 37!, wrap");
        }        
    }

    private void setupEventHandlers() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!selected){
                    setBackground(getBackgroundHover());
                }                    
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!selected){
                    setBackground(getBackgroundNormal());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panelMenu.selectMenuItem(PanelMenuItem.this);
                if (panelContainerSubMenu.getComponentCount() > 0) {
                    boolean visible = panelContainerSubMenu.isVisible();
                    panelContainerSubMenu.setVisible(!visible);
                    revalidate();
                    repaint();
                }
            }
        });
    }

    public void setSelectedByParent(boolean selected) {
        this.selected = selected;
        setBackground(selected ? getBackgroundSelected() : getBackgroundNormal());        
        labelMenu.setForeground(selected ? getTextSelected() : getTextNormal());
    }

    public String getContentKey() {
        return contentKey;
    }

    public JPanel getPanelCountainerSubMenu() {
        return panelContainerSubMenu;
    }

    private Color getBackgroundNormal() {
        return UIManager.getColor("Panel.background");
    }
    
    private Color getBackgroundHover() {
        Color hover = UIManager.getColor("List.hoverBackground");
        return hover != null ? hover : UIManager.getColor("List.selectionInactiveBackground");
    }
    
    private Color getBackgroundSelected() {
        return UIManager.getColor("List.selectionBackground");
    }
    
    private Color getTextNormal() {
        return UIManager.getColor("Label.foreground");
    }
    
    private Color getTextSelected() {
        Color selected = UIManager.getColor("List.selectionForeground");
        return selected != null ? selected : UIManager.getColor("Label.foreground");
    }
    
}