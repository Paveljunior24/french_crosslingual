package de.unidue.ltl.eduscoring.crosslingual_thesis.corpusAnalysis;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.apache.uima.fit.factory.CollectionReaderFactory.createReader;
import static org.apache.uima.fit.util.JCasUtil.toText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.factory.AggregateBuilder;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.frequency.util.FrequencyDistribution;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
//import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
//import de.tudarmstadt.ukp.dkpro.core.io.tiger.TigerXmlReader;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.ltl.eduscoring.crosslingual_thesis.experiments.DataSetPaths;

public class AnalyzeCorpurDistributions implements DataSetPaths{

	public static void main(String[] args) throws UIMAException, IOException{

		// Basic idea
		//compare KL-Distance between frequency distributions:
		// baseline: en_train - en_test
		// matrix with all possible combinations (translated to English)
		// potentially also the same for German and Spanish translations

		int[] ids = {1,2,10};
		String[][] files_lists = {{"en_train", "en_test", "de-en", "en_recollected", "es-en"},
				{"de", "de-es", "en_cw-es", "train_en-es", "test_en-es"},
				{"es", "es-de", "en_cw-de", "train_en-de", "test_en-de"}
		};
		for (String[] files : files_lists){
			
						for (int id : ids){
							System.out.println();
							System.out.println("id: "+id);
							for (String file : files){
								System.out.print("\t"+file);
							}
			
							for (String file1 : files){
								System.out.print("\n"+format(file1)+"\t");
								for (String file2 : files){
									//System.out.println("\n"+file1+" - "+file2);
			
									String filePath1 = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/texts_for_language_models/id"+id+"_"+file1+"_texts.txt";
									String filePath2 = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/texts_for_language_models/id"+id+"_"+file2+"_texts.txt";
									computeDivergence(filePath1, filePath2);
								}
							}
						}
			
			
						// just as a very dumb sanity check:
						// we cross the distributions for the different prompts for the english data
						for (String file : files){
							System.out.println("\n\n"+file);
							for (int id1 : ids){
								System.out.print("\t"+id1);
							}
							for (int id1 : ids){
								System.out.println();
								System.out.print(id1+"\t");
								for (int id2 : ids){
									String filePath1 = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/texts_for_language_models/id"+id1+"_"+file+"_texts.txt";
									String filePath2 = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/texts_for_language_models/id"+id2+"_"+file+"_texts.txt";
									computeDivergence(filePath1, filePath2);
								}
							}
						}
			// next: per label		
			for (int id : ids){
				int max = 3;
				if (id==10) {
					max =2;
				}
				System.out.println();
				System.out.println("id: "+id);
				for (String file : files){
					for (int label = 0; label <=max ; label++){
						System.out.print("\t"+file+"_"+label);
					}
				}
				for (String file1 : files){
					for (int label1 = 0; label1 <=max ; label1++){

						System.out.print("\n"+format(file1+"_"+label1)+"\t");
						for (String file2 : files){
							for (int label2 = 0; label2 <=max ; label2++){
								//System.out.println("\n"+file1+" - "+file2);
								String filePath1 = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/texts_for_language_models/id"+id+"_"+file1+"_texts.txt";
								String filePath2 = System.getenv("DKPRO_HOME")+"/datasets/asap/crosslingual/asap_en/texts_for_language_models/id"+id+"_"+file2+"_texts.txt";
								computeDivergence(filePath1, filePath2);
							}
						}
					}
				}
			}
		}
	}


	private static String format(String file1) {
		if (file1.length()<8){
			file1+="\t";
		}
		return file1;
	}


	static Collection<Token> backgroundTokens = null;
	static Collection<Sentence> backgroundSentences = null;
	static Collection<Token> forgroundTokens = null;
	static Collection<Sentence> forgroundSentences = null;

	private static void computeDivergence(String filePath1, String filePath2) throws UIMAException, IOException {
		getTaskTokensAndSentences(filePath1, "en", false);
		getTaskTokensAndSentences(filePath2, "en", true);
		//		System.out.println("Token divergence: "+getTokenDivergence(forgroundTokens, backgroundTokens));
		//		System.out.println("2-gram divergence: "+getNgrammDivergence(forgroundSentences, backgroundSentences, 2));
		System.out.print(//"3-gram divergence: "+
				Math.round(getNgrammDivergence(forgroundSentences, backgroundSentences, 3)*100.0)/100.0 + "\t");
	}




