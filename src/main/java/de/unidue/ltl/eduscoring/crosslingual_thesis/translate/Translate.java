package de.unidue.ltl.eduscoring.crosslingual_thesis.translate;

import de.unidue.ltl.eduscoring.crosslingual_thesis.experiments.DataSetPaths;

public class Translate implements DataSetPaths {
	
	// Set your API-Key from https://console.developers.google.com/

	static String dummyKey = "AIzaSyDhIB-xct2T341CfNOdDZE4qnuMwkEimEE";  //insert your own key here

	public static void main(String[] args) {
		//Example usage of the Google translator. 
		GoogleTranslator google = new GoogleTranslator(dummyKey, "de");
		google.translateFile("D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_en\\en to fr to trans.txt", EN_TRANSLATED_FR_TRANSLATED_DE);
	}

}
