public class CircleDecorator extends ShapeDecorator {

    @Override
    public void draw() {
        shapeToDecorator.draw();
        System.out.println("I have border");
    }

    public CircleDecorator(Shape shapeToDecorator){
        super(shapeToDecorator);
    }

}
