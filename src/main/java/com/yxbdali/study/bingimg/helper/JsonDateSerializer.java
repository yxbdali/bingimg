/**
 * 
 */
package com.yxbdali.study.bingimg.helper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author xiangbin.yang
 * @since 2016年11月11日
 */
public class JsonDateSerializer extends JsonSerializer<Date> {
	public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider ser)
			throws IOException, JsonProcessingException {
		gen.writeString(DATEFORMAT.format(date));
	}

}
