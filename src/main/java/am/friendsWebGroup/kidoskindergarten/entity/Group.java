package am.friendsWebGroup.kidoskindergarten.entity;

public enum Group {

    JUNIOR(3,  4),
    MIDDLE(4,5),
    SENIOR(5,6);

    Group(double minYear, double maxYear) {
        this.MIN_YEAR = minYear;
        this.MAX_YEAR = maxYear;
    }
    private final double MIN_YEAR;
    private final double MAX_YEAR;
}
