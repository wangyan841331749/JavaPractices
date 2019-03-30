package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 通过反射获取类
 * @version 2019年3月30日
 */
public class ReflectDemo01 {
	
	/**
	 * 获取反射对象(反射入口):Class 
	 * 1. Class.forName(全类名) 
	 * 2. xx.class 
	 * 3. 对象.getClass()
	 * 
	 */
	public static void demo01() {
		// 1.Class.forName(全类名)
		try {
			Class<?> perClass = Class.forName("reflect.Person");
			System.out.println(perClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2.类名.class
		Class<?> perClass2 = Person.class;
		System.out.println(perClass2);
		
		// 3.对象.getClass()
		Person per = new Person();
		Class<?> perClass3 = per.getClass();
		System.out.println(perClass3);
		}
	
	/**
	 * 
	 * 
	 * @Description 获取方法
	 */
	public static void demo02() {
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 获取所有的公共的方法(1.本类以及父类，接口中的所有方法 2.符合访问修饰符规律)
		Method[] methods = perClass.getMethods();
		for(Method method:methods){
			System.out.println(method);
		}
		
		System.out.println("=========");
		// 获取当前类的所有方法(1.只能是当前类 2.忽略访问修饰符限制)
		Method[] declareMethods = perClass.getDeclaredMethods();
		for(Method method:declareMethods){
			System.out.println(method);
		}
	}
	
	/**
	 * 
	 * 
	 * @Description 获取所有的接口
	 */
	public static void demo03() {
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class<?>[] interfaces = perClass.getInterfaces();
		for(Class<?> inter: interfaces){
			System.out.println(inter);
		}
	}

	/**
	 * 
	 * 
	 * @Description 获取所有的父类
	 */
	public static void demo04() {
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class<?> superClass = perClass.getSuperclass();
		System.out.println(superClass);	
	}
	
	/**
	 * 
	 * 
	 * @Description 获取所有的构造方法
	 */
	public static void demo05() {
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Constructor<?>[] constructors = perClass.getConstructors();
		for(Constructor<?> constructor: constructors){
			System.out.println(constructor);
		}
		
	}
	
	/**
	 * 
	 * 
	 * @Description 获取所有的公共属性
	 */
	public static void demo06() {
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] fields = perClass.getFields();
		for(Field field:fields){
			System.out.println(field);
		}
		System.out.println("===========");
		// 所有属性(属性的:公共属性\所有属性的区别同"方法")
		Field[] declaredFields = perClass.getDeclaredFields();
		for(Field field:declaredFields){
			System.out.println(field);
		}
	}
	
	/**
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @Description 获取当前反射所代表类(接口)的对象(实例)
	 */
	public static void demo07() throws InstantiationException, IllegalAccessException{
		Class<?> perClass = null;
		try {
			perClass = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Object instance = perClass.newInstance();
		Person per = (Person) instance;
		per.interface2Method();
		
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//demo01();
		//demo02();
		//demo03();
		//demo04();
		//demo05();
		//demo06();
		demo07();
	

 }
}
