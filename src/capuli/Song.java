package capuli;

public class Song extends MediaItem {

	//Constructors
	public Song() {
	}

	public Song(String title, int productionYear, String imagePath){
		super(title, productionYear, imagePath);
	}

	//Instead of actually playing the song, prints the
	//following text below to the status label
	@Override
	public String playMedia(){
		return "Now playing song: ";
	}
}
