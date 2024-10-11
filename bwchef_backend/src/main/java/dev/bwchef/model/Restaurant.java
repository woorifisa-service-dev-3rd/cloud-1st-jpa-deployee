package dev.bwchef.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chef_id")
    private Chef chef;

    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus = new ArrayList<>();
}
