package io;

import java.util.ArrayList;
import java.util.List;

import utils.FileUtil;
import utils.FileUtil.FileLineProcess;


public class DataLoader {
	
	public static List<double []> loadData (String path){
		
		//定义一个result的list来存储result
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
	
	public static List<int []> loadTicTacToeGameData(String path){
		final List<int []> result = new ArrayList<int []>();
		
		FileUtil.iteratePathFileByLine(path, new FileLineProcess(){
			
			public boolean process(String line){
				String [] splits = line.split(",");
				int [] data = new int [splits.length];
				for(int i=0;i<splits.length;i++){
					
					if(splits[i].trim().equals("x")){
						data[i] = 1;
					}
					else if(splits[i].trim().equals("o")){
						data[i] = -1;
					}
					//为"b"
					else if(splits[i].trim().equals("b")){
						data[i] = 0;
					}
				}
				
				result.add(data);
				return true;
			}
		});
		return result;
	}
	
	public static List<int []> loadTicTacToeGameData2(String path){
		final List<int []> result = new ArrayList<int []>();
		
		//调用函数
		FileUtil.iteratePathFileByLine(path, new FileLineProcess() {
			
			@Override
			public boolean process(String line) {
				
				String [] splits = line.split(",");
				int [] temp = new int [9];
				
				for(int i=0;i<splits.length;i++){
					
					if(splits[i].trim().equals("x")){
						temp[i] = 1;
					}
					else if(splits[i].trim().equals("o")){
						temp[i] = -1;
					}
					//为"b"
					else if(splits[i].trim().equals("b")){
						temp[i] = 0;
					}
				}
				int[] count_x = new int[8];
				for(int i=0;i<8;i++){
					count_x[i] = 0;
				}
				
				int [] count_o = new int[8];
				for(int i=0;i<8;i++){
					count_o[i] = 0;
				}
				
				int [] isX = new int[9];
				int [] isO = new int[9];
				
				for(int i=0;i<9;i++){
					
					if(temp[i]==1){
						isX[i] = 1;
					}
					
					if(temp[i]==-1){
						isO[i] = 1;
					}
					
//					if(temp[0]==1){
//						count_x[0]++;
//					}
//					if(temp[1]==1){
//						count_x[0]++;
//					}
//					if(temp[2]==1){
//						count_x[0]++;
//					}
					
					if(i>=0&&i<=2&&temp[i]==1){
						count_x[0]++;
					}
					
//					if(temp[0]==-1){
//						count_o[0]++;
//					}
//					if(temp[1]==-1){
//						count_o[0]++;
//					}
//					if(temp[2]==-1){
//						count_o[0]++;
//					}
					
					if(i>=0&&i<=2&&temp[i]==-1){
						count_o[0]++;
					}
					
//					if(temp[3]==1){
//						count_x[1]++;
//					}
//					if(temp[4]==1){
//						count_x[1]++;
//					}
//					if(temp[5]==1){
//						count_x[1]++;
//					}
					
					if(i>=3&&i<=5&&temp[i]==1){
						count_x[1]++;
					}
					
//					if(temp[3]==-1){
//						count_o[1]++;
//					}
//					if(temp[4]==-1){
//						count_o[1]++;
//					}
//					if(temp[5]==-1){
//						count_o[1]++;
//					}
					
					if(i>=3&&i<=5&&temp[i]==-1){
						count_o[1]++;
					}
					
//					if(temp[6]==1){
//						count_x[2]++;
//					}
//					if(temp[7]==1){
//						count_x[2]++;
//					}
//					if(temp[8]==1){
//						count_x[2]++;
//					}
					
					if(i>=6&&i<=8&&temp[i]==1){
						count_x[2]++;
					}
					
//					if(temp[6]==-1){
//						count_o[2]++;
//					}
//					if(temp[7]==-1){
//						count_o[2]++;
//					}
//					if(temp[8]==-1){
//						count_o[2]++;
//					}
					
					if(i>=6&&i<=8&&temp[i]==-1){
						count_o[2]++;
					}
					
//					if(temp[0]==1){
//						count_x[3]++;
//					}
//					if(temp[3]==1){
//						count_x[3]++;
//					}
//					if(temp[6]==1){
//						count_x[3]++;
//					}
					
					if((i==0||i==3||i==6)&&temp[i]==1){
						count_x[3]++;
					}
					
//					if(temp[0]==-1){
//						count_o[3]++;
//					}
//					if(temp[3]==-1){
//						count_o[3]++;
//					}
//					if(temp[6]==-1){
//						count_o[3]++;
//					}
					
					if((i==0||i==3||i==6)&&temp[i]==-1){
						count_o[3]++;
					}
					
//					if(temp[1]==1){
//						count_x[4]++;
//					}
//					if(temp[4]==1){
//						count_x[4]++;
//					}
//					if(temp[7]==1){
//						count_x[4]++;
//					}
					
					if((i==1||i==4||i==7)&&temp[i]==1){
						count_x[4]++;
					}
					
//					if(temp[1]==-1){
//						count_o[4]++;
//					}
//					if(temp[4]==-1){
//						count_o[4]++;
//					}
//					if(temp[7]==-1){
//						count_o[4]++;
//					}
					
					if((i==1||i==4||i==7)&&temp[i]==-1){
						count_o[4]++;
					}
					
//					if(temp[2]==1){
//						count_x[5]++;
//					}
//					if(temp[5]==1){
//						count_x[5]++;
//					}
//					if(temp[8]==1){
//						count_x[5]++;
//					}
					
					if((i==2||i==5||i==8)&&temp[i]==1){
						count_x[5]++;
					}
					
//					if(temp[2]==-1){
//						count_o[5]++;
//					}
//					if(temp[5]==-1){
//						count_o[5]++;
//					}
//					if(temp[8]==-1){
//						count_o[5]++;
//					}
					
					if((i==2||i==5||i==8)&&temp[i]==-1){
						count_o[5]++;
					}
					
//					if(temp[0]==1){
//						count_x[6]++;
//					}
//					if(temp[4]==1){
//						count_x[6]++;
//					}
//					if(temp[8]==1){
//						count_x[6]++;
//					}
					
					if((i==0||i==4||i==8)&&temp[i]==1){
						count_x[6]++;
					}
					
//					if(temp[0]==-1){
//						count_o[6]++;
//					}
//					if(temp[4]==-1){
//						count_o[6]++;
//					}
//					if(temp[8]==-1){
//						count_o[6]++;
//					}
					
					if((i==0||i==4||i==8)&&temp[i]==-1){
						count_o[6]++;
					}
					
//					if(temp[2]==1){
//						count_x[7]++;
//					}
//					if(temp[4]==1){
//						count_x[7]++;
//					}
//					if(temp[6]==1){
//						count_x[7]++;
//					}
					
					if((i==2||i==4||i==6)&&temp[i]==1){
						count_x[7]++;
					}
					
//					if(temp[2]==-1){
//						count_o[7]++;
//					}
//					if(temp[4]==-1){
//						count_o[7]++;
//					}
//					if(temp[6]==-1){
//						count_o[7]++;
//					}
					
					if((i==2||i==4||i==6)&&temp[i]==-1){
						count_o[7]++;
					}
				}
				
				int [] data = new int[34];
				
				for(int i=0;i<9;i++){
					data[i] = isX[i];
				}
				
				for(int i=0;i<9;i++){
					data[i+9] = isO[i];
				}
				
				for(int i=0;i<8;i++){
					data[i+9+9] = count_x[i];
				}
				
				for(int i=0;i<8;i++){
					data[i+9+9+8] = count_o[i];
				}
				
				result.add(data);
				return true;
				
			}
		});
		
		return result;
	}
	
	//根据resources文件夹的相对路径
	public static List<double []> loadData2(String path){
		
		//定义一个存储result的list
		final List<double []> result = new ArrayList<double[]> ();
		
		//调用FileUtil中的工具函数，参数路径为相对于resources的路径
		FileUtil.iterateResourceFileByLine(path, new FileLineProcess(){
			
			public boolean process(String line){
				String [] splits = line.split(",");
				double [] data = new double [splits.length];
				for(int i=0;i<splits.length;i++){
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
		
		List<double []>loadData2 = loadData2("data/label0.dat");
		
		System.out.println("the size of the loadData2 is:"+loadData2.size());
		
		
		System.out.println("*******************************");
		
		List<int []> loadData_Tic_Tac_Toe_negative = loadTicTacToeGameData("/Users/jianheluo/Downloads/tic_tac_toe_data_negative.dat");
		
		System.out.println("the size of the loadData_Tic_Tac_Toe_negative is:"+loadData_Tic_Tac_Toe_negative.size());
		
		System.out.println("the detail of the loadData_Tic_Tac_Toe_negative is:");
		
		for(int i=0;i<loadData_Tic_Tac_Toe_negative.size();i++){
			
			System.out.print("{");
			
			for(int j=0;j<9;j++){
				System.out.print(loadData_Tic_Tac_Toe_negative.get(i)[j]);
				System.out.print(",");
			}
			
			System.out.print("}");
			
			System.out.println();
		}
		
		System.out.println("*******************************");
		
		List<int []> loadData_Tic_Tac_Toe_positive = loadTicTacToeGameData("/Users/jianheluo/Downloads/tic_tac_toe_data_positive.dat");
		
		System.out.println("the size of the loadData_Tic_Tac_Toe_positive is:"+loadData_Tic_Tac_Toe_positive.size());
		
		System.out.println("the detail of the loadData_Tic_Tac_Toe_positive is:");
		
		for(int i=0;i<loadData_Tic_Tac_Toe_positive.size();i++){
			
			System.out.print("{");
			
			for(int j=0;j<9;j++){
				System.out.print(loadData_Tic_Tac_Toe_positive.get(i)[j]);
				System.out.print(",");
			}
			
			System.out.print("}");
			
			System.out.println();
		}
		
		System.out.println("*******************************&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		List<int []> loadData_Tic_Tac_Toe_negative2 = loadTicTacToeGameData2("/Users/jianheluo/Downloads/tic_tac_toe_data_negative.dat");
		
		System.out.println("the size of the loadData_Tic_Tac_Toe_negative2 is:"+loadData_Tic_Tac_Toe_negative2.size());
	
		System.out.println("the detail of the loadData_Tic_Tac_Toe_negative2 is:");
		
		for(int i=0;i<loadData_Tic_Tac_Toe_negative2.size();i++){
			
			System.out.print("{");
			
			System.out.print(loadData_Tic_Tac_Toe_negative2.get(i)[0]);
			
			for(int j=1;j<34;j++){
				System.out.print(","+loadData_Tic_Tac_Toe_negative2.get(i)[j]);
			}
			
			System.out.print("}");
			
			System.out.println();
			
//			System.out.print(loadData_Tic_Tac_Toe_negative2);
			
			
		}
	
	}
	
	
}
