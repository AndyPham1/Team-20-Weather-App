import javax.swing.*;

public class WeatherFrame extends JFrame {
	public WeatherFrame()
	{
		setTitle("Team 20 Weather App");
		setSize(500, 400); 
		setLocation(100, 200);
	}
	
	public static void main(String[] args)
	{
		JFrame f = new WeatherFrame();
		f.show();
	}
}
