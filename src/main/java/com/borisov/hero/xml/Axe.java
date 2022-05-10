package com.borisov.hero.xml;

import com.borisov.hero.Weapon;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@ToString
public class Axe implements Weapon {

    private String name;

    public Axe(String name) {
        this.name = name;
    }

    @Override
    public int getDamage() {
        return 15;
    }
}
