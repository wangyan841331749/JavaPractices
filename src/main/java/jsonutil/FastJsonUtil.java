package jsonutil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
public class FastJsonUtil {

	public static void main(String[] args) {
		List<JSONObject> jsonObjects = new ArrayList<>();
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("key1", "value1");
		jsonObject1.put("key2", "value2");
		jsonObjects.add(jsonObject1);
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("key3", "value3");
		jsonObject2.put("key4", "value4");
		jsonObjects.add(jsonObject2);
        String str = JSON.toJSONString(jsonObjects, SerializerFeature.PrettyFormat);
        System.out.println(str);
        createTimeJsonFile(str, "E:\\a\\a.json");
	}
	
    /**
     * 将JSON数据格式化并保存到文件中
     * @param jsonData 需要输出的json数
     * @param filePath 输出的文件地址
     * @return
     */
    public static void createTimeJsonFile(String content, String filePath) {
            // 保证创建一个新文件
            File file = new File(filePath);
            // 如果父目录不存在，创建父目录
            if (!file.getParentFile().exists()) { 
                file.getParentFile().mkdirs();
            }
            // 如果已存在,删除旧文件
            if (file.exists()) { 
                file.delete();
            }
            try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            // 将格式化后的字符串写入文件
            try {
                FileOutputStream fout = new FileOutputStream(file);
                byte[] bs = content.getBytes();
                fout.write(bs);
                fout.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    
    }


}
