package eapli.base.app.manager.presentation;

import eapli.base.MeetingManagement.application.CancelMeetingController;
import eapli.base.MeetingManagement.domain.Meeting;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 * @author Jorge Lima
 */

public class CancelMeetingUI extends AbstractUI {
    private CancelMeetingController controller = new CancelMeetingController();

    @Override
    public boolean doShow() {
        int index = 1, indexMeeting;
        boolean flag = true, valid = false;
        Iterable<Meeting> userMeetings = controller.userMeetings();

        if(!userMeetings.iterator().hasNext()){
            System.out.println("You have no meetings created.");
        }else {
            System.out.println("Meeting\n");
            System.out.printf("%-7s%-15s%-30s%-30s%n", "Index:", "Date", "Hour", "Duration");

            for (Meeting a : userMeetings) {
                System.out.printf("%-7s%-15s%-30s%-30s%n", index, a.date().date(), a.timeMeeting().timeMeeting(), a.duration().duration());
                index++;
            }

            while (flag) {
                indexMeeting = Console.readInteger("Choose the meeting you want to cancel (0 to exit): ");
                if (indexMeeting == 0) {
                    return false;
                } else {
                    index = 0;
                    for (Meeting a : userMeetings) {
                        index++;
                        if (index == indexMeeting) {
                            try{
                                controller.cancelMeeting(a);
                                System.out.println("The meeting was canceled with success.");
                            }catch (Exception e){
                                System.out.println(e);
                                System.out.println("An error has occurred and the meeting was not canceled.");
                            }

                            valid = true;
                            break;
                        }
                    }

                    if (!valid) {
                        System.out.println("Choose a valid index!");
                    } else {
                        flag = false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Cancel Meeting";
    }
}
