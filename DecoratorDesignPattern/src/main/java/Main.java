import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      //meniu cu 6 optiuni

        System.out.println("Shape options meniu");
        System.out.println("Tasta 1 triunghi");
        System.out.println("Tasta 2 cerc");
        System.out.println("Tasta 3 dreptunghi");
        System.out.println("Tasta 4 triunghi border");
        System.out.println("Tasta 5 cerc border");
        System.out.println("Tasta 6 dreptunghi border");

        Scanner scanner=new Scanner(System.in);
        int optiune=scanner.nextInt();


            if(optiune==1){
                Shape triangle= new Triangle();
                triangle.draw();
            }if(optiune==2){
                Shape circle=new Circle();
                circle.draw();
            }if(optiune==3){
                Shape rectangle=new Rectangle();
                rectangle.draw();
            }if(optiune==4){
                Shape triangle2 = new Triangle();
                ShapeDecorator triangleBorderr=new TriangleDecorator(triangle2);
                triangleBorderr.draw();
            }if(optiune==5){
                Shape circle2= new Circle();
                ShapeDecorator circleBorder= new CircleDecorator(circle2);
                circleBorder.draw();
            }if(optiune==6){
                Shape rectangle2= new Rectangle();
                ShapeDecorator rectangleBorder= new RectangleDecorator(rectangle2);
                rectangleBorder.draw();
            }
            }
        }



