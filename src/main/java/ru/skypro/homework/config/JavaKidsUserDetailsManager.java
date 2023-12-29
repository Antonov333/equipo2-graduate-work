package ru.skypro.homework.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JavaKidsUserDetailsManager implements UserDetailsManager {

    private final UserRepository userRepository;

    /**
     * <h2>createUser</h2>
     *
     * @param userDetails user to be created. <br>Method does nothing if given user is already existed in database
     *                    <br><b>If user pretty new saves his entity in database</b>
     */
    @Override
    public void createUser(UserDetails userDetails) {

        if (userExists(userDetails.getUsername())) {
            return;
        }
        User newUser = new User(0L, "", "", "",
                userDetails.getUsername(), Role.USER, "", userDetails.getPassword());


        userRepository.save(newUser);

    }

    /**
     * Not supported by current version
     *
     * @param user
     */
    @Override
    public void updateUser(UserDetails user) {

    }

    /**
     * Not supported by current version
     *
     * @param username
     */
    @Override
    public void deleteUser(String username) {

    }

    /**
     * Not supported by current version
     *
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    /**
     * <h2>userExists</h2><br>Checks whether user's email is present in database
     *
     * @param username user's email
     * @return true if user exists, or false if not
     */
    @Override
    public boolean userExists(String username) {
        return userRepository.findByEmail(username).isPresent();
    }

    /**
     * <h2>loadUserByUsername</h2>
     *
     * @param username user's email
     * @return user details or throw UsernameNotFoundException if user does not exists
     * @throws UsernameNotFoundException throws if user with given emails not present in database
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("user not found: " + username);
        }
        return new JavaKidsUserDetails(user.get());
    }
}