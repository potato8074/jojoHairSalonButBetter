import java.util.ArrayList;
import Appointment as ap;

public class Main {
    public static void main(String[] args) {
        // Here are the types of appointments:
        // 0 - Available, 1 = Mens cut $50, 2= Ladies cut $80, 3= Mens Colouring $50, 4= Ladies Colouring $120
        // create a list of 7 appointments for Saturday (between 9:00 and 15:00 start time)
        ArrayList<Integer> appt_list = new ArrayList<>();
        String day = "Saturday";
        for (int time = 9; time <= 15; time++) {
            appt_list.add(new ap.Appointment(day, time));
        }

        // Book the first appointment slot (9 AM) for Harvey Wallbanger for a Men's Cut (appt_type = 1)
        int current_appt_index = 0;
        ap.Appointment current_appt = appt_list.get(current_appt_index);
        current_appt.schedule("Harvey", "403-233-3944", 1);

        // Book the second appointment slot (10 AM) for Sara for a Ladies Colouring
        current_appt_index = 1;
        current_appt = appt_list.get(current_appt_index);
        current_appt.schedule("Sara", "403-233-3945", 4);

        // Go through all the appointments and find the noon hour slot and book Jenny for a cut
        boolean found = false;
        int index = 0;
        while (index < appt_list.size() && !found) {
            current_appt = appt_list.get(index);
            // is this appointment the noon hour appointment for Saturday available?
            if (current_appt.get_day_of_week().equals("Saturday")
                    && current_appt.get_start_time_hour() == 12
                    && current_appt.get_appt_type() == 0) {
                found = true;
            }
            index++;
        }
        if (found) {
            // book it!
            current_appt.set_client_name("Jenny");
            current_appt.set_client_phone("403-867-5309");
            current_appt.set_appt_type(2);  // 2 - Ladies Cut;
        } else {
            System.out.println("Appointment entry not found");
        }

        // Print only scheduled appointments using format_record()
        System.out.println("Scheduled appointment records:");
        for (ap.Appointment appt : appt_list) {
            if (appt.get_appt_type() != 0) {
                System.out.print(appt.format_record());
            }
        }

        // Cancel Sara's appointment
        current_appt_index = 1;
        current_appt = appt_list.get(current_appt_index);
        current_appt.cancel();

        // Print report of all appointment times using string method
        for (ap.Appointment appt : appt_list) {
            System.out.print(appt);
        }
    }
}