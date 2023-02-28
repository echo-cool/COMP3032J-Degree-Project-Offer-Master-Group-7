package com.group7.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "applicantbackgrounds", path = "applicantbackgrounds")
public interface ApplicantBackgroundRepository extends JpaRepository<ApplicantBackground, Long>, PagingAndSortingRepository<ApplicantBackground, Long>, CrudRepository<ApplicantBackground, Long> {

}
