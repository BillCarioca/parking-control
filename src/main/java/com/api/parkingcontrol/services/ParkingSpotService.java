package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;
    public ParkingSpotService (ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return  parkingSpotRepository.save(parkingSpotModel);
    }
    public Page<ParkingSpotModel> findAll(Pageable pageable){
        return parkingSpotRepository.findAll(pageable);
    }
    public boolean existsByLicensePlateCar( String licencePlateCar){
        return parkingSpotRepository.existsByLicensePlateCar(licencePlateCar);
    }
    public boolean existsByParkingSpotNumber(String parkingSpotNumber){
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }
    public boolean existsByApartmentAndBlock(String apartment, String block){
        return parkingSpotRepository.existsByApartmentAndBlock(apartment,block);
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }
}
