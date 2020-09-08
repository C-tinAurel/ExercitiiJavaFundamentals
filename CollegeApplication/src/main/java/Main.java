import config.SpringConfiguration;
import entryPoint.CollegeEntryPoint;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CollegeEntryPoint collegeEntryPoint=annotationConfigApplicationContext.getBean(CollegeEntryPoint.class);
        collegeEntryPoint.run();
    }
}

