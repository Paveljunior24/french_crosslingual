package de.unidue.ltl.eduscoring.crosslingual_thesis.translate;

import de.unidue.ltl.eduscoring.crosslingual_thesis.experiments.DataSetPaths2;

public class Translate2 implements DataSetPaths2 {
	
	// Set your API-Key from https://console.developers.google.com/

	static String dummyKey = "AIzaSyAunAXsJRSdtZo1o8imffCOmpuyjh4uGMg";  //insert your own key here

	public static void main(String[] args) {
		
		System.setProperty("DKPRO_HOME", "DKPRO_HOME");
		// example of pathToYourDKproDirectory: /home/user/workspace/DKPRO_HOME
		
		//Example usage of the Google translator. 
		GoogleTranslator google = new GoogleTranslator(dummyKey, "cn");
		google.translateFile("D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_en\\test_public_repaired.txt", EN_TRAIN_TRANSLATED_CN);
	}
	//google.translateFile("C:\\Users\\SXf\\Documents\\DKPRO_HOME\\datasets\\asap\\crosslingual\\asap_en\\asap_train_textsForTranslationTest.tsv", EN_TRAIN_TRANSLATED_CN);
}
