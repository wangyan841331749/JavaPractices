package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo02 {

	//获取对象的实例，并操作对象
	public static void demo01() throws InstantiationException, IllegalAccessException{
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Person per = (Person) perClass.newInstance();
		per.setName("zs");
		per.setAge(23);
		System.out.println(per.getName() + "," + per.getAge());
	}
	
	//操作属性
	public static void demo02() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Person per = (Person) perClass.newInstance();
		Field idField = perClass.getDeclaredField("id");
		//访问的是private修饰的id,但是private是私有的
		//修改属性的访问权限 使用反射时，如果因为访问权限出现异常，可以通过Field/Method.setAccessible(true)
		idField.setAccessible(true);
		idField.set(per, 1);
		System.out.println(per.getId());
		System.out.println("==============");
		Method method = perClass.getDeclaredMethod("privateMethod", null);
		method.setAccessible(true);
		method.invoke(per,null);//方法的调用:invoke
		
		Method method2 = perClass.getDeclaredMethod("privateMethod2", String.class);
		method2.setAccessible(true);
		method2.invoke(per,"zs");//方法的调用:invoke
	}
	
	//操作构造方法
	@SuppressWarnings("rawtypes")
	public static void demo03() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Constructor<?>[] constructors = perClass.getConstructors();
		for(Constructor constructor : constructors){
			System.out.println(constructor);
		}
		
		Constructor<?>[] constructors2 = perClass.getDeclaredConstructors();
		for(Constructor constructor : constructors2){
			System.out.println(constructor);
		}
		
		//获取指定的构造方法
		//在反射中，根据类型获取方法时候：基本类型和包装类型不同
		Constructor<?> constructor = perClass.getConstructor(int.class);
		System.out.println(constructor);
		
		Constructor<?> constructor2 = perClass.getDeclaredConstructor(String.class);
		System.out.println(constructor2);
		constructor2.setAccessible(true);
		Person per3 = (Person) constructor2.newInstance("zs");
		System.out.println("per3"+per3);
		
		
		//获得构造函数，然后生成对象实例
		Person instance = (Person) constructor.newInstance(12);
		System.out.println(instance);
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		//demo01();
		//demo02();
		demo03();
	}

}
