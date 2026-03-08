package com.kpk.stamps.controller;

import com.kpk.stamps.dto.ConcernResponseDTO;
import com.kpk.stamps.dto.CreateConcernRequestDTO;
import com.kpk.stamps.dto.UpdateConcernRequestDTO;
import com.kpk.stamps.entity.Concern;
import com.kpk.stamps.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ConcernController {

    @Autowired
    ConcernService concernService;

    @PostMapping("/v1/concerns")
    public ResponseEntity<Concern> postConcern(@RequestBody CreateConcernRequestDTO createConcernRequestDTO){
        Concern concern= concernService.saveConcern(createConcernRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(concern);
    }

    @GetMapping("/v1/concerns")
    public ResponseEntity<List<Concern>> getAllConcerns(){
        return ResponseEntity.ok(concernService.getAllConcerns());
    }

    @GetMapping("/v1/concerns/{id}")
    public ResponseEntity<Concern> getConcernById(@PathVariable Long id){
        Optional<Concern>
                concern= concernService.getConcernById(id);

        if(concern.isPresent()){
            return ResponseEntity.ok(concern.get());
        }
            return ResponseEntity.notFound().build();

    }

    @PutMapping("/v1/concerns/{id}")
    public ResponseEntity<Concern> updateConcern(@PathVariable Long id, @RequestBody UpdateConcernRequestDTO updateConcernRequestDTO){
        Optional<Concern> concern=concernService.updateConcern(id,updateConcernRequestDTO);

        if(concern.isPresent()){
            return ResponseEntity.ok(concern.get());
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/v1/concerns/{id}")
    public ResponseEntity<Void> deleteConcernById(@PathVariable Long id){
        concernService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
