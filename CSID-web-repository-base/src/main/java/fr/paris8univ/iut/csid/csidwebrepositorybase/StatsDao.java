package fr.paris8univ.iut.csid.csidwebrepositorybase;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsDao extends JpaRepository<StatsEntity, String> {

    @Query(value = "select * from stats as s where s.repository_name = ?1 and s.entry_type = ?2 order by datetime desc ",nativeQuery=true)
    List<StatsEntity> findAllStatsByDate(String repositoryName, String entryType);
}
