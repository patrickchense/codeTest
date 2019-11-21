package cz.code.lamba.springboot.dao;

import cz.code.lamba.springboot.dao.entity.POITrafficData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * DAO class for poi_traffic 
 * 
 * @author abaghel
 *
 */
@Repository
public interface POITrafficDataRepository extends CassandraRepository<POITrafficData,UUID>{
	 
}
