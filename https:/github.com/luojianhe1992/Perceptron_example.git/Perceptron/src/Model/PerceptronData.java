package Model;

import Interfaces.FeatureTrainingData;

//定义一个类PerceptronData 实现借口FeatureTrainingData 来存储每一个data
public class PerceptronData implements FeatureTrainingData{

	double [] features;
	String label;
	
	//constructor function
	public PerceptronData(double[] features, String label) {
		super();
		this.features = features;
		this.label = label;
	}

	//override
	public double[] getFeatures() {
		return features;
	}

	
	public void setFeatures(double[] features) {
		this.features = features;
	}

	//override
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
	
	
	
}
