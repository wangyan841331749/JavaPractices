package jsonutil;

import lombok.Data;
/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
@Data
public class Column {
	private String key;
	private String header;
	private String width;
	private String allowSort;
	private String hidden;
}
