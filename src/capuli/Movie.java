package capuli;

public class Movie extends MediaItem {

	//Constructors
	public Movie() {
	}

	public Movie(String title, int productionYear, String imagePath){
		super(title, productionYear, imagePath);
	}

	//Instead of actually playing the movie, prints the
	//following text below to the status label
	@Override
	public String playMedia(){
		return "Now presenting movie: ";
	}
}
