package com.github.qbek.screenplay.Tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;

import static facts.CardType.CREDIT;
import static facts.CardType.DEBIT;

public class Tasks {

    public static Task userLogsIntoAccount() {
        return new LogsInToAccount();
    }

    public static Task checkHisCardBalance(){
        return   new CheckCardBalance();
    }

//    public static Task checkCreditCardBalance(){
//     return   Instrumented.instanceOf(CheckCardBalance.class).newInstance();
//    }
}
