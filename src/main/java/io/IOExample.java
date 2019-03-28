package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class IOExample {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		Damo3();
	}
	
	/**
	 * 
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @Description 字节流形式读取和写入
	 */
	public static void Demo1() throws UnsupportedEncodingException, IOException {
		// 读取文件（字节流）
		InputStream in = new FileInputStream("E:\\Test\\1.txt");
		// 写入相应的文件
		OutputStream out = new FileOutputStream("E:\\Test\\2.txt");
		// 读取数据，一次性读取多少字节
		byte[] bytes = new byte[2048];
		// 接受读取的内容（n就代表相关数据，只不过是数字的形式）
		int n = -1;
		// 循环取出数据
		while ((n = in.read(bytes, 0, bytes.length)) != -1) {
			// 转换成字符串，实现从字节到字符串的转换
			String str = new String(bytes,0,n,"GBK");
			System.out.println(str);
			// 写入相关的文件
			out.write(bytes, 0, n);
		}
		// 关闭流
		in.close();
		out.close();
	}
	
	/**
	 * 
	 * @throws IOException
	 * @Description 缓存字节流读取与写入
	 */
	public static void Demo2() throws IOException {
		// 读取文件(缓存字节流)
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:\\Test\\1.txt"));
		// 写入相应的文件
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("E:\\Test\\2.txt"));
		// 读取数据，一次性取多少字节
		byte[] bytes = new byte[2048];
		// 接受读取的内容(n就代表的相关数据，只不过是数字的形式)
		int n = -1;
		// 循环取出数据
		while ((n = in.read(bytes, 0, bytes.length)) != -1) {
			// 转换成字符串
			String str = new String(bytes, 0, n, "GBK");
			System.out.println(str);
			// 写入相应的文件
			out.write(bytes, 0 , n);
		}
		// 清除缓存
		out.flush();
		// 关闭流
		in.close();
		out.close();
		
	}
	
	/**
	 * 
	 * @throws IOException
	 * @Description
	 */
	public static void Damo3() throws IOException {
		// 读取文件
		InputStreamReader in = new InputStreamReader(new FileInputStream("E:\\Test\\1.txt"));
		// 写入相应的文件
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("E:\\Test\\2.txt"));
		// 读取数据，循环取出数据
		int len = -1;
		while ((len = in.read()) != -1) {
			System.out.println(in.read());
			// 写入相应的文件
			out.write(len);
		}
		// 清除缓存
		out.flush();
		// 关闭流
		in.close();
		out.close();
		
	}
	
	/**
	 * 
	 * @throws IOException
	 * @Description
	 */
	public static void Damo4() throws IOException {
		// 读取文件(字符流)
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Test\\1.txt"),"GBK"));
        // 写入相应的文件
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Test\\2.txt"),"GBK"));
        // 读取数据
        // 循环取出数据
        String str = null;
        while ((str = in.readLine()) != null) {
            System.out.println(str);
            // 写入相关文件
            out.write(str);
            out.newLine();
        }
        // 清除缓存
        out.flush();
        // 关闭流
        in.close();
        out.close();
	}
	
	/**
	 * 
	 * @throws IOException
	 * @Description
	 */
	public static void Damo5() throws IOException {
		// 读取文件(字节流)
        Reader in = new InputStreamReader(new FileInputStream("E:\\Test\\1.txt"),"GBK");
        // 写入相应的文件
        PrintWriter out = new PrintWriter(new FileWriter("E:\\Test\\2.txt"));
        // 读取数据
        // 循环取出数据
        int len = -1;
        while ((len = in.read()) != -1) {
            System.out.println(len);
            // 写入相关文件
            out.write(len);
        }
        // 清除缓存
        out.flush();
        // 关闭流
        in.close();
        out.close();
	}

}
