package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vegetable", schema = "public")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_grown_on_tree")
    private Boolean isGrownOnTree;

    public Boolean isGrownOnTree() {
        return this.isGrownOnTree;
    }

    public void setGrownOnTree(Boolean isGrownOnTree) {
        this.isGrownOnTree = isGrownOnTree;
    }
}
