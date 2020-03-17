package com.trining.design.command.ftp;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class LsCommand implements  IFtpCommand{

    FtpCore ftpCore;

    public LsCommand(FtpCore ftpCore) {
        this.ftpCore = ftpCore;
    }

    @Override
    public void execute() {
        ftpCore.ls();
    }
}
