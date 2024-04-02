package org.konzerra.springex6.domain.subcategory;

import jakarta.persistence.*;
import lombok.*;
import org.konzerra.springex6.domain.product.Product;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name = "";

    @Column(name = "description", nullable = false)
    private String description = "";

    @ManyToMany(mappedBy = "subcategories", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();
}
