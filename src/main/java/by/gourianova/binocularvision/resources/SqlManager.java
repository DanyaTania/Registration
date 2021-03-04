package by.gourianova.binocularvision.resources;

import java.util.ResourceBundle;


public class SqlManager {

	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sql");

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}

	private SqlManager() {
	}
}
