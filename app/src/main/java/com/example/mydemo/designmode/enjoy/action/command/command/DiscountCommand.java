package com.example.mydemo.designmode.enjoy.action.command.command;


import com.example.mydemo.designmode.enjoy.action.command.Command;
import com.example.mydemo.designmode.enjoy.action.command.handler.DiscountHandler;

public class DiscountCommand extends Command {

    private DiscountHandler handler = new DiscountHandler();

    @Override
    public String execute() {
        return handler.getDiscounts();
    }
}
