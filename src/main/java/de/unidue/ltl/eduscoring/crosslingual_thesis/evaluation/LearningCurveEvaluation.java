package de.unidue.ltl.eduscoring.crosslingual_thesis.evaluation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearningCurveEvaluation implements Evaluation{
	
private String dataset;
	
	private Double kappa_min = -1.0;
	private Double kappa_mean = -1.0;
	private Double kappa_max = -1.0;
	
	private String itemSetId = "";
	private String date = "";
	
	private String discriminatorFileName = "DISCRIMINATORS.txt";
	private String evaluationFileName = "learningCurveResults_270.txt";
	
	@SuppressWarnings("resource")
	public LearningCurveEvaluation(String dataset, File f) {
		this.dataset = dataset;
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(f.lastModified());
		this.date =  cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + " "
				+ cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.SECOND);
		
		File discriminatorFile = new File(f.getAbsolutePath() + "/" + discriminatorFileName);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(discriminatorFile));

			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("readerTrain")) {
					String pattern = ".*(QuestionId|EssaySetId)\\\\=(\\d+).*";
					Pattern r = Pattern.compile(pattern);
					Matcher m = r.matcher(line);
					if (m.find()) {
						itemSetId = m.group(2);
					}
				}
			}
			
			br = new BufferedReader(new FileReader(f.getAbsoluteFile() + "/" + evaluationFileName));

			while ((line = br.readLine()) != null) {
				if (line.contains("quadraticWeightedKappa_min")) {
					String[] parts = line.split("=");
					this.kappa_min = Double.parseDouble(parts[1].trim());
				} else if (line.contains("quadraticWeightedKappa_mean")) {
					String[] parts = line.split("=");
					this.kappa_mean = Double.parseDouble(parts[1].trim());
				} else if (line.contains("quadraticWeightedKappa_max")) {
					String[] parts = line.split("=");
					this.kappa_max = Double.parseDouble(parts[1].trim());
				}
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public String getResult() {
		return this.dataset + "\t" + this.itemSetId + "\t" + this.date + "\tKappa(min): "
				+ new DecimalFormat("##.####").format(this.kappa_min) + "\tKappa(mean): "
				+ new DecimalFormat("##.####").format(this.kappa_mean) + "\tKappa(max): "
				+ new DecimalFormat("##.####").format(this.kappa_max);
	}
	
	public int compareTo(Object o) {
		if(!(o instanceof Evaluation)) {
			throw new ClassCastException("Expected object of type Evaluation");
		}
		return this.getResult().compareTo(((Evaluation)o).getResult());
	}

}
