package reflect;

import java.lang.reflect.Field;

public class PropertyUtil {
	public static void setProperty(Object obj,String propertyName,Object value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
	Class<?> clazz = obj.getClass();
	Field field = clazz.getDeclaredField(propertyName);
	field.setAccessible(true);
	field.set(obj, value);
	}
 }
