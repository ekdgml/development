package dom;


public class Rank  {

	private int rank;
	private String name;
	private int time;
	private int count;

	public Rank(String name, int time, int count) {
		//
		this.name = name;
		this.time = time;
		this.count = count;

	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getScore() {
		return time + count;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("�̸� : " + name + " �ð�: " + time + " Ƚ�� : " + count
				+ " ���� : " + getScore() + "\n");
		return builder.toString();

	}

	
}
