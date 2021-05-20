package com.sisipapa.graphql.repository;

import com.sisipapa.graphql.domain.RoleGraphQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleGraphQL, Integer> {
    RoleGraphQL findByMemberId(int memberId);
}
