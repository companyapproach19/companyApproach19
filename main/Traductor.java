package main;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;


import trazabilidad.model.Actor;


public class Traductor {
	public Trad_Res_Req traducir(HttpExchange t) throws IOException{
		Trad_Res_Req ele;
		String body_text;


		ele = new Trad_Res_Req();
		ele.headers_req = t.getRequestHeaders();
		ele.cookies = new JsonObject();
		ele.params =  new JsonObject();
		body_text = new String(t.getRequestBody().readAllBytes());
		ele.url_req = t.getRequestURI().getPath();
		ele.req_method = t.getRequestMethod();
		ele.params = get_params(t.getRequestURI().getQuery(),body_text);
		ele.cookies = get_cookies_json(t.getRequestHeaders().get("Cookie"));		

		return ele;
	}

	

	private JsonObject get_cookies_json(List<String> cookies){
		String value;
		String key;
		JsonObject cookies_json;	

		cookies_json = null;
		

		if(cookies != null){
			cookies_json = new JsonObject();

			for(String cookie : cookies.get(0).split(";")){
				cookie = cookie.trim();
				cookie = (cookie.charAt(cookie.length() - 1) == ';')?(cookie.substring(0, cookie.length() - 1)):(cookie);
				key = cookie.split("=")[0];
				value = cookie.split("=")[1];
				cookies_json.addProperty(key, value);
			}
		}		

		return cookies_json;
	}

	

	private JsonObject get_params(String url_query,String body_text){
		String value;
		String key;
		JsonObject params;
		String all_params_text;

		

		params = new JsonObject();

		all_params_text = (url_query != null)?(url_query):("");
		all_params_text += (body_text != null)?(body_text):("");

		if(all_params_text.split("&")[0].length() > 0){
			for(String field : all_params_text.split("&")){
				field = field.trim();
				key = field.split("=")[0];
				value = field.split("=")[1];
				params.addProperty(key, value);
			}
		}

		return params;
	}
}
