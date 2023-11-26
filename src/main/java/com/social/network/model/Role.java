package com.social.network.model;

import com.social.network.constants.Permission;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.social.network.constants.Permission.ADMIN_CREATE;
import static com.social.network.constants.Permission.ADMIN_DELETE;
import static com.social.network.constants.Permission.ADMIN_READ;
import static com.social.network.constants.Permission.ADMIN_UPDATE;
import static com.social.network.constants.Permission.MODERATOR_CREATE;
import static com.social.network.constants.Permission.MODERATOR_DELETE;
import static com.social.network.constants.Permission.MODERATOR_READ;
import static com.social.network.constants.Permission.MODERATOR_UPDATE;

@RequiredArgsConstructor
public enum Role {

  USER(Collections.emptySet()),
  ADMIN(
          Set.of(
                  ADMIN_READ,
                  ADMIN_UPDATE,
                  ADMIN_DELETE,
                  ADMIN_CREATE,
                  MODERATOR_READ,
                  MODERATOR_UPDATE,
                  MODERATOR_DELETE,
                  MODERATOR_CREATE
          )
  ),
  MODERATOR(
          Set.of(
                  MODERATOR_READ,
                  MODERATOR_UPDATE,
                  MODERATOR_DELETE,
                  MODERATOR_CREATE
          )
  )

//  USER(
//          Set.of(
//                  USER_CREATE,
//                  USER_READ,
//                  USER_UPDATE,
//                  USER_DELETE
//
//       )
//  )

  ;

  @Getter
  private final Set<Permission> permissions;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}
