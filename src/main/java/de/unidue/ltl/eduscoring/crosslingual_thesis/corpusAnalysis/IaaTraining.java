package de.unidue.ltl.eduscoring.crosslingual_thesis.corpusAnalysis;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import de.unidue.ltl.evaluation.core.EvaluationData;
import de.unidue.ltl.evaluation.measures.agreement.QuadraticallyWeightedKappa;
import de.unidue.ltl.evaluation.visualization.ConfusionMatrix;


public class  IaaTraining {



	public static void main(String[] args) throws IOException{
		System.out.println("Pavel- Arthur ");
		System.out.println("Prompt 1");
		String gold = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_fr\\prompt fr 1 gold.txt";
		String anno = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_fr\\essay 1 arthur.txt";
	
		computeIAA(gold, anno);

		System.out.println("Prompt 2");
		gold = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_fr\\essay 2 pavel.txt";
		anno = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_fr\\essay 2 arthur.txt";
		computeIAA(gold, anno);

		System.out.println("Prompt 10");
		gold = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_fr\\prompt fr 3 gold .txt";
		anno = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_fr\\correction arthur 3 fr.txt";
		
		computeIAA(gold, anno);

		/*System.out.println("Bea - Gold");
		System.out.println("Prompt 1");
		gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt1_anno_training_gold.txt";
		anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/asap_es/AnnoTraining/prompt1_anno_training_bea.txt";
		computeIAA(gold, anno);

		System.out.println("Prompt 2");
		gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt2_anno_training_gold.txt";
		anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/asap_es/AnnoTraining/prompt2_anno_training_bea.txt";
		computeIAA(gold, anno);

		System.out.println("Prompt 10");
		gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt10_anno_training_gold.txt";
		anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/asap_es/AnnoTraining/prompt10_anno_training_bea.txt";
		computeIAA(gold, anno);

		System.out.println("Diana - Gold");
		System.out.println("Prompt 1");
		gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt1_anno_training_gold.txt";
		anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/asap_es/AnnoTraining/prompt1_anno_training_diana.txt";
		computeIAA(gold, anno);

		System.out.println("Prompt 2");
		gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt2_anno_training_gold.txt";
		anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/asap_es/AnnoTraining/prompt2_anno_training_diana.txt";
		computeIAA(gold, anno);

		System.out.println("Prompt 10");
		gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt10_anno_training_gold.txt";
		anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/asap_es/AnnoTraining/prompt10_anno_training_diana.txt";
		computeIAA(gold, anno);
*/
//						System.out.println("Prompt 1");
//						String gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt1_anno_training_gold.txt";
//						String anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt1_anno_training_kk.txt";
//						computeIAA(gold, anno);
//						
//						System.out.println("Prompt 2");
//						gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt2_anno_training_gold.txt";
//						anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt2_anno_training_kk.txt";
//						computeIAA(gold, anno);
//						
//						System.out.println("Prompt 10");
//						gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt10_anno_training_gold.txt";
//						anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt10_anno_training_kk.txt";
//						computeIAA(gold, anno);
//		
//				System.out.println("Prompt 1");
//				gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt1_anno_training_gold.txt";
//				anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt1_anno_training_jeanette.txt";
//				computeIAA(gold, anno);
//		
//				System.out.println("Prompt 2");
//				gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt2_anno_training_gold.txt";
//				anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt2_anno_training_jeanette.txt";
//				computeIAA(gold, anno);
//		
//				System.out.println("Prompt 10");
//				gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt10_anno_training_gold.txt";
//				anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt10_anno_training_jeanette.txt";
//				computeIAA(gold, anno);
//				
//				
//				System.out.println("Prompt 1");
//				 gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt1_anno_training_kk.txt";
//				 anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt1_anno_training_jeanette.txt";
//				computeIAA(gold, anno);
//		
//				System.out.println("Prompt 2");
//				gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt2_anno_training_kk.txt";
//				anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt2_anno_training_jeanette.txt";
//				computeIAA(gold, anno);
//		
//				System.out.println("Prompt 10");
//				gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt10_anno_training_kk.txt";
//				anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/training/prompt10_anno_training_jeanette.txt";
//				computeIAA(gold, anno);
//			
//			
//				System.out.println("Prompt 1");
//				 gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/prompt1_kk_all.txt";
//				 anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/prompt1_jeanette_all.txt";
//				computeIAA(gold, anno);
//		
//				System.out.println("Prompt 2");
//				gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/prompt2_kk_all.txt";
//				anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/prompt2_jeanette_all.txt";
//				computeIAA(gold, anno);
//		
//				System.out.println("Prompt 10");
//				gold = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/prompt10_kk_all.txt";
//				anno = "/Users/andrea/dkpro/datasets/asap/crosslingual/NewEnglishAnnotations/prompt10_jeanette_all.txt";
//				computeIAA(gold, anno);

	}


	private static void computeIAA(String goldPath, String annoPath) throws IOException {
		ArrayList<Double> annosGold = readData(goldPath);
		ArrayList<Double> annosNew = readData(annoPath);
		//		System.out.println(annosGold);
		//		System.out.println(annosNew);

		EvaluationData<Double> entries = new EvaluationData<Double>();
		for (int i = 0; i<annosGold.size(); i++){
			if (annosGold.get(i)>=0 && annosNew.get(i)>=0){
				entries.register(annosGold.get(i),annosNew.get(i));
			}
		}
		ConfusionMatrix<Double> matrix = new ConfusionMatrix<Double>(entries);
	//	System.out.print(matrix.toText());
		System.out.println(new QuadraticallyWeightedKappa<Double>(entries).getResult());
	}

	private static ArrayList<Double> readData(String annoPath) throws IOException {
		//	System.out.println(annoPath);
		ArrayList<Double> result = new ArrayList<Double>();
		BufferedReader br = new BufferedReader(new FileReader(annoPath));
		String line = br.readLine();
		line = br.readLine();
		while (line != null){
			if (!line.trim().equals("")){
				String[] parts = line.split("\\s+");
				double score = Double.parseDouble(parts[2].trim());
				// merge all the error codes:
				if (score<0){
					score = -1.0;
				}
				result.add(score);
			}
			line = br.readLine();
		}

		return result;	
	}






}
