package com.pascal.miniDB.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
            name = "mini_game",
            joinColumns = @JoinColumn(name = "miniature_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    List<Game> games;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;

    @ManyToMany(mappedBy = "miniatures")
    @JsonIgnore
    List<MiniCollection> miniCollections;

    @ManyToOne
    @JoinColumn(name = "faction_id")
    Faction faction;

    //Genre genre

    @Override
    public String toString() {
        return this.name;
    }
}
