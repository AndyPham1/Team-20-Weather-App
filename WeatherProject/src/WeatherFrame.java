
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Weather Frame is the GUI for the app
 * @author Team 20
 */

public class WeatherFrame extends JFrame {
    private JTextField txtName;
    private JLabel lblGreeting;
    private JPanel contentPane;
    private JTextField textField;

    public WeatherFrame() throws IOException {
        BufferedImage myPictureSunny = ImageIO.read(new File("src/icons/sunny.png"));
        BufferedImage myPictureCloudy = ImageIO.read(new File("src/icons/cloudy.png"));
        BufferedImage myPictureDrizzle = ImageIO.read(new File("src/icons/drizzle.png"));
        BufferedImage myPictureUpdate = ImageIO.read(new File("src/icons/update.png"));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 645);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 51, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionText);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(70, 130, 180));

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 69, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 69, 0));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                                        .addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                                        .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        );
        panel_3.setLayout(null);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 153, 0));
        panel_5.setBounds(10, 11, 102, 149);
        panel_3.add(panel_5);
        panel_5.setLayout(null);

        // Creates Menu bar
        JMenuBar menubar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        mnuFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem mniSave = new JMenuItem("Save");
        mniSave.setMnemonic(KeyEvent.VK_S);
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
        mnuUnits.setMnemonic(KeyEvent.VK_U);
        JMenuItem mniMetric = new JMenuItem("Metric");
        mniMetric.setMnemonic(KeyEvent.VK_M);
        mniMetric.setToolTipText("Change units to Metric");
        mniMetric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ;
            }
        });
        mnuUnits.add(mniMetric);
        JMenuItem mniImperial = new JMenuItem("Imperial");
        mniImperial.setMnemonic(KeyEvent.VK_I);
        mniImperial.setToolTipText("Change units to Imperial");
        mniImperial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ;
            }
        });
        mnuUnits.add(mniImperial);
        menubar.add(mnuUnits);
        setJMenuBar(menubar);

        JLabel lblMonday = new JLabel("Monday");
        lblMonday.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonday.setBounds(10, 11, 82, 14);
        panel_5.add(lblMonday);

        // Adds an image
        JLabel label_26 = new JLabel(new ImageIcon(myPictureSunny));
        label_26.setBounds(10, 30, 82, 50);
        panel_5.add(label_26);

        JLabel label_27 = new JLabel("Cloudy");
        label_27.setHorizontalAlignment(SwingConstants.CENTER);
        label_27.setBounds(10, 84, 82, 14);
        panel_5.add(label_27);

        JLabel label_28 = new JLabel("21\u00B0");
        label_28.setFont(new Font("Tahoma", Font.BOLD, 16));
        label_28.setHorizontalAlignment(SwingConstants.CENTER);
        label_28.setBounds(10, 103, 82, 20);
        panel_5.add(label_28);

        JLabel label_29 = new JLabel("\u25B230");
        label_29.setBounds(10, 123, 40, 14);
        panel_5.add(label_29);

        JLabel label_30 = new JLabel("\u220715");
        label_30.setHorizontalAlignment(SwingConstants.RIGHT);
        label_30.setBounds(51, 123, 40, 15);
        panel_5.add(label_30);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 153, 0));
        panel_4.setBounds(122, 11, 102, 149);
        panel_3.add(panel_4);
        panel_4.setLayout(null);

        JLabel lblTuesday = new JLabel("Tuesday");
        lblTuesday.setHorizontalAlignment(SwingConstants.CENTER);
        lblTuesday.setBounds(10, 11, 82, 14);
        panel_4.add(lblTuesday);

        
        // Adds an image
        JLabel label_31 = new JLabel(new ImageIcon(myPictureSunny));
        label_31.setBounds(10, 30, 82, 50);
        panel_4.add(label_31);

        JLabel label_32 = new JLabel("Cloudy");
        label_32.setHorizontalAlignment(SwingConstants.CENTER);
        label_32.setBounds(10, 84, 82, 14);
        panel_4.add(label_32);

        JLabel label_33 = new JLabel("21\u00B0");
        label_33.setHorizontalAlignment(SwingConstants.CENTER);
        label_33.setFont(new Font("Tahoma", Font.BOLD, 16));
        label_33.setBounds(10, 103, 82, 20);
        panel_4.add(label_33);

        JLabel label_34 = new JLabel("\u25B230");
        label_34.setBounds(10, 123, 40, 14);
        panel_4.add(label_34);

        JLabel label_35 = new JLabel("\u220715");
        label_35.setHorizontalAlignment(SwingConstants.RIGHT);
        label_35.setBounds(51, 123, 40, 15);
        panel_4.add(label_35);

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(255, 153, 0));
        panel_6.setBounds(234, 11, 102, 149);
        panel_3.add(panel_6);
        panel_6.setLayout(null);

        JLabel lblWednesday = new JLabel("Wednesday");
        lblWednesday.setHorizontalAlignment(SwingConstants.CENTER);
        lblWednesday.setBounds(10, 11, 82, 14);
        panel_6.add(lblWednesday);

        // Adds an image
        JLabel label_36 = new JLabel(new ImageIcon(myPictureSunny));
        label_36.setBounds(10, 30, 82, 50);
        panel_6.add(label_36);

        JLabel label_37 = new JLabel("Cloudy");
        label_37.setHorizontalAlignment(SwingConstants.CENTER);
        label_37.setBounds(10, 84, 82, 14);
        panel_6.add(label_37);

        JLabel label_38 = new JLabel("21\u00B0");
        label_38.setHorizontalAlignment(SwingConstants.CENTER);
        label_38.setFont(new Font("Tahoma", Font.BOLD, 16));
        label_38.setBounds(10, 103, 82, 20);
        panel_6.add(label_38);

        JLabel label_39 = new JLabel("\u25B230");
        label_39.setBounds(10, 123, 40, 14);
        panel_6.add(label_39);

        JLabel label_40 = new JLabel("\u220715");
        label_40.setHorizontalAlignment(SwingConstants.RIGHT);
        label_40.setBounds(51, 123, 40, 15);
        panel_6.add(label_40);

        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(255, 153, 0));
        panel_7.setBounds(346, 11, 102, 149);
        panel_3.add(panel_7);
        panel_7.setLayout(null);

        JLabel lblThursday = new JLabel("Thursday");
        lblThursday.setHorizontalAlignment(SwingConstants.CENTER);
        lblThursday.setBounds(10, 11, 82, 14);
        panel_7.add(lblThursday);

        // Adds an image
        JLabel label_41 = new JLabel(new ImageIcon(myPictureSunny));
        label_41.setBounds(10, 30, 82, 50);
        panel_7.add(label_41);

        JLabel label_42 = new JLabel("Cloudy");
        label_42.setHorizontalAlignment(SwingConstants.CENTER);
        label_42.setBounds(10, 84, 82, 14);
        panel_7.add(label_42);

        JLabel label_43 = new JLabel("21\u00B0");
        label_43.setHorizontalAlignment(SwingConstants.CENTER);
        label_43.setFont(new Font("Tahoma", Font.BOLD, 16));
        label_43.setBounds(10, 103, 82, 20);
        panel_7.add(label_43);

        JLabel label_44 = new JLabel("\u25B230");
        label_44.setBounds(10, 123, 40, 14);
        panel_7.add(label_44);

        JLabel label_45 = new JLabel("\u220715");
        label_45.setHorizontalAlignment(SwingConstants.RIGHT);
        label_45.setBounds(51, 123, 40, 15);
        panel_7.add(label_45);

        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(255, 153, 0));
        panel_8.setBounds(458, 11, 102, 149);
        panel_3.add(panel_8);
        panel_8.setLayout(null);

        JLabel lblFriday = new JLabel("Friday");
        lblFriday.setHorizontalAlignment(SwingConstants.CENTER);
        lblFriday.setBounds(10, 11, 82, 14);
        panel_8.add(lblFriday);

        // Adds an image
        JLabel label_46 = new JLabel(new ImageIcon(myPictureSunny));
        label_46.setBounds(10, 30, 82, 50);
        panel_8.add(label_46);

        JLabel label_47 = new JLabel("Cloudy");
        label_47.setHorizontalAlignment(SwingConstants.CENTER);
        label_47.setBounds(10, 84, 82, 14);
        panel_8.add(label_47);

        JLabel label_48 = new JLabel("21\u00B0");
        label_48.setHorizontalAlignment(SwingConstants.CENTER);
        label_48.setFont(new Font("Tahoma", Font.BOLD, 16));
        label_48.setBounds(10, 103, 82, 20);
        panel_8.add(label_48);

        JLabel label_49 = new JLabel("\u25B230");
        label_49.setBounds(10, 123, 40, 14);
        panel_8.add(label_49);

        JLabel label_50 = new JLabel("\u220715");
        label_50.setHorizontalAlignment(SwingConstants.RIGHT);
        label_50.setBounds(51, 123, 40, 15);
        panel_8.add(label_50);
        panel_2.setLayout(null);

        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(255, 153, 0));
        panel_9.setBounds(10, 11, 60, 116);
        panel_2.add(panel_9);
        panel_9.setLayout(null);

        JLabel lblPm = new JLabel("3 PM");
        lblPm.setHorizontalAlignment(SwingConstants.CENTER);
        lblPm.setBounds(10, 11, 40, 14);
        panel_9.add(lblPm);

        // Adds an image
        JLabel label_3 = new JLabel(new ImageIcon(myPictureCloudy));
        label_3.setBounds(10, 28, 40, 40);
        panel_9.add(label_3);

        JLabel label_4 = new JLabel("-12\u00B0");
        label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_4.setHorizontalAlignment(SwingConstants.CENTER);
        label_4.setBounds(10, 79, 40, 26);
        panel_9.add(label_4);

        JLabel lblCloudy = new JLabel("Cloudy");
        lblCloudy.setHorizontalAlignment(SwingConstants.CENTER);
        lblCloudy.setBounds(0, 68, 60, 14);
        panel_9.add(lblCloudy);

        JPanel panel_10 = new JPanel();
        panel_10.setBackground(new Color(255, 153, 0));
        panel_10.setBounds(80, 11, 60, 116);
        panel_2.add(panel_10);
        panel_10.setLayout(null);

        JLabel lblPm_1 = new JLabel("6 PM");
        lblPm_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPm_1.setBounds(10, 11, 40, 14);
        panel_10.add(lblPm_1);

        // Adds an image
        JLabel label_5 = new JLabel(new ImageIcon(myPictureCloudy));
        label_5.setBounds(10, 28, 40, 40);
        panel_10.add(label_5);

        JLabel label_6 = new JLabel("Cloudy");
        label_6.setHorizontalAlignment(SwingConstants.CENTER);
        label_6.setBounds(0, 68, 60, 14);
        panel_10.add(label_6);

        JLabel label_7 = new JLabel("-12\u00B0");
        label_7.setHorizontalAlignment(SwingConstants.CENTER);
        label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_7.setBounds(10, 79, 40, 26);
        panel_10.add(label_7);

        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(255, 153, 0));
        panel_11.setBounds(150, 11, 60, 116);
        panel_2.add(panel_11);
        panel_11.setLayout(null);

        JLabel lblPm_2 = new JLabel("9 PM");
        lblPm_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblPm_2.setBounds(10, 11, 40, 14);
        panel_11.add(lblPm_2);

        // Adds an image
        JLabel label_8 = new JLabel(new ImageIcon(myPictureCloudy));
        label_8.setBounds(10, 28, 40, 40);
        panel_11.add(label_8);

        JLabel label_9 = new JLabel("Cloudy");
        label_9.setHorizontalAlignment(SwingConstants.CENTER);
        label_9.setBounds(0, 68, 60, 14);
        panel_11.add(label_9);

        JLabel label_10 = new JLabel("-12\u00B0");
        label_10.setHorizontalAlignment(SwingConstants.CENTER);
        label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_10.setBounds(10, 79, 40, 26);
        panel_11.add(label_10);

        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(255, 153, 0));
        panel_12.setBounds(220, 11, 60, 116);
        panel_2.add(panel_12);
        panel_12.setLayout(null);

        JLabel lblAm = new JLabel("12 AM");
        lblAm.setHorizontalAlignment(SwingConstants.CENTER);
        lblAm.setBounds(10, 11, 40, 14);
        panel_12.add(lblAm);

        // Adds an image
        JLabel label_11 = new JLabel(new ImageIcon(myPictureCloudy));
        label_11.setBounds(10, 28, 40, 40);
        panel_12.add(label_11);

        JLabel label_12 = new JLabel("Cloudy");
        label_12.setHorizontalAlignment(SwingConstants.CENTER);
        label_12.setBounds(0, 68, 60, 14);
        panel_12.add(label_12);

        JLabel label_13 = new JLabel("-12\u00B0");
        label_13.setHorizontalAlignment(SwingConstants.CENTER);
        label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_13.setBounds(10, 79, 40, 26);
        panel_12.add(label_13);

        JPanel panel_13 = new JPanel();
        panel_13.setBackground(new Color(255, 153, 0));
        panel_13.setBounds(290, 11, 60, 116);
        panel_2.add(panel_13);
        panel_13.setLayout(null);

        JLabel lblAm_1 = new JLabel("3 AM");
        lblAm_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblAm_1.setBounds(10, 11, 40, 14);
        panel_13.add(lblAm_1);

        // Adds an image
        JLabel label_14 = new JLabel(new ImageIcon(myPictureCloudy));
        label_14.setBounds(10, 28, 40, 40);
        panel_13.add(label_14);

        JLabel label_15 = new JLabel("Cloudy");
        label_15.setHorizontalAlignment(SwingConstants.CENTER);
        label_15.setBounds(0, 68, 60, 14);
        panel_13.add(label_15);

        JLabel label_16 = new JLabel("-12\u00B0");
        label_16.setHorizontalAlignment(SwingConstants.CENTER);
        label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_16.setBounds(10, 79, 40, 26);
        panel_13.add(label_16);

        JPanel panel_14 = new JPanel();
        panel_14.setBackground(new Color(255, 153, 0));
        panel_14.setBounds(360, 11, 60, 116);
        panel_2.add(panel_14);
        panel_14.setLayout(null);

        JLabel lblAm_2 = new JLabel("6 AM");
        lblAm_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblAm_2.setBounds(10, 11, 40, 14);
        panel_14.add(lblAm_2);

        // Adds an image
        JLabel label_17 = new JLabel(new ImageIcon(myPictureCloudy));
        label_17.setBounds(10, 28, 40, 40);
        panel_14.add(label_17);

        JLabel label_18 = new JLabel("Cloudy");
        label_18.setHorizontalAlignment(SwingConstants.CENTER);
        label_18.setBounds(0, 68, 60, 14);
        panel_14.add(label_18);

        JLabel label_19 = new JLabel("-12\u00B0");
        label_19.setHorizontalAlignment(SwingConstants.CENTER);
        label_19.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_19.setBounds(10, 79, 40, 26);
        panel_14.add(label_19);

        JPanel panel_15 = new JPanel();
        panel_15.setBackground(new Color(255, 153, 0));
        panel_15.setBounds(430, 11, 60, 116);
        panel_2.add(panel_15);
        panel_15.setLayout(null);

        JLabel lblAm_3 = new JLabel("9 AM");
        lblAm_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblAm_3.setBounds(10, 11, 40, 14);
        panel_15.add(lblAm_3);

        // Adds an image
        JLabel label_20 = new JLabel(new ImageIcon(myPictureCloudy));
        label_20.setBounds(10, 28, 40, 40);
        panel_15.add(label_20);

        JLabel label_21 = new JLabel("Cloudy");
        label_21.setHorizontalAlignment(SwingConstants.CENTER);
        label_21.setBounds(0, 68, 60, 14);
        panel_15.add(label_21);

        JLabel label_22 = new JLabel("-12\u00B0");
        label_22.setHorizontalAlignment(SwingConstants.CENTER);
        label_22.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_22.setBounds(10, 79, 40, 26);
        panel_15.add(label_22);

        JPanel panel_16 = new JPanel();
        panel_16.setBackground(new Color(255, 153, 0));
        panel_16.setBounds(500, 11, 60, 116);
        panel_2.add(panel_16);
        panel_16.setLayout(null);

        JLabel lblAm_4 = new JLabel("12 PM");
        lblAm_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblAm_4.setBounds(10, 11, 40, 14);
        panel_16.add(lblAm_4);

        // Adds an image
        JLabel label_23 = new JLabel(new ImageIcon(myPictureCloudy));
        label_23.setBounds(10, 28, 40, 40);
        panel_16.add(label_23);

        JLabel label_24 = new JLabel("Cloudy");
        label_24.setHorizontalAlignment(SwingConstants.CENTER);
        label_24.setBounds(0, 68, 60, 14);
        panel_16.add(label_24);

        JLabel label_25 = new JLabel("-12\u00B0");
        label_25.setHorizontalAlignment(SwingConstants.CENTER);
        label_25.setFont(new Font("Tahoma", Font.BOLD, 13));
        label_25.setBounds(10, 79, 40, 26);
        panel_16.add(label_25);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("CurrLocation");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(10, 11, 113, 24);
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel_1.add(lblNewLabel);

        JLabel lblLocation = new JLabel("Sunrise:");
        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLocation.setBounds(181, 202, 57, 14);
        panel_1.add(lblLocation);

        JLabel lblSunset = new JLabel("Sunset:");
        lblSunset.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSunset.setBounds(181, 227, 57, 14);
        panel_1.add(lblSunset);

        // Adds an image
        JLabel lblNewLabel_1 = new JLabel(new ImageIcon(myPictureDrizzle));
        lblNewLabel_1.setBounds(10, 40, 100, 100);
        panel_1.add(lblNewLabel_1);

        JLabel lblWeathercondition = new JLabel("WeatherCondition");
        lblWeathercondition.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblWeathercondition.setBounds(10, 150, 145, 24);
        panel_1.add(lblWeathercondition);

        JLabel lblHumdity_1 = new JLabel("Humidity:\r\n");
        lblHumdity_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblHumdity_1.setBounds(10, 174, 72, 24);
        panel_1.add(lblHumdity_1);

        JLabel lblWindSpeed = new JLabel("Wind Speed:\r\n");
        lblWindSpeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWindSpeed.setBounds(10, 197, 84, 24);
        panel_1.add(lblWindSpeed);

        JLabel lblPressure = new JLabel("Pressure:\r\n");
        lblPressure.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPressure.setBounds(10, 221, 84, 24);
        panel_1.add(lblPressure);

        JLabel label = new JLabel("-17\u00B0");
        label.setFont(new Font("Tahoma", Font.PLAIN, 56));
        label.setBounds(330, 46, 113, 68);
        panel_1.add(label);

        JLabel label_1 = new JLabel("\u2207-30");
        label_1.setBounds(397, 125, 31, 15);
        panel_1.add(label_1);

        JLabel lblNewLabel_2 = new JLabel("\u25B2-10");
        lblNewLabel_2.setBounds(330, 125, 46, 14);
        panel_1.add(lblNewLabel_2);

        // Adds an image
        JLabel label_2 = new JLabel(new ImageIcon(myPictureUpdate));
        label_2.setBounds(521, 11, 40, 40);
        panel_1.add(label_2);

        JLabel lblLastUpdated = new JLabel("Last updated:");
        lblLastUpdated.setBounds(306, 149, 84, 14);
        panel_1.add(lblLastUpdated);

        JLabel lblLocations = new JLabel("Locations");
        lblLocations.setBounds(10, 0, 60, 23);
        lblLocations.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JList list = new JList();
        list.setBackground(new Color(153, 153, 153));
        list.setBounds(0, 25, 197, 446);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(10, 511, 66, 23);

        JButton btnRemove = new JButton("Remove");
        btnRemove.setBounds(86, 511, 101, 23);

        textField = new JTextField();
        textField.setBounds(10, 478, 177, 20);
        textField.setColumns(10);
        panel.setLayout(null);
        panel.add(lblLocations);
        panel.add(list);
        panel.add(textField);
        panel.add(btnAdd);
        panel.add(btnRemove);
        contentPane.setLayout(gl_contentPane);
    }
}

