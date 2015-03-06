import com.fasterxml.jackson.annotation.JsonIgnore;


public class WeatherVals {
	
	private Coord coord;
	private Sys sys;
	private Weather weather;
	private String base; 
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private String dt, id, name, cod;

	public static class Coord
	{
		private double lon, lat;

		public double getLon() {
			return lon;
		}

		public double getLat() {
			return lat;
		}
		public void setLon(double lon) {
			this.lon = lon;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}
	}
	
	public static class Sys
	{
		private double type, id, message, sunrise, sunset;
		private String country;

		public double getType() {
			return type;
		}

		public double getId() {
			return id;
		}

		public double getMessage() {
			return message;
		}

		public String getCountry() {
			return country;
		}

		public double getSunrise() {
			return sunrise;
		}

		public double getSunset() {
			return sunset;
		}
		public void setType(double type) {
			this.type = type;
		}

		public void setId(double id) {
			this.id = id;
		}

		public void setMessage(double message) {
			this.message = message;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public void setSunrise(double sunrise) {
			this.sunrise = sunrise;
		}

		public void setSunset(double sunset) {
			this.sunset = sunset;
		}

	}
	public static class Weather
	{
		public void setId(String id) {
			this.id = id;
		}

		public void setMain(String main) {
			this.main = main;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		private String id, main, description, icon;

		public String getId() {
			return id;
		}

		public String getMain() {
			return main;
		}

		public String getDescription() {
			return description;
		}

		public String getIcon() {
			return icon;
		}
	}
	
	public static class Main
	{
		private double temp, pressure, humidity, temp_min, temp_max;

		public double getTemp() {
			return temp;
		}

		public double getPressure() {
			return pressure;
		}

		public double getHumidity() {
			return humidity;
		}

		public double getTemp_min() {
			return temp_min;
		}

		public double getTemp_max() {
			return temp_max;
		}

		public void setTemp(double temp) {
			this.temp = temp;
		}

		public void setPressure(double pressure) {
			this.pressure = pressure;
		}

		public void setHumidity(double humidity) {
			this.humidity = humidity;
		}

		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}

		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("temp: " + temp);
			sb.append("\npressure: " + pressure);
			sb.append("\nhumidity: " + humidity);
			sb.append("\ntemp_min: " + temp_min);
			sb.append("\ntemp_max: " + temp_max);
			return sb.toString();
			
		}
	}
	public static class Wind
	{
		private double speed, deg, varbeg, varend;

		public double getSpeed() {
			return speed;
		}

		public double getDeg() {
			return deg;
		}

		public double getVarbeg() {
			return varbeg;
		}

		public double getVarend() {
			return varend;
		}
		public void setSpeed(double speed) {
			this.speed = speed;
		}

		public void setDeg(double deg) {
			this.deg = deg;
		}

		public void setVarbeg(double varbeg) {
			this.varbeg = varbeg;
		}

		public void setVarend(double varend) {
			this.varend = varend;
		}
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("wind speed: " + speed);
			sb.append("\ndegree: " + deg);

			return sb.toString();
		} 
	}
	public static class Clouds
	{
		private int all;
		
		public int getAll()
		{
			return all;
		}
		public void setAll(int all)
		{
			this.all = all;
		}
	}
	public Coord getCoord() {
		return coord;
	}
	public Sys getSys() {
		return sys;
	}
	public Weather getWeather() {
		return weather;
	}
	public String getBase() {
		return base;
	}
	public Main getMain() {
		return main;
	}
	public Wind getWind() {
		return wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public String getDt() {
		return dt;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCod() {
		return cod;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	@JsonIgnore
	public void setWeather(Weather weather)
	{
		this.weather = weather;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	
}