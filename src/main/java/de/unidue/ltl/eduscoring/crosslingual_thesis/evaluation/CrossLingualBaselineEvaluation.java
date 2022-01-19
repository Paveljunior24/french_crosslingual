package de.unidue.ltl.eduscoring.crosslingual_thesis.evaluation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class CrossLingualBaselineEvaluation {


	public static void main (String[] args) throws IOException{
		String datapath = "/Users/andrea/dkpro/org.dkpro.lab/crosslingual";
		File folder = new File(datapath); 
		File[] subfolders = folder.listFiles();
		Map<String, Map<Integer, Double>> results = new  HashMap<String, Map<Integer, Double>>();
	//	ArrayList<String> results = new ArrayList<String>();
		for (File subfolder : subfolders){
			if (subfolder.getName().startsWith("ExperimentCrossValidation")){
				String name = subfolder.getName();
				name = name.substring(28);
				name = name.substring(0, name.lastIndexOf("-"));
			//	System.out.println(name);
				File[] files = subfolder.listFiles();
				for (File file : files){
					if (file.getName().equals("combined_classification_results.txt")){
					//	System.out.println(file.getName());
						List<String> lines = FileUtils.readLines(file);
						for (String line: lines){
							if (line.startsWith("accuracy=")){
								String[] parts = line.split("=");
						//		System.out.println("Acc\t"+parts[1]);
							} else if (line.startsWith("quadratically\\ weighted\\ kappa=")){
								String[] parts = line.split("=");
								double qwk = Math.round(Double.parseDouble(parts[1])*100.0)/100.0;
								String condition = name.substring(0, name.lastIndexOf("_"));
								Integer prompt = Integer.parseInt(name.substring(name.lastIndexOf("_")+1, name.lastIndexOf("-")));
								System.out.println(condition+" "+prompt+ " "+qwk);
								if (!results.containsKey(condition)){
									results.put(condition, new HashMap<Integer, Double>());
								}
								results.get(condition).put(prompt, qwk);
						//		results.add(name+"\tQWK\t"+qwk);
							}
						}
					}
				}
			} else if (subfolder.getName().startsWith("WekaTestTask") && subfolder.getName().contains("TrainTest")){
				String name = subfolder.getName();
				name = name.substring(13);
				name = name.substring(0, name.lastIndexOf("-"));
			//	System.out.println(name);
				File[] files = subfolder.listFiles();
				for (File file : files){
					if (file.getName().equals("classification_results.txt")){
					//	System.out.println(file.getName());
						List<String> lines = FileUtils.readLines(file);
						for (String line: lines){
							String condition = name.substring(0, name.lastIndexOf("_"));
							Integer prompt = Integer.parseInt(name.substring(name.lastIndexOf("_")+1, name.lastIndexOf("-")));
							if (line.startsWith("accuracy=")){
								String[] parts = line.split("=");
								System.out.println(condition+" "+prompt+ " Acc\t"+parts[1]);
							} else if (line.startsWith("quadratically\\ weighted\\ kappa=")){
								String[] parts = line.split("=");
								double qwk = Math.round(Double.parseDouble(parts[1])*100.0)/100.0;
								System.out.println(condition+" "+prompt+ " "+qwk);
								if (!results.containsKey(condition)){
									results.put(condition, new HashMap<Integer, Double>());
								}
								results.get(condition).put(prompt, qwk);
						//		results.add(name+"\tQWK\t"+qwk);
							}
						}
					}
				}
			}
		}	
		System.out.println("\n\n");
		ArrayList<String> keys = new ArrayList<String>();
		keys.addAll(results.keySet());
		Collections.sort(keys);
		for (String key : keys){
			double avg = Math.round(((results.get(key).get(1) + results.get(key).get(2) + results.get(key).get(10))/3)*100.0)/100.0;
			System.out.println(key +" & "+results.get(key).get(1)+" & "+results.get(key).get(2)+" & "+results.get(key).get(10)+" & "+avg+" \\\\");
		}
		System.out.println(keys.size()+" results");
	}	
}
