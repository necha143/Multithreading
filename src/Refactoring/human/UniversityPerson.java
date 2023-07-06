package Refactoring.human;

public class UniversityPerson extends Human{
    private University university;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public UniversityPerson(String name, int age) {
        super(name, age);
    }
}
