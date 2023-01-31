package hello.itemservice.repository.v2;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 기본 CRUD 기능 가능!
 * 단순 조회 쿼리들을 추가해서 사용 가능!
 */
public interface ItemRepositoryV2 extends JpaRepository<Item, Long> {
}
