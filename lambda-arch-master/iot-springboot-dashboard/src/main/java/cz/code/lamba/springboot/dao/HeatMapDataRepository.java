package cz.code.lamba.springboot.dao;

import cz.code.lamba.springboot.dao.entity.HeatMapData;
import cz.code.lamba.springboot.dao.entity.TotalTrafficData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

/**
 * DAO class for total_traffic
 *
 * @author apssouza22
 */
@Repository
public interface HeatMapDataRepository extends CassandraRepository<HeatMapData, UUID> {

    @Query("SELECT * FROM traffickeyspace.heat_map WHERE timestamp = ?0 ALLOW FILTERING")
    Iterable<TotalTrafficData> findHeatMapByDate(Date date);
}
