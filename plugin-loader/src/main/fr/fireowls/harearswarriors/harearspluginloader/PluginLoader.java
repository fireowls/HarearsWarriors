package fr.fireowls.harearswarriors.harearspluginloader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * PluginLoader create a valid instance of a class in an external jar
 * @param <C> Type of the main class jar
 */
class PluginLoader<C> {

    /**
     * Create a valid instance of an external jar
     * @param directory The directory of the jar
     * @param classpath The path to the main class
     * @param parentClass The parent class of the main jar
     * @return a new instance of the selected class in the jar
     * @throws ClassNotFoundException
     */
    public C LoadClass(String directory, String classpath, Class<C> parentClass) throws ClassNotFoundException {
        File pluginsDir = new File(directory);
        for (File jar : pluginsDir.listFiles()) {
            try {
                ClassLoader loader = URLClassLoader.newInstance(
                        new URL[] { jar.toURL() },
                        getClass().getClassLoader()
                );
                Class<?> clazz = Class.forName(classpath, true, loader);
                Class<? extends C> newClass = clazz.asSubclass(parentClass);
                // Apparently its bad to use Class.newInstance, so we use
                // newClass.getConstructor() instead
                Constructor<? extends C> constructor = newClass.getConstructor();
                return constructor.newInstance();

            } catch (ClassNotFoundException e) {
                // There might be multiple JARs in the directory,
                // so keep looking
                continue;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        throw new ClassNotFoundException("Class " + classpath
                + " wasn't found in directory " + System.getProperty("user.dir") + directory);
    }
}
