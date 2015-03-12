package weather;

import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import java.awt.*;

/**
 * Weather Frame is the GUI for the app
 * @author Team 20
 */

public class WeatherFrame extends JFrame implements ActionListener {

	/* Instance Variables */
	
	private WeatherData weatherData;
    private JTextField txtName;
    private JLabel lblGreeting;
    private JPanel contentPane;
//    private JTextField locationInputField;
    private JList locationList;
    private static WeatherData[] locationNames = new WeatherData[10];
    private String userCityInput;
    private String userCountryInput;
    
    
    /* Constructor */
    
    public WeatherFrame() throws IOException {
    	
        weatherData = new WeatherData("London", "Ca");	//THIS IS PRACTICE
    	
    	/*****IMAGES*****/
    	
    	BufferedImage myPictureSunny = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("sunny.png"));
        BufferedImage myPictureCloudy = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("cloudy.png"));
        BufferedImage myPictureDrizzle = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("drizzle.png"));
        BufferedImage myPictureUpdate = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("update.png"));

        /******END IMAGES*****/
        
       
        /*****PANELS*****/

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 645);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 51, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel LocationPanel = new JPanel();
        LocationPanel.setBackground(SystemColor.inactiveCaptionText);

        JPanel currWeatherPanel = new JPanel();
        currWeatherPanel.setBackground(new Color(70, 130, 180));

        JPanel shortTermFullPanel = new JPanel();
        shortTermFullPanel.setBackground(new Color(255, 69, 0));

        JPanel longTermFullPanel = new JPanel();
        longTermFullPanel.setBackground(new Color(255, 69, 0));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(LocationPanel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(longTermFullPanel, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                                        .addComponent(shortTermFullPanel, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                                        .addComponent(currWeatherPanel, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(LocationPanel, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(currWeatherPanel, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(shortTermFullPanel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(longTermFullPanel, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        );
        longTermFullPanel.setLayout(null);

        JPanel longTermPanel1 = new JPanel();
        longTermPanel1.setBackground(new Color(255, 153, 0));
        longTermPanel1.setBounds(10, 11, 102, 149);
        longTermFullPanel.add(longTermPanel1);
        longTermPanel1.setLayout(null);

        /******END PANELS******/
        
        /******MENU BAR******/
        
        // Creates Menu bar
        JMenuBar menubar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        mnuFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem mniSave = new JMenuItem("Save");
        mniSave.setMnemonic(KeyEvent.VK_S);
        mniSave.setToolTipText("Save");
        mniSave.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
                ;
            }
        });
        mnuFile.add(mniSave);
        JMenuItem mniLoad = new JMenuItem("Load");
        mniLoad.setToolTipText("Load");
        mniLoad.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
                ;
            }
        });
        mnuFile.add(mniLoad);
        JMenuItem mniFileExit = new JMenuItem("Exit");
        mniFileExit.setMnemonic(KeyEvent.VK_E);
        mniFileExit.setToolTipText("Exit application");
        mniFileExit.addActionListener(new ActionListener() {
          
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
            
            public void actionPerformed(ActionEvent event) {
                ;
            }
        });
        mnuUnits.add(mniMetric);
        JMenuItem mniImperial = new JMenuItem("Imperial");
        mniImperial.setMnemonic(KeyEvent.VK_I);
        mniImperial.setToolTipText("Change units to Imperial");
        mniImperial.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
                ;
            }
        });
        mnuUnits.add(mniImperial);
        menubar.add(mnuUnits);
        setJMenuBar(menubar);

        /******END MENU BAR******/
        
        /******LONG TERM WEATHER******/
        
        JLabel longTermDay1 = new JLabel("Monday");
        longTermDay1.setHorizontalAlignment(SwingConstants.CENTER);
        longTermDay1.setBounds(10, 11, 82, 14);
        longTermPanel1.add(longTermDay1);

        // Adds an image
        JLabel longTermIcon1 = new JLabel(new ImageIcon(myPictureSunny));
        longTermIcon1.setBounds(10, 30, 82, 50);
        longTermPanel1.add(longTermIcon1);

        JLabel longWeatherCondition1 = new JLabel("Cloudy");
        longWeatherCondition1.setHorizontalAlignment(SwingConstants.CENTER);
        longWeatherCondition1.setBounds(10, 84, 82, 14);
        longTermPanel1.add(longWeatherCondition1);

        JLabel longTermTemp1 = new JLabel("21\u00B0");
        longTermTemp1.setFont(new Font("Tahoma", Font.BOLD, 16));
        longTermTemp1.setHorizontalAlignment(SwingConstants.CENTER);
        longTermTemp1.setBounds(10, 103, 82, 20);
        longTermPanel1.add(longTermTemp1);

        JLabel longMaxTemp1 = new JLabel("\u25B230");
        longMaxTemp1.setBounds(10, 123, 40, 14);
        longTermPanel1.add(longMaxTemp1);

        JLabel longMinTemp1 = new JLabel("\u220715");
        longMinTemp1.setHorizontalAlignment(SwingConstants.RIGHT);
        longMinTemp1.setBounds(51, 123, 40, 15);
        longTermPanel1.add(longMinTemp1);

        JPanel longTermPanel2 = new JPanel();
        longTermPanel2.setBackground(new Color(255, 153, 0));
        longTermPanel2.setBounds(122, 11, 102, 149);
        longTermFullPanel.add(longTermPanel2);
        longTermPanel2.setLayout(null);

        JLabel longTermDay2 = new JLabel("Tuesday");
        longTermDay2.setHorizontalAlignment(SwingConstants.CENTER);
        longTermDay2.setBounds(10, 11, 82, 14);
        longTermPanel2.add(longTermDay2);
        
        // Adds an image
        JLabel longTermIcon2 = new JLabel(new ImageIcon(myPictureSunny));
        longTermIcon2.setBounds(10, 30, 82, 50);
        longTermPanel2.add(longTermIcon2);

        JLabel longWeatherCondition2 = new JLabel("Cloudy");
        longWeatherCondition2.setHorizontalAlignment(SwingConstants.CENTER);
        longWeatherCondition2.setBounds(10, 84, 82, 14);
        longTermPanel2.add(longWeatherCondition2);

        JLabel longTermTemp2 = new JLabel("21\u00B0");
        longTermTemp2.setHorizontalAlignment(SwingConstants.CENTER);
        longTermTemp2.setFont(new Font("Tahoma", Font.BOLD, 16));
        longTermTemp2.setBounds(10, 103, 82, 20);
        longTermPanel2.add(longTermTemp2);

        JLabel longMaxTemp2 = new JLabel("\u25B230");
        longMaxTemp2.setBounds(10, 123, 40, 14);
        longTermPanel2.add(longMaxTemp2);

        JLabel longMinTemp2 = new JLabel("\u220715");
        longMinTemp2.setHorizontalAlignment(SwingConstants.RIGHT);
        longMinTemp2.setBounds(51, 123, 40, 15);
        longTermPanel2.add(longMinTemp2);

        JPanel longTermPanel3 = new JPanel();
        longTermPanel3.setBackground(new Color(255, 153, 0));
        longTermPanel3.setBounds(234, 11, 102, 149);
        longTermFullPanel.add(longTermPanel3);
        longTermPanel3.setLayout(null);

        JLabel longTermDay3 = new JLabel("Wednesday");
        longTermDay3.setHorizontalAlignment(SwingConstants.CENTER);
        longTermDay3.setBounds(10, 11, 82, 14);
        longTermPanel3.add(longTermDay3);

        // Adds an image
        JLabel longTermIcon3 = new JLabel(new ImageIcon(myPictureSunny));
        longTermIcon3.setBounds(10, 30, 82, 50);
        longTermPanel3.add(longTermIcon3);

        JLabel longWeatherCondition3 = new JLabel("Cloudy");
        longWeatherCondition3.setHorizontalAlignment(SwingConstants.CENTER);
        longWeatherCondition3.setBounds(10, 84, 82, 14);
        longTermPanel3.add(longWeatherCondition3);

        JLabel longTermTemp3 = new JLabel("21\u00B0");
        longTermTemp3.setHorizontalAlignment(SwingConstants.CENTER);
        longTermTemp3.setFont(new Font("Tahoma", Font.BOLD, 16));
        longTermTemp3.setBounds(10, 103, 82, 20);
        longTermPanel3.add(longTermTemp3);

        JLabel longMaxTemp3 = new JLabel("\u25B230");
        longMaxTemp3.setBounds(10, 123, 40, 14);
        longTermPanel3.add(longMaxTemp3);

        JLabel longMinTemp3 = new JLabel("\u220715");
        longMinTemp3.setHorizontalAlignment(SwingConstants.RIGHT);
        longMinTemp3.setBounds(51, 123, 40, 15);
        longTermPanel3.add(longMinTemp3);

        JPanel longTermPanel4 = new JPanel();
        longTermPanel4.setBackground(new Color(255, 153, 0));
        longTermPanel4.setBounds(346, 11, 102, 149);
        longTermFullPanel.add(longTermPanel4);
        longTermPanel4.setLayout(null);

        JLabel longTermDay4 = new JLabel("Thursday");
        longTermDay4.setHorizontalAlignment(SwingConstants.CENTER);
        longTermDay4.setBounds(10, 11, 82, 14);
        longTermPanel4.add(longTermDay4);

        // Adds an image
        JLabel longTermIcon4 = new JLabel(new ImageIcon(myPictureSunny));
        longTermIcon4.setBounds(10, 30, 82, 50);
        longTermPanel4.add(longTermIcon4);

        JLabel longWeatherCondition4 = new JLabel("Cloudy");
        longWeatherCondition4.setHorizontalAlignment(SwingConstants.CENTER);
        longWeatherCondition4.setBounds(10, 84, 82, 14);
        longTermPanel4.add(longWeatherCondition4);

        JLabel longTermTemp4 = new JLabel("21\u00B0");
        longTermTemp4.setHorizontalAlignment(SwingConstants.CENTER);
        longTermTemp4.setFont(new Font("Tahoma", Font.BOLD, 16));
        longTermTemp4.setBounds(10, 103, 82, 20);
        longTermPanel4.add(longTermTemp4);

        JLabel longMaxTemp4 = new JLabel("\u25B230");
        longMaxTemp4.setBounds(10, 123, 40, 14);
        longTermPanel4.add(longMaxTemp4);

        JLabel longMinTemp4 = new JLabel("\u220715");
        longMinTemp4.setHorizontalAlignment(SwingConstants.RIGHT);
        longMinTemp4.setBounds(51, 123, 40, 15);
        longTermPanel4.add(longMinTemp4);

        JPanel longTermPanel5 = new JPanel();
        longTermPanel5.setBackground(new Color(255, 153, 0));
        longTermPanel5.setBounds(458, 11, 102, 149);
        longTermFullPanel.add(longTermPanel5);
        longTermPanel5.setLayout(null);

        JLabel longTermDay5 = new JLabel("Friday");
        longTermDay5.setHorizontalAlignment(SwingConstants.CENTER);
        longTermDay5.setBounds(10, 11, 82, 14);
        longTermPanel5.add(longTermDay5);

        // Adds an image
        JLabel longTermIcon5 = new JLabel(new ImageIcon(myPictureSunny));
        longTermIcon5.setBounds(10, 30, 82, 50);
        longTermPanel5.add(longTermIcon5);

        JLabel longWeatherCondition5 = new JLabel("Cloudy");
        longWeatherCondition5.setHorizontalAlignment(SwingConstants.CENTER);
        longWeatherCondition5.setBounds(10, 84, 82, 14);
        longTermPanel5.add(longWeatherCondition5);

        JLabel longTermTemp5 = new JLabel("21\u00B0");
        longTermTemp5.setHorizontalAlignment(SwingConstants.CENTER);
        longTermTemp5.setFont(new Font("Tahoma", Font.BOLD, 16));
        longTermTemp5.setBounds(10, 103, 82, 20);
        longTermPanel5.add(longTermTemp5);

        JLabel longMaxTemp5 = new JLabel("\u25B230");
        longMaxTemp5.setBounds(10, 123, 40, 14);
        longTermPanel5.add(longMaxTemp5);

        JLabel longMinTemp5 = new JLabel("\u220715");
        longMinTemp5.setHorizontalAlignment(SwingConstants.RIGHT);
        longMinTemp5.setBounds(51, 123, 40, 15);
        longTermPanel5.add(longMinTemp5);
        shortTermFullPanel.setLayout(null);

        /******END LONG TERM WEATHER******/
        
        /******SHORT TERM WEATHER******/
        
        JPanel shortTermPanel1 = new JPanel();
        shortTermPanel1.setBackground(new Color(255, 153, 0));
        shortTermPanel1.setBounds(10, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel1);
        shortTermPanel1.setLayout(null);

        JLabel shortTermTime1 = new JLabel("3 PM");
        shortTermTime1.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime1.setBounds(10, 11, 40, 14);
        shortTermPanel1.add(shortTermTime1);

        // Adds an image
        JLabel shortTermIcon1 = new JLabel(new ImageIcon(myPictureCloudy));
        shortTermIcon1.setBounds(10, 28, 40, 40);
        shortTermPanel1.add(shortTermIcon1);

        JLabel shortTermTemp1 = new JLabel("-12\u00B0");
        shortTermTemp1.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp1.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp1.setBounds(10, 79, 40, 26);
        shortTermPanel1.add(shortTermTemp1);

        JLabel shortWeatherCondition1 = new JLabel("Cloudy");
        shortWeatherCondition1.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition1.setBounds(0, 68, 60, 14);
        shortTermPanel1.add(shortWeatherCondition1);

        JPanel shortTermPanel2 = new JPanel();
        shortTermPanel2.setBackground(new Color(255, 153, 0));
        shortTermPanel2.setBounds(80, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel2);
        shortTermPanel2.setLayout(null);

        JLabel shortTermTime2 = new JLabel("6 PM");
        shortTermTime2.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime2.setBounds(10, 11, 40, 14);
        shortTermPanel2.add(shortTermTime2);

        // Adds an image
        JLabel shortTermIcon2 = new JLabel(new ImageIcon(myPictureCloudy));
        shortTermIcon2.setBounds(10, 28, 40, 40);
        shortTermPanel2.add(shortTermIcon2);

        JLabel shortWeatherCondition2 = new JLabel("Cloudy");
        shortWeatherCondition2.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition2.setBounds(0, 68, 60, 14);
        shortTermPanel2.add(shortWeatherCondition2);

        JLabel shortTermTemp2 = new JLabel("-12\u00B0");
        shortTermTemp2.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp2.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp2.setBounds(10, 79, 40, 26);
        shortTermPanel2.add(shortTermTemp2);

        JPanel shortTermPanel3 = new JPanel();
        shortTermPanel3.setBackground(new Color(255, 153, 0));
        shortTermPanel3.setBounds(150, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel3);
        shortTermPanel3.setLayout(null);

        JLabel shortTermTime3 = new JLabel("9 PM");
        shortTermTime3.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime3.setBounds(10, 11, 40, 14);
        shortTermPanel3.add(shortTermTime3);

        // Adds an image
        JLabel shortTermIcon3 = new JLabel(new ImageIcon(myPictureCloudy));
        shortTermIcon3.setBounds(10, 28, 40, 40);
        shortTermPanel3.add(shortTermIcon3);

        JLabel shortWeatherCondition3 = new JLabel("Cloudy");
        shortWeatherCondition3.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition3.setBounds(0, 68, 60, 14);
        shortTermPanel3.add(shortWeatherCondition3);

        JLabel shortTermTemp3 = new JLabel("-12\u00B0");
        shortTermTemp3.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp3.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp3.setBounds(10, 79, 40, 26);
        shortTermPanel3.add(shortTermTemp3);

        JPanel shortTermPanel4 = new JPanel();
        shortTermPanel4.setBackground(new Color(255, 153, 0));
        shortTermPanel4.setBounds(220, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel4);
        shortTermPanel4.setLayout(null);

        JLabel shortTermTime4 = new JLabel("12 AM");
        shortTermTime4.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime4.setBounds(10, 11, 40, 14);
        shortTermPanel4.add(shortTermTime4);

        // Adds an image
        JLabel shortTermIcon4 = new JLabel(new ImageIcon(myPictureCloudy));
        shortTermIcon4.setBounds(10, 28, 40, 40);
        shortTermPanel4.add(shortTermIcon4);

        JLabel shortWeatherCondition4 = new JLabel("Cloudy");
        shortWeatherCondition4.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition4.setBounds(0, 68, 60, 14);
        shortTermPanel4.add(shortWeatherCondition4);

        JLabel shortTermTemp4 = new JLabel("-12\u00B0");
        shortTermTemp4.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp4.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp4.setBounds(10, 79, 40, 26);
        shortTermPanel4.add(shortTermTemp4);

        JPanel shortTermPanel5 = new JPanel();
        shortTermPanel5.setBackground(new Color(255, 153, 0));
        shortTermPanel5.setBounds(290, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel5);
        shortTermPanel5.setLayout(null);

        JLabel shortTermTime5 = new JLabel("3 AM");
        shortTermTime5.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime5.setBounds(10, 11, 40, 14);
        shortTermPanel5.add(shortTermTime5);

        // Adds an image
        JLabel shortTermIcon5 = new JLabel(new ImageIcon(myPictureCloudy));
        shortTermIcon5.setBounds(10, 28, 40, 40);
        shortTermPanel5.add(shortTermIcon5);

        JLabel shortWeatherCondition5 = new JLabel("Cloudy");
        shortWeatherCondition5.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition5.setBounds(0, 68, 60, 14);
        shortTermPanel5.add(shortWeatherCondition5);

        JLabel shortTermTemp5 = new JLabel("-12\u00B0");
        shortTermTemp5.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp5.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp5.setBounds(10, 79, 40, 26);
        shortTermPanel5.add(shortTermTemp5);

        JPanel shortTermPanel6 = new JPanel();
        shortTermPanel6.setBackground(new Color(255, 153, 0));
        shortTermPanel6.setBounds(360, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel6);
        shortTermPanel6.setLayout(null);

        JLabel shortTermTime6 = new JLabel("6 AM");
        shortTermTime6.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime6.setBounds(10, 11, 40, 14);
        shortTermPanel6.add(shortTermTime6);

        // Adds an image
        JLabel shortTermIcon6 = new JLabel(new ImageIcon(myPictureCloudy));
        shortTermIcon6.setBounds(10, 28, 40, 40);
        shortTermPanel6.add(shortTermIcon6);

        JLabel shortWeatherCondition6 = new JLabel("Cloudy");
        shortWeatherCondition6.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition6.setBounds(0, 68, 60, 14);
        shortTermPanel6.add(shortWeatherCondition6);

        JLabel shortTermTemp6 = new JLabel("-12\u00B0");
        shortTermTemp6.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp6.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp6.setBounds(10, 79, 40, 26);
        shortTermPanel6.add(shortTermTemp6);

        JPanel shortTermPanel7 = new JPanel();
        shortTermPanel7.setBackground(new Color(255, 153, 0));
        shortTermPanel7.setBounds(430, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel7);
        shortTermPanel7.setLayout(null);

        JLabel shortTermTime7 = new JLabel("9 AM");
        shortTermTime7.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime7.setBounds(10, 11, 40, 14);
        shortTermPanel7.add(shortTermTime7);

        // Adds an image

