package jsonUtil;

import java.util.List;

import org.apache.commons.collections4.map.LinkedMap;

import lombok.Data;
@Data
public class Query {
	private String id;
	private String key;
	private String tableName;
	private String className;
	private List<LinkedMap<String, Object>> column;
	private List<Column> columnList;
	
}
