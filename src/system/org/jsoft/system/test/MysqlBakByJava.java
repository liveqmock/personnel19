package org.jsoft.system.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class MysqlBakByJava {
	public static void main(String[] args) {
		String user = "root";
		String password = "123456";
		String database="personnel";
		String filePath= "d:\\mysql.sql";
		String cmd ="cmd.exe /c \"C:\\Program Files (x86)\\MySQL\\MySQL Server 5.0\\bin\\mysqldump\" -h localhost -uroot -p123456  personnel > d:\\mysql.sql";
		System.out.println(cmd);
		String cmd5 ="cmd.exe /c \"C:\\Program Files (x86)\\MySQL\\MySQL Server 5.0\\bin\\mysql\" -h localhost -uroot -p123456  test < d:\\mysql.sql";
		System.out.println(cmd5);
		String cmd2 = "cmd.exe /c "+cmd;
		String cmd3 = "cmd.exe /c cd c:\\Program 20Files(x86)  ";
		String cmd4="cmd.exe /c   dir";
		
		Runtime runtime = Runtime.getRuntime();
		try {
				Process process =runtime.exec(cmd4);  
				InputStreamReader isr = new InputStreamReader(process.getInputStream());  
	            LineNumberReader input = new LineNumberReader(isr);  
	            String line;  
	            while((line = input.readLine())!= null){  
	                System.out.println(line+"~~~~~~~~~~");  
	            }  
	            
	            InputStreamReader isr2 = new InputStreamReader(process.getErrorStream());  
	            LineNumberReader input2 = new LineNumberReader(isr2);  
	            String line2;  
	            while((line2 = input2.readLine())!= null){  
	                System.out.println(line2+"~~~~~~~~~~");  
	            }  
	           
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
