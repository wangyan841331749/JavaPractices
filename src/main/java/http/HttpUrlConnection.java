package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;
/**
 * 这个类的作用是通过向服务器端的指定URL传送一个Json报文，方式为POST方式。
 * @author wangyan
 * @date 2019年4月6日
 * @Description 
 * @version 2019年4月6日
 */
public class HttpUrlConnection {
	public void doPost(String URL){
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        int successCode = 200;
        try{
        	// 创建URL对象
            URL url = new URL(URL);
            // 通过HttpURLConnection对象，向网络地址发送请求
            conn = (HttpURLConnection)url.openConnection();
            // 设置请求方式为POST
            conn.setRequestMethod("POST");
            // 如果打算使用URL连接进行输出，则将DoOutput标志设置为true
            conn.setDoOutput(true);
            // 如果打算使用URL连接进行输入，则将DoInput标志设置为true.
            conn.setDoInput(true);
            // 设置连接超时时间和读取超时时间
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            // 设置发送数据的格式
            conn.setRequestProperty("Content-Type", "application/json");
            // 设置接收数据的格式
            conn.setRequestProperty("Accept", "application/json");
            // 获取输出流
            out = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            // 要传送报文的json字符串
            String jsonStr = "{\"name\":\"jack\", \"age\":18}";
            // 向服务器端写入json报文
            out.write(jsonStr);
            out.flush();
            out.close();
            
            
            // 读取响应的数据，并使用Reader读取
            if (successCode == conn.getResponseCode()){
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null){
                    result.append(line);
                }
            }else{
                System.out.println("ResponseCode is an error code:" + conn.getResponseCode());
            }
            // 把响应的结果转换为Json对象，方便后面读取具体的Value值
            JSONObject obj = JSONObject.parseObject(result.toString());
            System.out.println("返回结果码: " + obj.getString("result"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(out != null){
                    out.close();
                }
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
}
	
	public static void main(String[] args) {
		HttpUrlConnection http = new HttpUrlConnection();
	    System.out.println("Do Http POST request");
	    http.doPost("http://localhost:8080/MapReduce/AnalysisJsonServlet");
	}
}
