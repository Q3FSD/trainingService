package com.mentorondemand.trainingservice.services;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mentorondemand.trainingservice.entities.Trainings;

//This will be AUTO IMPLEMENTED by Spring into a Bean called trainingRepository
//CRUD refers Create, Read, Update, Delete

public interface TrainingRepository extends CrudRepository<Trainings, Long> {

	Iterable<Trainings> findByNameLike(String name);

	@Modifying
	@Query(value = "UPDATE trainings SET mentor_name = :mentorName WHERE id = :id", nativeQuery = true)
	@Transactional
	int mentorBook(String mentorName, Long id);

	@Modifying
	@Query(value = "UPDATE trainings SET user_name = :studentName WHERE id = :id", nativeQuery = true)
	@Transactional
	int studentBook(String studentName, Long id);
}
