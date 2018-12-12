package com.encore.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class CrawlingTest {
	
	//1.
	public static void call() throws IOException {
		FileOutputStream a = new FileOutputStream("bithumb.csv", true);	//1바이트씩
		OutputStreamWriter b = new OutputStreamWriter(a, "MS949");		//2바이트씩으로 바꿀때
		BufferedWriter bw = new BufferedWriter(b);						//한 라인으로 write가 된다.
		
		Document doc = Jsoup.connect("https://www.bithumb.com/").get();
		Elements rows = doc.body().select("#tableAsset > tbody > tr");
		String s = "";
		for(int i=0; i<rows.size(); i++) {
			Elements cols = rows.eq(i).select("td");
			for(Element e:cols) {
				s += e.select("strong").text() + ",";
			}
			bw.write(s);
			bw.newLine();
		}
		bw.close();
		b.close();
		a.close();
	}
	//2. 제공API 활용
	public static void call2() throws IOException {
		//네트워크를 읽어오는 프로그램
		//문자로 읽기만 한것이다.
		URL url = new URL("https://api.bithumb.com/public/ticker/ALL");
		HttpURLConnection conn = null;
		conn = (HttpURLConnection)url.openConnection();
		InputStream a = conn.getInputStream();
		InputStreamReader b = new InputStreamReader(a, "UTF-8");
		BufferedReader br = new BufferedReader(b);
		String line = "";
		String result = "";
		while((line = br.readLine())!=null) {
			System.out.println(line);
			result += line;
		}
		//객체로 파싱을 해서 원하는 값으로 변경해야한다.		문자열을 객체로 만들어주는것이 파싱이다.
		System.out.println("=======parsing=========");
		JsonParser parser = new JsonParser();
		JsonObject json = new JsonObject();
		JsonElement je = parser.parse(result);
		json = je.getAsJsonObject().getAsJsonObject("data");
		System.out.println(json);
		
		JsonObject json2 = json.getAsJsonObject().getAsJsonObject("BTC");
		System.out.println(json2);
		String[] keys = {"opening_price", "closing_price", "min_price", "max_price"};
		for(String key:keys) {
			System.out.println(key + "===>" + json2.get(key));
		}
		//System.out.println(json2.get("opening_price"));
	}
	
	public static void main(String[] args) throws IOException {
		call2();
	}
}
