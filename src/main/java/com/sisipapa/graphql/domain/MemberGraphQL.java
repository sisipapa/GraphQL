package com.sisipapa.graphql.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberGraphQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String loginId;

    private String password;

    private String name;

    @OneToMany
    @JoinColumn(name = "memberId", referencedColumnName = "id", insertable = false, updatable = false)
    private List<RoleGraphQL> role;
}
