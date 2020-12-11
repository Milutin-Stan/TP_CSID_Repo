package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StatsRepository {

    private final StatsDao statsDao;

    @Autowired
    public StatsRepository(StatsDao statsDao) {
        this.statsDao = statsDao;
    }

    public List<Stats> getStats(String repositoryName, String entryType){
        List<StatsEntity> statsEntities = statsDao.findAllStatsByDate(repositoryName, entryType);
        List<Stats> stats = statsEntities.stream()
                .map(x -> new Stats(x.getId(),x.getEntry_type(),x.getDatetime(),x.getValue(),x.getRepository_name()))
                .collect(Collectors.toList());
        return stats;
    }
}
