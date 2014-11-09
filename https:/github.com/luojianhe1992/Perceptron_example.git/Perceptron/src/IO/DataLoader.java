package IO;

import java.util.ArrayList;
import java.util.List;

import Utils.FileUtil;
import Utils.FileUtil.FileLineProcess;


public class DataLoader {
	
	public static List<double []> loadData (String path){
		final List<double []> result = new ArrayList<double[]>();
		
		//在调用函数iterateStreamByLine的过程中，对接口FileLineProcess进行实现了
		FileUtil.iteratePathFileByLine(path, new FileLineProcess(){
			
			public boolean process(String line){
				String [] splits = line.split(",");
				double [] data = new double [splits.length];
				for(int i = 0;i < splits.length; i++){
					data[i] = Double.parseDouble(splits[i].trim());
					
				}
				result.add(data);
				return true;
			}
			
		});
		return result;
	}

	//调用main函数
	public static void main(String [] args){
		
		List<double []>loadData = loadData("/Users/jianheluo/Desktop/data/label0.dat");
		
		System.out.println("the size of the loadData is:"+loadData.size());
		
	}
}
