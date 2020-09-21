package com.queststore.service;

import com.queststore.dao.TestCodecoolerDAO;
import com.queststore.model.Codecoolers;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodecoolerService {
    private TestCodecoolerDAO dao;

    public CodecoolerService(TestCodecoolerDAO dao) {
        this.dao = dao;
    }

//    public void create(Codecoolers codecooler) {
//       dao.create(codecooler);
//    }
//
//    public void update(Codecoolers codecooler) {
//        dao.update(codecooler);
//    }
//
//    public List<Codecoolers> getAll() {
//        return dao.getAll();
//    }
//
//    public void delete(Long id) {
//        dao.delete(id);
//    }

    public List<Codecoolers> testFindAll(){
        return (List<Codecoolers>) dao.findAll();
    }
}
