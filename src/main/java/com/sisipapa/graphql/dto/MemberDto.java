package com.sisipapa.graphql.dto;

import com.sisipapa.graphql.domain.MemberGraphQL;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private Integer id;

    private String loginId;

    private String password;

    private String name;

    private List<RoleDto> roles;

    public static List<MemberDto> from(Collection<MemberGraphQL> entities) {
        return entities.stream().map(MemberDto::from).collect(Collectors.toList());
    }

    public static MemberDto from(MemberGraphQL entity) {
        return MemberDto.builder()
                .id(entity.getId())
                .loginId(entity.getLoginId())
                .password(entity.getPassword())
                .name(entity.getName())
                .roles(RoleDto.from(entity.getRole()))
                .build();
    }
}