	private static void getTaskTokensAndSentences(String filePath, String lang, boolean isBackground) 
			throws UIMAException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String text = "";
		while (br.ready()){
			text +=" "+br.readLine();
		}
		text = text.trim();
		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText(text);
		jcas.setDocumentLanguage(lang);
		AggregateBuilder builder = new AggregateBuilder();
		builder.add(createEngineDescription(
				createEngineDescription(BreakIteratorSegmenter.class),
				createEngineDescription(OpenNlpPosTagger.class,
						OpenNlpPosTagger.PARAM_LANGUAGE, lang)
				));
		AnalysisEngine engine = builder.createAggregate();
		engine.process(jcas);
		if (isBackground){
			backgroundTokens = JCasUtil.select(jcas, Token.class);
			backgroundSentences = JCasUtil.select(jcas, Sentence.class);
		} else{
			forgroundTokens = JCasUtil.select(jcas, Token.class);
			forgroundSentences = JCasUtil.select(jcas, Sentence.class);
		}
	}


	/*
	 * computes the average Kullback-Leibler-Divergence for n-grams of the
	 * length n
	 * 
	 */
	protected static double getNgrammDivergence(Collection<Sentence> sentences,
			Collection<Sentence> backgroundSentences, int n){
		FrequencyDistribution<String> fdFG = getNgramFD(sentences, n);
		FrequencyDistribution<String> fdBG = getNgramFD(backgroundSentences, n);
		double ngramDivergence = 0d;
		for(String ngram:fdFG.getKeys()){
			ngramDivergence += getDivergence(fdFG, fdBG, ngram, fdFG.getKeys().size(), fdBG.getKeys().size());
			//System.out.println(ngramDivergence);
		}
		return ngramDivergence;
	}


	/*
	 * inc all n-grams in a Collection of sentences to a frequency distribution
	 */
	private static FrequencyDistribution<String> getNgramFD(Collection<Sentence> sentences, int n) {
		FrequencyDistribution<String> fd = new FrequencyDistribution<String>();
		ArrayList<String> ngrams = new ArrayList<String>();
		for(Sentence s : sentences){
			ngrams.addAll(getNewNgramInSentence(s,n));
		}
		fd.incAll(ngrams);
		return fd;
	}
	/*
	 * get n-grams in a sentence
	 */
	private static ArrayList<String> getNewNgramInSentence(Sentence sentence, int n){
		ArrayList<String> ngrams = new ArrayList<String>();
		Collection<Token> tokens = JCasUtil.selectCovered(Token.class, sentence);
		ArrayList<String> tokenListInSentence = new ArrayList<String>();
		for (Token t : tokens) {
			if(!t.getPos().getPosValue().startsWith("$")) {
				tokenListInSentence.add(t.getCoveredText());
			}
		}
		for (int i = 0; i < tokenListInSentence.size() - n; i++) {
			String[] ngram = new String[n];
			for (int j = 0; j < n; j++) {
				ngram[j] = tokenListInSentence.get(i + j);
			}
			ngrams.add(StringUtils.join(ngram, " "));
		}
		return ngrams;
	}



	/*
	 * computes the average Kullback-Leibler-Divergence for tokens Ignores
	 * punctuation
	 * 
	 */
	protected static double getTokenDivergence(Collection<Token> tokens,
			Collection<Token> backGroundTokens) {
		// get the fds
		FrequencyDistribution<String> fdFG = new FrequencyDistribution<String>(
				toText(tokens));
		FrequencyDistribution<String> fdBG = new FrequencyDistribution<String>(
				toText(backGroundTokens));

		double tokenDivergence = 0;
		int n = 0;
		for (Token token : tokens) {
			// ignore punctuation
			if (token.getPos() == null){
				System.err.println("No POS for token "+token.getCoveredText());
			} else {
				if(!token.getPos().getPosValue().startsWith("$")){
					n++;
					tokenDivergence += getDivergence(fdFG, fdBG,
							token.getCoveredText(), tokens.size(),
							backGroundTokens.size());
				}
			}
		}
		return tokenDivergence = tokenDivergence / n;
	}


	// TODO is KL computed right? correct Smoothing?
	/*
	 * Calculates the Kullback-Leibler-Divergence between two frequency
	 * distributions on a given annotation
	 * 
	 * @param fdFG
	 *            frequency distribution of foreground corpus
	 * @param fdBG
	 *            frequency distribution of backgroundground corpus
	 */
	private static double getDivergence(FrequencyDistribution<String> fdFG,
			FrequencyDistribution<String> fdBG, String currentAnno,
			int lengthOfFG, int lengthOfBG) {
		double frequency1 = (double) fdFG.getCount(currentAnno) / lengthOfFG;
		double frequency2 = 0;
		if (fdBG.contains(currentAnno)) {
			frequency2 = (double) fdBG.getCount(currentAnno) / lengthOfBG;
			return frequency1
					* (Math.log(frequency1 / frequency2) / Math.log(2));
		} else {
			return 0;
		}
	}







}
