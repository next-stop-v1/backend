package project.NextStop.domain.schedule.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import project.NextStop.domain.schedule.entity.Schedule;

import static project.NextStop.domain.schedule.entity.QSchedule.*;
import static project.NextStop.domain.station.entity.QStation.*;
import static project.NextStop.domain.station.entity.QStationLine.*;
import static project.NextStop.domain.subway.entity.QSubway.*;

public class ScheduleRepositoryImpl implements ScheduleRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    public ScheduleRepositoryImpl( JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public Schedule getStationDetail(Long subwayId){
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
