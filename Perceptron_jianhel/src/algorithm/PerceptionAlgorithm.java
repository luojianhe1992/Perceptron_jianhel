package algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import interfaces.FeatureTrainingData;
import interfaces.Tic_Tac_Toe_Data;

//定义一个类来执行Perceptron 的 algorithm 的实现
public class PerceptionAlgorithm {

	// 定义一个Random类的对象rand，使用rand对象来随机生成theta(weight)
	public static Random rand = new Random();

	// 每个feature的对应的权值
	double[] theta;

	// data里面所包含的labels
	String[] labels;

	//
	public static double alpha = 0.00001;

	double[] firstTheta;

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

	// 定义一个train的函数
	public void train(List<FeatureTrainingData> training) {

		// 通过data来获取data中labels
		Set<String> labelSet = new HashSet<String>();

		// 存储data中features的数量
		int featurelength = -1;
		for (FeatureTrainingData d : training) {
			labelSet.add(d.getLabel());
			if (featurelength == -1) {
				featurelength = d.getFeatures().length;
			}
		}

		// 判断数据中是否只有两个类别labels
		if (labelSet.size() > 2) {
			System.err.println("too many labels:");
			for (String label : labelSet) {
				System.err.println(label + "\t");
			}
			System.out.println();
			System.err.println("only under determine whether its the 1st one.");
		}

		// 定义String数组来存储data的所有labels
		labels = new String[labelSet.size()];

		// 定义double数组来存储每个data中的features的数量
		theta = new double[featurelength];
		firstTheta = new double[featurelength];

		// 为label编上编号
		int labelIndex = 0;
		for (String label : labelSet) {
			labels[labelIndex++] = label;
		}

		// 利用Random类的对象随机生成权值
		for (int i = 0; i < featurelength; i++) {
			theta[i] = rand.nextDouble();
			firstTheta[i] = theta[i];
		}

		int count = 0;

		for (FeatureTrainingData d : training) {

			// 用y值来存储data的实际label值
			Double y = null;
			if (d.getLabel().equals(labels[0])) {
				// label值猜对了
				y = 1.0;
			} else {
				// label值猜错了
				y = -1.0;
			}
			// 用h来存储predition的label值
			Double h = 0.0;

			// 通过公式来计算出每个data的predition的h值
			for (int i = 0; i < featurelength; i++) {
				h += theta[i] * d.getFeatures()[i];
			}

			// 针对于y和h值，对权值theta进行调整。
			for (int i = 0; i < featurelength; i++) {
				theta[i] = theta[i] + alpha * (y - h) * d.getFeatures()[i];
			}

		}
		// 相当于一个evaluation
		errorRate(training, featurelength);
	}
	
