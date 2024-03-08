package project.NextStop.domain.schedule.repository;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.NextStop.domain.exit.entity.Exit;
import project.NextStop.domain.exit.repository.ExitRepository;
import project.NextStop.domain.schedule.entity.Schedule;
import project.NextStop.domain.station.entity.Station;
import project.NextStop.domain.station.entity.StationLine;
import project.NextStop.domain.station.repository.StationLineRepository;
import project.NextStop.domain.station.repository.StationRepository;
import project.NextStop.domain.subway.entity.Subway;
import project.NextStop.domain.subway.repository.SubwayRepository;
import project.NextStop.util.valuetype.Address;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ScheduleRepositoryImplTest {

    @Autowired EntityManager em;
    @Autowired ScheduleRepository scheduleRepository;
    @Autowired SubwayRepository subwayRepository;
    @Autowired StationLineRepository stationLineRepository;
    @Autowired StationRepository stationRepository;
    @Autowired ExitRepository exitRepository;

    @BeforeEach
    void setTestData(){

        Subway subway = new Subway(3,false);
        subwayRepository.save(subway);

        Station gundae = new Station("건대입구", new Address("건대로", "서울시", "123"),false,new BigDecimal(23),new BigDecimal(23));
        stationRepository.save(gundae);

        Station seungsu = new Station("성수", new Address("성수로", "서울시", "123"),false,new BigDecimal(23),new BigDecimal(23));
        stationRepository.save(seungsu);

        Station ttuksom = new Station("뚝섬", new Address("뚝섬로", "서울시", "123"),false,new BigDecimal(23),new BigDecimal(23));
        stationRepository.save(ttuksom);

        StationLine gundaeLine = new StationLine(gundae, "오른쪽");
        StationLine seungsuLine = new StationLine(seungsu, "오른쪽");
        StationLine ttuksomLine = new StationLine(ttuksom, "오른쪽");

        gundaeLine.addNext(seungsuLine);
        gundaeLine.addPrevious(ttuksomLine);

        stationLineRepository.save(gundaeLine);
        stationLineRepository.save(seungsuLine);
        stationLineRepository.save(ttuksomLine);

        Exit exit1 = new Exit(1,"1번 출구");
        Exit exit2 = new Exit(2, "2번 출구");
        Exit exit3 = new Exit(3, "3번 출구");

        exit1.addStation(seungsu);
        exit2.addStation(seungsu);
        exit3.addStation(seungsu);

        exitRepository.save(exit1);
        exitRepository.save(exit2);
        exitRepository.save(exit3);

        Schedule schedule = new Schedule(gundaeLine, subway, "평일", LocalTime.now(), "외선");
        scheduleRepository.save(schedule);

    }
    @Test
    void getStationDetail(){

        Subway subway = subwayRepository.findById(1L).get();

        em.flush();
        em.clear();

        List<Schedule> station = scheduleRepository.getStation(subway.getId());
        Schedule findSchedule = station.get(0);
        System.out.println("schedule.getStationLine().getNext().getStation().getName() = " + findSchedule.getStationLine().getNext().getStation().getName());
        List<Exit> exits = findSchedule.getStationLine().getNext().getStation().getExits();

        assertThat(findSchedule.getStationLine().getNext().getStation().getExits().size()).isEqualTo(3);
        assertThat(findSchedule.getStationLine().getNext().getStation().getName()).isEqualTo("성수");
    }

}