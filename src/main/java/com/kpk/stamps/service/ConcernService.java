package com.kpk.stamps.service;

import com.kpk.stamps.dto.ConcernResponseDTO;
import com.kpk.stamps.dto.CreateConcernRequestDTO;
import com.kpk.stamps.dto.UpdateConcernRequestDTO;
import com.kpk.stamps.entity.Concern;
import com.kpk.stamps.enums.ConcernStatus;
import com.kpk.stamps.repository.ConcernRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcernService {
   @Autowired
    public ConcernRepository concernRepository;

    public Concern saveConcern(CreateConcernRequestDTO createConcernRequestDTO) {
        Concern concern = new Concern();

        concern.setAssignedTo(createConcernRequestDTO.getAssignedTo());
        concern.setDescription(createConcernRequestDTO.getDescription());
        concern.setPriority(createConcernRequestDTO.getPriority());
        concern.setInitiatorName(createConcernRequestDTO.getInitiatorName());
        concern.setProgramName(createConcernRequestDTO.getProgramName());
        concern.setRaisedDate(createConcernRequestDTO.getRaisedDate());
        concern.setTargetDate(createConcernRequestDTO.getTargetDate());
        concern.setTitle(createConcernRequestDTO.getTitle());
        concern.setConcernNumber(generateConcernNumber());
        concern.setStatus(ConcernStatus.OPEN);

         return concernRepository.save(concern);
    }

    private String generateConcernNumber() {

                            Optional<Concern> lastConcern =
                concernRepository.findTopByOrderByIdDesc();

        if (lastConcern.isEmpty()) {
            return "CR-001";
        }

        String lastNumber = lastConcern.get().getConcernNumber();
        int number = Integer.parseInt(lastNumber.split("-")[1]);

        return String.format("CR-%03d", number + 1);
    }

    public List<Concern> getAllConcerns(){
        return concernRepository.findAll();
    }

    public Optional<Concern> getConcernById(Long id){
        Optional<Concern> concern=concernRepository.findById(id);

    return concern;
    }

    public Optional<Concern> updateConcern(Long id, UpdateConcernRequestDTO updateConcernRequestDTO){
         Optional<Concern> concern=concernRepository.findById(id);

         if(concern.isPresent()){
             Concern concern1=concern.get();
             concern1.setTitle(updateConcernRequestDTO.getTitle());
             concern1.setStatus(updateConcernRequestDTO.getStatus());
             concern1.setDescription(updateConcernRequestDTO.getDescription());
             concern1.setAssignedTo(updateConcernRequestDTO.getAssignedTo());
             concern1.setTargetDate(updateConcernRequestDTO.getTargetDate());
             concern1.setPriority(updateConcernRequestDTO.getPriority());

             concernRepository.save(concern1);

             return Optional.of(concern1);
         }
         return Optional.empty();
    }

    public void deleteById(Long id){
        Concern concern=concernRepository.findById(id).orElseThrow(()->new RuntimeException("Concern Not Found"));

        concernRepository.delete(concern);
    }
}