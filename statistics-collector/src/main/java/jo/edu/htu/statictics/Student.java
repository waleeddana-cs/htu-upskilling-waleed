package jo.edu.htu.statictics;

import java.time.Year;

public class Student {
    private String id;
    private String name;
    private Year graduationYear;
    private String university;
    private String major;
    private Gender gender;

    public static Builder builder() {
        return new Builder();
    }

    private Student(String id, String name, Year graduationYear, String university, String major, Gender gender) {
        this.id = id;
        this.name = name;
        this.graduationYear = graduationYear;
        this.university = university;
        this.major = major;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Year getGraduationYear() {
        return graduationYear;
    }

    public String getUniversity() {
        return university;
    }

    public String getMajor() {
        return major;
    }

    public Gender getGender() {
        return gender;
    }

    public static class Builder {
        private String id;
        private String name;
        private Year graduationYear;
        private String university;
        private String major;
        private Gender gender;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setGraduationYear(Year graduationYear) {
            this.graduationYear = graduationYear;
            return this;
        }

        public Builder setUniversity(String university) {
            this.university = university;
            return this;
        }


        public Builder setMajor(String major) {
            this.major = major;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Student build() {
            return new Student(id, name, graduationYear, university, major, gender);
        }
    }
}
