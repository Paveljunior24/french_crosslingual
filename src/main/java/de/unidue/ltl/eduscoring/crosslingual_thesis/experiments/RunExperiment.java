package de.unidue.ltl.eduscoring.crosslingual_thesis.experiments;

public class RunExperiment implements DataSetPaths {

	private static final String ENGLISH_LANGUAGE_CODE ="en";
	private static final String GERMAN_LANGUAGE_CODE ="de";
	private static final String FRENCH_LANGUAGE_CODE ="fr";

	public static void main(String[] args) throws Exception{
		
		System.setProperty("DKPRO_HOME", "D:\\proj\\DKPRO_HOME");

		AsapExperiment experiment = new AsapExperiment();
		//##### MONOLINGUAL BASELINES #####
		//original English Train Test cv
/*
		experiment.runAsapBaselineExperiment("EN_Train_Test", EN_TRAIN, EN_TEST, ENGLISH_LANGUAGE_CODE, true, false, 1, 2, 10);
		experiment.runAsapBaselineExperiment("FR_Train_Test", FR_TRAIN, FR_TEST, FRENCH_LANGUAGE_CODE, true, false,  1,2,10);
		experiment.runAsapBaselineExperiment("DE_Train_Test", DE_TRAIN, DE_TEST, GERMAN_LANGUAGE_CODE, true, false,  1,2,10);
		
		
		

		experiment.runAsapBaselineExperiment("EN_trans_FR_Train_EN_trans_FR_Test", EN_TRANSLATED_FR, EN_TRANSLATED_FR, ENGLISH_LANGUAGE_CODE, true, false, 1, 2, 10);
		experiment.runAsapBaselineExperiment("EN_trans_DE_Train_EN_trans_DE_Test", EN_TRANSLATED_DE, EN_TRANSLATED_DE, ENGLISH_LANGUAGE_CODE, true, false, 1, 2, 10);
		
		experiment.runAsapBaselineExperiment("DE_trans_EN_Train_DE_trans_EN_Test", DE_TRANSLATED_EN, DE_TRANSLATED_EN, GERMAN_LANGUAGE_CODE, true, false,  1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_FR_Train_DE_trans_FR_Test", DE_TRANSLATED_FR, DE_TRANSLATED_FR, GERMAN_LANGUAGE_CODE, true, false,  1,2,10);
		
		//experiment.runAsapBaselineExperiment("FR_trans_EN_Train_FR_trans_EN_Test", FR_TRANSLATED_EN, FR_TRANSLATED_EN, FRENCH_LANGUAGE_CODE, true, false,  1,2,10);
		//experiment.runAsapBaselineExperiment("FR_trans_DE_Train_FR_trans_DE_Test", FR_TRANSLATED_DE, FR_TRANSLATED_DE, FRENCH_LANGUAGE_CODE, true, false,  1,2,10);
		
	
		// Both 
		
		experiment.runAsapBaselineExperiment("EN_trans_FR_Train_FR_trans_EN_Test", EN_TRANSLATED_FR, FR_TRANSLATED_EN, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("EN_trans_FR_Train_FR_trans_DE_Test", EN_TRANSLATED_FR, FR_TRANSLATED_DE, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("EN_trans_FR_Train_EN_trans_DE_Test", EN_TRANSLATED_FR, EN_TRANSLATED_DE, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("EN_trans_FR_Train_DE_trans_EN_Test", EN_TRANSLATED_FR, DE_TRANSLATED_EN, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);
		
		experiment.runAsapBaselineExperiment("EN_trans_DE_Train_FR_trans_EN_Test", EN_TRANSLATED_DE, FR_TRANSLATED_EN, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);	
		experiment.runAsapBaselineExperiment("EN_trans_DE_Train_FR_trans_DE_Test", EN_TRANSLATED_DE, FR_TRANSLATED_DE, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);	
		experiment.runAsapBaselineExperiment("EN_trans_DE_Train_EN_trans_FR_Test", EN_TRANSLATED_DE, EN_TRANSLATED_FR, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);	
		experiment.runAsapBaselineExperiment("EN_trans_DE_Train_DE_trans_FR_Test", EN_TRANSLATED_DE, DE_TRANSLATED_FR, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("EN_trans_DE_Train_DE_trans_EN_Test", EN_TRANSLATED_DE, DE_TRANSLATED_EN, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);
		
		experiment.runAsapBaselineExperiment("FR_trans_EN_Train_FR_trans_DE_Test", FR_TRANSLATED_EN, FR_TRANSLATED_DE, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("FR_trans_EN_Train_EN_trans_DE_Test", FR_TRANSLATED_EN, EN_TRANSLATED_DE, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("FR_trans_EN_Train_EN_trans_FR_Test", FR_TRANSLATED_EN, EN_TRANSLATED_FR, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("FR_trans_EN_Train_DE_trans_FR_Test", FR_TRANSLATED_EN, DE_TRANSLATED_FR, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);	
		experiment.runAsapBaselineExperiment("FR_trans_EN_Train_DE_trans_EN_Test", FR_TRANSLATED_EN, DE_TRANSLATED_EN, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);	
		
		experiment.runAsapBaselineExperiment("FR_trans_DE_Train_FR_trans_EN_Test", FR_TRANSLATED_DE, FR_TRANSLATED_EN, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("FR_trans_DE_Train_EN_trans_DE_Test", FR_TRANSLATED_DE, EN_TRANSLATED_DE, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("FR_trans_DE_Train_EN_trans_FR_Test", FR_TRANSLATED_DE, EN_TRANSLATED_FR, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("FR_trans_DE_Train_DE_trans_FR_Test", FR_TRANSLATED_DE, DE_TRANSLATED_FR, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);	
		experiment.runAsapBaselineExperiment("FR_trans_DE_Train_DE_trans_EN_Test", FR_TRANSLATED_DE, DE_TRANSLATED_EN, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);	
		
		
		
		experiment.runAsapBaselineExperiment("DE_trans_EN_Train_FR_trans_EN_Test", DE_TRANSLATED_EN, FR_TRANSLATED_EN, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_EN_Train_FR_trans_DE_Test", DE_TRANSLATED_EN, FR_TRANSLATED_DE, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_EN_Train_EN_trans_DE_Test", DE_TRANSLATED_EN, EN_TRANSLATED_DE, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_EN_Train_EN_trans_FR_Test", DE_TRANSLATED_EN, EN_TRANSLATED_FR, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_EN_Train_DE_trans_FR_Test", DE_TRANSLATED_EN, DE_TRANSLATED_FR, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);
		
		experiment.runAsapBaselineExperiment("DE_trans_FR_Train_FR_trans_EN_Test", DE_TRANSLATED_FR, FR_TRANSLATED_EN, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_FR_Train_FR_trans_DE_Test", DE_TRANSLATED_FR, FR_TRANSLATED_DE, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_FR_Train_EN_trans_DE_Test", DE_TRANSLATED_FR, EN_TRANSLATED_DE, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_FR_Train_DE_trans_EN_Test", DE_TRANSLATED_FR, DE_TRANSLATED_EN, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);
		
		
		 //TRANSLATE TRAIN
		experiment.runAsapBaselineExperiment("EN_trans_FR_Train_FR_Test", EN_TRANSLATED_FR, FR_TEST, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("EN_trans_DE_Train_DE_Test", EN_TRANSLATED_DE, DE_TEST, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("FR_trans_DE_Train_DE_Test", FR_TRANSLATED_DE, DE_TEST, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("FR_trans_EN_Train_EN_Test", FR_TRANSLATED_EN, EN_TEST, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_EN_Train_EN_Test", DE_TRANSLATED_EN, EN_TEST, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);	
		experiment.runAsapBaselineExperiment("DE_trans_FR_Train_FR_Test", DE_TRANSLATED_FR, FR_TEST, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);		
					
		//TRANSLATE TEST 
		experiment.runAsapBaselineExperiment("DE_Train_EN_trans_DE_Test", DE_TRAIN, EN_TRANSLATED_DE, GERMAN_LANGUAGE_CODE, false, false,  1,2,10);
		experiment.runAsapBaselineExperiment("FR_Train_EN_trans_FR_Test", FR_TRAIN, EN_TRANSLATED_FR, FRENCH_LANGUAGE_CODE, false, false,  1,2,10);
		experiment.runAsapBaselineExperiment("DE_Train_FR_trans_DE_Test", DE_TRAIN, FR_TRANSLATED_DE, GERMAN_LANGUAGE_CODE, false, false,  1,2,10);
		experiment.runAsapBaselineExperiment("EN_Train_FR_trans_EN_Test", EN_TRAIN, FR_TRANSLATED_EN, ENGLISH_LANGUAGE_CODE, false, false,  1,2,10);
		experiment.runAsapBaselineExperiment("FR_Train_DE_trans_FR_Test", FR_TRAIN, DE_TRANSLATED_FR, FRENCH_LANGUAGE_CODE, false, false,  1,2,10);
		experiment.runAsapBaselineExperiment("EN_Train_DE_trans_EN_Test", EN_TRAIN, DE_TRANSLATED_EN, ENGLISH_LANGUAGE_CODE, false, false,  1,2,10);
		
		
		//french cross BOTH  
		
		
		experiment.runAsapBaselineExperiment("EN_trans_FR_Train_DE_trans_FR_Test", EN_TRANSLATED_FR, DE_TRANSLATED_FR, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);		
		experiment.runAsapBaselineExperiment("DE_trans_FR_Train_EN_trans_FR_Test", DE_TRANSLATED_FR, EN_TRANSLATED_FR, FRENCH_LANGUAGE_CODE, false, false, 1,2,10);		
				
					
				
		//baseline french bridge cv
		experiment.runAsapBaselineExperiment("DE_trans_FR_trans_EN_Train_DE_trans_FR_trans_EN_Test", DE_TRANSLATED_FR_TRANSLATED_EN, DE_TRANSLATED_FR_TRANSLATED_EN, ENGLISH_LANGUAGE_CODE, true, false, 1,2,10);	
		experiment.runAsapBaselineExperiment("EN_trans_FR_trans_DE_Train_EN_trans_FR_trans_DE_Test", EN_TRANSLATED_FR_TRANSLATED_DE, EN_TRANSLATED_FR_TRANSLATED_DE, GERMAN_LANGUAGE_CODE, true, false, 1,2,10);	
		

		//french Bridge train
		experiment.runAsapBaselineExperiment("DE_trans_FR_trans_EN_Train_EN_Test", DE_TRANSLATED_FR_TRANSLATED_EN, EN_TEST, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);	
		experiment.runAsapBaselineExperiment("EN_trans_FR_trans_DE_Train_DE_Test", EN_TRANSLATED_FR_TRANSLATED_DE, DE_TEST, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);	
		
		// french bridge test
		experiment.runAsapBaselineExperiment("EN_Train_DE_trans_FR_trans_EN_Test", EN_TRAIN, DE_TRANSLATED_FR_TRANSLATED_EN, ENGLISH_LANGUAGE_CODE, false, false,  1,2,10);
		experiment.runAsapBaselineExperiment("DE_Train_EN_trans_FR_trans_DE_Train", DE_TRAIN, EN_TRANSLATED_FR_TRANSLATED_DE, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);	
		
		//french bridge both 
		experiment.runAsapBaselineExperiment("DE_trans_FR_trans_EN_Train_EN_trans_FR_trans_DE_Test", DE_TRANSLATED_FR_TRANSLATED_EN, EN_TRANSLATED_FR_TRANSLATED_DE, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);	
		experiment.runAsapBaselineExperiment("EN_trans_FR_trans_DE_Train_DE_trans_FR_trans_EN_Test", EN_TRANSLATED_FR_TRANSLATED_DE, DE_TRANSLATED_FR_TRANSLATED_EN, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);	
		
		
		
		*/
		

		
		experiment.runAsapBaselineExperiment("EN_trans_DE_Train_EN_trans_FR_trans_DE_Test", EN_TRANSLATED_DE, EN_TRANSLATED_FR_TRANSLATED_DE, ENGLISH_LANGUAGE_CODE, false, false,  1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_EN_Train_DE_trans_FR_trans_EN_Test", DE_TRANSLATED_EN, DE_TRANSLATED_FR_TRANSLATED_EN, GERMAN_LANGUAGE_CODE, false, false,  1,2,10);
		
		experiment.runAsapBaselineExperiment("EN_trans_FR_trans_DE_Train_EN_trans_DE_Test",  EN_TRANSLATED_FR_TRANSLATED_DE ,EN_TRANSLATED_DE,ENGLISH_LANGUAGE_CODE, false, false,  1,2,10);
		experiment.runAsapBaselineExperiment("DE_trans_FR_trans_EN_Train_DE_trans_EN_Test", DE_TRANSLATED_FR_TRANSLATED_EN, DE_TRANSLATED_EN, GERMAN_LANGUAGE_CODE, false, false,  1,2,10);
		
		System.exit(-1);
		
		//recollected English CV
		//experiment.runAsapBaselineExperiment("EN_CW_CV", EN_RECOLLECTED, EN_RECOLLECTED, ENGLISH_LANGUAGE_CODE, true, false, 1, 2, 10);
		//original English Train Test with 270 training instances
		//experiment.runAsapBaselineExperiment("EN_270Train_Test", EN_TRAIN, EN_TEST, ENGLISH_LANGUAGE_CODE ,false, true, 1, 2, 10);
		//German Cross-Validation
		//experiment.runAsapBaselineExperiment("DE_CV", GER_ASAP, GER_ASAP, GERMAN_LANGUAGE_CODE, true, false, 1,2,10);

		//German translated into English CV
		//experiment.runAsapBaselineExperiment("DE_trans_EN_CV_NEW", DE_TRANSLATED_EN_FULL, DE_TRANSLATED_EN_FULL, ENGLISH_LANGUAGE_CODE, true, false, 1,2,10);

		//English translated into German Train Test google
		//experiment.runAsapBaselineExperiment("EN_trans_DE_Train_Test_NEW", EN_TRANSLATED_DE_TRAIN_FULL, EN_TRANSLATED_DE_TEST_FULL, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);
		// English recollected Translated into German CV
		//experiment.runAsapBaselineExperiment("EN_CW_trans_DE_CV", EN_RECOLLECTED_TRANSLATED_DE, EN_RECOLLECTED_TRANSLATED_DE, GERMAN_LANGUAGE_CODE, true, false, 1,2,10);
		//translate both
		//experiment.runAsapBaselineExperiment("EN_trans_DE_Train_FR_trans_DE_Test", EN_TRANSLATED_DE, FR_TRANSLATED_DE, GERMAN_LANGUAGE_CODE, false, false,  1,2,10);
		//experiment.runAsapBaselineExperiment("EN_trans_FR_Train_DE_trans_FR_Test", EN_TRANSLATED_FR, DE_TRANSLATED_FR, FRENCH_LANGUAGE_CODE, false, false,  1,2,10);
		//experiment.runAsapBaselineExperiment("DE_trans_FR_Train_EN_trans_FR_Test", DE_TRANSLATED_FR, EN_TRANSLATED_FR, FRENCH_LANGUAGE_CODE, false, false,  1,2,10);
		//experiment.runAsapBaselineExperiment("DE_trans_EN_Train_FR_trans_EN_Test", DE_TRANSLATED_EN, FR_TRANSLATED_EN, ENGLISH_LANGUAGE_CODE, false, false,  1,2,10);
		//experiment.runAsapBaselineExperiment("FR_trans_DE_Train_EN_trans_DE_Test", FR_TRANSLATED_DE, EN_TRANSLATED_DE, GERMAN_LANGUAGE_CODE, false, false,  1,2,10);
		//experiment.runAsapBaselineExperiment("FR_trans_EN_Train_DE_trans_EN_Test", FR_TRANSLATED_DE, DE_TRANSLATED_EN, ENGLISH_LANGUAGE_CODE, false, false,  1,2,10);

		//##### TRANSLATE TEST DATA#####
		//original English Train translated de-en Test
		//experiment.runAsapBaselineExperiment("EN_Train_DE_trans_EN_Test_NEW", EN_TRAIN, DE_TRANSLATED_EN_FULL, ENGLISH_LANGUAGE_CODE, false, false,  1,2,10);	

		//German Train translated en-de Test
		//experiment.runAsapBaselineExperiment("DE_Train_EN_trans_DE_Test_NEW", GER_ASAP, EN_TRANSLATED_DE_TEST_FULL, GERMAN_LANGUAGE_CODE, false, false,  1,2,10);
		//German Train translated enCW-de Test
		//experiment.runAsapBaselineExperiment("DE_Train_EN_CW_trans_DE_Test", GER_ASAP, EN_RECOLLECTED_TRANSLATED_DE_FULL, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);	
		
		
		
		


		//##### TRANSLATE TRAIN DATA#####
		//German translated de-en Train original Test
		//experiment.runAsapBaselineExperiment("DE_trans_EN_Train_EN_Test_NEW", DE_TRANSLATED_EN_FULL, EN_TEST, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);		
		//German translated de-en Train recollected English Test
		//experiment.runAsapBaselineExperiment("DE_trans_EN_Train_EN_CW_Test", DE_TRANSLATED_EN_FULL, EN_RECOLLECTED, ENGLISH_LANGUAGE_CODE, false, false, 1,2,10);

		//en-de translated Train German Test
		//experiment.runAsapBaselineExperiment("EN_trans_DE_Train_DE_Test_NEW", EN_TRANSLATED_DE_TRAIN_FULL, GER_ASAP, GERMAN_LANGUAGE_CODE, false, false,1,2,10);
		//recollected en-de translated Train German Test
		//experiment.runAsapBaselineExperiment("EN_CW_trans_DE_Train_DE_Test", EN_RECOLLECTED_TRANSLATED_DE_FULL, GER_ASAP, GERMAN_LANGUAGE_CODE, false, false, 1,2,10);		

		




}
}
