package com.oran;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RandomNumberRepository extends CrudRepository<RandomNumber, Long> {

    List<RandomNumber> findByName(String name);
}
