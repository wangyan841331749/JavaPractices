package reflect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

}
