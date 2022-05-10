package com.borisov.hero.xml;

import com.borisov.hero.Weapon;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Sword implements Weapon {

    private String name;

    Sword(String name) {
        this.name = name;
    }

    @Override
    public int getDamage() {
        return 10;
    }
}
