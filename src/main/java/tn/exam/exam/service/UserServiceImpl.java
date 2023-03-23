package tn.exam.exam.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.exam.exam.aop.LoggingAspect;
import tn.exam.exam.entity.User;
import tn.exam.exam.repository.UserRepository;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements  IUserService{
    @Autowired
    UserRepository userRepository;
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Override
  //  @Scheduled(fixedRate = 30000)
    public List<User> getAllUsers()
    {
        LOGGER.info("User :"+userRepository.findAll().get(0));
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    public User addUser(User u)
    {
        return userRepository.saveAndFlush(u);
    }

    @Override
    public User updateUser(User u)
    {
        return userRepository.saveAndFlush(u);
    }

    @Override
    public boolean deleteUSer(Long id)
    {
         userRepository.deleteById(id);
         return (!userRepository.existsById(id));

    }
}
