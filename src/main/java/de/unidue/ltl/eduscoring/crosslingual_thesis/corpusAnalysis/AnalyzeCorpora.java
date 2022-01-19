package de.unidue.ltl.eduscoring.crosslingual_thesis.corpusAnalysis;

import de.unidue.ltl.eduscoring.crosslingual_thesis.experiments.DataSetPaths;

public class AnalyzeCorpora implements DataSetPaths{

	public static void main(String[] args){
	
		AsapAnalysis germanAsapTranslatedToEnglish = new AsapAnalysis("german ASAP translated to English");
		germanAsapTranslatedToEnglish.readTranslatedAsapFile(GER_ASAP, DE_TRANSLATED_EN);
		germanAsapTranslatedToEnglish.analyzeCorpus();
		
		AsapAnalysis spanishAsapTranslatedToEnglish = new AsapAnalysis("spanish ASAP translated to English");
		spanishAsapTranslatedToEnglish.readOriginalAsapFile(ES_ASAP_TRANSLATED_EN);
		spanishAsapTranslatedToEnglish.analyzeCorpus();
		
		AsapAnalysis spanishAsap = new AsapAnalysis("original Spanish ASAP");
		spanishAsap.readOriginalAsapFile(ES_ASAP);
		spanishAsap.analyzeCorpus();
		
		AsapAnalysis germanAsap = new AsapAnalysis("original German ASAP");
		germanAsap.readOriginalAsapFile(GER_ASAP);
		germanAsap.analyzeCorpus();
		
		AsapAnalysis newEnglishAsap = new AsapAnalysis("new English ASAP");
		newEnglishAsap.readOriginalAsapFile(EN_RECOLLECTED);
		newEnglishAsap.analyzeCorpus();
		
		AsapAnalysis originalEnglishAsap = new AsapAnalysis("original English ASAP");
		originalEnglishAsap.readOriginalAsapFile(EN_TRAIN);
		originalEnglishAsap.analyzeCorpus();
		
	}

}
