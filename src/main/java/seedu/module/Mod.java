package seedu.module;

import java.util.Date;
import java.util.List;

public class Mod {
    private String preclusion;
    private String description;
    private String title;
    private String department;
    private String faculty;
    private String prerequisite;
    private double moduleCredit;
    private String moduleCode;
    private String corequisite;
    public class SemesterData {
        private int semester;
        private Date examDate;
        private int examDuration;
        public class Timetable {
            private String classNo;
            private int startTime;
            private int endTime;
            private String venue;
            private String day;
            private String lessonType; //placeholder
            private int size;
        }
        private List<Timetable> timetable;
    }
    private List<SemesterData> semesterData;

    public String getModuleCode() {
        return moduleCode;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return moduleCode + " " + title + " " + (int)moduleCredit + "MC";
    }

    public String getDescription() {
        return description;
    }
}
