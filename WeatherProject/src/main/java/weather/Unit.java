
package main.java.weather;

public class Unit {
	private static final String KELVIN_UNIT = "kelvin";
	private static final String CELSIUS_UNIT = "celsius";
	private static final String FAHRENHEIT_UNIT = "fahrenheit";
	private static final double KELVIN_CONSTANT = 273.15;
	private String from_Unit;
	private String to_Unit;
	String current_unit;
	double temperature;
	
	public Unit(double temp, String unit)
	{
		this.temperature = temp;
		this.current_unit = unit; 
	}

	public void changeUnits(String unit_to_change_to)
	{
		this.from_Unit = current_unit;
		this.to_Unit = unit_to_change_to;
		convertTemperature();
	}
	/**
	 * convertTemperature converts the temperature from Celsius, Kelvin or Fahrenheit to its corresponding temperature
	 * @param from_Unit,to_Unit,temp 
	 * @return temp the temperature that has been converted
	 */
	private void convertTemperature()
	{
		if(kelvinToCelsius())
			temperature=K_to_C();
		else if(celsiusToKelvin()) 
			temperature=C_to_K();
		else if(kelvinToFahrenheit()) 
		{
			temperature=K_to_C();
			temperature=C_to_F();
		}
		else if(fahrenheitToKelvin())
		{
			temperature=F_to_C();
			temperature=C_to_K();
		}
		else if(fahrenheitToCelsius())
			temperature=F_to_C();
		else if(celsiusToFahrenheit()) //celsiusToFahrenheit 
			temperature=C_to_F();	
	}
	
	private boolean kelvinToCelsius()
	{
		if(from_Unit.equals(KELVIN_UNIT) && to_Unit.equals(CELSIUS_UNIT))
			return true;
		else
			return false;
	}
	private double K_to_C()
	{
		temperature = temperature - KELVIN_CONSTANT;
		return temperature;
	}
	private boolean celsiusToKelvin()
	{
		if(from_Unit.equals(CELSIUS_UNIT) && to_Unit.equals(KELVIN_UNIT)) 
			return true;
		else
			return false;
	}
	private double C_to_K()
	{
		temperature = temperature + KELVIN_CONSTANT;
		return temperature;
	}
	private boolean kelvinToFahrenheit()
	{
		if(from_Unit.equals(KELVIN_UNIT) && to_Unit.equals(FAHRENHEIT_UNIT)) 
			return true;
		else
			return false;
	}
	private boolean fahrenheitToKelvin()
	{
		if(from_Unit.equals(FAHRENHEIT_UNIT) && to_Unit.equals(KELVIN_UNIT))
			return true;
		else
			return false;
	}
	private boolean fahrenheitToCelsius()
	{
		if(from_Unit.equals(FAHRENHEIT_UNIT) && to_Unit.equals(CELSIUS_UNIT))
			return true;
		else
			return false;
	}
	private double F_to_C()
	{
		temperature = (temperature - 32.0)/(9.0/5.0);
		return temperature;
	}
	private boolean celsiusToFahrenheit()
	{
		if(from_Unit.equals(CELSIUS_UNIT) && to_Unit.equals(FAHRENHEIT_UNIT))
			return true;
		else
			return false;
	}
	private double C_to_F()
	{
		temperature = temperature * (9.0/5.0) + 32.0;
		return temperature;
	}
	
}
