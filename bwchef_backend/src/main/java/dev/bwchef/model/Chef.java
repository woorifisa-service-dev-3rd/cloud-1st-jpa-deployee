package dev.bwchef.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 흑 또는 백
    private String chefType;

    @OneToMany(mappedBy = "chef")
    private List<Restaurant> restaurants = new ArrayList<>();

}
