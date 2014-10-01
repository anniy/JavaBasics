package javaCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class _13_WebCrawler {
	private static String loc = "./src/javaCollections/crawled-urls.txt";
	private static String startPageForCrawl = "https://softuni.bg/";
	private static String strURL = "softuni.bg";
	
	public static void main(String[] args) throws IOException {
		
		FileWriter fstream = new FileWriter(loc, true);
		BufferedWriter out = new BufferedWriter(fstream);
		out.newLine();
		out.close();
		
		processPage(startPageForCrawl, 4);
	}
 
	public static boolean checkExist(String s, File fin) throws IOException {
		
		FileInputStream fis = new FileInputStream(fin);
		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
 
		String aLine = null;
		while ((aLine = in.readLine()) != null) {
			if (aLine.trim().contains(s)) {
				in.close();
				fis.close();
				return true;
			}
		}

		in.close();
		fis.close();
 
		return false;
	}
 
	public static void processPage(String URL, int n) throws IOException {
		if (n == 0) {
			return;
		}
		// ignore non-html documents 
		if (URL.contains(".pdf") || URL.contains("@") 
				|| URL.contains(".css") || URL.contains(":80")
				|| URL.contains(".js") || URL.contains(".jpg")
				|| URL.contains(".gif") || URL.contains(".png"))
			return;
 
		// external URL
		if (!URL.contains(strURL)) {
			return;
		}
		
		if (URL.endsWith("/")) {
			URL = URL.substring(0, URL.length()-1);
		}
		
		File file = new File(loc);
 
		boolean e = checkExist(URL, file);
		if (!e) {
			//System.out.println("------ :  " + URL);
			FileWriter fstream = new FileWriter(loc, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(URL);
			out.newLine();
			out.close();
 
			Document doc = null;
			try {
				doc = Jsoup.connect(URL).get();
			} catch (IOException e1) {
				System.out.println("Can't connect to URL " + URL);
				return;
			}

			Elements questions = doc.select("a[href]");
			for (Element link : questions) {
				processPage(link.attr("abs:href"), n-1);
			}
		} else {
			return;
		}
	}
}