	public void train_Tic_Tac_Toe_GameOffLine(List<Tic_Tac_Toe_Data> training){
		
		for(int i=0;i<training.size();i++){
			for(int j=0;j<34;j++){
				System.out.print(training.get(i).getFeatures()[j]+" ");
			}
			System.out.print(training.get(i).getLabel());
			System.out.println();
		}
		
		// 通过data来获取data中labels
		Set<String> labelSet = new HashSet<String>();
		
		// 存储data中features的数量
		int featurelength = -1;
		
		for (Tic_Tac_Toe_Data d : training) {
			labelSet.add(d.getLabel());
			if (featurelength == -1) {
				featurelength = d.getFeatures().length;
			}
		}

		// 判断数据中是否只有两个类别labels
		if (labelSet.size() > 2) {
			System.err.println("too many labels:");
			for (String label : labelSet) {
				System.err.println(label + "\t");
			}
			System.out.println();
			System.err.println("only under determine whether its the 1st one.");
		}

		// 定义String数组来存储data的所有labels
		labels = new String[labelSet.size()];

		// 定义double数组来存储每个data中的features的数量
		theta = new double[featurelength];
		
		
		
		firstTheta = new double[featurelength];

		
		// 为label编上编号
		int labelIndex = 0;
		
		for (String label : labelSet) {
			labels[labelIndex++] = label;
		}
		
		for(int i=0;i<2;i++){
			System.out.println("labels["+i+"]"+labels[i]);
		}

		
		// 利用Random类的对象随机生成权值
		for (int i = 0; i < featurelength; i++) {
			theta[i] = rand.nextDouble();
			firstTheta[i] = theta[i];
		}
		
		
		//offline version 的计算公式
		double h = 0;
		
		for(int count=0;count<1000;count++){
			
			System.out.print(count+"time, the theta array is:{");
			
			for(int length=0;length<featurelength;length++){
				System.out.print(theta[length]+" ");
			}
			
			System.out.print("}");
			
			System.out.println();
			
			
			//define an array
			double [] temp_sum = new double [featurelength];
			
			for(int i=0;i<featurelength;i++){
				temp_sum[i] = 0;
			}
			
			for(int i=0;i<training.size();i++){
				
				//figure out the y, which is actual value of the data
				double y = 0;
				if(training.get(i).getLabel().equals(labels[1])){
					y = 1;
				}
				else if(training.get(i).getLabel().equals(labels[0])){
					y = -1;
				}
				else{
					System.out.println("the data has not been classified");
				}
				
				h = 0;
				
				//figure out the h, which is the hypothesis value of the data
				for(int j=0;j<featurelength;j++){
					h = h + theta[j] * training.get(i).getFeatures()[j];
				}
				
				
				for(int k=0;k<featurelength;k++){
					temp_sum [k] = temp_sum[k] + alpha * (y-h) * training.get(i).getFeatures()[k];
				}
			}
			for(int i=0;i<featurelength;i++){
				theta[i] = theta[i] + temp_sum[i];
			}
			errorRate_Tic_Tac_Toe_Game(training, featurelength);
			
		}
		
		
		
		
		/*
		for(int i=0;i<training.size();i++){
			for(int j=0;j<34;j++){
				System.out.print(training.get(i).getFeatures()[j]+" ");
			}
			System.out.print(training.get(i).getLabel());
			System.out.println();
		}
		
		// 通过data来获取data中labels
		Set<String> labelSet = new HashSet<String>();
		
		// 存储data中features的数量
		int featurelength = -1;
		
		for (Tic_Tac_Toe_Data d : training) {
			labelSet.add(d.getLabel());
			if (featurelength == -1) {
				featurelength = d.getFeatures().length;
			}
		}

		// 判断数据中是否只有两个类别labels
		if (labelSet.size() > 2) {
			System.err.println("too many labels:");
			for (String label : labelSet) {
				System.err.println(label + "\t");
			}
			System.out.println();
			System.err.println("only under determine whether its the 1st one.");
		}

		// 定义String数组来存储data的所有labels
		labels = new String[labelSet.size()];

		// 定义double数组来存储每个data中的features的数量
		theta = new double[featurelength];
		
		
		
		firstTheta = new double[featurelength];

		
		// 为label编上编号
		int labelIndex = 0;
		
		for (String label : labelSet) {
			labels[labelIndex++] = label;
		}
		
		for(int i=0;i<2;i++){
			System.out.println("labels["+i+"]"+labels[i]);
		}

		
		// 利用Random类的对象随机生成权值
		for (int i = 0; i < featurelength; i++) {
			theta[i] = rand.nextDouble();
			firstTheta[i] = theta[i];
		}
		
		for (int i = 0; i < featurelength; i++) {
			System.out.println("the firstTheta["+i+"]:"+firstTheta[i]);
		}
		
		int count = 0;
		
		for (int n=0;n<training.size();n++){
			// 用y值来存储data的实际label值
			
			Double y = null;
			
			if (training.get(n).getLabel().equals(labels[1])) {
				// data的实际类别为类别1
				y = 1.0;
				System.out.println("data的实际类别为类别1");
			} else if (training.get(n).getLabel().equals(labels[0])){
				// data的实际类别为类别2
				y = -1.0;
				System.out.println("data的实际类别为类别-1");
			}

			// 用h来存储predition的label值
			Double h = 0.0;
			
			// 通过公式来计算出每个data的predition的h值
			for (int i = 0; i < featurelength; i++) {
				h += theta[i] * training.get(n).getFeatures()[i];
			}
			
			System.out.println("the number "+ n +" :h="+h+"\t"+"y="+y);
			
			// 针对于y和h值，对权值theta进行调整。
			for (int i = 0; i < featurelength; i++) {
				theta[i] = theta[i] + alpha * (y - h) * training.get(n).getFeatures()[i];
			}
			
			for (int i = 0; i < featurelength; i++) {
				System.out.print("the number "+ n +" theta["+i+"]:"+theta[i]+"\t");
			}
		}
		//遍历循环结束，会产生一个最终的theta数组
		
		
		for (int i = 0; i < featurelength; i++) {
			System.out.println("the final theta["+i+"]:"+theta[i]);
		}
		
		
		// 相当于一个evaluation
		errorRate_Tic_Tac_Toe_Game(training, featurelength);
		*/
	}
	

