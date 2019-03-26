package jsonUtil;

import lombok.Data;

@Data
public class Column {
	private String key;
	private String header;
	private String width;
	private String allowSort;
	private String hidden;
}
