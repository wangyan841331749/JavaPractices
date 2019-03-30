package jsonutil;

import java.util.List;

import org.apache.commons.collections4.map.LinkedMap;

import lombok.Data;
/**
 * 
 * @author wangyan
 * @date 2019年3月30日
 * @Description 
 * @version 2019年3月30日
 */
@Data
public class Query {
	private String id;
	private String key;
	private String tableName;
	private String className;
	private List<LinkedMap<String, Object>> column;
	private List<Column> columnList;
	
}
