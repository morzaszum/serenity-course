package com.github.qbek.screenplay.Tasks;

import abilities.UseAccount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class UserChangesPassword implements Task {

    @Override
    @Step("{0} sets wrong password")
    public <T extends Actor> void performAs(T actor) {
        actor.usingAbilityTo(UseAccount.class).getCredentials().setPassword("IncorrectPassword");
    }
}
