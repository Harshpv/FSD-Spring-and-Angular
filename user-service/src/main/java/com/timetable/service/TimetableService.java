package com.timetable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timetable.exceptions.TimeTableAlreadyExistsExceptions;
import com.timetable.exceptions.TimeTableNotFoundExceptions;
import com.timetable.model.Timetable;
import com.timetable.repositary.TimetableRepositary;



@Service
public class TimetableService {
	
	
@Autowired
private final TimetableRepositary timetableRepositary;



private Timetable timetable;
public  TimetableService( TimetableRepositary timetableRepositary) {

	this.timetableRepositary = timetableRepositary;
}
// To get add new items  to weekdays
public void addtimetable(Timetable timetable) throws TimeTableAlreadyExistsExceptions  {

	
	if  (timetableRepositary.existsById(timetable.getTimeTableId())) {
		throw new TimeTableAlreadyExistsExceptions();
	}
	timetableRepositary.save(timetable);
//	throw new TimeTableAlreadyExistsExceptions();


}
// to find all the weekdays 
public List<Timetable> findAllCarts() throws TimeTableNotFoundExceptions {

	
//	MongoRepository<Timetable, String> timetableRepository;
	return timetableRepositary.findAll();

}



 
 
 // To update or save the items using email Id
 public Timetable saveOrUpdate(Timetable timetable) throws TimeTableNotFoundExceptions {

	 Timetable savedMenuModel = timetableRepositary.findById(timetable.getTimeTableId()).get();
		if (timetableRepositary.existsById(timetable.getTimeTableId())) {

			
			savedMenuModel.setTimeTableId(timetable.getTimeTableId());
			savedMenuModel.setUserEmailId(timetable.getUserEmailId());
			

			return timetableRepositary.save(timetable);

		}

		throw new TimeTableNotFoundExceptions();
	}

//To find item by using timetable id
 public Timetable findTimetableBytimetableId(String timeTableId) throws TimeTableNotFoundExceptions {

		if (
				timetableRepositary.existsById(timeTableId)) {

			return timetableRepositary.findById(timeTableId).get();
		}

		throw new TimeTableNotFoundExceptions();

	}
 public void deleteById(String timeTableId) throws TimeTableNotFoundExceptions {
		if (timetableRepositary.existsById(timeTableId)) {

			timetableRepositary.deleteById(timeTableId);
		}

		throw new TimeTableNotFoundExceptions();
	}

 

}
