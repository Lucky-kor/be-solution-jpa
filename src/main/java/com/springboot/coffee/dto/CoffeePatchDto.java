package com.springboot.coffee.dto;

import com.springboot.coffee.entity.Coffee;
import com.springboot.validator.NotSpace;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@Getter
public class CoffeePatchDto {
    private long coffeeId;

    @NotSpace(message = "커피명(한글)은 공백이 아니어야 합니다.")
    private String korName;

    @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$", message = "커피명(영문)은 영문이어야 합니다. 예) Cafe Latte")
    private String engName;

    @Range(min= 100, max= 50000)
    private Integer price;

    // 추가된 부분. 커피 상태 값을 사전에 체크하는 Custom Validator를 만들수도 있다.
    private Coffee.CoffeeStatus coffeeStatus;

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Integer getPrice() {
        return price;
    }
}
