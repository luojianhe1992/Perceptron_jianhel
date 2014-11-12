package algorithm;

import java.util.ArrayList;
import java.util.List;

import io.DataLoader;
import interfaces.FeatureTrainingData;
import interfaces.Tic_Tac_Toe_Data;
import model.PerceptronData;
import model.PerceptronGameData;

public class PerceptronTesteor {

	//存储所有数据
	List<FeatureTrainingData> allData;
	
	//store all the data from tic tac toe game
	List<Tic_Tac_Toe_Data> allData_Tic_Tac_Toe_Game;
	
	//store all the data from tic tac toe game in another way
	List<Tic_Tac_Toe_Data> allData_Tic_Tac_Toe_Game2;

	public void loadData() {

		allData = new ArrayList<FeatureTrainingData>();

		List<double[]> loadData0 = DataLoader.loadData("/Users/jianheluo/Desktop/data/label0.dat");
		List<double[]> loadData1 = DataLoader.loadData("/Users/jianheluo/Desktop/data/label1.dat");

		for (double[] data : loadData0) {
			PerceptronData pd = new PerceptronData(data, "label0");
			allData.add(pd);
		}

		for (double[] data : loadData1) {
			PerceptronData pd = new PerceptronData(data, "label1");
			allData.add(pd);
		}
	}
	
	//load the tic tac toe game data.
	public void loadData_Tic_Tac_Toe_Game(){
		
		System.out.println("invoke the function of loadData_Tic_Tac_Toe_Game");
		
		allData_Tic_Tac_Toe_Game = new ArrayList<Tic_Tac_Toe_Data>();
		
		List<int []> loadData0 = DataLoader.loadTicTacToeGameData("/Users/jianheluo/Downloads/tic_tac_toe_data_negative.dat");
		
		List<int []> loadData1 = DataLoader.loadTicTacToeGameData("/Users/jianheluo/Downloads/tic_tac_toe_data_positive.dat");
		
		for(int [] data:loadData0){
			PerceptronGameData pgd = new PerceptronGameData("negative",data);
			allData_Tic_Tac_Toe_Game.add(pgd);
		}
		
		for(int [] data:loadData1){
			PerceptronGameData pgd = new PerceptronGameData("positive", data);
			allData_Tic_Tac_Toe_Game.add(pgd);
		}
	}
	
	public void loadData_Tic_Tac_Toe_Game2(){
		
		System.out.println("invoke the function of loadData_Tic_Tac_Toe_Game2");
		
		allData_Tic_Tac_Toe_Game2 = new ArrayList<Tic_Tac_Toe_Data>();
		
		List<int []> loadData0 = DataLoader.loadTicTacToeGameData2("/Users/jianheluo/Downloads/tic_tac_toe_data_negative.dat");
		
		List<int []> loadData1 = DataLoader.loadTicTacToeGameData2("/Users/jianheluo/Downloads/tic_tac_toe_data_positive.dat");
		
		
		for(int [] data:loadData0){
			PerceptronGameData pgd = new PerceptronGameData("negative",data);
			allData_Tic_Tac_Toe_Game2.add(pgd);
		}
		
		for(int [] data:loadData1){
			PerceptronGameData pgd = new PerceptronGameData("positive", data);
			allData_Tic_Tac_Toe_Game2.add(pgd);
		}
	}

	public void trainAndDisplay() {
		PerceptionAlgorithm algorithm = new PerceptionAlgorithm();

		System.out.println("invoke the function of train in the PerceptionAlgorithm class");
		algorithm.train(allData);
		System.out.println("end the invokement of the function of train");

		System.out.println("the labels of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getLabels().length; i++) {
			System.out.print(algorithm.getLabels()[i] + "\t");
		}
		System.out.println();

		System.out.println("the firstTheta of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getFirstTheta().length; i++) {
			System.out.println(algorithm.getFirstTheta()[i] + "\t");
		}
		System.out.println();

		System.out.println("the theta of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getTheta().length; i++) {
			System.out.println(algorithm.getTheta()[i] + "\t");
		}
		System.out.println();

	}
	
	public void trainAndDisplay_Tic_Tac_Toe_Game(){
		PerceptionAlgorithm algorithm = new PerceptionAlgorithm();
		
		System.out.println("invoke the function of train_Tic_Tac_Toe_Game in the PerceptionAlgorithm class");
		
		
		
		algorithm.train_Tic_Tac_Toe_GameOffLine(allData_Tic_Tac_Toe_Game2);
		
		System.out.println("star the online version training");
		
		algorithm.train_Tic_Tac_Toe_GameOnLine(allData_Tic_Tac_Toe_Game2);
		
		System.out.println("end the invokement of the function of train_Tic_Tac_Toe_Game");
		
		System.out.print("the labels of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getLabels().length; i++) {
			System.out.print(algorithm.getLabels()[i] + "\t");
		}
		
		System.out.println();

		System.out.println("the firstTheta of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getFirstTheta().length; i++) {
			System.out.println(algorithm.getFirstTheta()[i] + "\t");
		}
		System.out.println();

		System.out.println("the theta of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getTheta().length; i++) {
			System.out.println(algorithm.getTheta()[i] + "\t");
		}
		System.out.println();
	}
	
	
	public List<Tic_Tac_Toe_Data> getAllData_Tic_Tac_Toe_Game2() {
		return allData_Tic_Tac_Toe_Game2;
	}

	public void setAllData_Tic_Tac_Toe_Game2(
			List<Tic_Tac_Toe_Data> allData_Tic_Tac_Toe_Game2) {
		this.allData_Tic_Tac_Toe_Game2 = allData_Tic_Tac_Toe_Game2;
	}

	public List<FeatureTrainingData> getAllData() {
		return allData;
	}

	public void setAllData(List<FeatureTrainingData> allData) {
		this.allData = allData;
	}

	public List<Tic_Tac_Toe_Data> getAllData_Tic_Tac_Toe_Game() {
		return allData_Tic_Tac_Toe_Game;
	}

	public void setAllData_Tic_Tac_Toe_Game(
			List<Tic_Tac_Toe_Data> allData_Tic_Tac_Toe_Game) {
		this.allData_Tic_Tac_Toe_Game = allData_Tic_Tac_Toe_Game;
	}
	
	

	public static void main(String[] args) {
		
		/*
		
		System.out.println("Process the outside data.");
		
		PerceptronTesteor testor = new PerceptronTesteor();

		testor.loadData();
		
		testor.trainAndDisplay();
		
		
		*/
		
		
		/*
		System.out.println("***************************************");
		
		System.out.println("Process the project data in the first way.");
		
		PerceptronTesteor testor_Tic_Tac_Toe_Game = new PerceptronTesteor();
		
		testor_Tic_Tac_Toe_Game.loadData_Tic_Tac_Toe_Game();
		
		
		testor_Tic_Tac_Toe_Game.trainAndDisplay_Tic_Tac_Toe_Game();
		*/
		
		
	
		System.out.println("***************************************&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		System.out.println("Process the project data in the second way.");
		
		PerceptronTesteor testor_Tic_Tac_Toe_Game2 = new PerceptronTesteor();
		
		testor_Tic_Tac_Toe_Game2.loadData_Tic_Tac_Toe_Game2();
		
		
	
		testor_Tic_Tac_Toe_Game2.trainAndDisplay_Tic_Tac_Toe_Game();
		
		
	}
	
	
	
	
	
	

	

}