	public void train_Tic_Tac_Toe_GameOnLine(List<Tic_Tac_Toe_Data> training){
		for(int i=0;i<training.size();i++){
			for(int j=0;j<34;j++){
				System.out.print(training.get(i).getFeatures()[j]+" ");
			}
			System.out.print(training.get(i).getLabel());
			System.out.println();
		}
		
		// 通过data来获取data中labels
		Set<String> labelSet = new HashSet<String>();
		
		// 存储data中features的数量
		int featurelength = -1;
		
		for (Tic_Tac_Toe_Data d : training) {
			labelSet.add(d.getLabel());
			if (featurelength == -1) {
				featurelength = d.getFeatures().length;
			}
		}

		// 判断数据中是否只有两个类别labels
		if (labelSet.size() > 2) {
			System.err.println("too many labels:");
			for (String label : labelSet) {
				System.err.println(label + "\t");
			}
			System.out.println();
			System.err.println("only under determine whether its the 1st one.");
		}

		// 定义String数组来存储data的所有labels
		labels = new String[labelSet.size()];

		// 定义double数组来存储每个data中的features的数量
		theta = new double[featurelength];
		
		
		
		firstTheta = new double[featurelength];

		
		// 为label编上编号
		int labelIndex = 0;
		
		for (String label : labelSet) {
			labels[labelIndex++] = label;
		}
		
		for(int i=0;i<2;i++){
			System.out.println("labels["+i+"]"+labels[i]);
		}

		
		// 利用Random类的对象随机生成权值
		for (int i = 0; i < featurelength; i++) {
			theta[i] = rand.nextDouble();
			firstTheta[i] = theta[i];
		}
		
		
		for(int i=0;i<training.size();i++){
			int y = 0;
			if(training.get(i).getLabel().equals(labels[1])){
				y = 1;
				//classify data as the label 1
			}
			else if(training.get(i).getLabel().equals(labels[0])){
				y = -1;
				//classify data as the label -1
			}
			else{
				System.out.println("the data has not been classified.");
			}
			
			double h = 0;
			
			for(int j = 0;j<featurelength;j++){
				h = h + theta[j] * training.get(i).getFeatures()[j];
			}
			
			for(int k=0;k<featurelength;k++){
				theta[k] = theta[k] + alpha *  (y-h) * training.get(i).getFeatures()[k];
			}
			
			System.out.print("the theta[] array is:{");
			
			System.out.print(theta[0]);
			
			for(int j=1;j<featurelength;j++){
				System.out.print(", "+theta[j]);
			}
			
			System.out.print("}");
			
			System.out.println();
			
			errorRate_Tic_Tac_Toe_Game(training,featurelength);
		}
		
	}
	
	
	// 定义一个evaluation函数，来对分类的错误率进行评估
	public void errorRate(List<FeatureTrainingData> training, int featureLength) {
		double j = 0.0;
		double j_sign = 0.0;
		int correctness = 0;
		double precision = 0.0;

		for (FeatureTrainingData d : training) {
			Double y = null;
			if (d.getLabel().equals(labels[0])) {
				//data的实际类别为类别1
				y = 1.0;
				
			}
			else {
				//data的实际类别为类别2
				y = -1.0;
			}

			double h = 0.0;

			for (int i = 0; i < featureLength; i++) {
				h = h + theta[i] * d.getFeatures()[i];
			}
			j = j + 0.5*Math.pow(h - y, 2);

			// prediction错误
			if (h * y < 0) {
				j_sign = j_sign + 0.5*Math.pow(h - y, 2);
			}
			else{
				correctness++;
			}

		}
		System.out.println("correctness is:"+correctness);
		
		precision = correctness*1.0/training.size();
		
		System.out.println(j + "\t" + j_sign + "\t" + "the precision is:"+precision);
	}
	
	public void errorRate_Tic_Tac_Toe_Game(List<Tic_Tac_Toe_Data> training, int featureLength){
		
		System.out.println("invoke the function errorRate_Tic_Tac_Toe_Game");
		
		
		double j = 0.0;
		double j_sign = 0.0;
		int correctness = 0;
		double precision = 0;

		for (Tic_Tac_Toe_Data d : training) {
			Double y = null;
			if (d.getLabel().equals(labels[1])) {
				//data的实际类别为1
				y = 1.0;
				
			} else {
				//data的实际类别为-1
				y = -1.0;
				
			}
			
			

			double h = 0.0;

			for (int i = 0; i < featureLength; i++) {
				h = h + theta[i] * d.getFeatures()[i];
			}
			
			
			//j stand for that even if you have correctly classify the point, there still will be the error rate.
			j = j + Math.pow(h - y, 2);

			// j_sign stand for that only if you have wrongly classify the point, there will be the error rate.
			if (h * y < 0) {
				j_sign = j_sign + Math.pow(h - y, 2);
			}
			else{
				correctness++;
			}
			
			/*if j-j_sign is very small, that means that most of the error rate j come from the j_sign, and only when classify 
			wrongly, there will error rate j_sign. So the model result is not very well. 
			
			if j-j_sign is very big, that means that the j_sign is very small, and only when classify wrongly, there will be 
			error rate j_sign. So most of the data are classify correctly. So the model is very well.
			*/

		}
		
		precision = 1.0*correctness/training.size();
		
		System.out.println("correctness ="+correctness);
		
		System.out.println("j="+j + "\t" +"j_sign="+j_sign+"\t"+"the precision is:"+precision);
	}
}
