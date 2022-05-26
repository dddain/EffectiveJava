package chapter4Test;

/**
 * 문제가 되는 태그 달린 클래스(?)
 */
class Figure {
    enum Shape { RECTANGLE, CIRCLE }; // 문제 1) 열거 타입 선언

    // 문제 2) 태그 필드 - 현재 모양을 나타낸다
    final Shape shape;

    double length, width; // 사각형

    double radius; // 원

    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        // 문제 3) switch 문
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * radius * radius;
            default:
                throw new AssertionError(shape);
        }
    }
}
