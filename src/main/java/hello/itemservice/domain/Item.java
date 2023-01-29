package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity //JPA entity
//@Table(name = "item") //객체명 == table 이름, 생략가능
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //PK, DB에서 값을 넣어주는 전략임!
    private Long id;
    @Column(name = "item_name", length = 10) //DB의 "item_name"과 바인딩 (column == 변수명인 경우, 생략 가능)
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
