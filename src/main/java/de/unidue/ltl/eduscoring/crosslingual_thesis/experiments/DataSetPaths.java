package de.unidue.ltl.eduscoring.crosslingual_thesis.experiments;

public interface DataSetPaths {
	
//	public static final String EN_TRAIN = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/train_repaired.txt";
	public static final String EN_TRAIN = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_en\\train_repaired.txt";
	public static final String EN_TEST = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_en\\test_public_repaired.txt";
	public static final String FR_TRAIN= "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_fr\\Prompts FR.txt";
	public static final String FR_TEST = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_fr\\Prompts FR.txt";
	public static final String DE_TRAIN = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_de\\new asap de.txt";
	public static final String DE_TEST = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_de\\new asap de.txt";
	//public static final String EN_TEST = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/test_public_repaired.txt";
	public static final String EN_TRAIN_DOUBLE_TRANSLATED = "C:\\Users\\SXf\\Documents\\DKPRO_HOME\\datasets\\asap\\crosslingual\\asap_en_double_translated\\train_double_translated_clean.txt";
	public static final String EN_TEST_DOUBLE_TRANSLATED = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_double_translated/test_double_translated_clean.txt";
	
	public static final String EN_RECOLLECTED_TRANSLATED = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_recollected_translated/train_recollected_translated_clean.txt";
	public static final String EN_RECOLLECTED = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_recollected/train_recollected_clean.txt";
	public static final String EN_RECOLLECTED_DICT = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_recollected/train_recollected_clean_texts.txt";
	public static final String EN_RECOLLECTED_TRANSLATED_DE = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_recollected_translated/asap_en_recollected_translated_clean.txt";
	public static final String EN_RECOLLECTED_TRANSLATED_DE_FULL = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_recollected/train_recollected_clean_de.txt";
	public static final String EN_RECOLLECTED_TRANSLATED_ES = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_recollected/train_recollected_clean_es.txt";
	
	
	
	public static final String EN_TRAIN_TRANSLATED_ES = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/asap_train_spanish.txt";;
	public static final String EN_TEST_TRANSLATED_ES = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/asap_test_spanish.txt";;
	
	public static final String EN_TRAIN_DICT = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/asap_train_textsForTranslation.tsv";
	public static final String EN_TEST_DICT = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/asap_test_public_textsForTranslation.txt";
	
	public static final String EN_TRANSLATED_DE_TRAIN = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_train_de_translated_clean.txt";
	public static final String EN_TRANSLATED_DE_TRAIN_FULL = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/asap_train_german.txt";
	public static final String GER_DEEPL_TRAIN = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_train_de_deepl_translated_clean.txt";
	public static final String EN_TRANSLATED_DE_TEST = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_test_public_de_translated_clean.txt";
	public static final String EN_TRANSLATED_DE_TEST_FULL = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/asap_test_german.txt";
	public static final String GER_DEEPL_TEST = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_test_public_de_deepl_translated_clean.txt";
	
	public static final String RU_GOOGLE_TRAIN = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_train_ru_translated_clean.txt";
	public static final String RU_GOOGLE_TEST = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_test_public_text_ru_translated_clean.txt";
	
	public static final String GER_ASAP = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de/germanAsap.txt";
	public static final String GER_ASAP_DOUBLE_TRANSLATED = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de_double_translated/germanAsap_double_translated_clean.txt";
	//public static final String DE_TRANSLATED_EN =System.getenv( "DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de_translated/germanAsap_en_translated_clean.txt";
	public static final String DE_TRANSLATED_EN_FULL = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de/germanAsap_clean_en.txt";
	public static final String DE_TRANSLATED_EN_DEEPL = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de_translated/germanAsap_en_deepl_translated_clean.txt";
	
	public static final String DE_TRANSLATED_ES = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de/germanAsap_clean_es.txt";
	
	
	public static final String ES_ASAP = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_es/spanish_gold.txt";
	public static final String ES_ASAP_TRANSLATED_EN = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_es/spanish_gold_en.txt";
	public static final String ES_ASAP_TRANSLATED_DE = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_es/spanish_gold_de.txt";
	
	
	
