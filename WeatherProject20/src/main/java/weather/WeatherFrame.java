package weather;

import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.sun.media.jai.codec.PNGEncodeParam.Gray;
import java.util.concurrent.TimeUnit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.awt.event.*;
import java.awt.*;

/**
 * Weather Frame is the GUI for the app
 * @author Team 20
 */

public class WeatherFrame extends JFrame implements ActionListener {

	/* Instance Variables */
	
	private DefaultListModel weatherList;
	private WeatherData weatherData;
    private JLabel lastUpdatedLabel;
    private JPanel contentPane;
    private JList locationList;
    private static WeatherData[] locationNames = new WeatherData[1];
    private String userCityInput;
    private String userCountryInput;
    private DecimalFormat df;
    
    private BufferedImage refreshImage;
    private BufferedImage clearSkyImage;
    private BufferedImage fewCloudsImage;
    private BufferedImage scatteredCloudsImage;
    private BufferedImage brokenCloudsImage;
    private BufferedImage showerRainImage;
    private BufferedImage thunderstormImage;
    private BufferedImage rainImage;
    private BufferedImage snowImage;
    private BufferedImage mistImage;
    
    private JLabel longTermDay1;
    private JLabel longTermIcon1;
    private JLabel longWeatherCondition1;
    private JLabel longTermTemp1;
    private JLabel longMaxTemp1;
    private JLabel longMinTemp1;

    private JLabel longTermDay2;
    private JLabel longTermIcon2;
    private JLabel longWeatherCondition2;
    private JLabel longTermTemp2;
    private JLabel longMaxTemp2;
    private JLabel longMinTemp2;

    private JLabel longTermDay3;
    private JLabel longTermIcon3;
    private JLabel longWeatherCondition3;
    private JLabel longTermTemp3;
    private JLabel longMaxTemp3;
    private JLabel longMinTemp3;

    private JLabel longTermDay4;
    private JLabel longTermIcon4;
    private JLabel longWeatherCondition4;
    private JLabel longTermTemp4;
    private JLabel longMaxTemp4;
    private JLabel longMinTemp4;

    private JLabel longTermDay5;
    private JLabel longTermIcon5;
    private JLabel longWeatherCondition5;
    private JLabel longTermTemp5;
    private JLabel longMaxTemp5;
    private JLabel longMinTemp5;
    
    private JLabel shortTermTime1;
    private JLabel shortTermIcon1;
    private JLabel shortWeatherCondition1;
    private JLabel shortTermTemp1;

    private JLabel shortTermTime2;
    private JLabel shortTermIcon2;
    private JLabel shortWeatherCondition2;
    private JLabel shortTermTemp2;

    private JLabel shortTermTime3;
    private JLabel shortTermIcon3;
    private JLabel shortWeatherCondition3;
    private JLabel shortTermTemp3;

    private JLabel shortTermTime4;
    private JLabel shortTermIcon4;
    private JLabel shortWeatherCondition4;
    private JLabel shortTermTemp4;

    private JLabel shortTermTime5;
    private JLabel shortTermIcon5;
    private JLabel shortWeatherCondition5;
    private JLabel shortTermTemp5;

    private JLabel shortTermTime6;
    private JLabel shortTermIcon6;
    private JLabel shortWeatherCondition6;
    private JLabel shortTermTemp6;

    private JLabel shortTermTime7;
    private JLabel shortTermIcon7;
    private JLabel shortWeatherCondition7;
    private JLabel shortTermTemp7;

    private JLabel shortTermTime8;
    private JLabel shortTermIcon8;
    private JLabel shortWeatherCondition8;
    private JLabel shortTermTemp8;

    private JLabel currLocationLabel;
    private JLabel currWeatherDescriptionLabel;
    private JLabel currSunriseLabel;
    private JLabel currSunsetLabel;
    private JLabel currWeatherIcon;
    private JLabel currWeatherConditionLabel;
    private JLabel currHumidityLabel;
    private JLabel currWindSpeedLabel;
    private JLabel currWindDirection;
    private JLabel currPressureLabel;
    private JLabel currTempOutput;
    private JLabel currLowestTemp;
    private JLabel currHighestTemp;
    
    /* Constructor */
    
