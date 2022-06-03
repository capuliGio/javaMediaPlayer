package capuli;

import java.util.ArrayList;

public class MediaList{
	private ArrayList<MediaItem> mediaList = new ArrayList<MediaItem>();

	public MediaList() {
		//Creation of the media list
		Movie m1 = new Movie("My Hero Academia: Heroes Rising", 2019, "/capuli/images/Movie1.jpg");
		Movie m2 = new Movie("My Hero Academia: Two Heroes", 2020, "/capuli/images/Movie2.jpg");
		Movie m3 = new Movie("Avengers: Endgame", 2019, "/capuli/images/Movie3.jpg");

		Song s1 = new Song("Lewis Capaldi - Before you go", 2020, "/capuli/images/Song1.png");
		Song s2 = new Song("Tones and I - Dance Monkey", 2020, "/capuli/images/Song2.png");
		Song s3 = new Song("Maroon 5 - Memories", 2019, "/capuli/images/Song3.png");

		mediaList.add(m1);
		mediaList.add(m2);
		mediaList.add(m3);

		mediaList.add(s1);
		mediaList.add(s2);
		mediaList.add(s3);
	}

	//This method should accept an integer parameter ‘index’
	//and return a MediaItem object.
	public MediaItem lookup(int index){
		int count = index;
		return mediaList.get(count);
	}
}
