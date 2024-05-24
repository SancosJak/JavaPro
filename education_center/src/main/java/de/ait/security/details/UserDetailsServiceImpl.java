package de.ait.security.details;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> userOptional = userRepository.findByEmail(email);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            AuthenticatedUser authenticatedUser = new AuthenticatedUser(user);
//            return authenticatedUser;
//        } else {
//            throw new UsernameNotFoundException("User with email " + email + " not found");
//        }
      //2d version
//        return userRepository
//                .findByEmail(email)
//                .map(AuthenticatedUser::new)
//                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
        //3d version
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
        return new AuthenticatedUser(user);
    }
}
