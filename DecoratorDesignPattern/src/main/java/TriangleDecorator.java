public class TriangleDecorator extends ShapeDecorator {

    @Override
    public void draw() {
        shapeToDecorator.draw();
        System.out.println("I have border");
    }

    public TriangleDecorator(Shape shapeToDecorater){
        super(shapeToDecorater);//astefel am facut realatia de compozitie

    }




}
