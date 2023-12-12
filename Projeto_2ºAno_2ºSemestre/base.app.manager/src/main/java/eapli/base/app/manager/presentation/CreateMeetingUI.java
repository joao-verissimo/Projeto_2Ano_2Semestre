package eapli.base.app.manager.presentation;

import eapli.base.MeetingManagement.application.CreateMeetingController;
import eapli.base.MeetingManagement.domain.Duration;
import eapli.base.MeetingManagement.domain.TimeMeeting;
import eapli.base.exammanagement.domain.Date;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge Lima
 */
public class CreateMeetingUI extends AbstractUI {
    private CreateMeetingController ctrl = new CreateMeetingController();

    @Override
    public boolean doShow() {
        List<String> emails = new ArrayList<>();
        String email, r;
        Date date = new Date();
        TimeMeeting timeMeeting = new TimeMeeting();
        Duration duration = new Duration();
        boolean a = true, b = true;

        System.out.println("<--- Information to create the meeting --->");

        while (a){
            try{
                date = new Date(Console.readLine("Introduce the date of the meeting (yyyy-dd-mm): "));
                a = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        a = true;
        while (a){
            try{
                timeMeeting = new TimeMeeting(Console.readLine("Introduce the time of the meeting (hh:mm): "));
                a = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        a = true;
        while (a){
            try{
                duration = new Duration(Console.readLine("Introduce the duration of the meeting (hh:mm): "));
                a = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        a = true;
        while (a){
            email = Console.readLine("Introduza um email: ");
            emails.add(email);
            while (b) {
                r = Console.readLine("Do you wish to introduce more emails ? (s or n)");
                if(r.equalsIgnoreCase("s")){
                    b = false;
                }else if(r.equalsIgnoreCase("n")){
                    b = false;
                    a = false;
                }else{
                    System.out.println("Please choose a valid option.");
                }
            }
            b = true;
        }

        if(ctrl.createMeeting(date, duration, timeMeeting, emails)){
            System.out.println("The meeting was created with success.");
        }else{
            System.out.println("An error as occurred, the meeting was not created.");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Create Meeting";
    }
}