//        JLabel label_23 = new JLabel(new ImageIcon(myPictureCloudy));
//        label_23.setBounds(10, 28, 40, 40);
//        panel_16.add(label_23);
//
//        JLabel label_24 = new JLabel("Cloudy");
//        label_24.setHorizontalAlignment(SwingConstants.CENTER);
//        label_24.setBounds(0, 68, 60, 14);
//        panel_16.add(label_24);
//
//        JLabel label_25 = new JLabel("-12\u00B0");
//        label_25.setHorizontalAlignment(SwingConstants.CENTER);
//        label_25.setFont(new Font("Tahoma", Font.BOLD, 13));
//        label_25.setBounds(10, 79, 40, 26);
//        panel_16.add(label_25);
//        panel_1.setLayout(null);
//
//        JLabel lblNewLabel = new JLabel("Currently Viewing:" + weatherData.getCurrrentCity() + ", " + weatherData.getCountryCode());
//        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        lblNewLabel.setBounds(10, 11, 120, 24);
//        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
//        panel_1.add(lblNewLabel);
//
//        JLabel lblLocation = new JLabel("Sunrise:");
//        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lblLocation.setBounds(181, 202, 57, 14);
//        panel_1.add(lblLocation);
//
//        JLabel lblSunset = new JLabel("Sunset:");
//        lblSunset.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        lblSunset.setBounds(181, 227, 57, 14);
//        panel_1.add(lblSunset);

        JLabel shortTermIcon7 = new JLabel(new ImageIcon(myPictureCloudy));
        shortTermIcon7.setBounds(10, 28, 40, 40);
        shortTermPanel7.add(shortTermIcon7);

        JLabel shortWeatherCondition7 = new JLabel("Cloudy");
        shortWeatherCondition7.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition7.setBounds(0, 68, 60, 14);
        shortTermPanel7.add(shortWeatherCondition7);

        JLabel shortTermTemp7 = new JLabel("-12\u00B0");
        shortTermTemp7.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp7.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp7.setBounds(10, 79, 40, 26);
        shortTermPanel7.add(shortTermTemp7);

        JPanel shortTermPanel8 = new JPanel();
        shortTermPanel8.setBackground(new Color(255, 153, 0));
        shortTermPanel8.setBounds(500, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel8);
        shortTermPanel8.setLayout(null);

        JLabel shortTermTime8 = new JLabel("12 PM");
        shortTermTime8.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime8.setBounds(10, 11, 40, 14);
        shortTermPanel8.add(shortTermTime8);


        // Adds an image
        JLabel shortTermIcon8 = new JLabel(new ImageIcon(myPictureCloudy));
        shortTermIcon8.setBounds(10, 28, 40, 40);
        shortTermPanel8.add(shortTermIcon8);

        JLabel shortWeatherCondition8 = new JLabel("Cloudy");
        shortWeatherCondition8.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition8.setBounds(0, 68, 60, 14);
        shortTermPanel8.add(shortWeatherCondition8);

        JLabel shortTermTemp8 = new JLabel("-12\u00B0");
        shortTermTemp8.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp8.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp8.setBounds(10, 79, 40, 26);
        shortTermPanel8.add(shortTermTemp8);
        currWeatherPanel.setLayout(null);

        /******END SHORT TERM WEATHER******/
        
        /******CURRENT WEATHER*****/
        //To keep certain variables to one decimal place
        DecimalFormat df = new DecimalFormat(); 
        df.setMaximumFractionDigits(1);
        
        JLabel currLocationLabel = new JLabel(weatherData.getCurrentCity() + ", " +weatherData.getCountryCode());
        currLocationLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        currLocationLabel.setBounds(10, 11, 140, 24);
        currLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        currWeatherPanel.add(currLocationLabel);

        JLabel currSunriseLabel = new JLabel("Sunrise: "+ weatherData.getSunrise());
        currSunriseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currSunriseLabel.setBounds(181, 202, 200, 14);
        currWeatherPanel.add(currSunriseLabel);

        JLabel currSunsetLabel = new JLabel("Sunset: " + weatherData.getSunset());
        currSunsetLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currSunsetLabel.setBounds(181, 227, 200, 14);
        currWeatherPanel.add(currSunsetLabel);

        // Adds an image
        JLabel currWeatherIcon = new JLabel(new ImageIcon(myPictureDrizzle));
        currWeatherIcon.setBounds(10, 40, 100, 100);
        currWeatherPanel.add(currWeatherIcon);

        JLabel currWeatherConditionLabel = new JLabel("Current Weather Conditions");
        currWeatherConditionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        currWeatherConditionLabel.setBounds(10, 150, 250, 24);
        currWeatherPanel.add(currWeatherConditionLabel);

        JLabel currHumidityLabel = new JLabel("Humidity: " + weatherData.getHumidity() + "%\r\n");
        currHumidityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currHumidityLabel.setBounds(10, 197, 150, 24);
        currWeatherPanel.add(currHumidityLabel);

        JLabel currWindSpeedLabel = new JLabel("Wind Speed: "+weatherData.getWindSpeed()+" km/h\r\n");
        currWindSpeedLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currWindSpeedLabel.setBounds(10, 174, 150, 24);
        currWeatherPanel.add(currWindSpeedLabel);

        JLabel currWindDirection = new JLabel("Wind Direction: "+weatherData.getWindDirectionString());
        currWindDirection.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currWindDirection.setBounds(181, 174, 200, 24);
        currWeatherPanel.add(currWindDirection);
        
        JLabel currPressureLabel = new JLabel("Pressure: "+ df.format(weatherData.getAirPressure()) +" kPa\r\n");
        currPressureLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currPressureLabel.setBounds(10, 221, 150, 24);
        currWeatherPanel.add(currPressureLabel);

        JLabel currTemp = new JLabel("Current Temperature: ");
        currTemp.setBounds(330, 22, 150, 50);
        currWeatherPanel.add(currTemp);
        
        JLabel currTempOutput = new JLabel(df.format(weatherData.getTemperature()) + "\u00B0");
        currTempOutput.setFont(new Font("Tahoma", Font.PLAIN, 56));
        currTempOutput.setBounds(330, 46, 250, 68);
        currWeatherPanel.add(currTempOutput);

        JLabel currLowestTemp = new JLabel("\u2207"+df.format(weatherData.getMinTemp())+"\u00B0");
        currLowestTemp.setBounds(397, 125, 60, 15);
        currWeatherPanel.add(currLowestTemp);

        JLabel currHighestTemp = new JLabel("\u25B2"+df.format(weatherData.getMaxTemp())+"\u00B0");
        currHighestTemp.setBounds(330, 125, 60, 14);
        currWeatherPanel.add(currHighestTemp);

        JLabel lastUpdatedLabel = new JLabel("Last updated: " + weatherData.getLastUpdatedTime());
        lastUpdatedLabel.setBounds(443, 238, 200, 14);
        currWeatherPanel.add(lastUpdatedLabel);
        
        JButton currRefreshButton = new JButton(new ImageIcon(myPictureUpdate));
        currRefreshButton.setContentAreaFilled(false);
        currRefreshButton.setBounds(519, 11, 40, 40);
        currWeatherPanel.add(currRefreshButton);

        /******END CURRENT WEATHER******/
        
        /******LOCATIONS******/
        
