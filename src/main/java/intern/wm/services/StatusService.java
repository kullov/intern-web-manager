package intern.wm.services;

import intern.wm.services.dto.StatusDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link intern.wm.domain.Status}.
 */
public interface StatusService {

    /**
     * Save a status.
     *
     * @param statusDTO the entity to save.
     * @return the persisted entity.
     */
    StatusDTO save(StatusDTO statusDTO);

    /**
     * Get all the statuses.
     *
     * @return the list of entities.
     */
    List<StatusDTO> findAll();

    /**
     * Get the "id" status.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StatusDTO> findOne(Long id);

    /**
     * Delete the "id" status.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
