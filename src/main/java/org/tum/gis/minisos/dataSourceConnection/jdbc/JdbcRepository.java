/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.jdbc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kchaturvedi
 *
 */
@Repository
public interface JdbcRepository extends CrudRepository<JdbcObservation, String> {

	//List<JdbcObservation> findAll();
}
