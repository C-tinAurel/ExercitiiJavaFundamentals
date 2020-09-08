public abstract class ShapeDecorator {
    protected Shape shapeToDecorator;


    public abstract void draw();

    public ShapeDecorator(Shape shapeToDecorator){
        this.shapeToDecorator=shapeToDecorator;




    }
}
