package ro.emanuel.cantece.pojo;

public class Cantec {
	private int id;
	private String title;
	private String author;
	private String scoreLink;
	private String lyrics;
	private int numberOfVotes;

	public Cantec() {
	}

	public Cantec(int id, String title, String author, String scoreLink, String lyrics, int numberOfVotes) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.scoreLink = scoreLink;
		this.lyrics = lyrics;
		this.numberOfVotes = numberOfVotes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getScoreLink() {
		return scoreLink;
	}

	public void setScoreLink(String scoreLink) {
		this.scoreLink = scoreLink;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public int getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(int numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

}
