package capuli;

public abstract class MediaItem {

	private String _title; //The movie or song title.
	private int _productionYear; //The year the media item was produced.
	private String _imagePath; //stores the image path name or URL

	//Constructors
	public MediaItem(){
	}

	public MediaItem(String title, int productionYear, String imagePath){
		_title = title;
		_productionYear = productionYear;
		_imagePath = imagePath;
	}

	//Getters and Setters
	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public int getProductionYear() {
		return _productionYear;
	}

	public void setProductionYear(int productionYear) {
		_productionYear = productionYear;
	}

	public String getImagePath() {
		return _imagePath;
	}

	public void setImagePath(String imagePath) {
		_imagePath = imagePath;
	}

	//Abstract method
	public abstract String playMedia();

}
