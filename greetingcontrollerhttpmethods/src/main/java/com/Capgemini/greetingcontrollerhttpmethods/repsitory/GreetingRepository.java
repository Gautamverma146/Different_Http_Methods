package com.Capgemini.greetingcontrollerhttpmethods.repsitory;

import com.Capgemini.greetingcontrollerhttpmethods.entity.GreetingEntity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<GreetingEntity,Long> {
}
