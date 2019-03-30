package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.junit.Test;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
public class FileChannelExampleTest {

	public static void main(String[] args) {
		
	}
	
	/**
	 * 
	 * @throws IOException
	 * @Description 通过NIO读取文件里面的内容，并且也处理了中文乱码的问题
	 */
	@Test
	public void readFile() throws IOException {
		Charset charset = Charset.forName("UTF-8");
		CharsetDecoder decoder = charset.newDecoder();
		RandomAccessFile aFile = new RandomAccessFile(FileChannelExampleTest.class.getClassLoader().getResource("nio/nio-data.txt").getPath(), "rw");
	    FileChannel inChannel = aFile.getChannel();
	    ByteBuffer buf = ByteBuffer.allocate(200);
	    CharBuffer charBuffer = CharBuffer.allocate(200);
	    int bytesRead = inChannel.read(buf);
	    while (bytesRead != -1) {
	      System.out.println("Read " + bytesRead);
	      buf.flip();
          decoder.decode(buf, charBuffer, false);
          charBuffer.flip();
          System.out.println(charBuffer);
	      buf.clear();
	      charBuffer.clear();
	      bytesRead = inChannel.read(buf);
	    }
	    aFile.close();
	}

}
