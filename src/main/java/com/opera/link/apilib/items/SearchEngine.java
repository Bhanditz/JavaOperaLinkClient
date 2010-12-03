package com.opera.link.apilib.items;

import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import com.opera.link.apilib.Base64;

public class SearchEngine extends Element {
	
	public static final String ITEM_TYPE = "search_engine";
	
	public String title;
	public String uri;
	public String encoding;

	public boolean is_post;
	public String post_query;
	public byte[] icon;
	public String key;
	
	protected SearchEngine() { 

	}
	
	public SearchEngine(String title, String uri) {
		this();
		this.title = title;
		this.uri = uri;
	}
	
	@Override
	void loadParameters(JSONObject json) throws JSONException {
		if (json.has(Element.TITLE_JSON_FIELD)) {
			title = json.getString(Element.TITLE_JSON_FIELD);
		}
		if (json.has(Element.URI_JSON_FIELD)) {
			uri = json.getString(Element.URI_JSON_FIELD);
		}
		if (json.has(Element.ENCODING_JSON_FIELD)) {
			encoding = json.getString(Element.ENCODING_JSON_FIELD);
		}
		if (json.has(Element.ISPOST_JSON_FIELD)) {
			is_post = Boolean.valueOf(json.getString(Element.ISPOST_JSON_FIELD));
		}
		if (json.has(Element.POSTQUERY_JSON_FIELD)) {
			post_query = json.getString(Element.POSTQUERY_JSON_FIELD);
		}
		if (json.has(Element.KEY_JSON_FIELD)) {
			key = json.getString(Element.KEY_JSON_FIELD);
		}
		if (json.has(Element.ICON_JSON_FIELD)) {
			try {
				icon = Base64.decode(json.getString(Element.ICON_JSON_FIELD), Base64.NO_OPTIONS);
			} catch (IOException e) {
				e.printStackTrace();
				icon = null;
			}
		}
	}
	
	@Override
	public HashMap<String, String> createParamsDict() {
		
		final String iconString;
		if (icon != null) {
			iconString = Base64.encodeBytes(icon);
		} else {
			iconString = null;
		}
		
		HashMap<String, String> params = new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
			{
				put(Element.TITLE_JSON_FIELD, title);
				put(Element.URI_JSON_FIELD, uri);
				put(Element.ENCODING_JSON_FIELD, encoding);
				put(Element.ISPOST_JSON_FIELD, new Boolean(is_post).toString());
				put(Element.POSTQUERY_JSON_FIELD, post_query);
				put(Element.KEY_JSON_FIELD, key);
				put(Element.ICON_JSON_FIELD, iconString);
			}
		};
		return skipNullParams(params);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public boolean isIs_post() {
		return is_post;
	}

	public void setIs_post(boolean isPost) {
		is_post = isPost;
	}

	public String getPost_query() {
		return post_query;
	}

	public void setPost_query(String postQuery) {
		post_query = postQuery;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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
