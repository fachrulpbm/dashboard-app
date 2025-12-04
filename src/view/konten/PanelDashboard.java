package view.konten;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class PanelDashboard extends JPanel {

    public PanelDashboard() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new MigLayout("fill, insets 60", "[grow]", "[grow]"));
        setBackground(UIManager.getColor("Panel.background"));
        setOpaque(true);

        JLabel title = new JLabel("Panel Dashboard");
        title.setFont(UIManager.getFont("h0.font")); // Extra large heading
        title.setForeground(UIManager.getColor("Label.foreground"));

        JLabel info = new JLabel("Deskripsi panel dashboard");
        info.setFont(UIManager.getFont("large.font"));
        info.setForeground(UIManager.getColor("Label.disabledForeground"));

        add(title, "alignx center, wrap 30");
        add(info, "alignx center");
    }

}
