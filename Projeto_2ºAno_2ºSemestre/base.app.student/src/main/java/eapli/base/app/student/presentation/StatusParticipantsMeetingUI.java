package eapli.base.app.student.presentation;

import eapli.base.MeetingManagement.application.MeetingParticipantsController;
import eapli.base.MeetingManagement.domain.Meeting;
import eapli.base.MeetingManagement.domain.MeetingAccessList;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

/**
 * @author Jorge Lima
 */

public class StatusParticipantsMeetingUI extends AbstractUI {
    private MeetingParticipantsController controller = new MeetingParticipantsController();

    @Override
    public boolean doShow() {
        int index = 1, indexMeeting;
        boolean flag = true, valid = false;
        Iterable<Meeting> userMeetings = controller.userMeetings();

        if(!userMeetings.iterator().hasNext()){
            System.out.println("You don't have any meetings.");
        }else {
            System.out.println("Meetings\n");
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
                                List<MeetingAccessList> users = controller.meetingParticipants(a);
                                System.out.println("Meeting Users\n");
                                System.out.printf("%-7s%-30s%-10s%n", "Index:", "User email", "State");

                                for (MeetingAccessList b : users) {
                                    System.out.printf("%-7s%-30s%-10s%n", index, b.user().email(), b.inviteState());
                                }
                            }catch (Exception e){
                                System.out.println(e);
                                System.out.println("An error has occurred.");
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
