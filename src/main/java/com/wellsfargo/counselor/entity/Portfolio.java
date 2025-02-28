package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    // Constructor
    public Portfolio(Client client) {
        this.client = client;
    }

    // Default constructor for JPA
    protected Portfolio() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    // Setters
    public void setClient(Client client) {
        this.client = client;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
