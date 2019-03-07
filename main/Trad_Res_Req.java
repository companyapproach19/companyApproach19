package main;



import java.io.File;

import java.util.List;

import java.util.Map;



import com.google.gson.JsonObject;

import com.sun.net.httpserver.Headers;



public class Trad_Res_Req {


	/*
	 Aqui estan todos los argumentos que resulten necesario para
	 pasar inforcion entre grupos,(si fuese necesario), y para almacenar
	 las correspondientes traducciones. 
	 */
	public Headers headers_req;
	public JsonObject cookies;
	public JsonObject params;
	public String url_req;
	public String req_method;
	public String inser_cons_jons;
	public String ret_I_C;
	public String ret_P_s;
	public File ret_P_f;
	public Integer codigo_res_req;
	public String resource_type;
	public Map<String, List<String>> set_header_response;
	

	public Trad_Res_Req(){
		this.headers_req = null;
		this.cookies = null;
		this.params = null;
		this.url_req= null;
		this.req_method= null;
		this.inser_cons_jons = null;
		this.ret_I_C = null;
		this.ret_P_s= null;
		this.ret_P_f = null;
		this.codigo_res_req = null;
		this.resource_type= null;
		this.set_header_response = null;
	}

}
