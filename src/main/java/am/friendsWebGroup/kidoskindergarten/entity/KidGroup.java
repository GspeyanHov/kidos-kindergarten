package am.friendsWebGroup.kidoskindergarten.entity;

public enum KidGroup {

    JUNIOR(3,  4),
    MIDDLE(4,5),
    SENIOR(5,6);

    KidGroup(double minYear, double maxYear) {
        this.MIN_YEAR = minYear;
        this.MAX_YEAR = maxYear;
    }
    private final double MIN_YEAR;
    private final double MAX_YEAR;
}
