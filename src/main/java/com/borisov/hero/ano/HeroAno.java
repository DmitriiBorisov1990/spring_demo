package com.borisov.hero.ano;

import com.borisov.hero.RandomValue;
import com.borisov.hero.Weapon;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Getter
@ToString
@Component
public class HeroAno {

    private String name;
    @RandomValue(min = 10, max = 50)
    private Integer uniqueNumber;
    private List<Weapon> weapons;
    //private Map<Integer,Weapon> map;

    public HeroAno() {
    }

    @Autowired
    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    @PostConstruct
    public void initialize() {
        System.out.println("initialize");
    }

    @Autowired // указывает какой конструктор использовать + аргументы в конструкторе или поля класса
    public HeroAno(@Autowired(required = false) String name, @Qualifier("axe-component") List<Weapon> weapons) {
        this.name = name;
        this.weapons = weapons;
        //this.map = weapons.stream().collect(Collectors.toMap(Weapon::getDamage, Function.identity()));
    }
}
