package am.friendsWebGroup.kidoskindergarten.security;

import am.friendsWebGroup.kidoskindergarten.entity.User;
import am.friendsWebGroup.kidoskindergarten.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(email);
        if(!byEmail.isPresent()){
            throw new UsernameNotFoundException("Username does not exist");
        }
        return new CurrentUser(byEmail.get());
    }
}
