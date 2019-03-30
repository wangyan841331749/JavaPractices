package jsonutiltest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jsonutil.User;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
public class GsonJsonTest {
	
	/**
	 * 
	 * 
	 * @Description 序列化对象到字符串
	 */
	@Test
	public void test() {
		final int cycleNumber = 10;
		Gson gson = new Gson();
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < cycleNumber; i++) {
			User p = new User();
			p.setUserName("username"+i);
			p.setPassWord("password"+i);
			users.add(p);
		}
		String str = gson.toJson(users);
		System.out.println(str);
	}
	
	/**
	 * 
	 * 
	 * @Description 反序列化单一实体对象
	 */
	@Test
	public void test1() {
		Gson gson = new Gson();
		String str = "{'userName':'name0','passWord':'000'}";
		User user = gson.fromJson(str, User.class);
		System.out.println(user.getUserName());
	}
	
	/**
	 * 
	 * 
	 * @Description 反序列化为对象列表
	 */
	@Test
	public void test2() {
		Gson gson = new Gson();
		String str = "[{'userName':'name0','passWord':'000'}, {'userName':'name1','passWord':'001'}]";
		List<User> users = gson.fromJson(str, new TypeToken<List<User>>(){}.getType());
		for(int i = 0; i < users.size() ; i++)
		{
		     User u = users.get(i);
		     System.out.println(u.toString());
		}
	}
}

	
