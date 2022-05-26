package chapter4Test;

abstract class FigureO {
    abstract double area();
}

class Circle extends FigureO {
    final double radius;
    Circle (double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends FigureO {
    final double length;
    final double width;
    Rectangle (double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}