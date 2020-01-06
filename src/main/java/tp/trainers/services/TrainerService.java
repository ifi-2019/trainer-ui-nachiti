package tp.trainers.services;



import tp.trainers.bo.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> getAllTrainers();
    Trainer getTrainer(String name);
    void addTrainer(String trainerName);
    void updatePassword(String name, String newPassword);
}


