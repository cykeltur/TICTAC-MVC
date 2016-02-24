package theEnum;
/**
 * @author Niklas Karlsson 0703032191
 * 
 */
public enum CharToImg {

	X("/X.gif"), O("/O.gif"), Default("/Defult.gif"), // the path to ' '-img
	D("/Defult.gif");

	// to use a test picture (not done!)
	// static ImageIcon buttonImg = new
	// ImageIcon(ButtonImage.class.getResource("/X.gif"));

	// and to use the ENUM :
	// CharToImg.valueOf("X")

	private String img;

	private CharToImg(String markerInStringFormat) {
		// img = Character.toString(charMarker);

		this.img = markerInStringFormat;

	}

	public String getImgPath() {
		return img;
	}

}
