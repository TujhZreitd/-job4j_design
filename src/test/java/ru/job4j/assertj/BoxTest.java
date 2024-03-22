package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 15);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .isEqualTo("Tetrahedron");
    }

    @Test
    void isThisVertexFour() {
        Box box = new Box(4, 15);
        assertThat(box.getNumberOfVertices()).isEqualTo(4);
    }

    @Test
    void isThisVertexNegativeOne() {
        Box box = new Box(5, 0);
        assertThat(box.getNumberOfVertices())
                .isNotZero()
                .isNegative()
                .isGreaterThan(-2)
                .isLessThan(0)
                .isEqualTo(-1);
    }

    @Test
    void isExitFalse() {
        Box box = new Box(5, 0);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void isExitTrue() {
        Box box = new Box(4, 15);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void isGetAreaNull() {
        Box box = new Box(5, 5);
        assertThat(box.getArea()).isEqualTo(0d, withPrecision(0.006d))
                .isCloseTo(0d, withPrecision(0.01d))
                .isCloseTo(0d, Percentage.withPercentage(1.0d))
                .isGreaterThan(-0.1d)
                .isLessThan(0.1d);
    }

    @Test
    void isGetAreaTwoHundredSixteen() {
        Box box = new Box(8, 6);
        assertThat(box.getArea()).isEqualTo(216d, withPrecision(0.006d))
                .isCloseTo(216d, withPrecision(0.01d))
                .isCloseTo(216d, Percentage.withPercentage(1.0d))
                .isGreaterThan(215.9d)
                .isLessThan(216.1d);
    }
}