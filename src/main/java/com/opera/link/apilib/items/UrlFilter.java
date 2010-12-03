package com.opera.link.apilib.items;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;



public class UrlFilter extends Element {
	
	public static final String ITEM_TYPE = "urlfilter";
	
	public String content;
	public String type;
	
	protected UrlFilter() { 

	}
	
	public UrlFilter(String content, String type) {
		this();
		this.content = content;
		this.type = type;
	}
	
	@Override
	void loadParameters(JSONObject json) throws JSONException {
		if (json.has(Element.CONTENT_JSON_FIELD)) {
			content = json.getString(Element.CONTENT_JSON_FIELD);
		}
		if (json.has(Element.TYPE_JSON_FIELD)) {
			type = json.getString(Element.TYPE_JSON_FIELD);
		}
	}
	
	@Override
	public HashMap<String, String> createParamsDict() {
		HashMap<String, String> params = new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;

			{
				put(Element.CONTENT_JSON_FIELD, content);
				put(Element.TYPE_JSON_FIELD, type);
			}
		};
		return skipNullParams(params);
	}

		@Override
	public String getDatatype() {
		return ITEM_TYPE;
	}

	@Override
	public String getItemType() {
		return ITEM_TYPE;
	}

}
