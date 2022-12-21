package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class weatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;

	private String lastupdateStr;

	private String temperature;
	
	private String cookieString;

	private String tempChoice;
	
	//Constructor
	public weatherBean(String cityStr, String countryStr, String tempStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;
		this.tempChoice = tempStr;
	}

	//Setters and Getters
	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}

	public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}

	public String getLastupdateStr() {
		return lastupdateStr;
	}

	public void setLastupdateStr(String lastupdateStr) {
		this.lastupdateStr = lastupdateStr;
	}

	public String getTemperatureStr() {
		return temperature;
	}

	public void setTemperatureStr(String temperature) {
		this.temperature = temperature;
	}
	
	public String getCookieString() {
		return cookieString;
	}

	public void setCookieString(String cookieString) {
		this.cookieString = cookieString;
	}
	
	public String getTempChoice() {
	return tempChoice;
}

	public void setTempChoice(String tempChoice) {
	this.tempChoice = tempChoice;
}
	

	//Method for transforming temp K to temperature of choice (celcius,fahrenheit,kelvin).
	public String tempCalculator() {
		String choice = this.tempChoice;
		String str = this.temperature;
		double kelvin = Double.parseDouble(str); // returns double primitive

		if (choice.equals("c")) {
			double celcius = (kelvin - 273.15);
			String celciusStr = DecimalFormat.getNumberInstance().format(celcius); //turns double to string
			celciusStr = new DecimalFormat("0.0#").format(celcius); //format string to 2 decimals
			return celciusStr;
		} else if (choice.equals("f")) {
			double fahrenheit = (1.8 * (kelvin - 273) + 32);
			String fahrenheitStr = DecimalFormat.getNumberInstance().format(fahrenheit); //turns double to string
			fahrenheitStr = new DecimalFormat("0.0#").format(fahrenheit); //format string to 2 decimals
			return fahrenheitStr;
		} else {
			String kelvinStr = DecimalFormat.getNumberInstance().format(kelvin); //turns double to string
			kelvinStr = new DecimalFormat("0.0#").format(kelvin); //format string to 2 decimals
			return kelvinStr;
		}
	}
	
	//Splits cookie string value, puts values in an ArrayList, returns Arraylist.
	public List<String> cookieCutter() {
		String string = this.cookieString;
		List<String> searchList = new ArrayList<String>(Arrays.asList(string.split(":")));
		
		return searchList;
		
	}
}
