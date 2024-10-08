package com.hellofresh.test.domain;
import java.util.concurrent.*;
import java.util.Calendar;
/**
 * 
 * @author Poornima Vadakeyil
 * Singleton class holding data posted by event
 * Each statics information is held against the unique Time information
 * passed along the event. Duplicates info will be overriden by Map implementation
 * keeping only the latest stats for a given time.
 */
public class StatiticsHolder {
	
	private ConcurrentHashMap<Calendar, StatiticsXAndY> statitcsMap =
			new ConcurrentHashMap<Calendar, StatiticsXAndY>();

	public ConcurrentHashMap<Calendar, StatiticsXAndY> getStatitcsMap() {
		return statitcsMap;
	}

	public void setStatitcsMap(ConcurrentHashMap<Calendar, StatiticsXAndY> statitcsMap) {
		this.statitcsMap = statitcsMap;
	}

	public StatiticsHolder() {
		super();
	}
	

}
