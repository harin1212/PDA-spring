package com.example.ioc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chef {
    private final IngredientFactory ingredientFactory;
    //요리 만들 수 있는 메소드
    public String cook(String menu){
        //재료 준비
        //재료 공장에서 받아옴
        Ingredient ingredient = ingredientFactory.getIngredient(menu);

        //요리중

        //요리 결과를 반환
        return ingredient.getName() + "으로 만든" + menu;
    }
}
