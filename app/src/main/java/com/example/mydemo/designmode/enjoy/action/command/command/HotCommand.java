package com.example.mydemo.designmode.enjoy.action.command.command;


import com.example.mydemo.designmode.enjoy.action.command.Command;
import com.example.mydemo.designmode.enjoy.action.command.handler.HotHandler;

public class HotCommand extends Command {
    private HotHandler handler = new HotHandler();

    @Override
    public String execute() {
        return handler.getHots();
    }
}
