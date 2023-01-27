package hello.itemservice;

import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;


//@Import(MemoryConfig.class) //앞서 설정한 MemoryConfig를 설정 파일로 사용
//@Import(JdbcTemplateV1Config.class)
//@Import(JdbcTemplateV2Config.class)
@Import(JdbcTemplateV3Config.class)
@SpringBootApplication(scanBasePackages = "hello.itemservice.web") //경로상 하위에 있는 controller만 컴포넌트 스캔을 사용, 나머지는 수동 등록
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean //Bean으로 등록해줘야 EventListener 적용 가능
	@Profile("local") //특정 프로필의 경우에만 해당 스프링 빈을 등록 (application.properties에서 프로필 setting)
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

}
