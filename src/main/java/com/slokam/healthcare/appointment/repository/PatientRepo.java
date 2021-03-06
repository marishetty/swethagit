package com.slokam.healthcare.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.healthcare.appointment.entity.Patient;
@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
	public List<Patient> findByName(String name);
	public List<Patient> findByName(Integer id);
	public List<Patient> findByNameLike(String name);
	@Query("from Patient p where p.name like?1")
	public List<Patient> getPatientsByNameLike(String name);


}
