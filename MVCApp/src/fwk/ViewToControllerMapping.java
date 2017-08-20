package fwk;

import java.util.HashMap;
import java.util.Map;

/**This class stores a map of views and it's controllers
 * 
 * @author Ilya Falko
 *
 */
public class ViewToControllerMapping {
	
	private Map<String, String> map = new HashMap<String, String>();

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	public String getByKey(String key) {
		return map.get(key);
	}
}
