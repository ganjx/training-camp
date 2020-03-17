package com.trining.design.command.ftp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class FtpClient {

    public List<IFtpCommand> ftpCommands = new ArrayList<>();

    /**
     * 输入命令
     * @param ftpCommand
     */
    public void inputCommand(IFtpCommand ftpCommand){
        ftpCommands.add(ftpCommand);
    }

    /**
     * 执行命令
     */
    public void executeCommands(){
        for (IFtpCommand ftpCommand : ftpCommands) {
            ftpCommand.execute();
        }
        ftpCommands.clear();
    }
}
