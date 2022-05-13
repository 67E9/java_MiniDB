package com.pascal.miniDB.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Miniature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "belongsTo",
            joinColumns = @JoinColumn(name = "miniature_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    List<Game> games;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;

    //Genre genre

    @Override
    public String toString() {
        return this.name;
    }
}
