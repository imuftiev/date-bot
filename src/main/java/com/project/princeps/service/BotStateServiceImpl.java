package com.project.princeps.service;

import com.project.princeps.service.contract.BotStateService;
import com.project.princeps.util.BotState;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class BotStateServiceImpl implements BotStateService {

    private final HashMap<Long, BotState> botStateMachine = new HashMap<>();

    @Override
    public void setState() {
    }

    @Override
    public HashMap<Long, BotState> getState() {
        return botStateMachine;
    }
}
