package model;

/**This is a model for storing text data and sharing it between controller and view
 * 
 * @author Ilya Falko
 *
 */
public class TextModel {

	private String text;

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
