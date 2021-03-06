package com.proyecto.services.impl;

import java.util.ArrayList;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.CarDao;
import com.proyecto.dao.CarImageDao;
import com.proyecto.dao.ClassificationDao;
import com.proyecto.dao.DriveLineDao;
import com.proyecto.dao.EngineDao;
import com.proyecto.dao.FuelDao;
import com.proyecto.dao.MakeDao;
import com.proyecto.dao.TransmissionDao;
import com.proyecto.model.Car;
import com.proyecto.model.Engine;
import com.proyecto.model.Classification;
import com.proyecto.model.DriveLine;
import com.proyecto.model.Fuel;
import com.proyecto.model.Transmission;
import com.proyecto.services.UtilsService;

@Service("utilService")
public class UtilServiceImpl implements UtilsService {

	@Autowired
	private TransmissionDao transmissionDao;
	
	@Autowired
	private MakeDao makeDao;
	
	@Autowired
	private CarImageDao carImageDao;

	@Autowired
	private FuelDao fuelTypeDao;
	
	@Autowired
	private DriveLineDao driveLineDao;
	
	@Autowired
	private EngineDao engineDao;
	
	@Autowired
	private ClassificationDao classificationDao;
	
	@Autowired
	private CarDao carDao;
	
	/* Llamadas al Dao */
	public List<String> getCarsImages() {

		return carImageDao.getCarImages();
	}
	
	public List<String> getCarsMakes() {

		return carDao.getCarsMakes();
	}
	
	public List<String> getCarsNames() {

		return carDao.getCarsNames();
	}
	
	public List<Car> getCarsMakesFilter(int m) {

		return carDao.getCarsMakesFilter(m);
	}

	public List<Integer> getCarsYears() {

		return carDao.getCarsYears();
	}
	
	public List<Boolean> getCarsHybrids() {

		return carDao.getCarsHybrids();
	}
	
	public List<Integer> getCarsId() {

		return carDao.getCarsId();
	}
	
	public List<Integer> getCarsPk() {

		return carDao.getCarsPk();
	}
	
	public List<Classification> getCarsClassificationsTabla() {

		return classificationDao.findClassifications();
	}
	
	public List<Fuel> getCarsFuelTypes() {

		return fuelTypeDao.findFuel();
	}
	
	public List<DriveLine> getCarsDriveLines() {

		return driveLineDao.findDriveLines();
	}
	
	public List<Transmission> getCarsTransmissions() {

		return transmissionDao.findTransmissions();
	}

	public Car saveMake(Car m) {

		return makeDao.save(m);
	}

	public Fuel saveFuelType(Fuel f) {

		return fuelTypeDao.save(f);
	}

	public DriveLine saveDriveLine(DriveLine d) {

		return driveLineDao.save(d);
	}
	
	public Transmission saveTransmission(Transmission t) {

		return transmissionDao.save(t);
	}
	
	public Classification saveClassification(Classification c) {

		return classificationDao.save(c);
	}
	
	public Car getMakeByName(String m) throws Exception{
		Car make = makeDao.findMakeByName(m);
		if(make == null) {
			throw new Exception("Marca con nombre "+ m +" no encontrada");
		}
		return make;
	}
	
	public Classification getClassificationByName(String m) throws Exception{
		Classification c = classificationDao.findClassificationByName(m);
		if(c == null) {
			throw new Exception("Classification con nombre "+ m +" no encontrada");
		}
		return c;
	}
	
	public Classification getClassificationById(int m) throws Exception{
		Classification c = classificationDao.findClassificationById(m);
		if(c == null) {
			throw new Exception("Classification con nombre "+ m +" no encontrada");
		}
		return c;
	}
	
	public DriveLine getDriveLineByName(String m) throws Exception{
		DriveLine d = driveLineDao.findDriveLineByName(m);
		if(d == null) {
			throw new Exception("DriveLine con nombre "+ m +" no encontrada");
		}
		return d;
	}
	
	public DriveLine getDriveLineById(int m) throws Exception{
		DriveLine d = driveLineDao.findDriveLineById(m);
		if(d == null) {
			throw new Exception("DriveLine con nombre "+ m +" no encontrada");
		}
		return d;
	}

	@Override
	public Fuel getFuelTypeByName(String m) throws Exception {
		Fuel f = fuelTypeDao.findFuelByName(m);
		if(f == null) {
			throw new Exception("FuelType con nombre "+ m +" no encontrada");
		}
		return f;
	}
	
	@Override
	public Fuel getFuelTypeById(int m) throws Exception {
		Fuel f = fuelTypeDao.findFuelById(m);
		if(f == null) {
			throw new Exception("FuelType con nombre "+ m +" no encontrada");
		}
		return f;
	}

	@Override
	public Transmission getTransmissionByName(String m) throws Exception {
		Transmission t = transmissionDao.findTransmissionByName(m);
		if(t == null) {
			throw new Exception("Transmission con nombre "+ m +" no encontrada");
		}
		return t;
	}
	
	@Override
	public Transmission getTransmissionById(int m) throws Exception {
		Transmission t = transmissionDao.findTransmissionById(m);
		if(t == null) {
			throw new Exception("Transmission con nombre "+ m +" no encontrada");
		}
		return t;
	}
	
	
	
}