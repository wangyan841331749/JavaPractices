package jsonutil;

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
public class User {
	private String userName;
	private String passWord;
}
