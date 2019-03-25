package jsonUtilTest;

import java.util.ArrayList;
import java.util.List;

import jsonUtil.User;
import jsonUtil.UserGroup;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TestFastJson {

	
	public static void main(String[] args) {

	}
	
	@Test
	public void objectToJson(){
		// 简单Java类转json字符串
		User user = new User("xiaoming","123456");
		String userJson = JSON.toJSONString(user);
		System.out.println("简单Java类转json字符串:" + userJson);
		
		//List<Object>转Json字符串
		User user1 = new User("zhangsan", "123321");
		User user2 = new User("lisi", "223321");
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		String ListUserJson = JSON.toJSONString(users);
		System.out.println("List<Object>转json字符串:" + ListUserJson);
		
		//复杂Java类转json字符串
		UserGroup userGroup = new UserGroup("usersGroup",users);
		String userGroupJson = JSON.toJSONString(userGroup);
		System.out.println("复杂Java类转json字符串:" + userGroupJson);
	}
	
	@Test
	public void JsonToObject() {
		/* json字符串转简单java对象
         * 字符串：{"password":"123456","username":"dmego"}*/
		String jsonStr1 = "{'password':'123456','username':'liming'}";
		User user = JSON.parseObject(jsonStr1, User.class);
		System.out.println("JSON字符串转简单Java对象:" + user.toString());
		
		/*
         * json字符串转List<Object>对象
         * 字符串：[{"password":"123123","username":"zhangsan"},{"password":"321321","username":"lisi"}]
         */
		String jsonStr2 = "[{'password':'123123','username':'zhangsan'},{'password':'321321','username':'lisi'}]";
	    List<User> users = JSON.parseArray(jsonStr2, User.class);
	    System.out.println("Json字符串转List<Object>对象:"+users.toString());
	     
	    /*json字符串转复杂java对象
	     * 字符串：{"name":"userGroup","users":[{"password":"123123","username":"zhangsan"},{"password":"321321","username":"lisi"}]}
	     * */
	    String jsonStr3 = "{'name':'userGroup','users':[{'password':'123123','username':'zhangsan'},{'password':'321321','username':'lisi'}]}";
	    UserGroup userGroup = JSON.parseObject(jsonStr3, UserGroup.class);
	    System.out.println("Json字符串转复杂Java对象:"+userGroup); 
		
	}

}
