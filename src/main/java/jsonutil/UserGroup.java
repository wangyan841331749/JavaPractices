package jsonutil;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroup {
	private String name;
	private List<User> users = new ArrayList<User>();
	
}
