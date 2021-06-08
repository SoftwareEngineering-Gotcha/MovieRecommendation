package edu.knu.se.service;


import edu.knu.se.domain.User;
import edu.knu.se.repository.UserRepository;
//import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public long join(User user){
        validateDuplicateMember(user);

        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateMember(User user){
        userRepository.findByUserid(user.getId())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<User> findMember(){return userRepository.findAll();}

    public Optional<User> findOne(Long memberId) { return userRepository.findByUserid(memberId);}
    public boolean ExistsOnebyUserid(Long memberId) {return userRepository.existsByUserid(memberId);}
    public void deleteByUserid(Long Id){ userRepository.deleteByUserid(Id);}
}


