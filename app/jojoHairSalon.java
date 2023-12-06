import java.util.ArrayList;
import ap.Appointment;  // Assuming Appointment is in the default package

public class Main {
    public static void main(String[] args) {
        // ArrayList to hold Appointment objects
        ArrayList<Appointment> appt_list = new ArrayList<>();
        String day = "Saturday";

        // Populate the appt_list with Appointment objects
        for (int time = 9; time <= 15; time++) {
            appt_list.add(new Appointment(day, time));
        }
        public class appointment {
            private String dayOfTheWeek;
            private int startTimeHour;
            private String clientName;
            private String clientPhone;
            private int apptType;

        public Appointment(String dayOfWeek, int startTimeHour){

        }

        // Book the first appointment slot (9 AM) for Harvey Wallbanger for a Men's Cut (appt_type = 1)
        int current_appt_index = 0;
        Appointment current_appt = appt_list.get(current_appt_index);
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
            // Check if this appointment is the noon hour appointment for Saturday and is available
            if (current_appt.get_day_of_week().equals("Saturday")
                    && current_appt.get_start_time_hour() == 12
                    && current_appt.get_appt_type() == 0) {
                found = true;
            }
            index++;
        }

        if (found) {
            // Book the noon hour appointment for Jenny
            current_appt.schedule("Jenny", "403-867-5309", 2);  // 2 - Ladies Cut
        } else {
            System.out.println("Appointment entry not found");
        }

        // Print only scheduled appointments using format_record()
        System.out.println("Scheduled appointment records:");
        for (Appointment appt : appt_list) {
            if (appt.get_appt_type() != 0) {
                System.out.print(appt.format_record());
            }
        }

        // Cancel Sara's appointment
        current_appt_index = 1;
        current_appt = appt_list.get(current_appt_index);
        current_appt.cancel();

        // Print report of all appointment times using toString() method
        System.out.println("All appointment records:");
        for (Appointment appt : appt_list) {
            System.out.println(appt);
        }
    }
}
