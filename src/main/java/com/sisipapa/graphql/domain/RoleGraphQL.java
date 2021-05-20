package com.sisipapa.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleGraphQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int memberId;

    private String role;
}