    public WeatherFrame() throws IOException {
    	
//        weatherData = new WeatherData("Toronto", "Ca");	//THIS IS PRACTICE
//    	locationNames[0] = weatherData;
    	weatherData = new WeatherData("London","Ca");
    	/*****IMAGES*****/
    	
    	URL url = new URL ("http://openweathermap.org/img/w/01d.png");
    	clearSkyImage = ImageIO.read(url); 
    	
    	url = new URL("http://openweathermap.org/img/w/02d.png");
    	fewCloudsImage = ImageIO.read(url);
    	
    	url = new URL("http://openweathermap.org/img/w/03d.png");
    	scatteredCloudsImage = ImageIO.read(url);
    	
    	url = new URL("http://openweathermap.org/img/w/04d.png");
    	brokenCloudsImage = ImageIO.read(url);
    	
    	url = new URL("http://openweathermap.org/img/w/09d.png");
    	showerRainImage = ImageIO.read(url);
    	
    	url = new URL("http://openweathermap.org/img/w/10d.png");
    	rainImage = ImageIO.read(url);
    	
    	url = new URL("http://openweathermap.org/img/w/11d.png");
    	thunderstormImage = ImageIO.read(url);
    	
    	url = new URL("http://openweathermap.org/img/w/13d.png");
    	snowImage = ImageIO.read(url);
    	
    	url = new URL("http://openweathermap.org/img/w/50d.png");
    	mistImage = ImageIO.read(url);
    	
        refreshImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("update.png"));

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
        
        
        JMenu menuEdit = new JMenu("Edit");
        JMenuItem menuEditRemove = new JMenuItem("Remove");
        menuEditRemove.setToolTipText("Choose a location you wish to remove.");
        menuEditRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		//TODO
        		//JFrame locationsFrame = new JFrame();
        		
        		
        	};
        });
        
        
        menuEdit.add(menuEditRemove);
        menubar.add(menuEdit);
        
        
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
        
        longTermDay1 = new JLabel("Monday");
        longTermDay1.setHorizontalAlignment(SwingConstants.CENTER);
        longTermDay1.setBounds(10, 11, 82, 14);
        longTermPanel1.add(longTermDay1);

        // Adds an image
        longTermIcon1 = new JLabel(new ImageIcon(rainImage));
        longTermIcon1.setBounds(10, 30, 82, 50);
        longTermPanel1.add(longTermIcon1);

        longWeatherCondition1 = new JLabel("Cloudy");
        longWeatherCondition1.setHorizontalAlignment(SwingConstants.CENTER);
        longWeatherCondition1.setBounds(10, 84, 82, 14);
        longTermPanel1.add(longWeatherCondition1);

        longTermTemp1 = new JLabel("21\u00B0");
        longTermTemp1.setFont(new Font("Tahoma", Font.BOLD, 16));
        longTermTemp1.setHorizontalAlignment(SwingConstants.CENTER);
        longTermTemp1.setBounds(10, 103, 82, 20);
        longTermPanel1.add(longTermTemp1);

        longMaxTemp1 = new JLabel("\u25B230");
        longMaxTemp1.setBounds(10, 123, 40, 14);
        longTermPanel1.add(longMaxTemp1);

        longMinTemp1 = new JLabel("\u220715");
        longMinTemp1.setHorizontalAlignment(SwingConstants.RIGHT);
        longMinTemp1.setBounds(51, 123, 40, 15);
        longTermPanel1.add(longMinTemp1);

        JPanel longTermPanel2 = new JPanel();
        longTermPanel2.setBackground(new Color(255, 153, 0));
        longTermPanel2.setBounds(122, 11, 102, 149);
        longTermFullPanel.add(longTermPanel2);
        longTermPanel2.setLayout(null);

        longTermDay2 = new JLabel("Tuesday");
        longTermDay2.setHorizontalAlignment(SwingConstants.CENTER);
        longTermDay2.setBounds(10, 11, 82, 14);
        longTermPanel2.add(longTermDay2);
        
        // Adds an image
        longTermIcon2 = new JLabel(new ImageIcon(rainImage));
        longTermIcon2.setBounds(10, 30, 82, 50);
        longTermPanel2.add(longTermIcon2);

        longWeatherCondition2 = new JLabel("Cloudy");
        longWeatherCondition2.setHorizontalAlignment(SwingConstants.CENTER);
        longWeatherCondition2.setBounds(10, 84, 82, 14);
        longTermPanel2.add(longWeatherCondition2);

        longTermTemp2 = new JLabel("21\u00B0");
        longTermTemp2.setHorizontalAlignment(SwingConstants.CENTER);
        longTermTemp2.setFont(new Font("Tahoma", Font.BOLD, 16));
        longTermTemp2.setBounds(10, 103, 82, 20);
        longTermPanel2.add(longTermTemp2);

        longMaxTemp2 = new JLabel("\u25B230");
        longMaxTemp2.setBounds(10, 123, 40, 14);
        longTermPanel2.add(longMaxTemp2);

        longMinTemp2 = new JLabel("\u220715");
        longMinTemp2.setHorizontalAlignment(SwingConstants.RIGHT);
        longMinTemp2.setBounds(51, 123, 40, 15);
        longTermPanel2.add(longMinTemp2);

        JPanel longTermPanel3 = new JPanel();
        longTermPanel3.setBackground(new Color(255, 153, 0));
        longTermPanel3.setBounds(234, 11, 102, 149);
        longTermFullPanel.add(longTermPanel3);
        longTermPanel3.setLayout(null);

        longTermDay3 = new JLabel("Wednesday");
        longTermDay3.setHorizontalAlignment(SwingConstants.CENTER);
        longTermDay3.setBounds(10, 11, 82, 14);
        longTermPanel3.add(longTermDay3);

        // Adds an image
        longTermIcon3 = new JLabel(new ImageIcon(rainImage));
        longTermIcon3.setBounds(10, 30, 82, 50);
        longTermPanel3.add(longTermIcon3);

        longWeatherCondition3 = new JLabel("Cloudy");
        longWeatherCondition3.setHorizontalAlignment(SwingConstants.CENTER);
        longWeatherCondition3.setBounds(10, 84, 82, 14);
        longTermPanel3.add(longWeatherCondition3);

        longTermTemp3 = new JLabel("21\u00B0");
        longTermTemp3.setHorizontalAlignment(SwingConstants.CENTER);
        longTermTemp3.setFont(new Font("Tahoma", Font.BOLD, 16));
        longTermTemp3.setBounds(10, 103, 82, 20);
        longTermPanel3.add(longTermTemp3);

        longMaxTemp3 = new JLabel("\u25B230");
        longMaxTemp3.setBounds(10, 123, 40, 14);
        longTermPanel3.add(longMaxTemp3);

        longMinTemp3 = new JLabel("\u220715");
        longMinTemp3.setHorizontalAlignment(SwingConstants.RIGHT);
        longMinTemp3.setBounds(51, 123, 40, 15);
        longTermPanel3.add(longMinTemp3);

        JPanel longTermPanel4 = new JPanel();
        longTermPanel4.setBackground(new Color(255, 153, 0));
        longTermPanel4.setBounds(346, 11, 102, 149);
        longTermFullPanel.add(longTermPanel4);
        longTermPanel4.setLayout(null);

        longTermDay4 = new JLabel("Thursday");
        longTermDay4.setHorizontalAlignment(SwingConstants.CENTER);
        longTermDay4.setBounds(10, 11, 82, 14);
        longTermPanel4.add(longTermDay4);

        // Adds an image
        longTermIcon4 = new JLabel(new ImageIcon(rainImage));
        longTermIcon4.setBounds(10, 30, 82, 50);
        longTermPanel4.add(longTermIcon4);

        longWeatherCondition4 = new JLabel("Cloudy");
        longWeatherCondition4.setHorizontalAlignment(SwingConstants.CENTER);
        longWeatherCondition4.setBounds(10, 84, 82, 14);
        longTermPanel4.add(longWeatherCondition4);

        longTermTemp4 = new JLabel("21\u00B0");
        longTermTemp4.setHorizontalAlignment(SwingConstants.CENTER);
        longTermTemp4.setFont(new Font("Tahoma", Font.BOLD, 16));
        longTermTemp4.setBounds(10, 103, 82, 20);
        longTermPanel4.add(longTermTemp4);

        longMaxTemp4 = new JLabel("\u25B230");
        longMaxTemp4.setBounds(10, 123, 40, 14);
        longTermPanel4.add(longMaxTemp4);

        longMinTemp4 = new JLabel("\u220715");
        longMinTemp4.setHorizontalAlignment(SwingConstants.RIGHT);
        longMinTemp4.setBounds(51, 123, 40, 15);
        longTermPanel4.add(longMinTemp4);

        JPanel longTermPanel5 = new JPanel();
        longTermPanel5.setBackground(new Color(255, 153, 0));
        longTermPanel5.setBounds(458, 11, 102, 149);
        longTermFullPanel.add(longTermPanel5);
        longTermPanel5.setLayout(null);

        longTermDay5 = new JLabel("Friday");
        longTermDay5.setHorizontalAlignment(SwingConstants.CENTER);
        longTermDay5.setBounds(10, 11, 82, 14);
        longTermPanel5.add(longTermDay5);

        // Adds an image
        longTermIcon5 = new JLabel(new ImageIcon(rainImage));
        longTermIcon5.setBounds(10, 30, 82, 50);
        longTermPanel5.add(longTermIcon5);

        longWeatherCondition5 = new JLabel("Cloudy");
        longWeatherCondition5.setHorizontalAlignment(SwingConstants.CENTER);
        longWeatherCondition5.setBounds(10, 84, 82, 14);
        longTermPanel5.add(longWeatherCondition5);

        longTermTemp5 = new JLabel("21\u00B0");
        longTermTemp5.setHorizontalAlignment(SwingConstants.CENTER);
        longTermTemp5.setFont(new Font("Tahoma", Font.BOLD, 16));
        longTermTemp5.setBounds(10, 103, 82, 20);
        longTermPanel5.add(longTermTemp5);

        longMaxTemp5 = new JLabel("\u25B230");
        longMaxTemp5.setBounds(10, 123, 40, 14);
        longTermPanel5.add(longMaxTemp5);

        longMinTemp5 = new JLabel("\u220715");
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

        shortTermTime1 = new JLabel("3 PM");
        shortTermTime1.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime1.setBounds(10, 11, 40, 14);
        shortTermPanel1.add(shortTermTime1);

        // Adds an image
        shortTermIcon1 = new JLabel(new ImageIcon(rainImage));
        shortTermIcon1.setBounds(10, 28, 40, 40);
        shortTermPanel1.add(shortTermIcon1);

        shortTermTemp1 = new JLabel("-12\u00B0");
        shortTermTemp1.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp1.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp1.setBounds(10, 79, 40, 26);
        shortTermPanel1.add(shortTermTemp1);

        shortWeatherCondition1 = new JLabel("Cloudy");
        shortWeatherCondition1.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition1.setBounds(0, 68, 60, 14);
        shortTermPanel1.add(shortWeatherCondition1);

        JPanel shortTermPanel2 = new JPanel();
        shortTermPanel2.setBackground(new Color(255, 153, 0));
        shortTermPanel2.setBounds(80, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel2);
        shortTermPanel2.setLayout(null);

        shortTermTime2 = new JLabel("6 PM");
        shortTermTime2.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime2.setBounds(10, 11, 40, 14);
        shortTermPanel2.add(shortTermTime2);

        // Adds an image
        shortTermIcon2 = new JLabel(new ImageIcon(rainImage));
        shortTermIcon2.setBounds(10, 28, 40, 40);
        shortTermPanel2.add(shortTermIcon2);

        shortWeatherCondition2 = new JLabel("Cloudy");
        shortWeatherCondition2.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition2.setBounds(0, 68, 60, 14);
        shortTermPanel2.add(shortWeatherCondition2);

        shortTermTemp2 = new JLabel("-12\u00B0");
        shortTermTemp2.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp2.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp2.setBounds(10, 79, 40, 26);
        shortTermPanel2.add(shortTermTemp2);

        JPanel shortTermPanel3 = new JPanel();
        shortTermPanel3.setBackground(new Color(255, 153, 0));
        shortTermPanel3.setBounds(150, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel3);
        shortTermPanel3.setLayout(null);

        shortTermTime3 = new JLabel("9 PM");
        shortTermTime3.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime3.setBounds(10, 11, 40, 14);
        shortTermPanel3.add(shortTermTime3);

        // Adds an image
        shortTermIcon3 = new JLabel(new ImageIcon(rainImage));
        shortTermIcon3.setBounds(10, 28, 40, 40);
        shortTermPanel3.add(shortTermIcon3);

        shortWeatherCondition3 = new JLabel("Cloudy");
        shortWeatherCondition3.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition3.setBounds(0, 68, 60, 14);
        shortTermPanel3.add(shortWeatherCondition3);

        shortTermTemp3 = new JLabel("-12\u00B0");
        shortTermTemp3.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp3.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp3.setBounds(10, 79, 40, 26);
        shortTermPanel3.add(shortTermTemp3);

        JPanel shortTermPanel4 = new JPanel();
        shortTermPanel4.setBackground(new Color(255, 153, 0));
        shortTermPanel4.setBounds(220, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel4);
        shortTermPanel4.setLayout(null);

        shortTermTime4 = new JLabel("12 AM");
        shortTermTime4.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime4.setBounds(10, 11, 40, 14);
        shortTermPanel4.add(shortTermTime4);

        // Adds an image
        shortTermIcon4 = new JLabel(new ImageIcon(rainImage));
        shortTermIcon4.setBounds(10, 28, 40, 40);
        shortTermPanel4.add(shortTermIcon4);

        shortWeatherCondition4 = new JLabel("Cloudy");
        shortWeatherCondition4.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition4.setBounds(0, 68, 60, 14);
        shortTermPanel4.add(shortWeatherCondition4);

        shortTermTemp4 = new JLabel("-12\u00B0");
        shortTermTemp4.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp4.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp4.setBounds(10, 79, 40, 26);
        shortTermPanel4.add(shortTermTemp4);

        JPanel shortTermPanel5 = new JPanel();
        shortTermPanel5.setBackground(new Color(255, 153, 0));
        shortTermPanel5.setBounds(290, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel5);
        shortTermPanel5.setLayout(null);

        shortTermTime5 = new JLabel("3 AM");
        shortTermTime5.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime5.setBounds(10, 11, 40, 14);
        shortTermPanel5.add(shortTermTime5);

        // Adds an image
        shortTermIcon5 = new JLabel(new ImageIcon(rainImage));
        shortTermIcon5.setBounds(10, 28, 40, 40);
        shortTermPanel5.add(shortTermIcon5);

        shortWeatherCondition5 = new JLabel("Cloudy");
        shortWeatherCondition5.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition5.setBounds(0, 68, 60, 14);
        shortTermPanel5.add(shortWeatherCondition5);

        shortTermTemp5 = new JLabel("-12\u00B0");
        shortTermTemp5.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp5.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp5.setBounds(10, 79, 40, 26);
        shortTermPanel5.add(shortTermTemp5);

        JPanel shortTermPanel6 = new JPanel();
        shortTermPanel6.setBackground(new Color(255, 153, 0));
        shortTermPanel6.setBounds(360, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel6);
        shortTermPanel6.setLayout(null);

        shortTermTime6 = new JLabel("6 AM");
        shortTermTime6.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime6.setBounds(10, 11, 40, 14);
        shortTermPanel6.add(shortTermTime6);

        // Adds an image
        shortTermIcon6 = new JLabel(new ImageIcon(rainImage));
        shortTermIcon6.setBounds(10, 28, 40, 40);
        shortTermPanel6.add(shortTermIcon6);

        shortWeatherCondition6 = new JLabel("Cloudy");
        shortWeatherCondition6.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition6.setBounds(0, 68, 60, 14);
        shortTermPanel6.add(shortWeatherCondition6);

        shortTermTemp6 = new JLabel("-12\u00B0");
        shortTermTemp6.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp6.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp6.setBounds(10, 79, 40, 26);
        shortTermPanel6.add(shortTermTemp6);

        JPanel shortTermPanel7 = new JPanel();
        shortTermPanel7.setBackground(new Color(255, 153, 0));
        shortTermPanel7.setBounds(430, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel7);
        shortTermPanel7.setLayout(null);

        shortTermTime7 = new JLabel("9 AM");
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

        shortTermIcon7 = new JLabel(new ImageIcon(rainImage));
        shortTermIcon7.setBounds(10, 28, 40, 40);
        shortTermPanel7.add(shortTermIcon7);

        shortWeatherCondition7 = new JLabel("Cloudy");
        shortWeatherCondition7.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition7.setBounds(0, 68, 60, 14);
        shortTermPanel7.add(shortWeatherCondition7);

        shortTermTemp7 = new JLabel("-12\u00B0");
        shortTermTemp7.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp7.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp7.setBounds(10, 79, 40, 26);
        shortTermPanel7.add(shortTermTemp7);

        JPanel shortTermPanel8 = new JPanel();
        shortTermPanel8.setBackground(new Color(255, 153, 0));
        shortTermPanel8.setBounds(500, 11, 60, 116);
        shortTermFullPanel.add(shortTermPanel8);
        shortTermPanel8.setLayout(null);

        shortTermTime8 = new JLabel("12 PM");
        shortTermTime8.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTime8.setBounds(10, 11, 40, 14);
        shortTermPanel8.add(shortTermTime8);


        // Adds an image
        shortTermIcon8 = new JLabel(new ImageIcon(rainImage));
        shortTermIcon8.setBounds(10, 28, 40, 40);
        shortTermPanel8.add(shortTermIcon8);

        shortWeatherCondition8 = new JLabel("Cloudy");
        shortWeatherCondition8.setHorizontalAlignment(SwingConstants.CENTER);
        shortWeatherCondition8.setBounds(0, 68, 60, 14);
        shortTermPanel8.add(shortWeatherCondition8);

        shortTermTemp8 = new JLabel("-12\u00B0");
        shortTermTemp8.setHorizontalAlignment(SwingConstants.CENTER);
        shortTermTemp8.setFont(new Font("Tahoma", Font.BOLD, 13));
        shortTermTemp8.setBounds(10, 79, 40, 26);
        shortTermPanel8.add(shortTermTemp8);
        currWeatherPanel.setLayout(null);

        
        
        /******END SHORT TERM WEATHER******/
        
        ////////////////////////////////////////////
        
        /******CURRENT WEATHER*****/
        
        
        
        
        //To keep certain variables to one decimal place
        df = new DecimalFormat(); 
        df.setMaximumFractionDigits(1);
        
        currLocationLabel = new JLabel(weatherData.getCurrentCity() + ", " +weatherData.getCountryCode());
        currLocationLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        currLocationLabel.setBounds(10, 11, 400, 24);
        currLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        currWeatherPanel.add(currLocationLabel);

        currSunriseLabel = new JLabel("Sunrise: "+ weatherData.getSunrise());
        currSunriseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currSunriseLabel.setBounds(181, 202, 200, 14);
        currWeatherPanel.add(currSunriseLabel);

        currSunsetLabel = new JLabel("Sunset: " + weatherData.getSunset());
        currSunsetLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currSunsetLabel.setBounds(181, 227, 200, 14);
        currWeatherPanel.add(currSunsetLabel);
        
        currWeatherDescriptionLabel = new JLabel("Conditions: "+weatherData.getDescription());
        currWeatherDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currWeatherDescriptionLabel.setBounds(10, 151, 400, 24);
        currWeatherPanel.add(currWeatherDescriptionLabel);
        
        
        // Adds an image
        System.out.println(weatherData.getDescription());
        currWeatherIcon = new JLabel(new ImageIcon(displayCorrectImage(weatherData.getDescription())));
        currWeatherIcon.setBounds(10, 40, 100, 100);
        
        currWeatherPanel.add(currWeatherIcon);

        currWeatherConditionLabel = new JLabel("Weather Conditions");
        currWeatherConditionLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        currWeatherConditionLabel.setBounds(10, 120, 250, 24);
        currWeatherPanel.add(currWeatherConditionLabel);

        currHumidityLabel = new JLabel("Humidity: " + weatherData.getHumidity() + "%\r\n");
        currHumidityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currHumidityLabel.setBounds(10, 197, 170, 24);
        currWeatherPanel.add(currHumidityLabel);

        currWindSpeedLabel = new JLabel("Wind Speed: "+df.format(weatherData.getWindSpeed())+" km/h\r\n");
        currWindSpeedLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currWindSpeedLabel.setBounds(10, 174, 170, 24);
        currWeatherPanel.add(currWindSpeedLabel);

        currWindDirection = new JLabel("Wind Direction: "+weatherData.getWindDirectionString());
        currWindDirection.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currWindDirection.setBounds(181, 174, 200, 24);
        currWeatherPanel.add(currWindDirection);
        
        currPressureLabel = new JLabel("Pressure: "+ df.format(weatherData.getAirPressure()) +" kPa\r\n");
        currPressureLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currPressureLabel.setBounds(10, 221, 150, 24);
        currWeatherPanel.add(currPressureLabel);

        JLabel currTemp = new JLabel("Current Temperature: ");
        currTemp.setBounds(330, 22, 150, 50);
        currWeatherPanel.add(currTemp);
        
        currTempOutput = new JLabel(df.format(weatherData.getTemperature()) + "\u00B0");
        currTempOutput.setFont(new Font("Tahoma", Font.PLAIN, 56));
        currTempOutput.setBounds(330, 46, 250, 68);
        currWeatherPanel.add(currTempOutput);

        currLowestTemp = new JLabel("\u2207"+df.format(weatherData.getMinTemp())+"\u00B0");
        currLowestTemp.setBounds(397, 125, 60, 15);
        currWeatherPanel.add(currLowestTemp);

        currHighestTemp = new JLabel("\u25B2"+df.format(weatherData.getMaxTemp())+"\u00B0");
        currHighestTemp.setBounds(330, 125, 60, 14);
        currWeatherPanel.add(currHighestTemp);

        lastUpdatedLabel = new JLabel("Last updated: " + weatherData.getLastUpdatedTime());
        lastUpdatedLabel.setBounds(443, 238, 200, 14);
        currWeatherPanel.add(lastUpdatedLabel);
        
        JButton currRefreshButton = new JButton(new ImageIcon(refreshImage));
        currRefreshButton.setContentAreaFilled(false);
        currRefreshButton.setBounds(519, 11, 40, 40);
        currWeatherPanel.add(currRefreshButton);
        currRefreshButton.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				lastUpdatedLabel.setText("Updating ...");
        				refreshGUI();
        			}
        		});

        /******END CURRENT WEATHER******/
        
        /******LOCATIONS******/
        
        weatherList = new DefaultListModel();
        locationList = new JList(weatherList);
        final JScrollPane pane = new JScrollPane(locationList);
        pane.setBounds(10, 25, 180, 520);
        
        //Switching the current weatherData when JList object is selected
        locationList.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		locationList = (JList)e.getSource();
        		if (e.getClickCount()==1) {		//If an object is clicked then: 
        			if (SwingUtilities.isLeftMouseButton(e)) {
        				String s = (String) locationList.getSelectedValue();
        				weatherData = changeWeatherLocation(s, weatherData);
        				refreshGUI();
        			}
        			else if (SwingUtilities.isRightMouseButton(e)) {
        				final JPopupMenu deleteMenu = new JPopupMenu("Delete");
        				JMenuItem deleteButton = new JMenuItem("Delete");
        				deleteMenu.add(deleteButton);
        				deleteMenu.setVisible(true);
        				System.out.println(locationList.getSelectedIndex());
        				locationList.setSelectedIndex(locationList.getSelectedIndex());
        				final boolean check = false;
        				deleteButton.addActionListener(new ActionListener() {
        					public void actionPerformed(ActionEvent e) {
       							deleteMenu.setVisible(false);
       							weatherList.removeElementAt(locationList.getSelectedIndex());
       							updateLocationList();
       						}
       					});
       				}
                }
       		}
 
        });
        
        
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
        		locationAdder.add(btnAccept);
        		btnAccept.addActionListener(
        				new ActionListener() {
							public void actionPerformed(ActionEvent e) {
        						userCityInput = cityInput.getText();
        						userCountryInput = countryInput.getText();
        						userCountryInput = changeToCountryCode(userCountryInput);
        						WeatherData newWeatherData = new WeatherData(userCityInput, userCountryInput);
        						addToLocationList(newWeatherData); //Adding the location to the myLocations list
        						locationAdder.dispose();	//Close the frame when accept is clicked
        					}
        				});
       		}
       	});
        
        
        LocationPanel.setLayout(null);
        LocationPanel.add(locationsLabel);
        LocationPanel.add(btnAdd);
        LocationPanel.add(pane);
        contentPane.setLayout(gl_contentPane);
        updateLocationList();
        /******END LOCATIONS******/
    }

    
    
    
    
    
    
    
    
    
    
	/**************METHODS*************/
    
	public void actionPerformed(ActionEvent e) {
		
	}
    
	public WeatherData changeWeatherLocation(String s, WeatherData weatherData) {
		for (int i=0; i<locationNames.length; i++) {
			String checkString = new String(locationNames[i].getCurrentCity()+", "+locationNames[i].getCountryCode());
			
			if (checkString.equals(s)) {
				weatherData = locationNames[i];
				return weatherData;
			}
			
		}
		return null;
	}
	
	
    public BufferedImage displayCorrectImage(String description) {
        if (description.equals("clear sky") ||
        	description.equals("calm") ||
        	description.equals("light breeze") ||
        	description.equals("gentle breeze") ||
        	description.equals("moderate breeze") ||
        	description.equals("fresh breeze") ||
            description.equals("Sky is Clear") ||
            description.equals("sky is clear")
            ) {
        	return clearSkyImage;
        }
        else if (description.equals("few clouds") || description.equals("overcast clouds")) {
        	return fewCloudsImage;
        }
        else if (description.equals("scattered clouds")) {
        	return scatteredCloudsImage;
        }
        else if (description.equals("broken clouds")) {
        	return brokenCloudsImage;
        }
        else if (description.equals("shower rain") ||
        		description.equals("heavy intensity drizzle") ||
        		description.equals("heavy intensity drizzle rain") ||
        		description.equals("heavy shower rain and drizzle") ||
        		description.equals("shower drizzle") ||
        		description.equals("shower rain and drizzle")
                 ) {
        	return showerRainImage; 
        }
        else if (description.equals("rain") ||
        		description.equals("light intensity drizzle") ||
        		description.equals("drizzle") ||
        		description.equals("light intensity drizzle rain") ||
        		description.equals("light rain") ||
        		description.equals("drizzle rain") ||
        		description.equals("moderate rain")
        		) {
        	return rainImage;
        }
        else if (description.equals("thunderstorm") ||
                description.equals("thunderstorm with light rain") ||
                description.equals("thunderstorm with rain") ||
                description.equals("thunderstorm with heavy rain")  ||
                description.equals("light thunderstorm") ||
                description.equals("heavy thunderstorm") ||
                description.equals("ragged thunderstorm") ||
                description.equals("thunderstorm with light drizzle") ||
                description.equals("thunderstorm with drizzle") ||
                description.equals("thunderstorm with heavy drizzle")
                ) {
            return thunderstormImage;
        }
        else if (description.equals("snow") ||
                description.equals("light snow") ||
                description.equals("heavy snow") ||
                description.equals("sleet") ||
                description.equals("shower sleet") ||
                description.equals("light rain and snow") ||
                description.equals("rain and snow") ||
                description.equals("light shower snow") ||
                description.equals("shower snow") ||
                description.equals("heavy shower snow")
                ) {
        	return snowImage;
        }
        else if (description.equals("mist") ||
                 description.equals("smoke") ||
                 description.equals("haze") ||
                 description.equals("sand, dust whirls") ||
                 description.equals("fog") ||
                 description.equals("sand") ||
                 description.equals("dust") ||
                 description.equals("volcanic ash") ||
                 description.equals("squalls") ||
                 description.equals("tornado") ||
                 description.equals("tropical storm") ||
                 description.equals("hurricane") ||
                 description.equals("windy") ||
                 description.equals("cold") ||
                 description.equals("hot") ||
                 description.equals("strong breeze") ||
                 description.equals("high wind, near gale") ||
                 description.equals("gale") ||
                 description.equals("severe gale") ||
                 description.equals("storm") ||
                 description.equals("violent storm")
                 ) {
        	return mistImage;
        }
        return null;
    }
    
    
	public String changeToCountryCode(String country) {
		country = country.replace(' ', '-');
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
			updateLocationList();
			return;
		}
		updateLocationList();
	}
	
	public void arrayOverflow(WeatherData newWeatherData) {
		WeatherData[] newWeatherDataArray = new WeatherData[locationNames.length+1];
		int i=0;
		for (; i<locationNames.length; i++) {
			newWeatherDataArray[i] = locationNames[i];
		}
		newWeatherDataArray[locationNames.length] = newWeatherData;
		locationNames = newWeatherDataArray;
	}
	
	
	public WeatherData[] removeLocationList(String cityName) {
		WeatherData[] newWeatherDataArray = new WeatherData[locationNames.length];
		for (int i=0; i<locationNames.length; i++) {
			if ((locationNames[i].getCurrentCity()+", "+locationNames[i].getCountryCode()).equals(cityName)) {
				locationNames[i] = null;
			}
		}
		boolean check = false;
		for (int i=0; i<locationNames.length; i++) {
			if (locationNames[i] != null) {
				if (!check) {
					newWeatherDataArray[i] = locationNames[i];
				}
				else {
					newWeatherDataArray[i-1] = locationNames[i];
				}
				
			}
			else 
				check = true;
		}
		return newWeatherDataArray;
		
	}
	
	
	public void updateLocationList() {
		weatherList.removeAllElements();
		for (int i=0; i<locationNames.length; i++) {
			if (locationNames[i]!=null) {
				 weatherList.addElement(locationNames[i].getCurrentCity() + ", " + locationNames[i].getCountryCode());
			}
		}
	}
	
    public void refreshGUI() {
    	try {
			weatherData.update();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    	currLocationLabel.setText(weatherData.getCurrentCity() + ", " +weatherData.getCountryCode());
    	currSunriseLabel.setText("Sunrise: "+ weatherData.getSunrise());
    	currSunsetLabel.setText("Sunset: " + weatherData.getSunset());
    	currWeatherConditionLabel.setText("Weather Conditions");
    	currHumidityLabel.setText("Humidity: " + weatherData.getHumidity() + "%\r\n");
    	currWindSpeedLabel.setText("Wind Speed: "+df.format(weatherData.getWindSpeed())+" km/h\r\n");
    	currWindDirection.setText("Wind Direction: "+weatherData.getWindDirectionString());
    	currPressureLabel.setText("Pressure: "+ df.format(weatherData.getAirPressure()) +" kPa\r\n");
    	currTempOutput.setText(df.format(weatherData.getTemperature()) + "\u00B0");
    	currLowestTemp.setText("\u2207"+df.format(weatherData.getMinTemp())+"\u00B0");
    	currHighestTemp.setText("\u25B2"+df.format(weatherData.getMaxTemp())+"\u00B0");
		lastUpdatedLabel.setText("Last updated: " + weatherData.getLastUpdatedTime());
		currWeatherDescriptionLabel.setText("Conditions: "+weatherData.getDescription());
		currWeatherIcon.setIcon(new ImageIcon(displayCorrectImage(weatherData.getDescription())));
		}
    
}

