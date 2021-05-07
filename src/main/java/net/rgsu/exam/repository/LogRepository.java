package net.rgsu.exam.repository;

import net.rgsu.exam.models.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {
    default void test(){
        System.out.println("Test in LogRepository!");
    }
}
