package pyt.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class MessageUtil {

	public static String getProperty(String property) {
		Properties properties = null;
		try {
			properties = getProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(MessageUtil.class).error(
					"Erro de IO de message.properties: " + e.getMessage());
		}
		return properties.getProperty(property);
	}

	private static Properties getProperties() throws IOException {
		InputStream msgProps = MessageUtil.class
				.getResourceAsStream("/message.properties");

		Properties properties = new Properties();
		properties.load(msgProps);
		return properties;

	}
}
