package by.gsu.epamlab.interfaces;

import java.util.Map;

public interface EntryChecker<K,V> {
	boolean check(Map.Entry<K, V> entry);
}
