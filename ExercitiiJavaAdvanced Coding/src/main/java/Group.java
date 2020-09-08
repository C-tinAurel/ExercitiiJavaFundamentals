import java.util.Set;

public class Group {
    private String groupName;
    private Trainer groupTrainer;
    private Set<Trainee> groupTrainees;

    public Group(String groupName, Trainer groupTrainer) {
        this.groupName=groupName;
        this.groupTrainer=groupTrainer;
    }
    public Group(){

    }

    public String getGroupName() {
        return groupName;
    }

    public Set<Trainee> getGroupTrainees() {
        return groupTrainees;
    }

    public void setGroupTrainees(Set<Trainee> groupTrainees) {
        this.groupTrainees = groupTrainees;
    }

    public Trainer getGroupTrainer() {
        return groupTrainer;
    }
    public String toString(){
        return this.groupName + " " +this.groupTrainer;
    }
}
