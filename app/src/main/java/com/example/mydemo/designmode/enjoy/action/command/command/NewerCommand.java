package com.example.mydemo.designmode.enjoy.action.command.command;

import com.example.mydemo.designmode.enjoy.action.command.Command;
import com.example.mydemo.designmode.enjoy.action.command.handler.NewerHandler;

public class NewerCommand extends Command {
    private NewerHandler handler = new NewerHandler();

    @Override
    public String execute() {
        return handler.getNewers();
    }
}
