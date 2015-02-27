
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Weather Frame is the GUI for the app
 * @author Team 20
 */

public class WeatherFrame extends JFrame {
    private JTextField txtName;
    private JLabel lblGreeting;
    private JRadioButton radBachelors;
    private JRadioButton radMasters;
    private JRadioButton radPhd;

    public WeatherFrame() {
        this.initUI();
    }

    private JPanel createForm() {
        JPanel panel = new JPanel();

        return panel;

    }

    private void initUI() {
        this.setTitle("Team 20 Weather App");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(this.createMenubar());
        this.add(this.createForm());
    }

    private JMenuBar createMenubar() {
        JMenuBar menubar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        mnuFile.setMnemonic(KeyEvent.VK_F);
                JMenuItem mniSave = new JMenuItem("Save");
        mniSave.setMnemonic(KeyEvent.VK_E);
        mniSave.setToolTipText("Save");
        mniSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ;
            }
        });
        mnuFile.add(mniSave);
        JMenuItem mniLoad = new JMenuItem("Load");
        mniLoad.setToolTipText("Load");
        mniLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ;
            }
        });
        mnuFile.add(mniLoad);
        JMenuItem mniFileExit = new JMenuItem("Exit");
        mniFileExit.setMnemonic(KeyEvent.VK_E);
        mniFileExit.setToolTipText("Exit application");
        mniFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        mnuFile.add(mniFileExit);
        menubar.add(mnuFile);
        // Creates menu item to choose units
        JMenu mnuUnits = new JMenu("Units");
        mnuUnits.setMnemonic(KeyEvent.VK_F);
        JMenuItem mniMetric = new JMenuItem("Metric");
        mniMetric.setMnemonic(KeyEvent.VK_E);
        mniMetric.setToolTipText("Change units to Metric");
        mniMetric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ;
            }
        });
        mnuUnits.add(mniMetric);
        JMenuItem mniImperial = new JMenuItem("Imperial");
        mniImperial.setMnemonic(KeyEvent.VK_E);
        mniImperial.setToolTipText("Change units to Imperial");
        mniImperial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ;
            }
        });
        mnuUnits.add(mniImperial);
        menubar.add(mnuUnits);
        return menubar;
    }
}