//        locationList = new JList<WeatherData>(locationNames);
//        locationList.setVisibleRowCount(4);	//Number of rows it will display
//        locationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Only one city can be selected at once
//        add(new JScrollPane(locationList));
//        locationList.addListSelectionListener(
//        		new ListSelectionListener(){
//					
//        			public void valueChanged(ListSelectionEvent e) {
//						
//						
//						
//					}
//        		});
        
        JLabel locationsLabel = new JLabel("Your Locations");
        locationsLabel.setBounds(10, 0, 200, 23);
        locationsLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        
        JButton btnAdd = new JButton("Add Location");
        btnAdd.setBounds(10, 560, 180, 23);
        btnAdd.addActionListener(
        new ActionListener() {
       		public void actionPerformed(ActionEvent e) {
       			final JFrame locationAdder = new JFrame("Add Location");
        		locationAdder.setSize(310,120);
        		locationAdder.setLocationRelativeTo(null);
        		locationAdder.setVisible(true);
        		locationAdder.getContentPane().setLayout(null);
        		
        		//Adding Text
        		JLabel cityInputLabel = new JLabel("Input a city: ");
        		cityInputLabel.setBounds(4, 5, 150, 23);
        		locationAdder.add(cityInputLabel);
        		
        		JLabel countryInputLabel = new JLabel("Input a country: ");
        		countryInputLabel.setBounds(4, 30, 150, 23);
        		locationAdder.add(countryInputLabel);
        		
        		//Adding a text field
        		final JTextField cityInput = new JTextField();
        		cityInput.setBounds(107, 5, 200, 23);
        		locationAdder.add(cityInput);
        		
        		final JTextField countryInput = new JTextField();
        		countryInput.setBounds(107, 30, 200, 23);
        		locationAdder.add(countryInput);
        		
        		//Adding an accept button
        		JButton btnAccept = new JButton("Accept");
        		btnAccept.setBounds(77, 65, 150, 23);
        		btnAccept.addActionListener(
        				new ActionListener() {
							public void actionPerformed(ActionEvent e) {
        						/*TODO: Take user input and add city data based on input */
        						userCityInput = cityInput.getName();
        						userCountryInput = countryInput.getName();
        						userCountryInput = changeToCountryCode(userCountryInput);
        						WeatherData newWeatherData = new WeatherData(userCityInput, userCountryInput);
        						addToLocationList(newWeatherData); //Adding the location to the myLocations list
        						locationAdder.setVisible(false);
        						locationAdder.dispose();	//Close the frame when accept is clicked
        					}
        				});
        		locationAdder.add(btnAccept);
        		
        		
       		}
       	});
        
