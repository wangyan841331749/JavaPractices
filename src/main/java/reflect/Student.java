package reflect;

import lombok.Getter;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
@Getter
public class Student {
	private int score;
	public void sayHi(){
		System.out.println("I am a student....");
	}
}
