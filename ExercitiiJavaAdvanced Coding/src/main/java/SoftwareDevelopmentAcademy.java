import java.util.Set;

public class SoftwareDevelopmentAcademy {


    public Set<Group> groups;
    private static SoftwareDevelopmentAcademy instance = new SoftwareDevelopmentAcademy();

    public SoftwareDevelopmentAcademy(Set<Group> groups) {
        this.groups = groups;
    }

    public SoftwareDevelopmentAcademy() {

    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public static SoftwareDevelopmentAcademy getInstance() {
        return instance;
    }

}
