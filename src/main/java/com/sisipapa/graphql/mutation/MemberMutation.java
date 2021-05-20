package com.sisipapa.graphql.mutation;

import com.sisipapa.graphql.domain.MemberGraphQL;
import com.sisipapa.graphql.domain.RoleGraphQL;
import com.sisipapa.graphql.dto.MemberDto;
import com.sisipapa.graphql.repository.MemberRepository;
import com.sisipapa.graphql.repository.RoleRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Transactional
public class MemberMutation implements GraphQLMutationResolver {

    private final MemberRepository memberRepository;

    private final RoleRepository roleRepository;

    public MemberDto createMember(MemberDto memberDto) {
        MemberGraphQL member = memberRepository.save(MemberGraphQL.builder()
                .loginId(memberDto.getLoginId())
                .name(memberDto.getName())
                .password(memberDto.getPassword())
                .build());
        return MemberDto.from(member);
    }

    public Boolean deleteMember(int id){
        Optional<MemberGraphQL> optionalMember = memberRepository.findById(id);
        RoleGraphQL role = roleRepository.findByMemberId(id);
        if(optionalMember.isPresent()) {
            roleRepository.delete(role);
            memberRepository.delete(optionalMember.get());
        }
        return true;
    }
}
