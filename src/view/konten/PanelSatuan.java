package view.konten;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class PanelSatuan extends JPanel {
    public PanelSatuan() {
        setLayout(new MigLayout("fill, insets 50", "[grow]", "[grow]"));
        setBackground(UIManager.getColor("Panel.background"));
        setOpaque(true);

        JLabel label = new JLabel("Panel Satuan");
        label.setFont(UIManager.getFont("h1.font"));
        label.setForeground(UIManager.getColor("Label.foreground"));

        add(label, "alignx center, aligny center");
    }
}