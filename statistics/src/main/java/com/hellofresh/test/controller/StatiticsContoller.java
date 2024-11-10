package com.hellofresh.test.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hellofresh.test.domain.StatitcsCalcException;
import com.hellofresh.test.service.StatiticsServiceImpl;

/**
 * 
 * @author Poornima Vadakeyil
 * Rest controller class. service end points stats and event
 *
 */
@RestController
public class StatiticsContoller {

	@Autowired
	StatiticsServiceImpl statiticsServiceImpl;
	
	/** Validation constants */
	private static final String INSUFFICIENT_DATA ="Insufficent data";
	private static final String BLANK_OR_EMPTY_DATA ="Blank or empty data";
	private static final String SUCCESSFULL_PROCESS ="Data processed successfully";
	private static final String INVALID_INPUT_FORMAT ="Input format invalid";
	
	/**
	 * POST API event controller method
	 * @param eventData String input
	 * @return Response entity with HTTP status code and validation messages if any
	 */
	@PostMapping("/event")
	public ResponseEntity<String> processEventData(@RequestBody String eventData) {

		try {
			if (eventData != null && !eventData.isBlank() && !eventData.isEmpty()) {
				String[] eventDetail = eventData.split(",");
				if (eventDetail.length == 3) {
					statiticsServiceImpl.loadStaticsData(eventDetail);
				} else {
					return new ResponseEntity<>(INSUFFICIENT_DATA, HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<>(BLANK_OR_EMPTY_DATA, HttpStatus.BAD_REQUEST);
			}
		} catch (StatitcsCalcException statitcsCalcException) {
			return new ResponseEntity<>(INVALID_INPUT_FORMAT, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(SUCCESSFULL_PROCESS,HttpStatus.ACCEPTED);
	}
	
	/**
	 * POST API stats controller method
	 * @return Response entity with HTTP status code and Status calculated
	 */
	@GetMapping("/stats")
	public ResponseEntity<String> calculateAndReturnStatitics() {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -1);

		String stats;
		try {
			stats = statiticsServiceImpl.calculateStaticsData(calendar);
		} catch (StatitcsCalcException statitcsCalcException) {
			return new ResponseEntity<>(statitcsCalcException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(stats, HttpStatus.OK);

	}

}
