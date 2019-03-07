package main;

//package distribuidor;

import java.io.BufferedOutputStream;

import java.io.ByteArrayInputStream;

import java.io.File;

import java.io.IOException;

import java.io.OutputStream;

import java.net.InetSocketAddress;

import java.nio.file.Files;

import com.sun.net.httpserver.HttpExchange;

import com.sun.net.httpserver.HttpHandler;

import com.sun.net.httpserver.HttpServer;







public class Distribuidor {



	public static Traductor traductor;



	public static void main(String[] args)throws Exception {



		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

		traductor = new Traductor();

		server.createContext("/", new Handler_Req());

		server.setExecutor(null);

		server.start();



	}



	static class Handler_Req implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			Trad_Res_Req res;

			try{
				res = traductor.traducir(t);

				t.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
