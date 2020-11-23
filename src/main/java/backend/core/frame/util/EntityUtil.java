package backend.core.frame.util;

import java.util.Collection;
import java.util.Iterator;

import backend.core.frame.jpa.Bean;

public class EntityUtil {

	public static String[] splitSearch(String term){
		return term.split(" ");
	}
	
	public static Long[] ids(Collection<? extends Bean> beans) {

		Long[] ids = new Long[beans.size()];
		Iterator<? extends Bean> it = beans.iterator();
		int i = 0;
		while (it.hasNext()) {
			ids[i] = it.next().getId();
			i++;
		}
		return ids;
	}
}
