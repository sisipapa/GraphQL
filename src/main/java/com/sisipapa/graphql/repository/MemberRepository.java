package com.sisipapa.graphql.repository;

import com.sisipapa.graphql.domain.MemberGraphQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberGraphQL, Integer> {
}
