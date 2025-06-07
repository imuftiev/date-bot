package com.project.princeps.service;

import com.project.princeps.entity.Info;
import com.project.princeps.repository.InfoRepository;
import com.project.princeps.service.contract.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InfoServiceImpl implements InfoService {

    private final InfoRepository infoRepository;

    public InfoServiceImpl(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @Override
    public void add(Info info) {
        try {
            infoRepository.save(info);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
