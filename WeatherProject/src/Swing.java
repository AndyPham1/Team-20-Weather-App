import javax.swing.SwingUtilities;

public class Swing {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				WeatherFrame window = new WeatherFrame();
				window.setVisible(true);
			}
		});
	}
}