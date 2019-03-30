package readfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
public class PropertiesDemo {
	public static final Properties PROP = new Properties();
	public static final String NAME_PATH = "readFile/file.properties";
	public static void init() {
		InputStream inputStream = PropertiesDemo.class.getClassLoader().getResourceAsStream(NAME_PATH);
		try {
			PROP.load(inputStream);
			inputStream.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 * @Description 通过key获取value
	 */
	public static String get(String key) {
		return PROP.getProperty(key);
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @Description 修改或者更新key
	 */
	public static void update(String key, String value) {
		FileOutputStream outFile = null;
		try {
			outFile = new FileOutputStream(PropertiesDemo.class.getClassLoader().getResource(NAME_PATH).getPath());
			PROP.setProperty(key, value);
			// 将properties中属性列表(键和元素对)写入输出流
			PROP.store(outFile, "");
			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param key
	 * @Description 通过key删除value
	 */
	public static void delete(String key) {
		PROP.remove(key);
		FileOutputStream outFile = null;
		try {
			outFile = new FileOutputStream(PropertiesDemo.class.getClassLoader().getResource(NAME_PATH).getPath());
			PROP.store(outFile, "");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @Description 循环所有key value
	 */
	@SuppressWarnings("rawtypes")
	public static void list() {
		// 得到配置文件的名字
		Enumeration en = PROP.propertyNames();
		while(en.hasMoreElements()) {
			String strKey = (String) en.nextElement();
			String strValue = PROP.getProperty(strKey);
			System.out.println(strKey  + "=" + strValue);
		}
	}
	
	public static void main(String[] args) {
		PropertiesDemo.init();
		// 修改
		PropertiesDemo.update("password", "12345d6");
		System.out.println(PropertiesDemo.get("password"));
		// 删除
		PropertiesDemo.delete("username");
		System.out.println(PropertiesDemo.get("username"));
		// 获取所有
		PropertiesDemo.list();
	}

}