//        JButton btnRemove = new JButton("Remove");
//        btnRemove.setBounds(86, 511, 101, 23);
        
//        locationInputField = new JTextField();
//        locationInputField.setBounds(10, 478, 177, 20);
//        locationInputField.setColumns(10);
//        LocationPanel.add(locationInputField);
        
        LocationPanel.setLayout(null);
        LocationPanel.add(locationsLabel);
        LocationPanel.add(btnAdd);
//        LocationPanel.add(btnRemove);
        contentPane.setLayout(gl_contentPane);
        
        /******END LOCATIONS******/
    }

	/**************METHODS*************/
    
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    
	public String changeToCountryCode(String country) {
		//TODO: Must use if statements to change input string country into a country code
		return country;
	}
	
	public void addToLocationList(WeatherData newWeatherData) {
		boolean check = false;
		for (int i=0; i<locationNames.length; i++) {
			if (locationNames[i] == null) {
				locationNames[i] = newWeatherData;
				check = true;
			}
		}
		if (check == false) {
			arrayOverflow(newWeatherData);
		}
	}
	
	public void arrayOverflow(WeatherData newWeatherData) {
		WeatherData[] newWeatherDataArray = new WeatherData[locationNames.length+1];
		int i=0;
		for (; i<locationNames.length; i++) {
			newWeatherDataArray[i] = locationNames[i];
		}
		newWeatherDataArray[i+1] = newWeatherData;
	}
	
    
}

