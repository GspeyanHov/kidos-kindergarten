package am.friendsWebGroup.kidoskindergarten.entity;

public enum Experience {

    JUNIOR(0,2),
    MEDDLE(2,5),
    SENIOR(5,5 + Double.MAX_EXPONENT);

    Experience(double minYear, double maxYear) {
        this.MIN_YEAR = minYear;
        this.MAX_YEAR = maxYear;
    }
    private final double MIN_YEAR;
    private final double MAX_YEAR;
}
