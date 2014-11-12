package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


//一个读取文件的工具类
public class FileUtil {

	//定义一个接口，里面有一个函数，定义文件读取的方式。
	public static interface FileLineProcess{
		/**
		 * 
		 * @param line
		 * @return true:continue iteration
		 * 			false: break
		 */
		public boolean process(String line);
	}
	
	//从resource文件的path开始读取
	public static void iterateResourceFileByLine(String resourcePath, FileLineProcess process){
		
		//通过绝对resource文件的相对路径获取输入流
		InputStream stream = FileUtil.class.getClassLoader().getResourceAsStream(resourcePath);
		iterateStreamByLine(stream,process);
		
	}
	
	//从绝对路径path开始读取
	public static void iteratePathFileByLine(String path,FileLineProcess process){
		InputStream stream = null;
		try{
			
			//通过文件绝对路径获取文件的输入流
			stream = new FileInputStream(new File(path));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		iterateStreamByLine(stream,process);
	}
	
	
	//通过文件输入流来读取文件
	public static void iterateStreamByLine(InputStream stream, FileLineProcess process){
		
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new InputStreamReader(stream, "utf-8"));
			
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		String line = null;
		
		try{
			while((line = reader.readLine())!=null){
				if(!process.process(line)){
					break;
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
