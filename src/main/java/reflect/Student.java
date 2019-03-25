package reflect;

import lombok.Getter;

@Getter
public class Student {
	private int score;
	public void sayHi(){
		System.out.println("I am a student.");
	}
}
