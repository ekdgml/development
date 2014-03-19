package helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dom.Rank;

public class RankDataHandler implements Comparable<Rank> {

	private static final String DATA_FILE_NAME = "CSV.txt";
	static List<Rank> ranks = new ArrayList<>();

	public static void saveCSV(String name, int time, int count) {
		//
		FileWriter fw = null;
		try {
			fw = new FileWriter(DATA_FILE_NAME, true);
			fw.write(name);
			fw.write("," + time);
			fw.write("," + count);
			fw.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (Exception e) {
			}
		}
	}

	public static List<Rank> readCSV() {
		//
		FileReader reader = null;
		BufferedReader br = null;
		

		try {
			br = new BufferedReader(reader = new FileReader(DATA_FILE_NAME));

			String line = null;
			while ((line = br.readLine()) != null) {
				//
				// parsing... [0]name, [1]time, [2]count
				String[] split = line.split(",");
				String name = split[0];
				int time = Integer.parseInt(split[1]);
				int count = Integer.parseInt(split[2]);

				Rank rank = new Rank(name, time, count);
				ranks.add(rank);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
			}
		}

		// sort..

		// set rank
		int rankNo = 1;
		for (Rank rank : ranks) {
			rank.setRank(rankNo++);
		}
		return ranks;
	}
	
	public int sortRank (Rank o) {
		//
		//Collections.sort(ranks);
		for (Rank rank : ranks) {
			System.out.println(rank.getScore());
		} 
		return 0;
	}

	@Override
	public int compareTo(Rank o) {
		//
		return 0;
	}

}
