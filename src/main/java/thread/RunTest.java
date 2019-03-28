package thread;

public class RunTest {

	public static void main(String[] args) {
		ExtendThread extendThread = new ExtendThread();
		extendThread.start();
		
		ImplementThread implementsThread = new ImplementThread();
		Thread thread = new Thread(implementsThread);
		thread.start();
	}

}
