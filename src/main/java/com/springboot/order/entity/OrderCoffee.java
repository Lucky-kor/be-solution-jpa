package com.springboot.order.entity;

import com.springboot.audit.Auditable;
import com.springboot.coffee.entity.Coffee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * <h2>Spring Data JPA 실습 Solution 코드 포함</h2>
 * OrderCoffee 클래스는 Spring Data JPA 실습 과제 중 첫 번째 과제의 Solution 코드를 포함하고 있습니다.
 * <p>&nbsp;</p>
 * <h3>OrderCoffee 클래스에 대한 추가 설명</h3>
 * <ul>
 *     <li>
 *         <a href="https://projectlombok.org/api/lombok/Setter" target="_blank">
 *              {@literal @}Setter
 *         </a>/
 *         <a href="https://projectlombok.org/api/lombok/Getter" target="_blank">
 *             {@literal @}Getter
 *         </a>
 *         <ul>
 *             <li>
 *                 기본적으로 클래스 레벨에 lombok의
 *                 <a href="https://projectlombok.org/api/lombok/Setter" target="_blank">
 *                    {@literal @}Setter
 *                 </a>/
 *                 <a href="https://projectlombok.org/api/lombok/Getter" target="_blank">
 *                    {@literal @}Getter
 *                 </a>를 추가하면 클래스의 모든 필드에 setter/getter 메서드가 생깁니다.
 *             </li>
 *             <li>
 *                 만약
 *                 <a href="https://projectlombok.org/api/lombok/Setter" target="_blank">
 *                    {@literal @}Setter
 *                 </a>가 필요하지 않은 필드의 경우,
 *                 <a href="https://projectlombok.org/api/lombok/Setter" target="_blank">
 *                    {@literal @}Setter
 *                 </a>(
 *                 <a href="https://projectlombok.org/api/lombok/AccessLevel#NONE" target="_blank">
 *                     AccessLevel.NONE
 *                 </a>)과 같이 setter를 사용할 수 없도록 접근을 제한할 수 있습니다.
 *             </li>
 *         </ul>
 *     </li>
 *     <li>
 *         <a href="https://projectlombok.org/features/constructor" target="_blank">
 *             {@literal @}NoArgsConstructor
 *         </a>
 *         <ul>
 *             <li>
 *                 파라미터가 없는 디폴트 생성자를 추가합니다.
 *                 Spring Data JPA의 경우 Entity에 디폴트 생성자가 존재하지 않으면 데이터 조회 시, 에러가 발생합니다.
 *             </li>
 *         </ul>
 *     </li>
 *     <li>
 *         {@link com.springboot.audit.Auditable}
 *         <ul>
 *             <li>
 *                 {@link com.springboot.audit.Auditable} 클래스는 엔티티 클래스마다 공통으로 존재하는 엔티티 생성일, 수정일, 작성자 등의
 *                 필드를 공통화한 뒤, 엔티티에 대한 이벤트 발생 시 해당 필드의 값을 자동으로 채워주는 기능을 합니다.
 *             </li>
 *         </ul>
 *     </li>
 * </ul>
 * @version 1.0.0
 * @see <a href="https://projectlombok.org/features/constructor" target="_blank">@NoArgsConstructor</a>
 * @see <a href="https://projectlombok.org/api/lombok/Setter" target="_blank">@Setter</a>
 * @see <a href="https://projectlombok.org/api/lombok/Getter" target="_blank">@Getter</a>
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderCoffee extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCoffeeId;

    @Column(nullable = false)
    private int quantity;

    /**
     * OrderCoffee와 Order 간에 N대1 연관 관계를 매핑하기 위한 Solution 코드입니다.
     * <p>
     *     <b>Solution 키 포인트</b>
     * </p>
     * <ul>
     *     <li>
     *         <a href="https://docs.oracle.com/javaee/7/api/javax/persistence/ManyToOne.html" target="_blank">
     *             {@literal @}ManyToOne
     *         </a>을 이용해 N대1의 연관관계를 매핑합니다.
     *     </li>
     *     <li>
     *         <a href="https://docs.oracle.com/javaee/7/api/javax/persistence/JoinColumn.html" target="_blank">
     *             {@literal @}JoinColumn
     *         </a>을 이용해 ORDER_COFFEE 테이블에서 ORDER 테이블의 참조를 위한 외래키가 추가되는 컬럼을 지정합니다.
     *     </li>
     * </ul>
     */
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    /**
     * OrderCoffee와 Coffee 간에 N대1 연관 관계를 매핑하기 위한 Solution 코드입니다.
     * <p>
     *     <b>Solution 키 포인트</b>
     * </p>
     * <ul>
     *     <li>
     *         <a href="https://docs.oracle.com/javaee/7/api/javax/persistence/ManyToOne.html" target="_blank">
     *             {@literal @}ManyToOne
     *         </a>을 이용해 N대1의 연관관계를 매핑합니다.
     *     </li>
     *     <li>
     *         <a href="https://docs.oracle.com/javaee/7/api/javax/persistence/JoinColumn.html" target="_blank">
     *             {@literal @}JoinColumn
     *         </a>을 이용해 ORDER_COFFEE 테이블에서 COFFEE 테이블의 참조를 위한 외래키가 추가되는 컬럼을 지정합니다.
     *     </li>
     * </ul>
     */
    @ManyToOne
    @JoinColumn(name = "COFFEE_ID")
    private Coffee coffee;

    /**
     * OrderCoffee와 Order 간에 양방향 연관 관계를 안전하게 매핑하기 위한 Solution 코드입니다.
     * <p>
     *     <b>Solution 키 포인트</b>
     * </p>
     * <ul>
     *     <li>
     *         클래스 레벨에
     *         <a href="https://projectlombok.org/api/lombok/Setter" target="_blank">
     *             {@literal @}Setter
     *         </a>애너테이션으로 setter를 추가했지만 양방향 연관관계를 안전하게 매핑하기 위해 order 쪽에도 orderCoffee를 추가합니다.
     *     </li>
     *     <li>
     *         이 처럼 양방향 관계일 경우, 한 쪽의 엔티티만 추가해 주는 실수를 하더라도 다른 쪽 엔티티를 추가해 주기 때문에
     *         정상적인 연관관계 매핑을 보장해 줍니다.
     *     </li>
     * </ul>
     * @param order OrderCoffee와 연관관계를 맺을 대상인 order 객체
     */
    public void setOrder(Order order) {
        this.order = order;
        if (!this.order.getOrderCoffees().contains(this)) {
            this.order.getOrderCoffees().add(this);
        }
    }

    /**
     * OrderCoffee와 Coffee 간에 양방향 연관 관계를 안전하게 매핑하기 위한 Solution 코드입니다.
     * <p>
     *     <b>Solution 키 포인트</b>
     * </p>
     * <ul>
     *     <li>
     *         클래스 레벨에
     *         <a href="https://projectlombok.org/api/lombok/Setter" target="_blank">
     *             {@literal @}Setter
     *         </a>애너테이션으로 setter를 추가했지만 양방향 연관관계를 안전하게 매핑하기 위해 coffee 쪽에도 orderCoffee를 추가합니다.
     *     </li>
     *     <li>
     *         이 처럼 양방향 관계일 경우, 한 쪽의 엔티티만 추가해 주는 실수를 하더라도 다른 쪽 엔티티를 추가해 주기 때문에
     *         정상적인 연관관계 매핑을 보장해 줍니다.
     *     </li>
     * </ul>
     * @param coffee    OrderCoffee와 연관관계를 맺을 대상인 coffee 객체
     */
    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
        if (!this.coffee.getOrderCoffees().contains(this)) {
            this.coffee.setOrderCoffee(this);
        }
    }
}
