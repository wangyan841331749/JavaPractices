package thread;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
public class ExtendThread extends Thread {
	@Override
	public void run() {
		System.out.println("This is a thread by extends Runnable.");
	}
}
