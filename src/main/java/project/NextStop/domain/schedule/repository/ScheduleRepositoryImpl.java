package project.NextStop.domain.schedule.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import project.NextStop.domain.schedule.entity.QSchedule;
import project.NextStop.domain.schedule.entity.Schedule;
import project.NextStop.domain.station.entity.QStation;
import project.NextStop.domain.station.entity.QStationLine;
import project.NextStop.domain.station.entity.Station;
import project.NextStop.domain.subway.entity.QSubway;

import java.util.List;

import static project.NextStop.domain.schedule.entity.QSchedule.*;
import static project.NextStop.domain.station.entity.QStation.*;
import static project.NextStop.domain.station.entity.QStationLine.*;
import static project.NextStop.domain.subway.entity.QSubway.*;

public class ScheduleRepositoryImpl implements ScheduleRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    public ScheduleRepositoryImpl( JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public Schedule findStationDetail(Long subwayId){
        return queryFactory
                .selectFrom(schedule)
                .join(schedule.subway, subway).fetchJoin()
                .join(schedule.stationLine, stationLine).fetchJoin()
                .join(stationLine.next).fetchJoin()
                .join(stationLine.next.station, station).fetchJoin()
                .where(schedule.subway.id.eq(subwayId))
                .fetchOne();
    }
}
