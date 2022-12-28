package com.sid.factureservice.repository;



import com.sid.factureservice.model.FactureLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FactureLigneRepository extends JpaRepository<FactureLigne,Long> {
}
