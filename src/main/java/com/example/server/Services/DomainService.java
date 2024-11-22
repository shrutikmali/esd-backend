package com.example.server.Services;

import com.example.server.Entities.Domain;
import com.example.server.Repositories.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainService {

    @Autowired
    private DomainRepository domainRepository;

    public List<Domain> getAllDomains() {
        return domainRepository.findAllBy();
    }

    public Domain getDomainById(int id) {
        return domainRepository.findById(id);
    }

    public Domain createDomain(String program, int batch, int capacity, String qualification) {
        Domain domain = new Domain();
        domain.setProgram(program);
        domain.setCapacity(capacity);
        domain.setBatch(batch);
        domain.setQualification(qualification);

        return domainRepository.save(domain);
    }

}
