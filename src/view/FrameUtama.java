package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import model.MenuItem;
import view.konten.PanelDashboard;
import view.konten.PanelKategori;
import view.konten.PanelProduk;
import view.konten.PanelSatuan;
import view.konten.PanelSupplier;
import view.menu.PanelMenu;

import net.miginfocom.swing.MigLayout;

public class FrameUtama extends JFrame {

    private static final int PERCENT_WIDTH_PREFERED = 80;
    private static final int PERCENT_HEIGHT_PREFERED = 80;
    private static final int PERCENT_WIDTH_MIN = 35;
    private static final int PERCENT_HEIGHT_MIN = 50;

    MenuItem menuDashboard;
    MenuItem menuProduk;
    MenuItem menuMasterData;
    List<MenuItem> listDaftarMenuItem;
    
    CardLayout cardLayout;
    JPanel panelKonten;
    PanelMenu panelMenu;    

    public FrameUtama() {
        initializeUI();
        setupPanelKonten();
        setupPanelMenu();
        addPanel();
    }

    private void initializeUI() {
        setTitle("Frame Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setPreferredSize(
            new Dimension(
                (int) screenSize.getWidth() * PERCENT_WIDTH_PREFERED/100,
                (int) screenSize.getHeight() * PERCENT_HEIGHT_PREFERED/100
            )
        );
        setMinimumSize(
            new Dimension(
                (int) screenSize.getWidth() * PERCENT_WIDTH_MIN/100,
                (int) screenSize.getHeight() * PERCENT_HEIGHT_MIN/100
            )
        );
        pack();
        setLocationRelativeTo(null);
        setLayout(new MigLayout(
            "fill, insets 0, gap 0",
            "[224!][grow]",
            "[grow]"
        ));     
    }

    private void setupPanelMenu() {
        listDaftarMenuItem = new ArrayList<>();

        menuDashboard = new MenuItem("Dashboard", "dashboard");
        menuProduk = new MenuItem("Produk");
        menuMasterData = new MenuItem("Master Data");

        menuProduk.addSubMenuItem(new MenuItem("Data Produk", "produk"));
        menuProduk.addSubMenuItem(new MenuItem("Kategori Produk", "kategori"));
        menuMasterData.addSubMenuItem(new MenuItem("Supplier", "supplier"));
        menuMasterData.addSubMenuItem(new MenuItem("Satuan", "satuan"));

        listDaftarMenuItem.add(menuDashboard);
        listDaftarMenuItem.add(menuProduk);
        listDaftarMenuItem.add(menuMasterData);

        panelMenu = new PanelMenu(listDaftarMenuItem, cardLayout, panelKonten);
        panelMenu.setBackground(UIManager.getColor("Panel.background"));
    }

    private void setupPanelKonten() {
        cardLayout = new CardLayout();
        panelKonten = new JPanel(cardLayout);        

        panelKonten.add(new PanelDashboard(), "dashboard");
        panelKonten.add(new PanelProduk(), "produk");
        panelKonten.add(new PanelKategori(), "kategori");
        panelKonten.add(new PanelSupplier(), "supplier");
        panelKonten.add(new PanelSatuan(), "satuan");        
    }

    private void addPanel() {
        add(panelMenu, "growy");
        add(panelKonten, "grow"); 
    }
}
