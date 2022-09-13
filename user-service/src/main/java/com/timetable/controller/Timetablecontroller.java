package com.timetable.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timetable.exceptions.TimeTableAlreadyExistsExceptions;
import com.timetable.exceptions.TimeTableNotFoundExceptions;
import lombok.extern.slf4j.Slf4j;
import com.timetable.model.Timetable;
import com.timetable.service.TimetableService;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class Timetablecontroller {
	private final TimetableService timetableservice ;
	private Timetable timetable;

	public Timetablecontroller(TimetableService timetableservice) {

		this.timetableservice = timetableservice;
	}
//To get add new items  to weekdays by post mapping
	@PostMapping(value = "/create")
		public ResponseEntity<Object> addtimetable(@RequestBody Timetable timetable) {
		try {
			timetableservice.addtimetable(timetable);
				

	 
			return new ResponseEntity<>("Time Table Added Sucessfully",HttpStatus.CREATED);
		} catch (TimeTableAlreadyExistsExceptions e) {

			return new ResponseEntity<>("Time Table  already exists!!",HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Time Table  details already exists!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}
	
	
	//To update or save the Time Table  using user email Id
	@PutMapping("/{userEmailId}")
	public ResponseEntity<Object> saveOrUpdate(@RequestBody Timetable timetable) {
		try {

			timetableservice.saveOrUpdate(timetable);
			return new ResponseEntity<>("Update success!!", HttpStatus.OK);

		} catch (TimeTableNotFoundExceptions e) {

			return new ResponseEntity<>("Time Table  not found!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong we will be back soon !!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

	}
	// To find cart by using timetableId
	@GetMapping("/gettimeTable{timeTableId}")
	public ResponseEntity<Timetable> findTimetableBytimetableId(@PathVariable String timeTableId) {

		try {

			return new ResponseEntity(timetableservice.findTimetableBytimetableId(timeTableId), HttpStatus.OK);

		} catch (TimeTableNotFoundExceptions e) {

			return new ResponseEntity("Time Table  not found!!",HttpStatus.CONFLICT);
		} catch (Exception e) {

			return new ResponseEntity("Time Table  not found!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	//to find all the items 
	@GetMapping("/getTimetable")
	public ResponseEntity<List<Timetable>> findAllCarts() {
		try {
			return ResponseEntity.ok(timetableservice.findAllCarts());
		} catch (TimeTableNotFoundExceptions e) {
			return new ResponseEntity("Empty repository!!", HttpStatus.CONFLICT);
		}
	}
	@DeleteMapping("/deleteTimetable/{timeTableId}")
	public ResponseEntity<?> deleteItem(@PathVariable String timeTableId) {
		try {

			timetableservice.deleteById(timeTableId);
			return new ResponseEntity<>("Deleted successfully!!", HttpStatus.OK);

		} catch (TimeTableNotFoundExceptions e) { 

			

			return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>("Something went wrong!!", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	private void ResponseEntity(String string, HttpStatus conflict) {
		// TODO Auto-generated method stub

	}


	}

