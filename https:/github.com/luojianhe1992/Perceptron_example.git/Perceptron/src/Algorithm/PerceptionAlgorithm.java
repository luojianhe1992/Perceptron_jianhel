package Algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;



import Interfaces.FeatureTrainingData;

//定义一个类来执行Perceptron 的 algorithm 的实现
public class PerceptionAlgorithm {
	
	//定义一个Random类的对象rand，使用rand对象来随机生成theta(weight)
	public static Random rand = new Random();
	
	//每个feature的对应的权值
	double [] theta;
	
	//data里面所包含的labels
	String [] labels;
	
	//
	public static double alpha = 0.1;
	
	double [] firstTheta;
	
	
	
	
	
	public double[] getFirstTheta() {
		return firstTheta;
	}




	public void setFirstTheta(double[] firstTheta) {
		this.firstTheta = firstTheta;
	}




	public static Random getRand() {
		return rand;
	}




	public static void setRand(Random rand) {
		PerceptionAlgorithm.rand = rand;
	}




	public double[] getTheta() {
		return theta;
	}




	public void setTheta(double[] theta) {
		this.theta = theta;
	}




	public String[] getLabels() {
		return labels;
	}




	public void setLabels(String[] labels) {
		this.labels = labels;
	}




	public static double getAlpha() {
		return alpha;
	}




	public static void setAlpha(double alpha) {
		PerceptionAlgorithm.alpha = alpha;
	}




	//定义一个train的函数
	public void train(List<FeatureTrainingData> training){
		
		//通过data来获取data中labels
		Set<String> labelSet = new HashSet<String>();
		
		//存储data中features的数量
		int featurelength = -1;
		for(FeatureTrainingData d:training){
			labelSet.add(d.getLabel());
			if(featurelength == -1){
				featurelength = d.getFeatures().length;
			}
		}
		
		//判断数据中是否只有两个类别labels
		if(labelSet.size()>2){
			System.err.println("too many labels:");
			for(String label:labelSet){
				System.err.println(label+"\t");
			}
			System.out.println();
			System.err.println("only under determine whether its the 1st one.");
		}
		
		//定义String数组来存储data的所有labels
		labels = new String [labelSet.size()];
		
		//定义double数组来存储每个data中的features的数量
		theta = new double [featurelength];
		firstTheta = new double [featurelength];
		
		//为label编上编号
		int labelIndex = 0;
		for (String label:labelSet){
			labels[labelIndex++] = label;
		}
		
		//利用Random类的对象随机生成权值
		for(int i=0;i<featurelength;i++){
			theta[i] = rand.nextDouble();
			firstTheta [i] = theta[i];
		}
		
		
		int count = 0;
		
		
		for(FeatureTrainingData d:training){
			
			//用y值来存储data的实际label值
			Double y = null;
			if(d.getLabel().equals(labels[0])){
				
				//label值猜对了
				y = 1.0;
			}else{
				
				//label值猜错了
				y = -1.0;
			}
			
			//用h来存储predition的label值
			Double h = 0.0;
			
			//通过公式来计算出每个data的predition的h值
			for(int i=0;i<featurelength;i++){
				h += theta[i] * d.getFeatures()[i];
			}
			
			//针对于y和h值，对权值theta进行调整。
			for(int i=0;i<featurelength;i++){
				theta[i] = theta[i] + alpha * (y-h) * d.getFeatures()[i];
			}
			
		}	
		//相当于一个evaluation
		errorRate(training,featurelength);
	}
	
	
	
	
	//定义一个evaluation函数，来对分类的错误率进行评估
	public void errorRate(List<FeatureTrainingData> training, int featureLength){
		double j = 0.0;
		double j_sign = 0.0;
		
		for (FeatureTrainingData d: training){
			Double y = null;
			if(d.getFeatures().equals(labels[0])){
				y = 1.0;
			}
			else{
				y = -1.0;
			}
			
			double h = 0.0;
			
			for(int i=0;i<featureLength;i++){
				h = h + theta[i] * d.getFeatures()[i];
			}
			j = j + Math.pow(h-y, 2);
			
			//prediction错误
			if(h*y<0){
				j_sign = j_sign + Math.pow(h-y, 2);
			}

		}
		System.out.println(j+"\t"+j_sign);
	}
}

