package com.queststore.service;

import com.queststore.dao.MentorJDBCDAO;
import com.queststore.dao.UserDAO;
import com.queststore.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {

    UserDAO mentorDao;

    public MentorService(MentorJDBCDAO mentorDao) {
        this.mentorDao = mentorDao;
    }

    public List<User> getAllMentors(){
        return mentorDao.getAll();
    }

    public void createMentor(User mentor){
        mentorDao.create(mentor);
    }
    public User getMentorById(long id){
        return mentorDao.getMentorById(id);
    }

    public void updateMentor(User mentor){
        mentorDao.update(mentor);
    }
}
