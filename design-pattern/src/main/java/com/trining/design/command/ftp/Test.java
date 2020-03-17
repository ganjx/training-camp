package com.trining.design.command.ftp;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class Test {


    public static void main(String[] args) {
        // 1.初始化
        FtpClient ftpClient = new FtpClient();
        FtpCore ftpCore = new FtpCore();
        // 2.输入命令
        ftpClient.inputCommand(new DirCommand(ftpCore));
        ftpClient.inputCommand(new LsCommand(ftpCore));
        // 3.执行命令
        ftpClient.executeCommands();
    }
}
