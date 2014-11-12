package model;

import interfaces.Tic_Tac_Toe_Data;

public class PerceptronGameData  implements Tic_Tac_Toe_Data{

	String label;
	int [] features;
	
	
	
	public PerceptronGameData(String label, int[] features) {
		super();
		this.label = label;
		this.features = features;
	}

	public String getLabel(){
		return label;
	}
	
	public int[] getFeatures(){
		return features;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setFeatures(int[] features) {
		this.features = features;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		sb.append("("+features[0]);
		
		for(int i=1;i<features.length;i++){
			sb.append(","+features[i]);
		}
		
		sb.append(",label:");
		
		sb.append(label);
		
		sb.append(")");
		
		
		return sb.toString();
	}
	
	
}