	public static final String GER_DICT = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de/germanAsap_Dict.txt";
	
	
	
//	public static final String EN_TRAIN = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/train_repaired.txt";
//	public static final String EN_TEST = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/test_public_repaired.txt";
//	public static final String EN_TRAIN_DOUBLE_TRANSLATED = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_double_translated/train_double_translated.txt";
//	public static final String EN_TEST_DOUBLE_TRANSLATED = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_double_translated/test_double_translated.txt";
//	
//	public static final String EN_TRAIN_DICT = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/asap_train_textsForTranslation.tsv";
//	public static final String EN_TEST_DICT = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/asap_test_public_textsForTranslation.txt";
//	
//	public static final String GER_GOOGLE_TRAIN = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_train_de_translated.txt";
//	public static final String GER_DEEPL_TRAIN = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_train_de_deepl_translated.txt";
//	public static final String GER_GOOGLE_TEST = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_test_public_de_translated.txt";
//	public static final String GER_DEEPL_TEST = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_test_public_de_deepl_translated.txt";
//	
//	public static final String RU_GOOGLE_TRAIN = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_train_ru_translated.txt";
//	public static final String RU_GOOGLE_TEST = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en_translated/asap_test_public_text_ru_translated.txt";
//	
//	public static final String GER_ASAP = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de/germanAsap.txt";
//	public static final String GER_ASAP_DOUBLE_TRANSLATED = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de_double_translated/germanAsap_double_translated.txt";
//	public static final String EN_GOOGLE_ASAP = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de_translated/germanAsap_en_translated.txt";
//	public static final String EN_DEEPL_ASAP = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_de_translated/germanAsap_en_deepl_translated.txt";
//	
//	public static final String GER_DICT = System.getenv("DKPRO_HOME")+"/datasets/asap/asap_de/germanAsap_Dict.txt";
	
/*	public static final String EN_TRAIN_TRANSLATED_CN = "C:\\Users\\SXf\\Documents\\DKPRO_HOME\\datasets\\asap\\crosslingual\\asap_en_translated\\asap_train_cn_translated_Xf.txt";
	public static final String EN_TEST_TRANSLATED_CN = "C:\\Users\\SXf\\Documents\\DKPRO_HOME\\datasets\\asap\\crosslingual\\asap_en_translated\\asap_test_cn_translated_Xf.txt";
	
	public static final String EN_TRANSLATED_CN_TRAIN_FULL = "C:\\Users\\SXf\\Documents\\DKPRO_HOME\\datasets\\asap\\crosslingual\\asap_en\\asap_train_chinese2.txt";
	public static final String EN_TRANSLATED_CN_TEST_FULL = "C:\\Users\\SXf\\Documents\\DKPRO_HOME\\datasets\\asap\\crosslingual\\asap_en\\asap_test_chinese2.txt";	
*/
	public static final String FR_TRANSLATED_EN = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_fr\\FR_TRANSLATED_EN.txt";
	public static final String FR_TRANSLATED_DE = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_fr\\FR_TRANSLATED_DE.txt";
	public static final String EN_TRANSLATED_FR = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_en\\en_to_fr.txt";
	public static final String EN_TRANSLATED_DE = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_en\\en_to_de.txt";
	public static final String DE_TRANSLATED_FR = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_de\\de_to_fr1.txt";
	public static final String DE_TRANSLATED_EN = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_de\\de_to_en1.txt";
	public static final String DE_TRANSLATED_FR_TRANSLATED_EN = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_de\\DE_TRANSLATED_FR_TRANSLATED_EN.txt";
	public static final String EN_TRANSLATED_FR_TRANSLATED_DE = "D:\\proj\\DKPRO_HOME\\data\\datasets\\asap\\crosslingual\\asap_en\\EN_TRANSLATED_FR_TRANSLATED_DE.txt";

	
}
