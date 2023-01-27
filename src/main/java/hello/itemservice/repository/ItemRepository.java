package hello.itemservice.repository;

import hello.itemservice.domain.Item;

import java.util.List;
import java.util.Optional;

/**
 * ItemRepository에서 ItemUpdateDto, ItemSearchCond를 직접적으로 사용하기 때문에
 * memory에 ItemUpdateDto, ItemSearchCond 같이 보관!
 * 어짜피 Service에서 Repository를 호출함
 *
 * 컨트롤러 -> 서비스 -> 리포지터리    DTO위치: 마지막에 DTO가 쓰이는 위치에 같이 묶어서 보관!
 */

public interface ItemRepository {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam); //itemId에 맞는 상품을 updateParam 업데이트 해라

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond cond);

}
