package com.example.internproject.repository;

import com.example.internproject.domain.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Spring Data  repository for the Request entity.
 */
@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query(value = "select distinct request from Request request left join fetch request.requestAbilities",
        countQuery = "select count(distinct request) from Request request")
    Page<Request> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct request from Request request left join fetch request.requestAbilities")
    List<Request> findAllWithEagerRelationships();

    @Query("select request from Request request left join fetch request.requestAbilities where request.id =:id")
    Optional<Request> findOneWithEagerRelationships(@Param("id") Long id);

    @Query("select distinct request from Request request where request.organizationRequest.id =:id")
    List<Request> findAllByOrganizationId(@Param("id") Long id);

    @Query("select distinct request from Request request where request.position =:position")
    List<Request> findAllByPosition(@Param("position") String position);
}
