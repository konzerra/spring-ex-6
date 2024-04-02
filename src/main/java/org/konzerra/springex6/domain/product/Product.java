package org.konzerra.springex6.domain.product;

import jakarta.persistence.*;
import lombok.*;
import org.konzerra.springex6.domain.category.Category;
import org.konzerra.springex6.domain.subcategory.Subcategory;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name = "";

    @Column(name = "description", nullable = false)
    private String description = "";

    @JoinColumn(name = "category_id")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Category category;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_subcategory",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id")
    )
    private Set<Subcategory> subcategories = new HashSet<>();

}
