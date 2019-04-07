package command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author wangyan
 * @date 2019年4月7日
 * @Description  此类的功能是在系统的命令行下执行命令，在Windows和linux下均可以使用
 * @version 2019年4月7日
 */
public class CmdDemo {
	
	public static String runCommand(String cmd) {
		Runtime rt = Runtime.getRuntime();
		Process process = null;
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			process = rt.exec(cmd);
			// 通过process关联到一个管道，用于读取命令行运行的结果,这里用utf-8会出现乱码
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		String cmd = "ping www.baidu.com";
		String result =runCommand(cmd);
		System.out.println(result);
	}

}
