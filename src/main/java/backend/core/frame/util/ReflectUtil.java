package backend.core.frame.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.util.Map;

import backend.core.frame.jpa.Bean;
import backend.core.frame.jpa.Dao;

public class ReflectUtil {

	private static Map<Class<? extends Bean>, Class<? extends Dao<?>>> modelKnowledge = new LinkedHashMap<>();

	@SuppressWarnings("unchecked")
	public static <T> Class<T> myParamClass(int index, Object caller) {

		return (Class<T>) ((ParameterizedType) caller.getClass().getGenericSuperclass())
				.getActualTypeArguments()[index];
	}

	@SuppressWarnings("unchecked")
	private static <B extends Bean> Class<Dao<B>> getDaoClass(Class<B> beanClass) throws ClassNotFoundException {

		if (modelKnowledge.get(beanClass) == null) {
			modelKnowledge.put(beanClass,
					(Class<? extends Dao<?>>) Class.forName(beanClass.getName().replace("Bean", "Dao")));
		}

		return (Class<Dao<B>>) modelKnowledge.get(beanClass);
	}

	public static <B extends Bean> Dao<B> getDao(Class<B> beanClass) {

		Dao<B> dao = null;
		try {
			Class<Dao<B>> daoClass = getDaoClass(beanClass);
			dao = daoClass.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.err.println("Dao não encontrado no modelKnowledge");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return dao;
	}
}
