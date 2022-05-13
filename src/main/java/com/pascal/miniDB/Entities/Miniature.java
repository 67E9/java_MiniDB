package com.pascal.miniDB.Entities;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "game_id")
    Game game;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;

    //Genre genre

    @Override
    public String toString() {
        return this.name;
    }
}
