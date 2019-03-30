package thread;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
public class ImplementThread implements Runnable {
	@Override
	public void run() {
		System.out.println("This is a thread by implements Runnable.");
	}

}
