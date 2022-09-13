package com.timetable.repositary;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.timetable.model.Timetable;

public interface TimetableRepositary extends MongoRepository<Timetable, String> {

}
