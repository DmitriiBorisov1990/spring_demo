package com.borisov.hero.ano;

import com.borisov.hero.Weapon;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Getter
//@Primary // решает конфликт
@ToString
@Component("axe-component")
@Qualifier("axe-qualifier")
public class AxeAno implements Weapon {

    private String name;

    public AxeAno(){

    }
    @Autowired
    public AxeAno(String name){
        this.name = name;
    }

    @Override
    public int getDamage() {
        return 5;
    }
}
