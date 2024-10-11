package dev.bwchef.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "menuType_id")
    private MenuType menuType;

    private String name;
    private Long price;



}
