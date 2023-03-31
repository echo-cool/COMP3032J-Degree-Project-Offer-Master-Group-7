package com.group7.db.jpa;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ProfileRepository extends JpaRepository<Profile, Long>, PagingAndSortingRepository<Profile, Long>, CrudRepository<Profile, Long> {
    @Override
    @Cacheable(value = "profile")
    <S extends Profile> Optional<S> findOne(Example<S> example);

    @Override
    @Cacheable(value = "profile")
    List<Profile> findAll();

    @Override
    @Cacheable(value = "profile")
    Optional<Profile> findById(Long aLong);

    @Override
    @Cacheable(value = "profile")
    boolean existsById(Long aLong);
    @Cacheable(value = "profile")
    List<Profile> findByRanking(int ranking);
}
