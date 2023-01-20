package hello.itemservice;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;

    /**
     * 확인용 초기 데이터 추가
     * ItemServiceApplication에서 @Profile("local") TestDataInit을 통해 스프링 빈으로 등록!
     * 컨테이너 초기화 끝내고 @Bean으로 등록된 initData()를 기본 값으로 repository.save 시킴!
     */
    @EventListener(ApplicationReadyEvent.class) //스프링 컨테이너가 초기화 다 끝내고 실행 준비가 되었을 때 발생하는 이벤트!
    public void initData() {
        log.info("test data init");
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}
