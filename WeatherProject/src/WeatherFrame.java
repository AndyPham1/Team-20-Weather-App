import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class WeatherFrame extends JFrame implements ActionListener {
	 
	public WeatherFrame()
	{
		setTitle("Team 20 Weather App");
		setSize(500, 400); 
		setLocation(100, 200);
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBounds(40, 50, 40, 50);
		add(refreshButton);
		refreshButton.addActionListener(this);
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		JFrame f = new WeatherFrame();
		f.show();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
