package com.kpk.stamps.repository;

import com.kpk.stamps.dto.ConcernResponseDTO;
import com.kpk.stamps.entity.Concern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConcernRepository extends JpaRepository<Concern,Long> {

    Optional<Concern> findTopByOrderByIdDesc();
}
