/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.app.manager.presentation.authz;

import domain.model.SystemUserAuth;
import eapli.base.usermanagement.application.DeactivateActivateUserController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
@SuppressWarnings("squid:S106")
public class DeactivateActivateUserUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeactivateActivateUserUI.class);

    private final DeactivateActivateUserController theController = new DeactivateActivateUserController();

    @Override
    protected boolean doShow() {
        final List<SystemUserAuth> listActive = new ArrayList<>();
        final Iterable<SystemUserAuth> iterableActive = this.theController.activeUsers();
        final List<SystemUserAuth> listInactive = new ArrayList<>();
        final Iterable<SystemUserAuth> iterableInactive = this.theController.deactivedUsers();
        final Integer optionAcDea = Console.readInteger("Enter number to choose the action:\n1. Deactivate\n2. Activate");
        switch (optionAcDea){
            case 1: {
                if (!iterableActive.iterator().hasNext()) {
                    System.out.println("There is no registered User");
                } else {
                    int cont = 1;
                    System.out.println("SELECT User to deactivate\n");
                    // FIXME use select widget, see, ChangeDishTypeUI
                    System.out.printf("%-6s%-10s%-30s%-30s%n", "Nº:", "Username", "Firstname", "Lastname");
                    for (final SystemUserAuth user : iterableActive) {
                        listActive.add(user);
                        System.out.printf("%-6d%-10s%-30s%-30s%n", cont, user.email(), user.name().fullName(),
                                user.name().shortName());
                        cont++;
                    }
                    final int option = Console.readInteger("Enter user nº to deactivate or 0 to finish ");
                    if (option == 0) {
                        System.out.println("No user selected");
                    } else {
                        try {
                            this.theController.deactivateUser(listActive.get(option - 1));
                        } catch (IntegrityViolationException | ConcurrencyException ex) {
                            LOGGER.error("Error performing the operation", ex);
                            System.out.println(
                                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
                        }
                    }
                    break;
                }
            }
            case 2: {
                if (!iterableInactive.iterator().hasNext()) {
                    System.out.println("There is no registered User");
                } else {
                    int cont = 1;
                    System.out.println("SELECT User to activate\n");
                    // FIXME use select widget, see, ChangeDishTypeUI
                    System.out.printf("%-6s%-10s%-30s%-30s%n", "Nº:", "Username", "Firstname", "Lastname");
                    for (final SystemUserAuth user : iterableInactive) {
                        listInactive.add(user);
                        System.out.printf("%-6d%-10s%-30s%-30s%n", cont, user.email(), user.name().fullName(),
                                user.name().shortName());
                        cont++;
                    }
                    final int option = Console.readInteger("Enter user nº to activate or 0 to finish ");
                    if (option == 0) {
                        System.out.println("No user selected");
                    } else {
                        try {
                            this.theController.activateUser(listInactive.get(option - 1));
                        } catch (IntegrityViolationException | ConcurrencyException ex) {
                            LOGGER.error("Error performing the operation", ex);
                            System.out.println(
                                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
                        }
                    }
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Deactivate/Activate User";
    }
}
