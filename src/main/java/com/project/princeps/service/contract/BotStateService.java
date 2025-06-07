package com.project.princeps.service.contract;

import com.project.princeps.util.BotState;

import java.util.HashMap;

public interface BotStateService {
    void setState();
    HashMap<Long, BotState> getState();
}
