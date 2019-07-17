package com.conifer.health.dao;

import java.util.ArrayList;

public interface PatientDao {
	ArrayList<com.conifer.health.entity.Patient> findAllPatients();
}
