package com.monirul.toyrobot.command;

import com.monirul.toyrobot.exception.ApplicationException;

public interface CommandConfig {
    UserCommand getCommand(String command)throws ApplicationException;
}
