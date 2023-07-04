package elements;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Circle extends GameElement{

	public Circle(final int col, final int row) {
		super(col, row);
	}

	@Override
	public Image getImage() {
		return new ImageIcon(Objects.requireNonNull(getClass().getResource("circle.png"))).getImage();
	}
}
