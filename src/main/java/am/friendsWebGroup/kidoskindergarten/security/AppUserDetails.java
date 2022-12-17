package am.friendsWebGroup.kidoskindergarten.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDetails {

  private int id;
  private String name;
  private String username;
  private List<SimpleGrantedAuthority> authorities;
  private Boolean enabled;
}
