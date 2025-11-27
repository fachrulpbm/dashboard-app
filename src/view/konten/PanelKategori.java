package view.konten;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class PanelKategori extends JPanel {

    public PanelKategori() {
        setLayout(new MigLayout("fill, insets 50", "[grow]", "[grow]"));
        setBackground(Color.WHITE);
        setOpaque(true);

        JLabel label = new JLabel("Panel Kategori Produk");
        label.setFont(new Font("Inter", Font.BOLD, 30));        
        label.setForeground(new Color(51, 51, 51));        

        add(label, "alignx center, aligny center");
    }
    
}
