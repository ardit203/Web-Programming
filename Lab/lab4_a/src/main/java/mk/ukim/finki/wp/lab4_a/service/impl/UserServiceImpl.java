//package mk.ukim.finki.wp.lab4_a.service.impl;
//
//import lombok.AllArgsConstructor;
//import mk.ukim.finki.wp.lab4_a.model.User;
//import mk.ukim.finki.wp.lab4_a.model.enums.Role;
//import mk.ukim.finki.wp.lab4_a.model.exceptions.InvalidArgumentsException;
//import mk.ukim.finki.wp.lab4_a.model.exceptions.PasswordsDoNotMatchException;
//import mk.ukim.finki.wp.lab4_a.model.exceptions.UsernameAlreadyExistsException;
//import mk.ukim.finki.wp.lab4_a.repository.UserRepository;
//import mk.ukim.finki.wp.lab4_a.service.UserService;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
////@Service
//@AllArgsConstructor
//public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public User register(String username, String password, String repeatedPassword, Role role) {
//        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
//            throw new InvalidArgumentsException();
//        }
//
//        if (!password.equals(repeatedPassword)) {
//            throw new PasswordsDoNotMatchException();
//        }
//
//        if (this.userRepository.findByUsername(username).isPresent()) {
//            throw new UsernameAlreadyExistsException(username);
//        }
//
//        User user = new User(username, passwordEncoder.encode(password), role);
//
//        return userRepository.save(user);
//
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
//    }
//}
