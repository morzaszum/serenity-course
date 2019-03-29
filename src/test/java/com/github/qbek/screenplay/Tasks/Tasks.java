package com.github.qbek.screenplay.Tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Tasks {

    public static Task logsIntoAccount() {
        return new UserLogsInToAccount();
    }

    public static Task checkHisCardBalance() {
        return new CheckCardBalance();
    }

    public static Task succesfullyLoggsIntoAccount() {
        return new UserSuccessfullyLogsIntoAccount();
    }

    public static Task changeHisPassword() {
        return new UserChangesPassword();

    }

//    public static Task checkCreditCardBalance(){
//     return   Instrumented.instanceOf(CheckCardBalance.class).newInstance();
//    }
}
