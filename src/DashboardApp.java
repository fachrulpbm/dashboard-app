import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

// import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import view.FrameUtama;

public class DashboardApp {
    public static void main(String[] args) {
        
        // setupPureFlatLaf();
        // setupCustomFlatLaf();
        setupFullCustomFlatLaf();

        SwingUtilities.invokeLater(() -> {
            new FrameUtama().setVisible(true);
        });

    }

    // private static void setupPureFlatLaf() {
    //     try {
    //         UIManager.setLookAndFeel(new FlatGruvboxDarkHardIJTheme());            
    //     } catch(Exception e) {
    //         System.err.println(e.getMessage());
    //     }
    // }

    // private static void setupCustomFlatLaf() {
    //     try {
    //         UIManager.setLookAndFeel(new FlatMacLightLaf());
            
    //         UIManager.put("Component.accentColor", new Color(131, 188, 160)); // Sage
    //         UIManager.put("Button.default.background", new Color(131, 188, 160));
            
    //     } catch(Exception e) {
    //         System.err.println(e.getMessage());
    //     }
    // }

    private static void setupFullCustomFlatLaf() {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            
            // Sidebar colors
            UIManager.put("Panel.background", new Color(245, 247, 250));
            
            // Menu item colors
            UIManager.put("MenuItem.selectionBackground", new Color(234, 242, 235));
            UIManager.put("MenuItem.selectionForeground", new Color(131, 188, 160));
            UIManager.put("List.selectionBackground", new Color(234, 242, 235));
            UIManager.put("List.selectionForeground", new Color(131, 188, 160));
            
            // Hover colors
            UIManager.put("List.hoverBackground", new Color(224, 230, 235));
            
            // Text colors
            UIManager.put("Label.foreground", new Color(98, 117, 138));

            // Font type
            UIManager.put("defaultFont", new Font("Inter", Font.PLAIN, 14));

            // Heading fonts - Inter Bold
            UIManager.put("h0.font", new Font("Inter", Font.BOLD, 52));
            UIManager.put("h1.font", new Font("Inter", Font.BOLD, 36));
            UIManager.put("h2.font", new Font("Inter", Font.BOLD, 28));
            UIManager.put("h3.font", new Font("Inter", Font.BOLD, 22));
            UIManager.put("h4.font", new Font("Inter", Font.BOLD, 16));
            
            // Size variants - Inter Regular
            UIManager.put("large.font", new Font("Inter", Font.PLAIN, 16));
            UIManager.put("medium.font", new Font("Inter", Font.PLAIN, 14));
            UIManager.put("small.font", new Font("Inter", Font.PLAIN, 12));
            UIManager.put("mini.font", new Font("Inter", Font.PLAIN, 10));
            
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }


}
