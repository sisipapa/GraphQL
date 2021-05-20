package com.sisipapa.graphql.query;

import com.sisipapa.graphql.domain.MemberGraphQL;
import com.sisipapa.graphql.dto.MemberDto;
import com.sisipapa.graphql.repository.MemberRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class MemberQuery implements GraphQLQueryResolver {

    private final MemberRepository memberRepository;

    public MemberDto getMember(int id) {
        MemberGraphQL member = memberRepository.findById(id)
                .orElse(null);
        return MemberDto.from(member);
    }
}
