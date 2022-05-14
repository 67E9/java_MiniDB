package com.pascal.miniDB.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MiniCollection {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    String owner; //might be replaced by owners table later on
    Boolean painted;
    Boolean for_sale;

    @ManyToMany
    @JoinTable (
            name = "contains",
            joinColumns = @JoinColumn(name = "miniature_id"),
            inverseJoinColumns = @JoinColumn (name = "miniCollection_id")
    )
    List<Miniature> miniatures;

    //image data o be added later
}
