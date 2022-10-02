package com.example.zombiesApi.services;

import com.example.zombiesApi.repos.PropertyRepo;
import com.example.zombiesApi.utils.Location;
import com.example.zombiesApi.models.Survivor;
import com.example.zombiesApi.repos.SurvivorRepo;
import com.example.zombiesApi.utils.Report;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class SurvivorServiceImp implements SurvivorService {
    @Autowired
    SurvivorRepo survivorRepo;

    @Autowired
    PropertyRepo propertyRepo;
    @Override
    public ResponseEntity<Survivor> addSurvivor(Survivor survivor) {
        survivor.getResources().iterator().forEachRemaining(e->  propertyRepo.save(e));
        Survivor s =  survivorRepo.save(survivor);
        return  ResponseEntity.ok().body(s);

    }

    @Override
    public ResponseEntity<?> updateLocation(Long SID , Location location) {
        Optional<Survivor> survivor = survivorRepo.findById(SID);
        if (survivor.isPresent()){
            Survivor foulen = survivor.get();
            foulen.setLongitude(location.getLongitude());
            foulen.setLatitude(location.getLatitude());
            return ResponseEntity.ok().body(survivorRepo.save(foulen));
        }else {
            return ResponseEntity.badRequest().body("no survivor with this id please verify");
        }


    }

    @Override
    public ResponseEntity<List<Survivor>> getAll() {
        return ResponseEntity.ok().body(survivorRepo.findAll());
    }

    @Override
    public ResponseEntity<?> getReport() {
          int infectedNumber =0;
        double infectedPercentage =0;
        List<Survivor> survivorList = survivorRepo.findAll();
        for (int i =0 ; i<survivorList.size() ; i++){
                if (survivorList.get(i).getInfected()){
                    infectedNumber ++;
                }
        }
        log.info("infected number is {} list size is {} " ,infectedNumber , survivorList.size());
        Report report = new Report(infectedNumber , survivorList.size());


        return   ResponseEntity.ok().body( report.getReport() );

            }
}
