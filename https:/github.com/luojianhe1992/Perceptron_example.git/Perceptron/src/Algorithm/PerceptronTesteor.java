package Algorithm;

import java.util.ArrayList;
import java.util.List;

import IO.DataLoader;
import Interfaces.FeatureTrainingData;
import Model.PerceptronData;

public class PerceptronTesteor {
	
	//存储所有数据
	List<FeatureTrainingData> allData;
	
	public void loadData(){
		
		allData = new ArrayList<FeatureTrainingData>();
		
		List<double []> loadData0 = DataLoader.loadData("/Users/jianheluo/Desktop/data/label0.dat");
		List<double []> loadData1 = DataLoader.loadData("/Users/jianheluo/Desktop/data/label1.dat");
		
		for(double [] data:loadData0){
			PerceptronData pd = new PerceptronData (data,"label0");
			allData.add(pd);
		}
		
		for(double[] data:loadData1){
			PerceptronData pd = new PerceptronData(data, "label1");
			allData.add(pd);
		}
	}

	
	public void trainAndDisplay(){
		PerceptionAlgorithm algorithm = new PerceptionAlgorithm();
		
		algorithm.train(allData);
		
		System.out.println("the labels of PerceptronAlgorithm is:");
		for(int i=0;i<algorithm.getLabels().length;i++){
			System.out.print(algorithm.getLabels()[i]+"\t");
		}
		System.out.println();
		
		System.out.println("the firstTheta of PerceptronAlgorithm is:");
		for(int i=0;i<algorithm.getFirstTheta().length;i++){
			System.out.println(algorithm.getFirstTheta()[i]+"\t");
		}
		System.out.println();
		
		System.out.println("the theta of PerceptronAlgorithm is:");
		for(int i=0;i<algorithm.getTheta().length;i++){
			System.out.println(algorithm.getTheta()[i]+"\t");
		}
		System.out.println();
		
		
		
	}
	
	public static void main(String [] args){
		PerceptronTesteor testor = new PerceptronTesteor();
		
		testor.loadData();
		testor.trainAndDisplay();
	}
	

}
