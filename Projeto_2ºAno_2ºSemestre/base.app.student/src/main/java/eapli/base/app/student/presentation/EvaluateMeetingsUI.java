package eapli.base.app.student.presentation;

import domain.model.SystemUserAuth;
import eapli.base.MeetingManagement.application.MeetingEvaluationController;
import eapli.base.MeetingManagement.domain.InviteState;
import eapli.base.MeetingManagement.domain.MeetingAccessList;
import eapli.base.MeetingManagement.repositories.MeetingALRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;
import java.util.Iterator;

public class EvaluateMeetingsUI extends AbstractListUI<MeetingAccessList> {

    private final MeetingALRepository meetingaccesslistRepository = PersistenceContext.repositories().meetingAlRepository();

    @Override
    protected Iterable<MeetingAccessList> elements() {
        return null;
    }

    @Override
    protected Visitor<MeetingAccessList> elementPrinter() {
        return null;
    }

    @Override
    protected String elementName() {
        return null;
    }

    @Override
    protected String listHeader() {
        return null;
    }

    @Override
    protected String emptyMessage() {
        return null;
    }

    public boolean doShow() {
        int index = 1;
        MeetingEvaluationController controller = new MeetingEvaluationController();
        Iterable<MeetingAccessList> meetingList = controller.listMeetingAL();
        SystemUserAuth user = controller.getUser();

        System.out.println("Meeting Requests\n");
        System.out.printf("%-6s%-6s%-15s%-30s%-30s%n", "Index:", "Id:", "Date", "Hour", "Duration");

        for (MeetingAccessList meetingAccessList : meetingList) {
            if (meetingAccessList.inviteState().equals(InviteState.Sent) && meetingAccessList.user().equals(user)) {
                System.out.printf("%-6s%-6d%-15s%-30s%-30s%n", index, meetingAccessList.idAccessList(),
                        meetingAccessList.meeting().date().date(), meetingAccessList.meeting().timeMeeting().timeMeeting(), meetingAccessList.meeting().duration().duration());
                index++;
            }
        }

        boolean flag = true;
        MeetingAccessList selectedMeeting = null;

        while (flag) {
            int indexMeeting = Console.readInteger("Choose the Enrollment index to respond (0 to exit): ");
            if (indexMeeting == 0) {
                return false;
            } else {
                Iterator<MeetingAccessList> iterator = meetingList.iterator();
                int currentIndex = 0;
                while (iterator.hasNext()) {
                    currentIndex++;
                    MeetingAccessList meetingAL = iterator.next();
                    if (currentIndex == indexMeeting) {
                        selectedMeeting = meetingAL;
                        break;
                    }
                }

                if (selectedMeeting != null) {
                    flag = false;
                } else {
                    System.out.println("Choose a valid index!");
                }
            }
        }

        boolean responseFlag = true;

        while (responseFlag) {
            String response = Console.readLine("Accept (A) or Deny (D) the meeting? ");
            switch (response.toUpperCase()) {
                case "A":
                    try {

                        meetingaccesslistRepository.save(controller.alterStateA(controller.getUser()));

                        System.out.println("User " + controller.getUser().name()
                                + " has successfully accepted the meeting!");

                        responseFlag = false;
                        return true;
                    } catch (Exception e) {
                        System.out.println("An error occurred while accepting the meeting: " + e.getMessage());
                        return false;
                    }
                case "D":
                    try {
                        meetingaccesslistRepository.save(controller.alterStateD(controller.getUser()));

                        System.out.println("User " + controller.getUser().name()
                                + " has successfully denied the meeting!");

                        responseFlag = false;
                        return true;
                    } catch (Exception e) {
                        System.out.println("An error occurred while denying the meeting: " + e.getMessage());
                        return false;
                    }
                default:
                    System.out.println("Invalid response. Please enter 'A' to accept or 'D' to deny the meeting.");
            }
        }

        return false;
    }

    @Override
    public String headline() {
        return null;
    }
}
