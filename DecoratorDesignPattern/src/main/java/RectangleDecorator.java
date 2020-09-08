public class RectangleDecorator extends ShapeDecorator {
    @Override
    public void draw() {
        shapeToDecorator.draw();
        System.out.println("I have border");
    }

    public RectangleDecorator(Shape shapeToDecorator){
        super(shapeToDecorator);
    }
}
