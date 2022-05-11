package com.borisov.hero.ano;

import com.borisov.hero.Weapon;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@ToString
@Component
public class HeroAno {

    private String name;
    private List<Weapon> weapons;
    //private Map<Integer,Weapon> map;

    public HeroAno() {
    }

    @Autowired // указывает какой конструктор использовать + аргументы в конструкторе или поля класса
    public HeroAno(@Autowired(required = false) String name,@Qualifier("axe-component") List<Weapon> weapons) {
        this.name = name;
        this.weapons = weapons;
        //this.map = weapons.stream().collect(Collectors.toMap(Weapon::getDamage, Function.identity()));
    }
}
