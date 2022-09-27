package ru.korsa.pp_3_1_1_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.korsa.pp_3_1_1_springboot.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
