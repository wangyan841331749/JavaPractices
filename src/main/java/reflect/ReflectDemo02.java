package reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

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
	
	//动态加载类名和方法
	public static void demo04() throws FileNotFoundException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException  {
		Properties prop = new Properties();
		prop.load(new FileReader("class.properties"));
		String className = prop.getProperty("classname");
		String methodName = prop.getProperty("methodname");
		Class<?> perClass = null;
		try {
			perClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Method method = perClass.getMethod(methodName);
		method.invoke(perClass.newInstance());
	}
	
	//反射可以越过泛型检查
	//虽然可以通过反射 访问private等访问修饰符不允许访问的变量，也可以忽略泛型检查，但是不建议这样做，会造成程序混乱
	public static void demo05() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		ArrayList<Integer> list = new ArrayList<>();
		list.add(123);
		list.add(3);
		list.add(2);
		Class<?> listClass = list.getClass();
		Method method = listClass.getMethod("add", Object.class);
		method.invoke(list, "zs");
		System.out.println(list);
	}
	
	public static void demo06() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Person per = new Person();
		PropertyUtil.setProperty(per, "name", "zs");
		PropertyUtil.setProperty(per,"age", 23);
		
		Student stu = new Student();
		PropertyUtil.setProperty(stu, "score", 99);
		System.out.println(per.getName()+","+per.getAge());
		System.out.println(stu.getScore());
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException {
		//demo01();
		//demo02();
		//demo03();
		demo04();
		//demo05();
		//demo06();
	}

}
