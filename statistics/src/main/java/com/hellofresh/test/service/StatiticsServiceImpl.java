package com.hellofresh.test.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellofresh.test.domain.StatiticsHolder;
import com.hellofresh.test.domain.StatiticsXAndY;
import com.hellofresh.test.domain.StatitcsCalcException;
import com.hellofresh.test.domain.StatitcsResult;
/**
 * 
 * @author Poornima Vadakeyil
 * Service implementation
 *
 */
@Service
public class StatiticsServiceImpl implements StatiticsServiceInterface {

	/** Singleton bean service relies on for calculation and storing */
	@Autowired
	private StatiticsHolder statiticsHolder;
	
	
	/**
	 * Stats loading implementation
	 */
	@Override
	public void loadStaticsData(String[] eventDetails) throws StatitcsCalcException {
		try {
			Calendar statsRecordedTime = Calendar.getInstance();
			statsRecordedTime.setTimeInMillis(Long.parseLong(eventDetails[0].trim()));
			statiticsHolder.getStatitcsMap().put(statsRecordedTime,
					new StatiticsXAndY(Float.parseFloat(eventDetails[1].trim()), 
							Long.parseLong(eventDetails[2].trim())));
		} catch (NumberFormatException exception) {
			throw new StatitcsCalcException(exception.getMessage());
		} 
	}
	
	/**
	 * Stats calculation implementation
	 */
	@Override
	public String calculateStaticsData(Calendar previousMinute) throws StatitcsCalcException {
		
		try {
			Set<Calendar> keySet = statiticsHolder.getStatitcsMap().keySet();
			List<Calendar> timeFrameTocheckList = keySet.stream()
					.filter(x -> (x.getTimeInMillis() >= previousMinute.getTimeInMillis()))
					.collect(Collectors.toList());
			System.out.println("\n Received a stats call.Calculation starts.Time Data considered for calculation");
			timeFrameTocheckList.stream().forEach(x -> System.out.println("\n "+ x.getTime()));
			List<StatiticsXAndY> staticsDataForTheTimeFrame = new ArrayList<StatiticsXAndY>();
			timeFrameTocheckList.stream()
					.forEach(mapKey -> staticsDataForTheTimeFrame.add(statiticsHolder.getStatitcsMap().get(mapKey)));
			if (staticsDataForTheTimeFrame.isEmpty()) {
				return "0,0.0,0.0,0,0";
			} else {
				StatitcsResult statitcsResult = new StatitcsResult();
				staticsAmend(staticsDataForTheTimeFrame, statitcsResult);
				statitcsResult.setAverageX(statitcsResult.getTotalX() / statitcsResult.getTotal());
				statitcsResult.setAverageY(statitcsResult.getTotalY() / statitcsResult.getTotal());
				return statitcsResult.getTotal() + "," + String.format("%.5f", statitcsResult.getTotalX()) + ","
						+ String.format("%.5f", statitcsResult.getAverageX()) + "," + statitcsResult.getTotalY() + ","
						+ statitcsResult.getAverageY();
			}
		} catch (Exception ex) {
			throw new StatitcsCalcException(ex.getMessage());
		}
	}
	
	/**
	 * Average and sum calculation method
	 * @param staticsDataForTheTimeFrame
	 * @param statitcsResult
	 */
	private void staticsAmend(List<StatiticsXAndY> staticsDataForTheTimeFrame, StatitcsResult statitcsResult) {
		 System.out.println("\n Statitics data considered for calculation");
		staticsDataForTheTimeFrame.stream().forEach(x -> System.out.println("\n"+x.toString()));
		staticsDataForTheTimeFrame.stream().forEach(statitcsIndvidualData -> {
			statitcsResult.setTotal(statitcsResult.getTotal()+1);
			statitcsResult.setTotalX(statitcsResult.getTotalX()+statitcsIndvidualData.getxValue()) ;
			statitcsResult.setTotalY(statitcsResult.getTotalY()+statitcsIndvidualData.getYValue());});
		
	}

}
