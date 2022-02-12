package com.training.centre.training.centre.Repo;
import com.training.centre.training.centre.Entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCenterRepo extends JpaRepository<Training, Long> {
    public Training findByCentreName(String trainingName);
    public Training findByTrainingCentreId(Long trainingCenterId);
}