package backend.core.frame.jpa;

import java.lang.reflect.InvocationTargetException;

import backend.core.frame.non.LoggerClass;
import backend.core.frame.util.ReflectUtil;

public abstract class Rule<B extends Bean, D extends Dao<B>> extends LoggerClass {

	private D dao;

	@SuppressWarnings("unchecked")
	public D getDao() {
		
		if (dao == null) {
			try {
				dao = (D) ReflectUtil.myParamClass(1, this).getDeclaredConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		
		return dao;
	}
}
