package reflect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person implements MyInterface, MyInterface2{
	private int id;
	private String name;
	private int age;
	public String desc;
	public Person(int id) {
		this.id = id;
	}
	@SuppressWarnings("unused")
	private Person(String name){
		this.name = name;
	}
	@Override
	public void interfaceMethod() {
		System.out.println("interfaceMethod...");
	}
	
	public static void staticMethod() {
		System.out.println("staticMethod...");
	}
	
	@SuppressWarnings("unused")
	private void privateMethod() {
		System.out.println("privateMethod...");
	}

	@Override
	public void interface2Method() {
		System.out.println("interface2Method...");	
	}
	
	@SuppressWarnings("unused")
	private void privateMethod2(String name){
		System.out.println("private method2..." + name);
	}

	@SuppressWarnings("unused")
	private void privateString(String name){
		System.out.println("private..." + name);
	}
	
	
}
