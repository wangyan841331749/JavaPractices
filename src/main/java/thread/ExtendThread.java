package thread;

public class ExtendThread extends Thread {
	@Override
	public void run() {
		System.out.println("This is a thread by extends Runnable.");
	}
}
