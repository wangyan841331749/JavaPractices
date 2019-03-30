package thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
public class RunTest {

	public static void main(String[] args) {
		// 使用线程池是线程的创建与销毁
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 20,
	                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		executor.execute(new ImplementThread());
		executor.execute(new ExtendThread());
		executor.shutdown();
		
	}

}
