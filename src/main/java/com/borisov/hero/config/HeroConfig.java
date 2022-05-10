package com.borisov.hero.config;

import com.borisov.hero.Weapon;
import com.borisov.hero.ano.AxeAno;
import com.borisov.hero.ano.HeroAno;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan("com.borisov.ano")
public class HeroConfig {

    @Bean
    public String name(){
        return "Просто меч conf";
    }

    @Bean
    public Weapon axeConf(){
        return new AxeAno();
    }

    @Bean("lego")
    public HeroAno legolas(String name, List<Weapon> weapons){
        return new HeroAno("Леголас",weapons);
    }
}
