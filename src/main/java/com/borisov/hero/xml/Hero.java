package com.borisov.hero.xml;

import com.borisov.hero.Weapon;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Hero {

    private String name;
    private List<Weapon> weapons;

    public Hero() {
    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, List<Weapon> weapons) {
        this.name = name;
        this.weapons = weapons;
    }
}
