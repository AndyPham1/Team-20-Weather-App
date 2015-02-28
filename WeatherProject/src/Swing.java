import javax.swing.SwingUtilities;

/**
 * Swing is a class for the GUI 
 * @author Team 20
 */

public class Swing {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
                try {
                    WeatherFrame window = new WeatherFrame();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

			}
		});
	}
}